<%-- 
    Document   : Order
    Created on : 13/02/2021, 17:14:37
    Author     : solan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Listar Ordenes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=Order" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente:</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="apellidoCliente" value="${cli.getLastName()}" class="form-control" placeholder="Apellido">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>   
                                <div class="col-sm-3 d-flex">
                                    <input type="hidden" name="codigoClient" value="${cli.getCode()}" class="form-control">
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" value="${cli.getName()}" class="form-control" placeholder="Nombre" readonly>
                                </div> 
                            </div>
                            <br>
                            <div class="form-group">
                                <button type="submit" name="accion" value="BuscarOrdenes" class="btn btn-outline-info">Buscar Ordenes</button>
                            </div>
                            <br>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Número de Orden</th>
                                    <th>Nombre del Cliente</th>                                 
                                    <th>Código Barras</th>
                                    <th>Descripción</th>
                                    <th>Fecha</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${listaOC}" >
                                    <tr>
                                        <td>${String.format("%010d", Integer.parseInt(list.getCodeO()))}</td>
                                        <td>${list.getNombreCliente()}</td>
                                        <td>${list.getCodeBaA()}</td>
                                        <td>${list.getNombreA()}</td>
                                        <td>${list.getFechaO()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>                                
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
