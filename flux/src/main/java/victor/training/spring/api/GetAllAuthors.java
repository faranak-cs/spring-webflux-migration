package victor.training.spring.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import victor.training.spring.mongo.Author;
import victor.training.spring.mongo.AuthorRepo;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GetAllAuthors { // #1
  private final AuthorRepo authorRepo;
  private final WebClient webClient;

  @PostConstruct
  public void initialDataInMongo() {
    authorRepo.save(new Author().setId(1000L).setName("John DOE").setBio("Long description"));
  }

  public record GetAuthorsResponse(Long id, String name, String email, String bio) {
    GetAuthorsResponse(Author author, String email) {
      this(author.getId(), author.getName(),email, author.getBio());
    }
  }
  @GetMapping("authors")
  public Flux<GetAuthorsResponse> getAllAuthors() {
    return authorRepo.findAll()
        .flatMap(a-> fetchEmail(a.getId()).map(e->new GetAuthorsResponse(a, e)));
  }

  private Mono<String> fetchEmail(Long authorId) {
    return webClient.get().uri("http://localhost:9999/contact/" + authorId + "/email")
        .retrieve().bodyToMono(String.class);
  }
}
