/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBean;

import Clases.Estudiante;
import Controlador.CursoControl;
import Controlador.EstudianteControl;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Felipe
 */
@Named(value = "estudianteBeann")
@RequestScoped
public class EstudianteBean {
     
    
    Estudiante es=new Estudiante();

    
    public Estudiante getEs() {
        return es;
    }

    public void setEs(Estudiante es) {
        this.es = es;
    }

  

    public void registrar(){
        EstudianteControl per=new EstudianteControl();
        try {
            per.insertarEstudiante(es.getCedula(),es.getNombre(),es.getApellidos(), es.getEdad(),es.getDireccion(),es.getTelefono(), es.getIdCurso());
        } catch (Exception e) {
            throw e;
        }
    }
      public void actualizar(){
        EstudianteControl per=new EstudianteControl();
        try {
            per.actualizoEstudiante(es.getCedula(),es.getNombre(),es.getApellidos(), es.getEdad(),es.getDireccion(),es.getTelefono(), es.getIdCurso());
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void eliminar(){
        EstudianteControl cc=new EstudianteControl();
        try {
            cc.eliminarEstudiante(es.getCedula());
        } catch (Exception e) {
            throw e;
        }
    }
    public void listar(){
        EstudianteControl cc=new EstudianteControl();
        try {
            cc.listarEstudiante();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
