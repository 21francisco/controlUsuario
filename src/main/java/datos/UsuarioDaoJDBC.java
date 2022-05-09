package datos;

import dominio.Usuario;
import java.sql.*;
import java.util.*;


// En esta clase vamos a poner todas las sentencias "SQL"
public class UsuarioDaoJDBC {

    private static final String SQL_SELECT = "SELECT Id_usuario, nombre, apellido, email, telefono"
            + "FROM usuario";

    private static final String SQL_SELECT_BY_ID = "SELECT Id_usuario, nombre, apellido, email, telefono"
            + "FROM usuario WHERE idusuario=?";

    private static final String SQL_INSERT = "INSERT INTO usuario( nombre, apellido, email, telefono)"
            + "VALUES (?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE usuario"
            + "SET nombre=?, apellido=?, email=?, telefono=? WHERE id_usuario=?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    // creo una lista para retornar el listado de clientes
    public List<Usuario> listar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                usuario = new Usuario(idUsuario, nombre, apellido, email, telefono);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.setNextException(ex);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    }

    // metodo para encontrar el usuario por ID 
    public Usuario encontrar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getIdUsuario());
            rs = stmt.executeQuery();
            rs.absolute(1);// nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");

            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setTelefono(telefono);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return usuario;

    }

    //metodo insertar usuario 
    public int insertar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;

        //esta variable no miestra los numero de registros insertados
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefono());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public int actualizar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;

        //Esta variable es para definir cuanto registros se han modificado
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefono());
            stmt.setInt(6, usuario.getIdUsuario());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;

    }

    //Metodo eliminar 
    public int eliminar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;

        //Esta variable es para definir cuanto registros se han modificado
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);          
            stmt.setInt(1, usuario.getIdUsuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;

    }
}
