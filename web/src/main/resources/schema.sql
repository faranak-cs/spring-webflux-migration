drop table if exists public.comment;
drop table if exists  public.post;

create table public.post
(
    id        varchar(255) not null
        primary key,
    created_at timestamp,
    author_id bigint,
    body      varchar(255),
    title     varchar(255)
);

alter table public.post
    owner to postgres;

create table public.comment
(
    id      varchar(255) not null
        primary key,
    comment varchar(255),
    created_at timestamp,
    name    varchar(255),
    post_id varchar(255)
        constraint FK_COMMENT_POST
            references public.post
);

alter table public.comment
    owner to postgres;

INSERT INTO public.post (id, author_id, body, title) VALUES (1, 1000, 'European Software Crafters', 'Hello world!');
INSERT INTO public.post (id, author_id, body, title) VALUES (2, 1001, 'No Comments', 'Locked Post');