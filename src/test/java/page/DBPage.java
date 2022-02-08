
package page;

import data.DataHelper;

import data.DataModel;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.BeforeEach;

import java.sql.DriverManager;


public class DBPage {

    private DBPage(){}



    @BeforeEach
    @SneakyThrows
    void setUp() {
        // var faker = new Faker();
        var runner = new QueryRunner();
        // var dataSQL = "INSERT INTO users(login, password) VALUES (?, ?);";
         var dataSQL = "INSERT INTO payment_entity(numberCard , status) VALUES (?, ?);";
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
            // System.out.println(first);
            var status = first.getStatus();
            return status;
                  }
    }

}

