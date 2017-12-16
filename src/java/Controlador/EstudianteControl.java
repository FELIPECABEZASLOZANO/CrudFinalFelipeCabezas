/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Estudiante;
import Modelo.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
   
    public List<Estudiante> listarEstudiantes() {
      List<Estudiante> lista=null;
        String sql = "select idEstudiante, nombre, apellidos, telefono, edad, direccion, idCurso from estudiante";
        ResultSet res = p.ejecutarconsulta(sql);

        try {
            int i = 0;
            lista=new ArrayList();
            while (res.next()) {
                Estudiante est=new Estudiante();
                est.setCedula(res.getInt(1));
                est.setNombre( res.getString(2));
                est.setApellidos(res.getString(3));
                est.setTelefono(res.getString(4));
                est.setEdad(res.getInt(5));
                est.setDireccion(res.getString(6));
                est.setIdCurso(res.getInt(7));
                
                
                
                
                lista.add(est);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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
