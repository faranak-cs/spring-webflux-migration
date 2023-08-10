/*
 * This file is generated by jOOQ.
 */
package victor.training.spring.table.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import victor.training.spring.table.tables.Post;

import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostRecord extends UpdatableRecordImpl<PostRecord> implements Record5<Long, LocalDateTime, Long, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.post.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.post.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.post.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.post.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.post.author_id</code>.
     */
    public void setAuthorId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.post.author_id</code>.
     */
    public Long getAuthorId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.post.body</code>.
     */
    public void setBody(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.post.body</code>.
     */
    public String getBody() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.post.title</code>.
     */
    public void setTitle(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.post.title</code>.
     */
    public String getTitle() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, LocalDateTime, Long, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, LocalDateTime, Long, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Post.POST.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Post.POST.CREATED_AT;
    }

    @Override
    public Field<Long> field3() {
        return Post.POST.AUTHOR_ID;
    }

    @Override
    public Field<String> field4() {
        return Post.POST.BODY;
    }

    @Override
    public Field<String> field5() {
        return Post.POST.TITLE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreatedAt();
    }

    @Override
    public Long component3() {
        return getAuthorId();
    }

    @Override
    public String component4() {
        return getBody();
    }

    @Override
    public String component5() {
        return getTitle();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreatedAt();
    }

    @Override
    public Long value3() {
        return getAuthorId();
    }

    @Override
    public String value4() {
        return getBody();
    }

    @Override
    public String value5() {
        return getTitle();
    }

    @Override
    public PostRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PostRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public PostRecord value3(Long value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public PostRecord value4(String value) {
        setBody(value);
        return this;
    }

    @Override
    public PostRecord value5(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public PostRecord values(Long value1, LocalDateTime value2, Long value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PostRecord
     */
    public PostRecord() {
        super(Post.POST);
    }

    /**
     * Create a detached, initialised PostRecord
     */
    public PostRecord(Long id, LocalDateTime createdAt, Long authorId, String body, String title) {
        super(Post.POST);

        setId(id);
        setCreatedAt(createdAt);
        setAuthorId(authorId);
        setBody(body);
        setTitle(title);
    }
}
