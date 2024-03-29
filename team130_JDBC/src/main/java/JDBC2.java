import java.sql.*;

public class JDBC2 {


    // Sizden bir JDBC testi yapilmasi istendiginde yapacaginiz ilk is:

    // Ilgili DATABASE YONETICISI ile iletisime gecerek
    // DATABASE ACCESS INFORMATION'larini edinmek.


    /*
            type	jdbc:mysql
            host/ip	45.87.83.5
            port	3306
            database_name	u168183796_qaloantec
            username	u168183796_qaloantecuser
            password	0&vG1A/MuWN
     */


    /*
    URL: "jdbc:mysql://45.87.83.5/u168183796_qaloantec";
    USERNAME= "u168183796_qaloantecuser";
    PASSWORD="0&vG1A/MuWN";

     */


// Verilen access informationlardan URL USERNAME ve PASSWORD cikartmaniz gerekir.


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //  1.ADIM: Dogru Surucuyu Ekle


        Class.forName("com.mysql.cj.jdbc.Driver");


        // 2. ADIM: DataBase ile Baglanti Kur


        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec",
                "u168183796_qaloantecuser",
                "0&vG1A/MuWN");


        // 3.ADIM: SQL Query'si Olustur.


        String query = "SELECT * FROM u168183796_qaloantec.users";

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        System.out.println(resultSet.getString("firstname"));

        resultSet.next();
        System.out.println(resultSet.getString("firstname"));

        resultSet.next();
        System.out.println(resultSet.getString("lastname"));

        System.out.println(resultSet.getString("country_code"));

        resultSet.absolute(10);
        System.out.println(resultSet.getString("email"));

        resultSet.first();
        System.out.println(resultSet.getInt("id"));










    }
}
