package stepDefinition;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinition {

    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();

    String query;

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
    public void sonuclar_islenir() throws SQLException {

        resultSet.next();
        int actualResult = resultSet.getInt("user_id");
        int expectedResult = 1;

        assertEquals(expectedResult,actualResult);


    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();

    }

    @Given("Query02 hazirlanir ve execute edilir.")
    public void query02_hazirlanir_ve_execute_edilir() throws SQLException {

        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("Result02 Sonuclar islenir.")
    public void result02_sonuclar_islenir() throws SQLException {

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("5 Minutes");
        expectedNames.add("10 Minutes");

        List<String> actualNames = new ArrayList<>();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            actualNames.add(name);

        }

        for (int i = 0; i < actualNames.size(); i++) {

            assertEquals(expectedNames.get(i),actualNames.get(i));
            System.out.println(i + " . index dogrulandı");

        }



    }

}

