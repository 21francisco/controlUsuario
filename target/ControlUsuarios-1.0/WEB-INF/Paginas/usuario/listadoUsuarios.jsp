<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_RD"/>



<section id="usuarios">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Usuarios</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>

                                <th>#</th>
                                <th>Nombre</th>
                                <th>Apellido</th>                                 
                                <th>Email</th>
                                <th></th>                 

                            </tr>                         


                        </thead>
                        <tbody>

                            <!-- Iteramos cada elemento de la lista de Usuarios -->
                            <c:forEach var="usuario" items="${usuarios}">
                                <tr>                                    
                                    <td>${usuario.idUsuario}</td>
                                    <td>${usuario.nombre} ${usuario.apellido}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idUsuario=${usuario.idUsuario}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>


                </div>


            </div>

            <!-- Inicio Tarjetas para el Total de Usuarios-->

            <div class="col-md-3">

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Usuarios</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>${totalUsuarios}
                        </h4>
                    </div>
                </div>
            </div>

            <!-- Fin Tarjetas para el Total de Usuarios-->

            </section>


            <!<!-- Agregar usuario MODAL-->

            <jsp:include page="WEB-INF/Paginas/usuario/agregarUsuario.jsp"/>
