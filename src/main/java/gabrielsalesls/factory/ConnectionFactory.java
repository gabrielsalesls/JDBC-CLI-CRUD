package gabrielsalesls.factory;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {
        throw new IllegalStateException("Utility class");
    }

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mysql://localhost/crud_jdbc?useTimezone=true&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("12345");
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
