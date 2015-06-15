<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ClienteJson.aspx.cs" Inherits="AppIntegradorASPNET.Servicios.ClienteJson" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <script src="../js/jquery-1.6.2.min.js" type="text/javascript"></script>
    <script src="../js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
    <form id="form1" runat="server">

    <script>
        function ConsultarUsuarios() {
            var StrCadenaUrl = "LOGICA_UsuariosJSON.aspx?LoginUsuario=" + $("TxtLoginUsuario").val() + "&Contrasenia=" + $("TxtContrasenia").val();
            var strUrl = StrCadenaUrl;
            $.ajax({
                url: StrCadenaUrl,
                dataType: "json",
                type: "POST",
                success: function (data) {
                    var TotalFilasCategoria = data.length;

                    var iFilasUnica = 0;
                    EliminarFilasTablaDatos('TblResumen', 0);
                    for (iFilasUnica = 0; iFilasUnica < TotalFilasCategoria; iFilasUnica++) {
                        var tbl = document.getElementById('TblResumen');
                        var ultimoRegistro = tbl.rows.length;
                        var row = tbl.insertRow(ultimoRegistro);

                        var spanCampo = document.createElement("span");
                        spanCampo.innerHTML = data[iFilasUnica].Nombres;
                        var CeldaCampo = row.insertCell(0);
                        CeldaCampo.appendChild(spanCampo);

                        spanCampo = document.createElement("span");
                        spanCampo.innerHTML = data[iFilasUnica].LoginUsuario;
                        CeldaCampo = row.insertCell(1);
                        CeldaCampo.appendChild(spanCampo);

                        spanCampo = document.createElement("span");
                        spanCampo.innerHTML = data[iFilasUnica].Correo;
                        CeldaCampo = row.insertCell(2);
                        CeldaCampo.appendChild(spanCampo);

                        spanCampo = document.createElement("span");
                        spanCampo.innerHTML = data[iFilasUnica].Contrasenia;
                        CeldaCampo = row.insertCell(3);
                        CeldaCampo.appendChild(spanCampo);
                        

                    }
                    //Fin del For
                }
            });
        }
        function EliminarFilasTablaDatos(pNombreTabla, pNumeroFilasBase) { var table = document.getElementById(pNombreTabla); for (var i = table.rows.length - 1; i > pNumeroFilasBase; i--) { table.deleteRow(i); } }

    </script>
    <div>

<br />Usuario:<input type="text" id="TxtLoginUsuario" />
<br />Contrasenia:<input type="text" id="TxtContrasenia" />
    

    <input type ="button" id="BtnAceptar" value ="Aceptar" onclick="return ConsultarUsuarios();"></button>

     <table id="TblResumen" border ="0" cellpadding='0' cellspacing ='0' width ="100%">
                                             <colgroup> 
                                             </colgroup>
                                                 <tr> 
                                                    <td style='text-align:left;'>Nombres</td>
                                                    <td style='text-align:left;'>LoginUsuario</td>
                                                    <td style='text-align:left;'>Correo</td>
                                                     <td style='text-align:left;'>psw</td>
                                                </tr>
                                            </table>
    </div>
    </form>
</body>
</html>
