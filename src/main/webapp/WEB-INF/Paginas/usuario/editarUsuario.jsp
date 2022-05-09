<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS  uso estas libreria para darle un toque extra al diseño de la UI.--> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/d4f5870273.js" crossorigin="anonymous"></script>
        <title>Editar Usuarios </title>
    </head>
</head>
<body>        
    <!--cabecero-->
    <jsp:include page="/WEB-INF/Paginas/comunes/cabecero.jsp"/>

    <form action="${pageContext.request.contexPath}/ServletControlador?accion=modificar&idUsuario"
          method="POST" class="-validated">

        <!--Botones de navegaion-->
        <jsp:include page="/WEB-INF/Paginas/comunes/botonesNavegacionEdicion.jsp"/>

        <section id="details">
            <div class="container">
                <div class="row">
                    <div class="col">           
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Usuario</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-group">

                                    <label for="nombre">Nombre</label>
                                    <input type="text"  class="form-control" name="nombre" required value="${usuario.nombre}">              

                                </div>
                                <div class="form-group">

                                    <label for="apellido">Apellido</label>
                                    <input type="text"  class="form-control" name="apellido" required ${usuario.apellido}>              

                                </div>
                                <div class="form-group">

                                    <label for="email">Email</label>
                                    <input type="email"  class="form-control" name="email" ${usuario.email}>              

                                </div>
                                <div class="form-group">

                                    <label for="telefono">Telefono</label>
                                    <input type="telefono"  class="form-control" name="telefono" required ${usuario.telefono}>              

                                </div><!-- comment -->   

                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit">Guardar</button>



                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



    </form>
    <!--pie de Pagina -->
    <jsp:include page="/WEB-INF/Paginas/comunes/piePagina.jsp"/>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
