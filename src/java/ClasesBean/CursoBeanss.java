/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBean;

import Clases.Curso;
import Controlador.CursoControl;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Felipe
 */
@Named(value = "cursoBeann")
@RequestScoped
public class CursoBeanss {
Curso curso=new Curso();
  

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void guardar(){
        CursoControl cc=new CursoControl();
        
        
        try {
           cc.insertarCuso(curso);
        } catch (Exception e) {
            throw e;
        }
    }
    public void actualizar(){
        CursoControl cc=new CursoControl();
        try {
            cc.actualizarCurso(curso);
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void eliminar(){
        CursoControl cc=new CursoControl();
        try {
            cc.eliminarCurso(curso.getIdCodigo());
        } catch (Exception e) {
            throw e;
        }
    }
    public CursoBeanss() {
    }
    
}
