/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class Persistencia {
     conexionBD cBD= new conexionBD();
    
    public boolean ejecutarDML(String sql){
        cBD= new conexionBD();
        boolean ejecuto = false;
        try{
            PreparedStatement ps = cBD.getConection().prepareStatement(sql);
           if(ps.executeUpdate()>0){
               ejecuto = true;
           }
        
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        
        cBD.desconectar();
        return ejecuto;
        
    }
    
    public ResultSet ejecutarconsulta(String sql){
        cBD= new conexionBD();
        ResultSet res=null;
        try{
          PreparedStatement ps= cBD.getConection().prepareStatement(sql);
          res= ps.executeQuery();
            
        }catch(SQLException e){
          System.out.println(e.toString());   
        }
        cBD.desconectar();
        return res;
        
    }
    
   // public static void main(String[] args) {
     //    Persistencia Ps= new Persistencia();
        /*  String sql="Delete from countries where country_id='PRU'";
          if (Ps.ejecutarDML(sql)) {
              System.out.println("Ejecutado correctamente"); 
          }else{
              System.out.println("Error"); 
          } */
          
     /*  String sql="Select region_id, region_name from regions";
        ResultSet res= Ps.jeecutarconsulta(sql);
        try {
            while(res.next()){
                System.out.print("Codigo: "+res.getInt(1));
                System.out.println(" Nombre"+res.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }*/
         
         
  /*   String sql="Select country_id, country_name,region_name from countries natural join regions";
        ResultSet res= Ps.jeecutarconsulta(sql);
        try {
            while(res.next()){
                System.out.print("Codigo: "+res.getString(1));
                System.out.print(" Nombre: "+res.getString(2));
                System.out.println(" Nombre R000000000000000000000egion: "+res.getString(3));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  */
 //   }
}
