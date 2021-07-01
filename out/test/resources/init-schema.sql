create table user
(
    id       varchar(40)  not null
        primary key,
    password varchar(400) not null,
    name     varchar(20)  not null
);
