<%-- 
    Document   : Anticle
    Created on : 11/02/2021, 17:29:16
    Author     : solan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Articulos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Article" method="POST">
                        <div class="form-group">
                            <label>Código de Barras: </label>
                            <input type="text" value="${article.getBarCodeA()}" name="txtBarCode" class="form-control">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Nombre: </label>
                            <input type="text" value="${article.getNameArt()}" name="txtNameA" class="form-control">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Precio Unitario: </label>
                            <input type="text" value="${article.getUnitPriceA()}"name="txtPrecioU" class="form-control">
                        </div>
                        <br>
                        <button type="submit" name="accion" value="AgregarArticulo" class="btn btn-info">Agregar Artículo</button>
                        <button type="submit" name="accion" value="ActualizarArticulo" class="btn btn-success">Actualizar Artículo</button>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th style="visibility:hidden;">Código</th>
                            <th>Código de Barras</th>
                            <th>Nombre</th>
                            <th>Precio Unitario</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="art" items="${articles}">
                            <tr>
                                <td style="visibility:hidden;">${art.getCodeA()}</td>
                                <td>${art.getBarCodeA()}</td>
                                <td>${art.getNameArt()}</td>
                                <td>${art.getUnitPriceA()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Article&accion=EditarArticulo&code=${art.getCodeA()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Article&accion=EliminarArticulo&code=${art.getCodeA()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
