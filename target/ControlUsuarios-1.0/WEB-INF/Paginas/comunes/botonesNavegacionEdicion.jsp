<section id="actions " class="py-4 mg-4 bg-light">
    
    <div class="container">
        
        <div class="row">
            
            <div class="col-md-3">
                
                <a href="index.jsp" class="btn btn-light btn-block">
                    
                    <i class="fas fa-arrow-left"></i>Regresar al inicio
                </a>
            </div>
            <button type="submit" class="btn btn-sucess btn-block">
                <i class="fas fa-check"></i>Guardar Usuario
            </button>
        </div>
        <div class="col-md-3">
            
            <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idUsuario=${usuario.idUsuario}"
               class='btn btn-danger btn-block'>
                <i class="fas fas-trash"></i>Eliminar Usuario
            </a>
        </div>
        
    </div>
</section>