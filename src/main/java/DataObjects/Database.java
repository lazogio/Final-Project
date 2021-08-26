package DataObjects;
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {
    @Step("Connect Data Base")
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try (FileInputStream f = new FileInputStream
                ("src\\main\\resources\\db.properties")) {
            Properties pros = new Properties();
            pros.load(f);
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
@Step("Insert  Users")
    public static void InsertUsers (String firstName, String lastName, String phone, String password,
                                    String address, String email,String country ,String state, String city, int zip) {
        String sql = " insert into [users].[dbo].[users]\n" +
                "(firstName,lastName,phone,password,address,email,country,state,city,zip)\n" +
                "  values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setString(4, password);
            pstmt.setString(5, address);
            pstmt.setString(6, email);
            pstmt.setString(7, country);
            pstmt.setString(8, state);
            pstmt.setString(9, city);
            pstmt.setInt(10, zip);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Step("Get last User")
    public static Users GetLastUsers() throws SQLException {
        Users users = new Users();
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement())   {
            ResultSet resultSet = stmt.executeQuery("select top 1 * from [users].[dbo].[users] order by id desc;");
            while(resultSet.next()){
                users.setFirstName(resultSet.getString("firstName"));
                users.setLastName(resultSet.getString("lastName"));
                users.setPhone(resultSet.getString("phone"));
                users.setPassword(resultSet.getString("password"));
                users.setAddress(resultSet.getString("address"));
                users.setEmail(resultSet.getString("email"));
                users.setState(resultSet.getString("state"));
                users.setCity(resultSet.getString("city"));
                users.setCountry(resultSet.getString("country"));
                users.setZip(resultSet.getInt("zip"));
            }
        }
        return users;
    }
}
