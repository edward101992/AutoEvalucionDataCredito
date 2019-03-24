/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacreditoauto;

/**
 *
 * @author SuperUs
 */
public class Reporte implements java.io.Serializable {
    private int codigo;
    private String empresa;
    private String estado;
    private int valor;

    public Reporte(int codigo, String empresa, String estado, int valor) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.estado = estado;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getEstado() {
        return estado;
    }

    public int getValor() {
        return valor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
