/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.*;


public class Agenda {

    
    
    /*
    To do: 
    1.- Agregar.                                                    Listo
    2.- Consultar                                                   Listo
            *Ordenar contactos por nombre o fecha de cumpleaños.    Listo
            *Búsqueda de un contacto por nombre o teléfono.         Listo
    3.- Modificar                                                   Listo
    4.- Eliminar                                                    Listo
    */
    
    ArrayList<Contacto> contactos;
    
    //Constructor
    public Agenda()
    {
        contactos = new ArrayList();
    }
    
    
    
    //Se agrega el contacto al array
    public void agregarContacto(String numero, String nombre, int dia, int mes, int año)
    {
        Contacto nuevoContacto = new Contacto(numero, nombre, dia, mes-1, año);
        contactos.add(nuevoContacto);
    }
    
    
    
    //Se utiliza el método de la burbuja
    public String mostrarContactos(int nombreOFecha)
    {
        Contacto contactoAuxiliar;
        String nombreContacto1;
        String contactoOrdenado="";
        String nombreContacto2;
        Calendar cumpleContacto1;
        Calendar cumpleContacto2;
        
        switch(nombreOFecha)
        {
            case 1: //Nombre
                for(int i = 1; i < contactos.size(); i++)
                {
                  for(int j = 0;j < contactos.size()-i;j++)
                  {
                      //Aqui se empieza el método de la burbuja para nombres
                      nombreContacto1 = contactos.get(j).getNombre();
                      nombreContacto2 = contactos.get(j+1).getNombre();
                      
                    if(nombreContacto1.compareToIgnoreCase(nombreContacto2)>=0)
                    {
                      contactoAuxiliar = contactos.get(j);
                      contactos.set((j),contactos.get(j+1));
                      contactos.set((j+1), contactoAuxiliar);
                    }   
                  }
                }
                
                for (Contacto c : contactos)
                {
                    contactoOrdenado+=c+" \n";
                    //System.out.println(c);
                } 
                break;
                
            //***************************************************************  
                
            case 2: //Orden por fecha
                for(int i = 1; i < contactos.size(); i++)
                {
                  for(int j = 0;j < contactos.size()-i;j++)
                  {
                      //Aqui se empieza el método de la burbuja para nombres
                      cumpleContacto1 = contactos.get(j).getCumple();
                      cumpleContacto2 = contactos.get(j+1).getCumple();
                      
                    if(cumpleContacto1.compareTo(cumpleContacto2)>=0)
                    {
                      contactoAuxiliar = contactos.get(j);
                      contactos.set((j),contactos.get(j+1));
                      contactos.set((j+1), contactoAuxiliar);
                    }   
                  }
                }
                
                for (Contacto c : contactos)
                {
                    contactoOrdenado+=c+" \n";
                    //System.out.println(c);
                } 
                break;
        }
        return contactoOrdenado;
    }
    
    public String busquedaContacto(String datoBuscar, boolean busquedaCompleta)
    {
        int encontrado = -1;
        String contactoHallado="";
        for(int k=0;k<=contactos.size()-1;k++){
            String nombreComparar = contactos.get(k).getNombre();
            String numeroComparar = contactos.get(k).getNumero();
            boolean existeNombre = datoBuscar.compareTo(nombreComparar)==0;
            boolean existeNumero = datoBuscar.compareTo(numeroComparar)==0;
            if(existeNombre || existeNumero){
                encontrado = k;
            }
        }
        
        if(encontrado == -1)
        {
            contactoHallado = "";
            
        }
        if(encontrado>=0)
        {
            if(busquedaCompleta==true)
                contactoHallado=(contactos.get(encontrado).toString());
            else
                contactoHallado = contactos.get(encontrado).getNombre();
        }
        return contactoHallado;
    }
    
    public String modificarContacto(String datoBuscar, String newNombre, String newNumero, int newDia, int newMes, int newAño)
    {
        String contactoModificado,contactoAntiguo,contactoEnviado="";
        int encontrado = -1,numContacto;
        
        for(int k=0;k<=contactos.size()-1;k++){
            String nombreComparar = contactos.get(k).getNombre();
            String numeroComparar = contactos.get(k).getNumero();
            boolean existeNombre = datoBuscar.compareTo(nombreComparar)==0;
            boolean existeNumero = datoBuscar.compareTo(numeroComparar)==0;
            if(existeNombre || existeNumero){
                encontrado = k;
            }
        }
        
        if(encontrado == -1)
        {
            System.out.println("El contacto "+ datoBuscar +" no existe en la agenda");
        }
        numContacto=encontrado;
        if(numContacto != -1)
        {
            System.out.println("El contacto: \n"+contactos.get(numContacto));//Se muestra el contacto antes de modificar
            contactoAntiguo="El contacto: \n"+contactos.get(numContacto);
            Contacto contactoAux = new Contacto(newNombre, newNumero, newDia, newMes-1, newAño);
            contactos.set(numContacto, contactoAux);
            System.out.println("Ha sido modificado como: \n"+contactos.get(numContacto));//Se muestra el contacto modificado
            contactoModificado="Ha sido modificado como: \n"+contactos.get(numContacto);
            contactoEnviado=contactoAntiguo+"\n"+contactoModificado;
        }
        return contactoEnviado;
        
    }
   
    public void eliminarContacto(String datoBuscar)
    {
        int encontrado = -1,numContacto;
        
        for(int k=0;k<=contactos.size()-1;k++){
            String nombreComparar = contactos.get(k).getNombre();
            String numeroComparar = contactos.get(k).getNumero();
            boolean existeNombre = datoBuscar.compareTo(nombreComparar)==0;
            boolean existeNumero = datoBuscar.compareTo(numeroComparar)==0;
            if(existeNombre || existeNumero){
                encontrado = k;
            }
        }
        
        if(encontrado == -1)
        {
            System.out.println("El contacto "+ datoBuscar +" no existe en la agenda");
        }
        numContacto=encontrado;
        if(numContacto>=0)
        {
            System.out.println("El contacto\n"+contactos.get(numContacto)+"\nha sido eliminado");
            contactos.remove(numContacto);
        }
    }
}
