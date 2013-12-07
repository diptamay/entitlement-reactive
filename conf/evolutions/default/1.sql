# --- First database schema

# --- !Ups
create table school (
  id                        varchar(36) not null,
  name                      varchar(255) not null,
  constraint pk_school primary key (id))
;

create table student (
  id                        varchar(36) not null,
  name                      varchar(255) not null,
  constraint pk_student primary key (id))
;

create table book (
  isbn                      varchar(13) not null,
  name                      varchar(255) not null,
  constraint pk_book primary key (isbn))
;

create table school_student (
  school_id                 varchar(36) not null,
  student_id                varchar(36) not null,
  constraint pk_school_student primary key (school_id, student_id))
;

create table school_book (
  school_id                 varchar(36) not null,
  isbn                      varchar(13) not null,
  constraint pk_school_book primary key (school_id, isbn))
;


alter table school_student add constraint fk_school_student_1 foreign key (school_id) references school (id) on delete restrict on update restrict;
alter table school_student add constraint fk_school_student_2 foreign key (student_id) references student (id) on delete restrict on update restrict;

alter table school_book add constraint fk_school_book_1 foreign key (school_id) references school (id) on delete restrict on update restrict;
alter table school_book add constraint fk_school_book_2 foreign key (isbn) references book (isbn) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists school;

drop table if exists student;

drop table if exists book;

drop table if exists school_student;

drop table if exists school_book;

SET REFERENTIAL_INTEGRITY TRUE;

