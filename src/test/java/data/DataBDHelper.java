
package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.DriverManager;


public class DataBDHelper {

    private DataBDHelper() {
    }




    @SneakyThrows
    public static String stubTest() {
        var countSQL = "SELECT COUNT(*) FROM credit_request_entity";
        var usersSQL = "SELECT * FROM credit_request_entity;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://185.119.57.9:3306/app", "app", "pass"
                );
        ) {
            var first = runner.query(conn, usersSQL, new BeanHandler<>(DataModel.class));
            var status = first.getStatus();
            return status;
        }
    }

}

