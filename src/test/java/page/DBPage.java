package page;

import data.DataGenerator;
import data.DataHelper;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.BeforeEach;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DBPage {

    private DBPage(){}



    @BeforeEach
    @SneakyThrows
    void setUp() {
        // var faker = new Faker();
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
            runner.update(conn, dataSQL, DataHelper.getFirstCardInfo(), "APPROVED");
           runner.update(conn,dataSQL, DataHelper.getSecondCardInfo(),"DECLINED");
            //runner.update(conn, dataSQL, DataGenerator.generateNumber(), "DECLINED");
        }
    }



    @SneakyThrows
    public static DataHelper stubTest(String newNumber) {
        var countSQL = "SELECT COUNT(*) FROM users;";
        var usersSQL = "SELECT * FROM users;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/b'app'?serverTimezone=UTC", "newuser", "pass"
                );
        ) {
            var first = runner.query(conn, usersSQL, newNumber,"status");
            // System.out.println(first);
            return first;
                  }
    }

}
