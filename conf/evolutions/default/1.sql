

create table document (
                          id bigint auto_increment not null,
                          title varchar(255),
                          content varchar(1000),
                          constraint pk_document primary key (id)
);



drop table if exists document;
