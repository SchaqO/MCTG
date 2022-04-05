create table player
(
    "userToken" text not null
        constraint player_pk
            primary key,
    username    text,
    password    text,
    coins       text,
    elo         text,
    status      text
);

alter table player
    owner to postgres;

create unique index player_username_uindex
    on player (username);

create unique index player_usertoken_uindex
    on player ("userToken");

create table card
(
    id          varchar(80),
    cardname    varchar(80),
    carddmg     varchar(80),
    cardelement varchar(80),
    cardtype    varchar(80)
);

alter table card
    owner to postgres;

create table package
(
    id      varchar(80),
    cardid1 varchar(80),
    cardid2 varchar(80),
    cardid3 varchar(80),
    cardid4 varchar(80),
    cardid5 varchar(80)
);

alter table package
    owner to postgres;

create table profile
(
    "userToken" varchar(80),
    name        varchar(80),
    description varchar(80),
    image       varchar(80)
);

alter table profile
    owner to postgres;

create table deck
(
    "userToken" varchar(80),
    cardid1     varchar(80),
    cardid2     varchar(80),
    cardid3     varchar(80),
    cardid4     varchar(80)
);

alter table deck
    owner to postgres;

create table trade
(
    id          varchar(80),
    "userToken" varchar(80),
    card        varchar(80),
    minpower    varchar(80),
    cardtype    varchar(80)
);

alter table trade
    owner to postgres;

create table stack
(
    "userToken" text not null,
    "cardId"    text not null
);

alter table stack
    owner to postgres;

create table holder
(
    cardholderid varchar not null,
    cardid       varchar,
    holderid     varchar,
    number       varchar,
    locked       varchar
);

alter table holder
    owner to postgres;

create unique index holder_cardholderid_uindex
    on holder (cardholderid);


