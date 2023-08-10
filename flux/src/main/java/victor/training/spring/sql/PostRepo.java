package victor.training.spring.sql;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import victor.training.spring.table.tables.Post;
import victor.training.spring.table.tables.records.PostRecord;

import java.util.Optional;

@Repository
public class PostRepo {
    @Autowired
    private DSLContext dsl;
    public Long save(PostRecord post) {
//        Mono.from(...)
        return dsl.insertInto(Post.POST)
                .set(post)
                .returningResult(Post.POST.ID)
                .fetch()
                .get(0)
                .value1();
    }

    public Optional<PostRecord> findById(Long postId) {
        return Optional.ofNullable(dsl.selectFrom(Post.POST)
                .where(Post.POST.ID.eq(postId))
                .fetch()
                .get(0));

    }

    public Flux<PostRecord> findAll() {
        return Flux.from(dsl.selectFrom(Post.POST));
    }
}
