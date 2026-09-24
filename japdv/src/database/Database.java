package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/rafapdv";
    private String user = "root";
    private String password = "";

    public Connection conectar() {

        try {

            Class.forName(driver);

            Connection con = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            System.out.println("=================================");
            System.out.println("BANCO CONECTADO COM SUCESSO!");
            System.out.println("Banco: rafapdv");
            System.out.println("=================================");

            return con;

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("ERRO AO CONECTAR COM O BANCO!");
            System.out.println("=================================");
            e.printStackTrace();

            return null;
        }
    }

    public boolean testarConexao() {

        Connection con = conectar();

        if (con == null) {
            return false;
        }

        try {

            con.close();
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}