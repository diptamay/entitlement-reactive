# --- Sample dataset

# --- !Ups
insert into school (id,name) values ('797ff043-11eb-11e1-80d6-510998755d10', 'Avalon Elementary School');
insert into school (id,name) values ('6c84fb90-12c4-11e1-840d-7b25c5ee775a', 'Beloved Community Charter School');
insert into school (id,name) values ('109156be-c4fb-41ea-b1b4-efe1671c5836', 'Bradley Beach Elementary School');

insert into student (id,name) values ('02a31cb0-1432-11e1-8558-0b488e4fc115', 'Shawshank');
insert into student (id,name) values ('710b962e-041c-11e1-9234-0123456789ab', 'Becca');
insert into student (id,name) values ('110ec58a-a0f2-4ac4-8393-c866d813b8d1', 'Bradley');

insert into book (isbn,name) values ('0385754728', 'The Book Thief');
insert into book (isbn,name) values ('0385537131', 'Sycamore Row');
insert into book (isbn,name) values ('1493659111', 'Meditation: 30 Days of Meditation');

insert into school_student (school_id, student_id) values ('797ff043-11eb-11e1-80d6-510998755d10', '02a31cb0-1432-11e1-8558-0b488e4fc115');
insert into school_student (school_id, student_id) values ('6c84fb90-12c4-11e1-840d-7b25c5ee775a', '710b962e-041c-11e1-9234-0123456789ab');
insert into school_student (school_id, student_id) values ('109156be-c4fb-41ea-b1b4-efe1671c5836', '110ec58a-a0f2-4ac4-8393-c866d813b8d1');

insert into school_book (school_id, isbn) values ('797ff043-11eb-11e1-80d6-510998755d10', '0385754728');
insert into school_book (school_id, isbn) values ('6c84fb90-12c4-11e1-840d-7b25c5ee775a', '0385537131');
insert into school_book (school_id, isbn) values ('109156be-c4fb-41ea-b1b4-efe1671c5836', '1493659111');

# --- !Downs
delete from school_student;
delete from school_book;
delete from school;
delete from student;
delete from book;