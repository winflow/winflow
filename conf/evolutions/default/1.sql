# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ACTIVE_TRADE (
  id                        bigint not null,
  created_at                timestamp,
  updated_at                timestamp,
  OPTION_STRIKE             double,
  OPTION_RIGHT              varchar(255),
  local_symbol              varchar(255),
  security_type             varchar(255),
  expiry                    timestamp,
  position                  integer,
  multiplier                integer,
  exchange                  varchar(255),
  primary_exchange          varchar(255),
  currency                  varchar(255),
  transaction_date          timestamp,
  original_price            double,
  constraint pk_ACTIVE_TRADE primary key (id))
;

create table alert (
  id                        bigint not null,
  label                     varchar(255),
  created_on                timestamp,
  constraint pk_alert primary key (id))
;

create table ACCOUNT (
  email                     varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  password                  varchar(255),
  created_on                timestamp,
  updated_on                timestamp,
  constraint pk_ACCOUNT primary key (email))
;

create sequence ACTIVE_TRADE_seq;

create sequence alert_seq;

create sequence ACCOUNT_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ACTIVE_TRADE;

drop table if exists alert;

drop table if exists ACCOUNT;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ACTIVE_TRADE_seq;

drop sequence if exists alert_seq;

drop sequence if exists ACCOUNT_seq;

