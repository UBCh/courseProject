
package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.BeforeEach;

import java.sql.DriverManager;


public class DataBDHelper {

    private DataBDHelper() {
    }


    @BeforeEach
    @SneakyThrows
    void setUp () {
        var runner = new QueryRunner();
        var dataSQL = "INSERT INTO payment_entity(numberCard , status) VALUES (?, ?);";
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://185.119.57.9:3306/app", "user", "pass"
                );

        ) {

            runner.update(conn, dataSQL, DataHelper.getFirstCardInfo(), "APPROVED");
            runner.update(conn, dataSQL, DataHelper.getSecondCardInfo(), "DECLINED");

        }
    }


    @SneakyThrows
    public static String stubTest() {
        var countSQL = "SELECT COUNT(*) FROM credit_request_entity";
        var usersSQL = "SELECT * FROM credit_request_entity;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/b'app'?serverTimezone=UTC", "newuser", "pass"
                );
        ) {
            var first = runner.query(conn, usersSQL, new BeanHandler<>(DataModel.class));
            var status = first.getStatus();
            return status;
        }
    }

}

