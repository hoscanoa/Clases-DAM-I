use master 
go

create database WB
go

use WB
go

create table alumno(
	cod varchar(5),
	nom varchar(250),
	nota int
)
go


select * from alumno
go

