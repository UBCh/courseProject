package page;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.BeforeEach;

import java.sql.DriverManager;

public class BDPageFaker {

    private BDPageFaker(){}
    @BeforeEach
    @SneakyThrows
    public static void setUp(String number) {
        var runner = new QueryRunner();
        // var dataSQL = "INSERT INTO users(login, password) VALUES (?, ?);";
        var dataSQL = "INSERT INTO users(numberCard , status) VALUES (?, ?);";
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/b'app'?serverTimezone=UTC", "newuser", "pass"
                );

        ) {
            // обычная вставка
            // runner.update(conn, dataSQL, faker.name().username(), "pass");
           runner.update(conn, dataSQL, number, "DECLINED");
        }
    }



    @SneakyThrows
    public static Object stubTest(String newNumber) {
        var countSQL = "SELECT COUNT(*) FROM users;";
        var usersSQL = "SELECT * FROM users;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/b'app'?serverTimezone=UTC", "newuser", "pass"
                );
        ) {
            var first = runner.query(conn,  usersSQL, newNumber, "Status");
            // System.out.println(first);
            return first;
        }
    }



}
