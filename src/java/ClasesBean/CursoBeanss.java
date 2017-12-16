/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBean;

import Clases.Curso;
import Controlador.CursoControl;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Felipe
 */
@Named(value = "cursoBeann")
@RequestScoped
public class CursoBeanss {
Curso curso=new Curso();
private List<Curso> listacursos;
  

    public Curso getCurso() {
        return curso;
    }

    public List<Curso> getListacursos() {
        return listacursos;
    }

    public void setListacursos(List<Curso> listacursos) {
        this.listacursos = listacursos;
    }

    

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void guardar(){
        CursoControl cc=new CursoControl();
        
        boolean inserto=cc.insertarCuso(curso);
        
        
        try {
           
           if(inserto){
            FacesMessage msg = new FacesMessage("Curso registrado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            listar();}
            else{
              FacesMessage msgf = new FacesMessage("No se pudo Guardar... /n datos erroneos o codigo ya registrado!!");
            FacesContext.getCurrentInstance().addMessage(null, msgf);      
                    
            
           }
           
        } catch (Exception e) {
            throw e;
        }
    }
    public void actualizar(){
        CursoControl cc=new CursoControl();
        boolean actualizo= cc.actualizarCurso(curso);
        try {
            if(actualizo){
                FacesMessage msg = new FacesMessage("Curso actualizado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
                 this.listar();
            }
           
           
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void eliminar(){
        CursoControl cc=new CursoControl();
        try {
           boolean eli= cc.eliminarCurso(curso.getIdCodigo());
           if(eli){
               FacesMessage msg = new FacesMessage("Curso eliminado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
               this.listar();
           }
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void listar(){
        CursoControl cc=new CursoControl();
        try {
            listacursos=cc.listarCursos();
        } catch (Exception e) {
            throw e;
        }
    }
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panelCur");
    }
     
    
    public CursoBeanss() {
    }
    
}
