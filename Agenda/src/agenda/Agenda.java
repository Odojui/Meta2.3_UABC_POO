/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.*;


public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        
        
        agenda.agregarContacto("6861987523","Rebeca",28,01,1996);
        agenda.agregarContacto("6861204177","Irma",17,10,1972);
        agenda.agregarContacto("6863315483","Adriana",21,12,2000);
        agenda.agregarContacto("6862038026","Alberto",10,12,1973);
        agenda.agregarContacto("6861564896","Bertha",20,11,1994);
        agenda.agregarContacto("6861519874", "Luis", 15, 07, 2001);
        agenda.agregarContacto("6863310614","Carlos",29,06,2001);
        
        agenda.mostrarContactos(1);
        System.out.println("");
        agenda.mostrarContactos(2);
        
        
        
        
        
    }
    
    /*
    To do: 
    1.- Agregar.                                                    Listo
    2.- Consultar
            *Ordenar contactos por nombre o fecha de cumpleaños.    Listo
            *Búsqueda de un contacto por nombre o teléfono.
    3.- Modificar
    4.- Eliminar
    */
    
    ArrayList<Contacto> contactos;
    
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
    public void mostrarContactos(int nombreOFecha)
    {
        Contacto contactoAuxiliar;
        String nombreContacto1;
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
                    System.out.println(c);
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
                    System.out.println(c);
                } 
                break;
                
            default:
                System.out.println("Elija correctamente");
                break;
        }
    }
}
