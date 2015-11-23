# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                            bigint not null,
  name                          varchar(255),
  categorie                     varchar(255),
  liste_course_id               bigint,
  constraint pk_article primary key (id)
);
create sequence article_seq;

create table liste_course (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_liste_course primary key (id)
);
create sequence liste_course_seq;

alter table article add constraint fk_article_liste_course_id foreign key (liste_course_id) references liste_course (id) on delete restrict on update restrict;
create index ix_article_liste_course_id on article (liste_course_id);


# --- !Downs

alter table article drop constraint if exists fk_article_liste_course_id;
drop index if exists ix_article_liste_course_id;

drop table if exists article;
drop sequence if exists article_seq;

drop table if exists liste_course;
drop sequence if exists liste_course_seq;

