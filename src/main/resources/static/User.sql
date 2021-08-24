--pregreSQL 建表名字是User时，因其是关键字要加双引号，主键自增用serial
create table "User"(id serial primary key,username varchar(20),password varchar(20));
--建表后查看表的sql语句如下所示,使用serial会创建一个关联的sequece
--CREATE TABLE IF NOT EXISTS public."User"
--(
--    id integer NOT NULL DEFAULT nextval('User_id_seq'::regclass),
--    username character varying(20) COLLATE pg_catalog."default",
--    password character varying(20) COLLATE pg_catalog."default",
--    CONSTRAINT "User_pkey" PRIMARY KEY (id)
--)