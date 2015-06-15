GO
--'Estructura de la Tabla: Usuario_Android
CREATE TABLE  [dbo].[Usuario_Android](
          [CodigoUsuario] int NOT NULL , 
          [Nombres] varchar(50) NOT NULL  Default (''), 
          [LoginUsuario] varchar(50) NOT NULL  Default (''), 
          [Contrasenia] varchar(150) NOT NULL  Default (''), 
          [Correo] varchar(150) NOT NULL  Default (''), 
PRIMARY KEY (CodigoUsuario) 
)


CREATE PROCEDURE [dbo].[uspUsuario_Android_ValidarUsuario]
	@LoginUsuario VarChar(50)='',
	@Contrasenia VarChar(150)=''
AS 
BEGIN 
 SET NOCOUNT ON;
	SELECT 
		a.CodigoUsuario,
		a.Nombres,
		a.LoginUsuario,
		a.Contrasenia,
		a.Correo
	 FROM Usuario_Android  as  a 
	 WHERE   a.LoginUsuario =@LoginUsuario 
			 AND a.Contrasenia =@Contrasenia
END
go
