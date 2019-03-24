/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacreditoauto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.io.FileOutputStream;
/**
 *
 * @author Edward Ramos - Sebastian Rincon
 */
public class Negocio implements java.io.Serializable{
   
    public BufferedReader datos = new BufferedReader(new InputStreamReader(System.in));
    private HashMap<Integer, Persona>persona;
    
    public Negocio(){
        persona = new HashMap();
    }
    
    public void inicio(){
        try{
            
            String opc = "";
            int codigoCliente;
            do{
                leerArchivo();
                System.out.println("1. Agregar Persona");
                System.out.println("2. Agregar Reporte a persona");
                System.out.println("3. Eliminar Reporte");
                System.out.println("4. Buscar");
                System.out.println("5. Salir");
                opc = datos.readLine();
                
                if(opc.equals("1")){
                    System.out.println("Agregar Persona *****");
                    System.out.println("Digite nombre: ");
                    String nombre = datos.readLine();
                    System.out.println("Digite Apellido");
                    String apellido = datos.readLine();
                    System.out.println("Digite Codigo:");
                    codigoCliente = Integer.parseInt(datos.readLine());
                    agregarPersona(codigoCliente,nombre,apellido);
                    guardarArchivo();
                }else if(opc.equals("2")){
                    System.out.println("Agregar Reporte a Persona *****");
                    System.out.println("Digite codigo de Persona:");
                    codigoCliente = Integer.parseInt(datos.readLine());
                    agregarReporte(codigoCliente);
                    guardarArchivo();          
                }else if(opc.equals("3")){
                    System.out.println("Eliminar Reporte de Cliente ******");
                    System.out.println("Digite codigo de Persona:");
                    codigoCliente = Integer.parseInt(datos.readLine());
                    eliminarReporte(codigoCliente);
                    guardarArchivo();
                }else if(opc.equals("4")){
                    System.out.println("Buscar Reportes de Cliente *****");
                    System.out.println("Digite codigo de Persona:");
                    codigoCliente = Integer.parseInt(datos.readLine());
                    verReporte(codigoCliente);
                }else if(opc.equals("5")){
                    System.out.println("Fin de la aplicacion");
                }
                        
            }while(!(opc.equals("5")));
            
            
            
        }catch(Exception Ex){
            System.out.println(Ex.getMessage());
            System.out.println("Aqui ocurrio un error Linea 40");
        }
          
    }
    
     public void leerArchivo() throws FileNotFoundException, IOException{
        File f;
        f=new File("Archivo\\persona.txt");
        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(f));
        try{
            persona=(HashMap)entrada.readObject();
        }catch(Exception ex){
            System.out.println("Error al leer el archivo");
            System.err.println(ex.getMessage());
        }finally{
            entrada.close();
        }    
    }
     
    public void guardarArchivo() throws FileNotFoundException, IOException{
        File f;
        f=new File("Archivo\\persona.txt");
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));
        try{
            salida.writeObject(persona);
        }catch(Exception ex){
            System.out.println("Error al Guardar el archivo");
            ex.getMessage();
        }finally{
            salida.close();
        }
    }
    
    
    
}
