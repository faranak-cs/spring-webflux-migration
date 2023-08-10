/*
 * This file is generated by jOOQ.
 */
package victor.training.spring.table;


import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import victor.training.spring.table.tables.Comment;
import victor.training.spring.table.tables.Post;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.comment</code>.
     */
    public final Comment COMMENT = Comment.COMMENT;

    /**
     * The table <code>public.post</code>.
     */
    public final Post POST = Post.POST;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Comment.COMMENT,
            Post.POST
        );
    }
}
