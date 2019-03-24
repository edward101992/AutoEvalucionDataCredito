/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacreditoauto;
import java.util.HashMap;

/**
 *
 * @autor Edward Ramos - Sebastian Rincon
 */
public class Persona implements java.io.Serializable{
      
    int codigo;
    String nombre;
    String apellido;
    public HashMap<Integer, Reporte>reporte;

    public Persona(int codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        reporte = new HashMap();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    public HashMap<Integer, Reporte>getReporte(){
        return reporte;
    }
    
    public void setReporte(HashMap<Integer, Reporte>reporte){
        this.reporte = reporte;
    }
    
}
