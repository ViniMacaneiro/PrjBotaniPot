/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    
    private static final String DATABASE = "hortaprototipo";
    private static final String HOST = "localhost:3306";
   
    public static Connection conectar(){
        Connection con = null;
        
        String url = "jdbc:mysql://" + HOST + "/" + DATABASE;
        String user = "admhorta";
        String password = "ShinyCapy";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o banco " + ex);
        }        
        return con;
    }
}
