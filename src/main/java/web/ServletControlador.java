package web;

import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Este Servlet Controlador va a adquirir el listado usuarios y compartir a un JSP
@WebServlet("/ServletControlador")

public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {

                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                    
                default:
                    this.accionDefault(request, response);

            }

        } else {

            this.accionDefault(request, response);
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = new UsuarioDaoJDBC().listar();
        System.out.println("usuarios = " + usuarios);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarios", usuarios);

        // en este setAttribute calculamos en total de clientes 
        sesion.setAttribute("totalUsuarios", usuarios.size());

        // request.getRequestDispatcher("usuarios.jsp").forward(request, response); 
        response.sendRedirect("usuario.jsp");

    }
    //metodo editar usuario

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //recuperamos el IdUsuario
        int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
        Usuario usuario = new UsuarioDaoJDBC().encontrar(new Usuario(idUsuario));
        request.setAttribute("usuario", usuario);
        String jspEditar = "/WEB-INF/paginas/usuarios/editarUsuarios.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {

                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "Modificar":
                    this.modificarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);

            }

        } else {

            this.accionDefault(request, response);
        }

    }
    
    
// metodo para insertar 
    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperamos los valores de formulario agregarUsuario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

    }
    
    //esta metodo modifcar no se va mostrar parte de formulario sino de URL
     private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

   
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

   

}
     
       private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
           int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));   
           
       }
}