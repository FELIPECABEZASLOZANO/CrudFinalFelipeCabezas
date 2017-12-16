/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Curso;
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
public class CursoControl {
    Persistencia p=new Persistencia();
    
     public boolean insertarCuso(Curso curso ){
        boolean inserto = false;
        String sql = "Insert into curso values ("+curso.getIdCodigo()+", '"+curso.getNombre()+"','"+curso.getDescripcion()+"')";
        inserto = p.ejecutarDML(sql);
        return inserto;
    }
      public boolean actualizarCurso(Curso curso ){
        boolean actualizo = false;
        String sql = "Update curso set idCurso="+curso.getIdCodigo()+", nombreCurso='"+curso.getNombre()+"', descripcionCurso='"+curso.getDescripcion()+"' where idCurso= "+curso.getIdCodigo();
                
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }
      public boolean eliminarCurso(int idCurso ){
        boolean elimino = false;
        String sql = "Delete from curso where idCurso='"+idCurso+"'";
                
        elimino = p.ejecutarDML(sql);
        return elimino;
    }
      public Object[][] listarCurso() {
        Object data[][] = new Object[numeroCurso()][3];
        String sql = "select idCurso, nombreCurso, descripcioncurso from curso";
        ResultSet res = p.ejecutarconsulta(sql);

        try {
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getInt(1);
                data[i][1] = res.getString(2);
                data[i][2] = res.getString(3);
                
               
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
       public List<Curso> listarCursos() {
        
        List<Curso> lista = null;
        String sql = "select idCurso, nombreCurso, descripcioncurso from curso";
        ResultSet res = p.ejecutarconsulta(sql);

        try {
            int i = 0;
            lista=new ArrayList();
            while (res.next()) {
                Curso cur=new Curso();
                cur.setIdCodigo(res.getInt(1));
                cur.setNombre(res.getString(2));
                cur.setDescripcion(res.getString(3));
                
               
                lista.add(cur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
      public int numeroCurso() {
        int numero = 0;
        ResultSet res = null;
        String sql = "Select count(*) from curso ";
        res = p.ejecutarconsulta(sql);
        try {

            while (res.next()) {
                numero = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
return numero;
    }       
      public Object[][] listarCursoId(int idCurso) {
        Object data[][] = new Object[1][7];
        String sql = "select idCurso, nombreCurso, descripcionCurso where idCurso = '"+idCurso+"'";
        ResultSet res = p.ejecutarconsulta(sql);

        try {

            while (res.next()) {
                data[0][0] = res.getInt(1);
                data[0][1] = res.getString(2);
                data[0][2] = res.getString(3);
                
               
               
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
