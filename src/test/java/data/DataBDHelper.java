
package data;

import lombok.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.DriverManager;


public class DataBDHelper {

    private DataBDHelper() {
    }


    @SneakyThrows
    public static String getCreditPurchaseStatus() {
       var usersSQL = "SELECT * FROM credit_request_entity;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(Connection.url, Connection.user, Connection.password
                );
        ) {
            var first = runner.query(conn, usersSQL, new BeanHandler<>(DataModel.class));
            var status = first.getStatus();
            return status;
        }
    }

    @SneakyThrows
    public static String getDebitPurchaseStatus() {
        var usersSQL = "SELECT * FROM payment_entity;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection(Connection.url, Connection.user, Connection.password);
        ) {
            var first = runner.query(conn, usersSQL, new BeanHandler<>(DataModel.class));
            var status = first.getStatus();
            return status;
        }
    }
    @Data
    @NoArgsConstructor


 static class Connection{

       static String url = "jdbc:mysql://185.119.57.9:3306/app";
       static String user ="app" ;
       static String password= "pass";
    }
}

