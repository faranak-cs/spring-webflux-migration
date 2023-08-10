/*
 * This file is generated by jOOQ.
 */
package victor.training.spring.table.tables;


import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import victor.training.spring.table.Keys;
import victor.training.spring.table.Public;
import victor.training.spring.table.tables.records.PostRecord;

import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Post extends TableImpl<PostRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.post</code>
     */
    public static final Post POST = new Post();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostRecord> getRecordType() {
        return PostRecord.class;
    }

    /**
     * The column <code>public.post.id</code>.
     */
    public final TableField<PostRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.post.created_at</code>.
     */
    public final TableField<PostRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.post.author_id</code>.
     */
    public final TableField<PostRecord, Long> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.post.body</code>.
     */
    public final TableField<PostRecord, String> BODY = createField(DSL.name("body"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.post.title</code>.
     */
    public final TableField<PostRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255), this, "");

    private Post(Name alias, Table<PostRecord> aliased) {
        this(alias, aliased, null);
    }

    private Post(Name alias, Table<PostRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.post</code> table reference
     */
    public Post(String alias) {
        this(DSL.name(alias), POST);
    }

    /**
     * Create an aliased <code>public.post</code> table reference
     */
    public Post(Name alias) {
        this(alias, POST);
    }

    /**
     * Create a <code>public.post</code> table reference
     */
    public Post() {
        this(DSL.name("post"), null);
    }

    public <O extends Record> Post(Table<O> child, ForeignKey<O, PostRecord> key) {
        super(child, key, POST);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<PostRecord, Long> getIdentity() {
        return (Identity<PostRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PostRecord> getPrimaryKey() {
        return Keys.POST_PKEY;
    }

    @Override
    public Post as(String alias) {
        return new Post(DSL.name(alias), this);
    }

    @Override
    public Post as(Name alias) {
        return new Post(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Post rename(String name) {
        return new Post(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Post rename(Name name) {
        return new Post(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, LocalDateTime, Long, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
