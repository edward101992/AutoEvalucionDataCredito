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
    
       public void agregarPersona(int cod, String nom, String ape){
            Persona per = new Persona(cod,nom,ape);
            if(persona.containsKey(cod)){
                System.out.println("La persona ya esta registrada");
            }else{
                persona.put(cod, per);
            }                       
    }
    
 public void agregarReporte(int id){
        try{
            if(persona.containsKey(id)){
                System.out.println("Codigo del reporte: ");
                int codigo=Integer.parseInt(datos.readLine());
                System.out.println("Empresa: ");
                String nombre=datos.readLine();
                System.out.println("Estado P - N");
                String estado=datos.readLine();
                if((estado.equals("P"))||((estado.equals("N")))){
                     System.out.println("Valor: ");
                     int valor=Integer.parseInt(datos.readLine());
                     Reporte rep=new Reporte(codigo,nombre,estado,valor);
                     persona.get(id).getReporte().put(codigo, rep);                  
                }else{
                 System.out.println("El estado no es valido");
                }              
            }else{
                System.out.println("El cliente no está registrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 
    
    public void eliminarReporte(int cod){
          try{
              if(persona.containsKey(cod)){
                  if(persona.get(cod).reporte.isEmpty()){
                      System.out.println("El usuario no tiene reportes");
                  }else{
                      int codigoReporte;
                      System.out.println("Digite codigo del reporte");
                      codigoReporte = Integer.parseInt(datos.readLine()); 
                       for(Reporte report : persona.get(cod).getReporte().values()){  
                           if(report.getCodigo() == codigoReporte){
                               if(report.getCodigo() == codigoReporte && report.getEstado().equals("P")){
                                    System.out.println("No se puede eliminar un reporte Positivo");
                               }else{
                                     persona.get(cod).getReporte().remove(codigoReporte);
                                     System.out.println("Reporte eliminado satisfactoriamente");
                                }
                           }                         
                      }
                  }
              }else{
                  System.out.println("El cliente no esta en el sistema...");
              }
          }catch(Exception ex){
                System.out.println(ex.getMessage());
                
          }
      }
    
    
}
