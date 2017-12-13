/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Felipe
 */
public class Curso {
    private int idCodigo;
    private String nombre;
    private String descripcion;

    public Curso() {
    }

    public Curso(int idCodigo, String nombre, String descripcion) {
        this.idCodigo = idCodigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
