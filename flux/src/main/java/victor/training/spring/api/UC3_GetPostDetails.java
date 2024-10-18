package victor.training.spring.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import victor.training.spring.api.UC3_GetPostDetails.GetPostDetailsResponse.CommentResponse;
import victor.training.spring.sql.Comment;
import victor.training.spring.sql.CommentRepo;
import victor.training.spring.sql.Post;
import victor.training.spring.sql.PostRepo;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UC3_GetPostDetails {
  private final PostRepo postRepo;
  private final CommentRepo commentRepo;

  @GetMapping("posts/{postId}")
  public Mono<GetPostDetailsResponse> getPostDetails(@PathVariable long postId) {
    // i need to fail if not found

    // RULE: in a method returning a Mono/Flux
    // - you are not allowed to throw exceptions, only return .error(new Exception)
    // - you are not allowed to block in NETWORK/IO
    return postRepo.findById(postId)
        .switchIfEmpty(Mono.error(()->new IllegalArgumentException("Post not found")))
        .flatMap(post -> commentRepo.findByPostId(postId)
            .map(CommentResponse::new)
            .collectList()
            .map(comments -> new GetPostDetailsResponse(post, comments)));
  }

  public record GetPostDetailsResponse(long id, String title, String body, List<CommentResponse> comments) {
    GetPostDetailsResponse(Post post, List<CommentResponse> comments) {
      this(post.id(), post.title(), post.body(), comments);
    }

    public record CommentResponse(String text, String name) {
      CommentResponse(Comment comment) {
        this(comment.comment(), comment.name());
      }
    }
  }

}
