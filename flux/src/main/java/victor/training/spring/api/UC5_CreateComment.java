package victor.training.spring.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import victor.training.spring.sql.Comment;
import victor.training.spring.sql.CommentRepo;
import victor.training.spring.sql.Post;
import victor.training.spring.sql.PostRepo;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC5_CreateComment {
  private final PostRepo postRepo;
  private final CommentRepo commentRepo;
  private final WebClient webClient;

  public record CreateCommentRequest(String comment, String name) {
  }

  @PostMapping("posts/{postId}/comments")
  public Mono<Comment> createComment(@PathVariable long postId, @RequestBody CreateCommentRequest request) {
    Mono<Post> postMono = postRepo.findById(postId)
            .switchIfEmpty(Mono.error(new NoSuchElementException("No post found")));

    Mono<Boolean> safeMono = postMono.flatMap(post -> isSafe(post.body(), request.comment()));
    Mono<Boolean> unlockedMono = postMono.flatMap(post -> isUnlocked(post.authorId()));

    Mono<Boolean> safeToSendMono = Mono.zip(safeMono, unlockedMono, (a, b) -> a && b);

    // it is empty or not
    Mono<Boolean> filterMono = safeToSendMono.filter(b -> b)
            .switchIfEmpty(Mono.error(new IllegalArgumentException("Comment Rejected")));

    return Mono.zip(filterMono, postMono, (b, post) ->
                    commentRepo.save(new Comment(post.id(), request.comment(), request.name())))
            .flatMap(m -> m);
  }

  private Mono<Boolean> isUnlocked(long authorId) {
    String url = "http://localhost:9999/author/" + authorId + "/comments";
    Mono<String> result = webClient.get().uri(url).retrieve().bodyToMono(String.class);
    return result.map(Boolean::parseBoolean);
  }

  private Mono<Boolean> isSafe(String postBody, String comment) {
    record Request(String body, String comment) {
    }
    String url = "http://localhost:9999/safety-check";
    Mono<String> result = webClient.post().uri(url)
            .bodyValue(new Request(postBody, comment))
            .retrieve()
            .bodyToMono(String.class);
    return result.map("OK"::equals);
  }
}
