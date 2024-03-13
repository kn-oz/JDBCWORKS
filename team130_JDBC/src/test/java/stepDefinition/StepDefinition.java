package stepDefinition;

import io.cucumber.java.en.Given;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StepDefinition {

    ResultSet resultSet;

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();

    }
    @Given("Query hazirlanir ve execute edilir.")
    public void query_hazirlanir_ve_execute_edilir() throws SQLException {

        // Select user_id from deposits where amount BETWEEN 100 and 500;
        String query ="SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN 100 AND 500";
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("Sonuclar islenir.")
    public void sonuclar_islenir() {



    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

    }
}

