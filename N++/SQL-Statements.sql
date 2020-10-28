create database pregschool;

drop table users;


create table users (
   id int(11) not null auto_increment primary key,
   firstname varchar(20) not null,
   surname varchar(30) not null,
   phonenumber varchar(10) not null,
   username varchar(30) not null,
   password varchar(50) not null,
   confirmpassword varchar(50) not null,
   saltvalue varchar(50) not null
);

insert into users (`id`, `firstname`, `surname`, `phonenumber`, `username`, `password`, `confirmpassword`)
values (`3`,`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);


insert into `antenatal`.`users` (`id`, `firstname`, `surname`, `phonenumber`, `username`, `password`, `confirmpassword`)
values (`3`,`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);


insert into users (`firstname`, `surname`, `phonenumber`, `username`, `password`, `confirmpassword`)
values (`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);


insert into users ('firstname', 'surname', 'phonenumber', 'username', 'password', 'confirmpassword')
values ('Judith', 'Gato', '0247158874', 'Judy', 'jams4444', 'jams4444');


insert into users values (`3`,`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);


insert into users values (`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);


insert into users values ('Judith', 'Gato', '0247158874', 'Judy', 'jams4444', 'jams4444');


insert into users values (3, 'Judith', 'Gato', '0247158874', 'Judy', 'jams4444', 'jams4444');    //worked


insert into users values (null, 'Judith', 'Gato', '0247158874', 'Judy', 'jams4444', 'jams4444');    //worked


insert into users values (null, 'Joshua', 'Gato', '0244306303', 'Josh', 'hams4444', 'hams4444');    //worked


insert into users values ('Judith', 'Gato', '0247158874', 'Judy', 'jams4444', 'jams4444');


insert into users values (4,`Judith`, `Gato`, `0247158874`, `Judy`, `jams4444`, `jams4444`);
