# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
  id                        bigint auto_increment not null,
  client_ip                 varchar(255),
  client_city               varchar(255),
  client_country            varchar(255),
  constraint pk_client primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table client;

SET FOREIGN_KEY_CHECKS=1;

