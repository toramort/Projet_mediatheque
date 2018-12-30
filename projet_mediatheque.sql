------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: personality
------------------------------------------------------------
CREATE TABLE public.personality(
	id_p        SERIAL NOT NULL ,
	firstname   VARCHAR (255) NOT NULL ,
	lastname    VARCHAR (255) NOT NULL ,
	surname     VARCHAR (255) NOT NULL  ,
	CONSTRAINT personality_PK PRIMARY KEY (id_p)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: job
------------------------------------------------------------
CREATE TABLE public.job(
	id_job   SERIAL NOT NULL ,
	job      VARCHAR (255) NOT NULL  ,
	CONSTRAINT job_PK PRIMARY KEY (id_job)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: genre
------------------------------------------------------------
CREATE TABLE public.genre(
	id_g    SERIAL NOT NULL ,
	genre   VARCHAR (255) NOT NULL  ,
	CONSTRAINT genre_PK PRIMARY KEY (id_g)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: origin
------------------------------------------------------------
CREATE TABLE public.origin(
	id_o     SERIAL NOT NULL ,
	name_o   VARCHAR (255) NOT NULL  ,
	CONSTRAINT origin_PK PRIMARY KEY (id_o)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: version
------------------------------------------------------------
CREATE TABLE public.version(
	id_v      SERIAL NOT NULL ,
	version   VARCHAR (255) NOT NULL  ,
	CONSTRAINT version_PK PRIMARY KEY (id_v)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: categorie
------------------------------------------------------------
CREATE TABLE public.categorie(
	id_c     SERIAL NOT NULL ,
	name_c   VARCHAR (255) NOT NULL  ,
	CONSTRAINT categorie_PK PRIMARY KEY (id_c)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: console
------------------------------------------------------------
CREATE TABLE public.console(
	id_c     SERIAL NOT NULL ,
	name_c   VARCHAR (255) NOT NULL  ,
	CONSTRAINT console_PK PRIMARY KEY (id_c)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: support
------------------------------------------------------------
CREATE TABLE public.support(
	id_s     SERIAL NOT NULL ,
	name_s   VARCHAR (255) NOT NULL  ,
	CONSTRAINT support_PK PRIMARY KEY (id_s)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: oeuvre
------------------------------------------------------------
CREATE TABLE public.oeuvre(
	id           SERIAL NOT NULL ,
	title        VARCHAR (255) NOT NULL ,
	date_ajout   DATE  NOT NULL ,
	date         DATE  NOT NULL ,
	finished     BOOL  NOT NULL ,
	id_p         INT  NOT NULL ,
	id_o         INT  NOT NULL ,
	id_c         INT  NOT NULL ,
	id_s         INT  NOT NULL  ,
	CONSTRAINT oeuvre_PK PRIMARY KEY (id)

	,CONSTRAINT oeuvre_personality_FK FOREIGN KEY (id_p) REFERENCES public.personality(id_p)
	,CONSTRAINT oeuvre_origin0_FK FOREIGN KEY (id_o) REFERENCES public.origin(id_o)
	,CONSTRAINT oeuvre_categorie1_FK FOREIGN KEY (id_c) REFERENCES public.categorie(id_c)
	,CONSTRAINT oeuvre_support2_FK FOREIGN KEY (id_s) REFERENCES public.support(id_s)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: morceau
------------------------------------------------------------
CREATE TABLE public.morceau(
	id_m      SERIAL NOT NULL ,
	morceau   VARCHAR (255) NOT NULL ,
	id        INT  NOT NULL  ,
	CONSTRAINT morceau_PK PRIMARY KEY (id_m)

	,CONSTRAINT morceau_oeuvre_FK FOREIGN KEY (id) REFERENCES public.oeuvre(id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: user
------------------------------------------------------------
CREATE TABLE public.user(
	id_user   SERIAL NOT NULL ,
	name_u    VARCHAR (255) NOT NULL  ,
	CONSTRAINT user_PK PRIMARY KEY (id_user)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: evaluation
------------------------------------------------------------
CREATE TABLE public.evaluation(
	id_e      SERIAL NOT NULL ,
	comment   VARCHAR (2000)  NOT NULL ,
	note      INT  NOT NULL ,
	id        INT  NOT NULL ,
	id_user   INT  NOT NULL  ,
	CONSTRAINT evaluation_PK PRIMARY KEY (id_e)

	,CONSTRAINT evaluation_oeuvre_FK FOREIGN KEY (id) REFERENCES public.oeuvre(id)
	,CONSTRAINT evaluation_user0_FK FOREIGN KEY (id_user) REFERENCES public.user(id_user)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: job_personality
------------------------------------------------------------
CREATE TABLE public.job_personality(
	id_job   INT  NOT NULL ,
	id_p     INT  NOT NULL  ,
	CONSTRAINT job_personality_PK PRIMARY KEY (id_job,id_p)

	,CONSTRAINT job_personality_job_FK FOREIGN KEY (id_job) REFERENCES public.job(id_job)
	,CONSTRAINT job_personality_personality0_FK FOREIGN KEY (id_p) REFERENCES public.personality(id_p)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: morceau_personality
------------------------------------------------------------
CREATE TABLE public.morceau_personality(
	id_m   INT  NOT NULL ,
	id_p   INT  NOT NULL  ,
	CONSTRAINT morceau_personality_PK PRIMARY KEY (id_m,id_p)

	,CONSTRAINT morceau_personality_morceau_FK FOREIGN KEY (id_m) REFERENCES public.morceau(id_m)
	,CONSTRAINT morceau_personality_personality0_FK FOREIGN KEY (id_p) REFERENCES public.personality(id_p)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: genre_oeuvre
------------------------------------------------------------
CREATE TABLE public.genre_oeuvre(
	id     INT  NOT NULL ,
	id_g   INT  NOT NULL  ,
	CONSTRAINT genre_oeuvre_PK PRIMARY KEY (id,id_g)

	,CONSTRAINT genre_oeuvre_oeuvre_FK FOREIGN KEY (id) REFERENCES public.oeuvre(id)
	,CONSTRAINT genre_oeuvre_genre0_FK FOREIGN KEY (id_g) REFERENCES public.genre(id_g)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: version_oeuvre
------------------------------------------------------------
CREATE TABLE public.version_oeuvre(
	id     INT  NOT NULL ,
	id_v   INT  NOT NULL  ,
	CONSTRAINT version_oeuvre_PK PRIMARY KEY (id,id_v)

	,CONSTRAINT version_oeuvre_oeuvre_FK FOREIGN KEY (id) REFERENCES public.oeuvre(id)
	,CONSTRAINT version_oeuvre_version0_FK FOREIGN KEY (id_v) REFERENCES public.version(id_v)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: console_oeuvre
------------------------------------------------------------
CREATE TABLE public.console_oeuvre(
	id_c   INT  NOT NULL ,
	id     INT  NOT NULL  ,
	CONSTRAINT console_oeuvre_PK PRIMARY KEY (id_c,id)

	,CONSTRAINT console_oeuvre_console_FK FOREIGN KEY (id_c) REFERENCES public.console(id_c)
	,CONSTRAINT console_oeuvre_oeuvre0_FK FOREIGN KEY (id) REFERENCES public.oeuvre(id)
)WITHOUT OIDS;



