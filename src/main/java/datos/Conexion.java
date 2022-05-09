package datos;

import java.sql.*;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

//Esta clase sera utilizada para recurar la conexion a una base de datos desde el pool conexion APACHE-COMMONS-DBCP2
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_usuarios?useSSL=false&iseTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";

    private static final String JDBC_USER = "root";

    private static final String JDBC_PASSWORD = "admin";

    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource() {
        if (dataSource == null) {

            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }

        return dataSource;

    }

    public static Connection getConnection() throws SQLException {

        return getDataSource().getConnection();

    }

    public static void close(ResultSet rs) {

        try {

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }

    }

    public static void close(PreparedStatement stmt) {

        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void close(Connection conn) {

        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}