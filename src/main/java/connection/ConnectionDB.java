package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection;

    public static ConnectionDB instance = null;

    private ConnectionDB() {
    }

    public static ConnectionDB getInstance() {
        if (instance == null) {
            return instance = new ConnectionDB();
        }
        return instance;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/casestudy3";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public Connection getConnect() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ket noi khong thanh cong");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
