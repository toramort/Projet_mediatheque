/*==============================================================*/
/* Nom de SGBD :  SAP SQL Anywhere 17                           */
/* Date de création :  16/12/2018 17:09:11                      */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='Appartenir_console_FK') then
    alter table Appartenir
       delete foreign key Appartenir_console_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Appartenir_video_games0_FK') then
    alter table Appartenir
       delete foreign key Appartenir_video_games0_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Avoir_artiste_FK') then
    alter table Avoir
       delete foreign key Avoir_artiste_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Avoir_morceaux0_FK') then
    alter table Avoir
       delete foreign key Avoir_morceaux0_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Book_oeuvre_FK') then
    alter table Book
       delete foreign key Book_oeuvre_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Composer_album0_FK') then
    alter table Composer
       delete foreign key Composer_album0_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Composer_morceaux_FK') then
    alter table Composer
       delete foreign key Composer_morceaux_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='Movies_oeuvre_FK') then
    alter table Movies
       delete foreign key Movies_oeuvre_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='album_oeuvre_FK') then
    alter table album
       delete foreign key album_oeuvre_FK
end if;

if exists(select 1 from sys.sysforeignkey where role='video_games_oeuvre_FK') then
    alter table video_games
       delete foreign key video_games_oeuvre_FK
end if;

drop table if exists Appartenir;

drop table if exists Avoir;

drop table if exists Book;

drop table if exists Composer;

drop table if exists Movies;

drop table if exists album;

drop table if exists artiste;

drop table if exists console;

drop table if exists morceaux;

drop table if exists oeuvre;

drop table if exists video_games;

/*==============================================================*/
/* Table : Appartenir                                           */
/*==============================================================*/
create or replace table Appartenir 
(
   id_console           Int                            not null,
   id_vg                Int                            not null,
   constraint Appartenir_PK primary key (id_console, id_vg)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : Avoir                                                */
/*==============================================================*/
create or replace table Avoir 
(
   id_artiste           Int                            not null,
   id_morceaux          Int                            not null,
   constraint Avoir_PK primary key (id_artiste, id_morceaux)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : Book                                                 */
/*==============================================================*/
create or replace table Book 
(
   id_book              Int                            not null,
   title_book           Varchar (50)                   not null,
   genre_book           Varchar (50)                   not null,
   termine              Varchar (50)                   not null,
   id_oeuvre            Int                            not null,
   constraint Book_PK primary key (id_book),
   constraint Book_oeuvre_AK unique (id_oeuvre)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : Composer                                             */
/*==============================================================*/
create or replace table Composer 
(
   id_morceaux          Int                            not null,
   id_album             Int                            not null,
   constraint Composer_PK primary key (id_morceaux, id_album)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : Movies                                               */
/*==============================================================*/
create or replace table Movies 
(
   id_movies            Int                            not null,
   realisateur          Varchar (255)                  not null,
   version              Varchar (255)                  not null,
   genre                Varchar (255)                  not null,
   id_oeuvre            Int                            not null,
   constraint Movies_PK primary key (id_movies),
   constraint Movies_oeuvre_AK unique (id_oeuvre)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : album                                                */
/*==============================================================*/
create or replace table album 
(
   id_album             Int                            not null,
   genre                Varchar (255)                  not null,
   id_oeuvre            Int                            not null,
   constraint album_PK primary key (id_album),
   constraint album_oeuvre_AK unique (id_oeuvre)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : artiste                                              */
/*==============================================================*/
create or replace table artiste 
(
   id_artiste           Int                            not null,
   name_artiste         Varchar (255)                  not null,
   constraint artiste_PK primary key (id_artiste)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : console                                              */
/*==============================================================*/
create or replace table console 
(
   id_console           Int                            not null,
   name_console         Varchar (50)                   not null,
   constraint console_PK primary key (id_console)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : morceaux                                             */
/*==============================================================*/
create or replace table morceaux 
(
   id_morceaux          Int                            not null,
   title                Varchar (255)                  not null,
   constraint morceaux_PK primary key (id_morceaux)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : oeuvre                                               */
/*==============================================================*/
create or replace table oeuvre 
(
   id_oeuvre            Int                            not null,
   title                Varchar (255)                  not null,
   note                 Int                            null,
   commentaire          Text                           null,
   origine              Varchar (255)                  not null,
   support              Varchar (255)                  not null,
   constraint oeuvre_PK primary key (id_oeuvre)
)
ENGINE=InnoDB;

/*==============================================================*/
/* Table : video_games                                          */
/*==============================================================*/
create or replace table video_games 
(
   id_vg                Int                            not null,
   console              Varchar (255)                  not null,
   genre                Varchar (255)                  not null,
   termine              Varchar (255)                  not null,
   id_oeuvre            Int                            not null,
   constraint video_games_PK primary key (id_vg),
   constraint video_games_oeuvre_AK unique (id_oeuvre)
)
ENGINE=InnoDB;

alter table Appartenir
   add constraint Appartenir_console_FK foreign key (id_console)
      references console (id_console)
      on update restrict
      on delete restrict;

alter table Appartenir
   add constraint Appartenir_video_games0_FK foreign key (id_vg)
      references video_games (id_vg)
      on update restrict
      on delete restrict;

alter table Avoir
   add constraint Avoir_artiste_FK foreign key (id_artiste)
      references artiste (id_artiste)
      on update restrict
      on delete restrict;

alter table Avoir
   add constraint Avoir_morceaux0_FK foreign key (id_morceaux)
      references morceaux (id_morceaux)
      on update restrict
      on delete restrict;

alter table Book
   add constraint Book_oeuvre_FK foreign key (id_oeuvre)
      references oeuvre (id_oeuvre)
      on update restrict
      on delete restrict;

alter table Composer
   add constraint Composer_album0_FK foreign key (id_album)
      references album (id_album)
      on update restrict
      on delete restrict;

alter table Composer
   add constraint Composer_morceaux_FK foreign key (id_morceaux)
      references morceaux (id_morceaux)
      on update restrict
      on delete restrict;

alter table Movies
   add constraint Movies_oeuvre_FK foreign key (id_oeuvre)
      references oeuvre (id_oeuvre)
      on update restrict
      on delete restrict;

alter table album
   add constraint album_oeuvre_FK foreign key (id_oeuvre)
      references oeuvre (id_oeuvre)
      on update restrict
      on delete restrict;

alter table video_games
   add constraint video_games_oeuvre_FK foreign key (id_oeuvre)
      references oeuvre (id_oeuvre)
      on update restrict
      on delete restrict;

