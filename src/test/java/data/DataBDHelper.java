
package data;

import lombok.SneakyThrows;
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
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root", "Password12!")
                              ;
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
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root", "Password12!");

        ) {
            var first = runner.query(conn, usersSQL, new BeanHandler<>(DataModel.class));
            var status = first.getStatus();
            return status;
        }
    }



}

