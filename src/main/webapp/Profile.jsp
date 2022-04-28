<% String nam; %><%--
  Created by IntelliJ IDEA.
  User: vmuno
  Date: 10/04/2022
  Time: 7:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BLUEMARKET</title>
    <link rel="shortcut icon" href="./images/logo_BM.png" type="image/x-icon">
    <link rel="stylesheet" href="./css/normalize.css">
    <link rel="stylesheet" href="./css/profile.css">
    <meta name="theme-color" content="#2091F9">

    <meta name="title" content="BlueMarket">
    <meta name="description"
          content="">


    <meta property="og:type" content="website">
    <meta property="og:url" content="Maria Luisa Enciso, Daniel Alvarado, Valeria Muñoz">
    <meta property="og:title" content="BlueMarket">
    <meta property="og:description"
          content="">
    <meta property="og:image" content="BlueMarket">

    <meta property="twitter:title" content="BlueMarket">
    <meta property="twitter:description"
          content="">
    <meta property="twitter:image" content="BlueMarket">
</head>
<body>
<section class="seccion-perfil-usuario">
    <div class="perfil-usuario-header">
        <div class="perfil-usuario-portada">
            <div class="perfil-usuario-avatar">
                <img src="./images/profileImage.png" alt="img-avatar">
            </div>
        </div>
    </div>

    <div class="perfil-usuario-body">
        <div class="perfil-usuario-bio">
            name: <h3 class="titulo"><%= request.getAttribute("name")%>
        </h3>
        </div>
        <div class="perfil-usuario-footer">
            <%--@declare id="typesart"--%><h3 class="titulo">Crea una publicación</h3>
            <label for="typesArt"> Tipos de arte </label> &nbsp; &nbsp;
            <select name="typesArt">
                <option value="abstractArt">Arte Abstracto</option>
                <option value="cubism">Cubismo</option>
                <option value="photography">Fotografía</option>
                <option value="impresionism">Impresionismo</option>
                <option value="renaissance">Renacimiento</option>
                <option value="xxcentury">Siglo XX</option>
            </select>
        </div> &nbsp;
        <div class="perfil-usuario-footer">
            <form name="subida-imagenes" type="POST" enctype="multipart/formdata">
                <input type="file" name="imagen1"/>
                <input class="button" type="submit" name="subir-imagen" value="Publicar"/>
            </form>
        </div>

        <br>
        <div class="perfil-usuario-footer">
            <h3 class="titulo">Billetera</h3>
            <a href="Wallet.html" class="nav__links">Ver billetera</a>

        </div>

        <div class="redes-sociales">
            <a href="" class="boton-redes facebook fab fa-facebook-f"></a>
            <a href="index.html" class="boton-redes twitter fab fa-twitter"></a>
        </div>
    </div>
</section>
</body>
</html>
