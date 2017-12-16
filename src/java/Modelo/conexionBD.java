/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class conexionBD {
    static String bd="crud";
    static String login = "root";
    static String password="";
    static String url="jdbc:mysql://localhost/"+bd;
    
    Connection conn=null;
    
    public conexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, login, password);
            if(conn!=null){
                System.out.println("Conexion a base de"+ " datos "
                + bd +" OK");
                
            }
        }catch(SQLException e){
             System.out.println(e);
        }catch(ClassNotFoundException e){
             System.out.println(e);
        }
        
    }
    
    public Connection getConection(){
        return conn;
    }
    
    public void desconectar(){
        conn=null;
    }
    
   /*   public static void main(String[] args) {
          conexionBD cBD = new conexionBD();
          cBD.getConection();
    } */
}
