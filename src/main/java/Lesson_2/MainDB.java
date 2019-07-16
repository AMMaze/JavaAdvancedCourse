package Lesson_2;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;

public class MainDB {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement pstmt;
//    private static DatabaseMetaData dbm;

    public static void main(String[] args) throws SQLException {

        try {
            connection();
            dropIfExists("employees");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stmt.executeUpdate("CREATE TABLE employees (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "hire_date DATE, " +
                "salary INTEGER)");

        pstmt = conn.prepareStatement("INSERT INTO employees (name, hire_date, salary) VALUES (?, ?, ?)");

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            pstmt.setString(1, "Bob "  + i);
            pstmt.setDate(2, new Date(System.currentTimeMillis()));
            pstmt.setInt(3, random.nextInt(10000));
            pstmt.addBatch();
        }

        pstmt.executeBatch();

        printAll();

        stmt.executeUpdate("DELETE FROM employees WHERE salary < 5000");

        System.out.println("---------------");

        printAll();


        disconnect();
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = conn.createStatement();
//        dbm = conn.getMetaData();
    }

    public static void disconnect() throws SQLException {
        conn.close();
    }

    public static void dropIfExists(String table) throws SQLException{
        String sql =  String.format("DROP TABLE IF EXISTS %s", table);
        stmt.execute(sql);
    }

    public static void printAll() throws SQLException {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Date date = rs.getDate(3);
            int salary = rs.getInt(4);
            System.out.println(id + ", " + name + ", " + simpleDate.format(date) + ", " + salary);
        }
    }

}
