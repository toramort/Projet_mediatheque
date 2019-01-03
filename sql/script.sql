#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: oeuvre
#------------------------------------------------------------

CREATE TABLE oeuvre(
        id_oeuvre   Int  Auto_increment  NOT NULL ,
        title       Varchar (255) NOT NULL ,
        note        Int ,
        commentaire Text ,
        origine     Varchar (255) NOT NULL ,
        support     Varchar (255) NOT NULL
	,CONSTRAINT oeuvre_PK PRIMARY KEY (id_oeuvre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Movies
#------------------------------------------------------------

CREATE TABLE Movies(
        id_movies   Int  Auto_increment  NOT NULL ,
        realisateur Varchar (255) NOT NULL ,
        version     Varchar (255) NOT NULL ,
        genre       Varchar (255) NOT NULL ,
        id_oeuvre   Int NOT NULL
	,CONSTRAINT Movies_PK PRIMARY KEY (id_movies)

	,CONSTRAINT Movies_oeuvre_FK FOREIGN KEY (id_oeuvre) REFERENCES oeuvre(id_oeuvre)
	,CONSTRAINT Movies_oeuvre_AK UNIQUE (id_oeuvre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: video_games
#------------------------------------------------------------

CREATE TABLE video_games(
        id_vg     Int  Auto_increment  NOT NULL ,
        console   Varchar (255) NOT NULL ,
        genre     Varchar (255) NOT NULL ,
        termine   Varchar (255) NOT NULL ,
        id_oeuvre Int NOT NULL
	,CONSTRAINT video_games_PK PRIMARY KEY (id_vg)

	,CONSTRAINT video_games_oeuvre_FK FOREIGN KEY (id_oeuvre) REFERENCES oeuvre(id_oeuvre)
	,CONSTRAINT video_games_oeuvre_AK UNIQUE (id_oeuvre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: morceaux
#------------------------------------------------------------

CREATE TABLE morceaux(
        id_morceaux Int  Auto_increment  NOT NULL ,
        title       Varchar (255) NOT NULL
	,CONSTRAINT morceaux_PK PRIMARY KEY (id_morceaux)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: artiste
#------------------------------------------------------------

CREATE TABLE artiste(
        id_artiste   Int  Auto_increment  NOT NULL ,
        name_artiste Varchar (255) NOT NULL
	,CONSTRAINT artiste_PK PRIMARY KEY (id_artiste)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: album
#------------------------------------------------------------

CREATE TABLE album(
        id_album  Int  Auto_increment  NOT NULL ,
        genre     Varchar (255) NOT NULL ,
        id_oeuvre Int NOT NULL
	,CONSTRAINT album_PK PRIMARY KEY (id_album)

	,CONSTRAINT album_oeuvre_FK FOREIGN KEY (id_oeuvre) REFERENCES oeuvre(id_oeuvre)
	,CONSTRAINT album_oeuvre_AK UNIQUE (id_oeuvre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Book
#------------------------------------------------------------

CREATE TABLE Book(
        id_book    Int  Auto_increment  NOT NULL ,
        title_book Varchar (50) NOT NULL ,
        genre_book Varchar (50) NOT NULL ,
        termine    Varchar (50) NOT NULL ,
        id_oeuvre  Int NOT NULL
	,CONSTRAINT Book_PK PRIMARY KEY (id_book)

	,CONSTRAINT Book_oeuvre_FK FOREIGN KEY (id_oeuvre) REFERENCES oeuvre(id_oeuvre)
	,CONSTRAINT Book_oeuvre_AK UNIQUE (id_oeuvre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: console
#------------------------------------------------------------

CREATE TABLE console(
        id_console   Int  Auto_increment  NOT NULL ,
        name_console Varchar (50) NOT NULL
	,CONSTRAINT console_PK PRIMARY KEY (id_console)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Composer
#------------------------------------------------------------

CREATE TABLE Composer(
        id_morceaux Int NOT NULL ,
        id_album    Int NOT NULL
	,CONSTRAINT Composer_PK PRIMARY KEY (id_morceaux,id_album)

	,CONSTRAINT Composer_morceaux_FK FOREIGN KEY (id_morceaux) REFERENCES morceaux(id_morceaux)
	,CONSTRAINT Composer_album0_FK FOREIGN KEY (id_album) REFERENCES album(id_album)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Avoir
#------------------------------------------------------------

CREATE TABLE Avoir(
        id_artiste  Int NOT NULL ,
        id_morceaux Int NOT NULL
	,CONSTRAINT Avoir_PK PRIMARY KEY (id_artiste,id_morceaux)

	,CONSTRAINT Avoir_artiste_FK FOREIGN KEY (id_artiste) REFERENCES artiste(id_artiste)
	,CONSTRAINT Avoir_morceaux0_FK FOREIGN KEY (id_morceaux) REFERENCES morceaux(id_morceaux)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Appartenir
#------------------------------------------------------------

CREATE TABLE Appartenir(
        id_console Int NOT NULL ,
        id_vg      Int NOT NULL
	,CONSTRAINT Appartenir_PK PRIMARY KEY (id_console,id_vg)

	,CONSTRAINT Appartenir_console_FK FOREIGN KEY (id_console) REFERENCES console(id_console)
	,CONSTRAINT Appartenir_video_games0_FK FOREIGN KEY (id_vg) REFERENCES video_games(id_vg)
)ENGINE=InnoDB;

