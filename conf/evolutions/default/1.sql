# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alert (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_alert primary key (id))
;

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;

create sequence alert_seq;

create sequence account_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists alert;

drop table if exists account;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists alert_seq;

drop sequence if exists account_seq;

