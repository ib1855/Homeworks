package JDBC;

import java.sql.*;

public class TableExistChecker {
    private final Connection connection;

    public TableExistChecker() {
        this.connection = getConnection();
    }


    public static Connection getConnection(){
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("auth_task?").          //db name
                    append("serverTimezone=UTC&").
                    append("user=javatest&").          //login
                    append("password=Zxcv1234!");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void checkTableExist() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("create table if not exists users (login varchar(50) PRIMARY KEY, password varchar(32), email varchar(50))");
        statement.close();
    }


}
