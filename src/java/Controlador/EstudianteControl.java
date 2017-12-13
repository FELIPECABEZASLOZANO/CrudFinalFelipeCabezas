/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Felipe
 */

public class EstudianteControl {
      Persistencia p = new Persistencia();
    
    public boolean insertarEstudiante(int cedulaEstudiante,String nombreEstudiante,String apellidosEstudiante, int edadEstudiante, String direccionEstudiante, String telefonoEstudiante, int idCurso ){
        boolean inserto = false;
        String sql = "Insert into estudiante( idEstudiante, nombre, apellidos, telefono, edad, direccion, idCurso) "
                + "values ("+cedulaEstudiante+", '"+nombreEstudiante+"','"+apellidosEstudiante+"','"+telefonoEstudiante+"', "
                + ""+edadEstudiante+", '"+direccionEstudiante+"', "+idCurso+")";
        inserto = p.ejecutarDML(sql);
        return inserto;
    }
    
    public boolean actualizoEstudiante(int cedulaEstudiante,String nombreEstudiante,String apellidosEstudiante, int edadEstudiante, String direccionEstudiante, String telefonoEstudiante, int idCurso ){
        boolean actualizo = false;
        String sql= "Update  estudiante set  idEstudiante = "+cedulaEstudiante+" ,nombre='"+nombreEstudiante+"',apellidos='"+apellidosEstudiante+"', telefono= '"+telefonoEstudiante+"' "
                + ", edad="+edadEstudiante+", direccion='"+direccionEstudiante+"', idCurso="+idCurso+" where idEstudiante= "+cedulaEstudiante+"";
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }
    
    public boolean eliminarEstudiante(int cedulaEstudiante){
        boolean elimino = false;
        String sql = "Delete from estudiante where idEstudiante = "+ cedulaEstudiante+"";
        elimino = p.ejecutarDML(sql);
        return elimino;
    }
    
   
    public Object[][] listarEstudiante() {
        Object data[][] = new Object[numeroEstudiante()][7];
        String sql = "select idEstudiante, nombre, apellidos, telefono, edad, direccion, idCurso from estudiante";
        ResultSet res = p.ejecutarconsulta(sql);

        try {
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getInt(1);
                data[i][1] = res.getString(2);
                data[i][2] = res.getString(3);
                data[i][3] = res.getString(4);
                data[i][4] = res.getInt(5);
                data[i][5] = res.getString(6);
                data[i][6] = res.getInt(7);
                
                
                
                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int numeroEstudiante() {
        int numero = 0;
        ResultSet res = null;
        String sql = "Select count(*) from estudiante ";
        res = p.ejecutarconsulta(sql);
        try {

            while (res.next()) {
                numero = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
return numero;
    }       

    public Object[][] listarEstudianteCedula(int cedulaPersona) {
        Object data[][] = new Object[1][7];
        String sql = "select idEstudiante,nombre, apellidos, telefono, edad, direccion, idCurso where idEstudiante = '"+cedulaPersona+"'";
        ResultSet res = p.ejecutarconsulta(sql);

        try {

            while (res.next()) {
                data[0][0] = res.getInt(1);
                data[0][1] = res.getString(2);
                data[0][2] = res.getString(3);
                data[0][3] = res.getString(4);
                data[0][4] = res.getInt(5);
                data[0][5] = res.getString(6);
                data[0][6] = res.getString(7);
                
               
               
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
        
    
//     public static void main(String[] args) {
//        EstudianteControl cr=new EstudianteControl();
//       Object data[][] = cr.listarPersona();
//
//        System.out.println("Usuarios: " + data[0][1]);
//
//        
//
//    }
}
