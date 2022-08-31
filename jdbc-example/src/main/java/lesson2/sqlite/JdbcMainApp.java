package lesson2.sqlite;
/*CREATE TABLE students (
        id    INTEGER PRIMARY KEY AUTOINCREMENT,
        name  TEXT,
        score INTEGER
        );
*/


import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.Collection;

public class JdbcMainApp {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            dropAndCreateTable();
            fillTable();
            //prepareStatement();
            //prepareStatementExample();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
    public static int getStudentScoreName(String name) {
        try (ResultSet rs = stmt.executeQuery("select score from students where name = '" + name + "';")) {
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void prepareStatementExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            //insert into students(name, score) values (?, ?)
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, 100);
            psInsert.executeUpdate();
        }
        connection.setAutoCommit(true);
    }

    private static void prepareStatement() throws SQLException {
        psInsert = connection.prepareStatement("insert into students(name, score) values (?, ?);");
    }

    private static void batchExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            stmt.addBatch(String.format("insert into students (name,score) values('%s', 100);", "Bob #" + i));
        }
        stmt.executeBatch();
        connection.setAutoCommit(true);
    }

    private static void dropAndCreateTable() throws SQLException {
        stmt.executeUpdate("drop table if exists students");
        stmt.executeUpdate("CREATE TABLE if not exists students (\n" +
                "        id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        name  TEXT,\n" +
                "        score INTEGER\n" +
                "        );");
    }

    private static void fillTable() throws SQLException {
        //cоздаем заполняем таблицу
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            stmt.executeUpdate(String.format("insert into students (name,score) values('%s', 100);", "Bob #" + i));
        }
        connection.setAutoCommit(true);
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static void clearTableExample() throws SQLException {
        //удали из таблицы студены ,студента у которга ид = 5
        stmt.executeUpdate("delete from students");
    }

    private static void deleteOneExample() throws SQLException {
        //удали из таблицы студены ,студента у которга ид = 5
        stmt.executeUpdate("delete from students where id = 5");
    }

    private static void updateExample() throws SQLException {
        //обнови данные в таблицы студенты в столбце скор у кого айди больше 0
        stmt.executeUpdate("update students set score = 100 where id > 0");
    }

    private static void readExample() throws SQLException {
        //Метод говорит дай мне студентов ид которых больше 2
        // так же при запросе можем за место * указать конкретны столбцы id and score > *
        try (ResultSet rs = stmt.executeQuery("select * from students where id > 2;");) {
            while (rs.next()) {
                //id  name  score
                //1  Roma    90
                //2  Bob     70
                // также можно не указывать какой это столбец и указать его название
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
        }
    }

    private static void insertExample() throws SQLException {
        // Добавь в таблицу студенты (столбцы наме и скор) следующие данные (name и значениние)
        stmt.executeUpdate("insert into students (name,score) values ('A',20);");
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключение к БД");
        }
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psInsert != null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
