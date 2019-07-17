package demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    public static Connection conn() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hihih", "root", "");
    }
    public static String register(User user) {
        ResultSet flag;
        try {
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            PreparedStatement ps = conn().prepareStatement("INSERT INTO user (name,email,password) VALUES(?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.execute();
            System.out.println(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    public static User fetchData(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hihih", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND  password = ?");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            User users = null;
            while (rs.next()) {

                String exitusername = rs.getString(2);
                String exitpassword = rs.getString(3);
                users = new User(exitusername,exitpassword);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Work> getWork() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hihih", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM work");
            ResultSet rs = preparedStatement.executeQuery();
            List<Work> works = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String time = rs.getString("time");
                Work c = new Work(id, time);
                works.add(c);
            }
            System.out.println(works.size());
            System.out.println(preparedStatement);
            return works;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
