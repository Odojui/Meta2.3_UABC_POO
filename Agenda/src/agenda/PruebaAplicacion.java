/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author carlo
 */



    /**
    * @param args the command line arguments
    */
    public class PruebaAplicacion {
    
    public static void main(String[] args)
    {
        PruebaAplicacion pruebaApp = new PruebaAplicacion();
        
        pruebaApp.agregarContacto();
    }
    
    Agenda agenda;
    
    public PruebaAplicacion()
    {
       agenda = new Agenda();
    }
    
    /*
        Para mensajes de informacion:
        JOptionPane.showMessageDialog(null,"Mensaje","Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        Para mensajes de error:
        JOptionPane.showMessageDialog(null,"Mensaje","Nombre ventana",JOptionPane.ERROR_MESSAGE);
        Para mensajes de aviso importante:
        JOptionPane.showMessageDialog(null,"Mensaje","Nombre ventana",JOptionPane.WARNING_MESSAGE);
    
        Para preguntas si o no y mensajes con confirmacion
        int respuesta = JOptionPane.showConfirmDialog(null,"Mensaje","Nombre ventana",JOptionPane.YES_NO_OPTION);
        //JOptionPane.YES_NO_OPTION es SI o NO
        //JOptionPane.YES_NO_CANCEL_OPTION es SI, NO o CANCELAR
        //JOptionPane.OK_CANCEL_OPTION es ACEPTAR o CANCELAR
        //JOptionPane.DEFAULT_OPTION es ACEPTAR
        //SI = 0
        //NO = 1
        //CANCEL = 2
    
        Para preguntas con salida String
        String respuesta = JOptionPane.showInputDialog(null,"Mensaje","Text por defecto (Argumento opcional)");
        JOptionPane.showMessageDialog(null,"Respuesta: "+respuesta,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        CANCEL = null
    
    
        ******************Seccion de preguntas de seleccion mulitple************
    
        Para preguntas de seleccion multiple
        Object[] botones = {"Hugo", "Paco", "Luis"};
        int respuesta = JOptionPane.showOptionDialog(null,"Mensaje","Nombre ventana",
        JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]);
        
        Para preguntas con listas
        Object[] lista = {"Hugo", "Paco", "Luis"};
        Object respuesta = JOptionPane.showInputDialog(null,"Mensaje","Nombre ventana",
        JOptionPane.INFORMATION_MESSAGE,null,lista,lista[0]);
        //CANCEL = null
    
        Para preguntas con listas Integer
        Integer[] lista = {1, 2, 3};
        Integer respuesta = (Integer)JOptionPane.showInputDialog(null,"Mensaje","Nombre ventana",
        JOptionPane.INFORMATION_MESSAGE,null,lista,lista[0]);
    
        Para convertir la respuesta a String:
        String respuestaString = botones[respuesta].toString();
        Para convertir la respuesta a Int:
        int respuestaInt = (Integer)botones[respuesta];
        
        
    */
    
    public void pruebaJOption()
    {
        Object[] lista = {1, 2, 3};
        Object respuesta = JOptionPane.showInputDialog(null,"Mensaje","Nombre ventana",
        JOptionPane.INFORMATION_MESSAGE,null,lista,lista[0]);
        if(respuesta == null)
            respuesta = lista[0];
        int respuestaInt = (Integer)respuesta;
        JOptionPane.showMessageDialog(null,"Respuesta: "+respuestaInt,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void agregarContacto()
    {
        /*
        public void agregarContacto(String numero, String nombre, int dia, int mes, int año)
        {
            Contacto nuevoContacto = new Contacto(numero, nombre, dia, mes-1, año);
            contactos.add(nuevoContacto);
        }
        */
        boolean sonDigitos;
        String numero;
        String nombre;
        int dia;
        int mes;
        int año=0;//Hay que inicializar la variable para su uso posterior
        
        //Numero de telefono del contacto
        do
        {
            sonDigitos = true;
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            numero = JOptionPane.showInputDialog(null,"Número de Telefono","###-###-####");
            if(numero.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                sonDigitos = false;
            }
            else
            {
                if((numero.length())!=10)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese número a 10 dígitos.","Error",JOptionPane.ERROR_MESSAGE);
                    sonDigitos = false;
                }
            }
        }
        while(sonDigitos == false);
        
        //Nombre del contacto
        nombre = JOptionPane.showInputDialog(null,"Nombre del contacto","Nombre");
        
        //Año de cumpleaños del contacto
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        do
        {
            sonDigitos = true;
            String añoString = JOptionPane.showInputDialog(null,"Año de cumpleaños","####");
            
            
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            if(añoString.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                sonDigitos = false;
            }
            else
            {
                año = Integer.parseInt(añoString);
                if(año>añoActual)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese un año válido.","Error",JOptionPane.ERROR_MESSAGE);
                    sonDigitos = false;
                }
            }
        }while(sonDigitos == false);
        JOptionPane.showMessageDialog(null,"Año: "+año,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        
        /*
        //Mes de cumpleaños del contacto
        Integer[] mesLista = {1,2,3,4,5,6,7,8,9,10,11,12};
        mes = (Integer)JOptionPane.showInputDialog(null,"Día de cumpleaños","Cumpleaños: día",
        JOptionPane.INFORMATION_MESSAGE,null,mesLista,mesLista[0]);
        JOptionPane.showMessageDialog(null,"Numero: "+mes,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        
        
        Integer[] lista = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        Integer respuesta = (Integer)JOptionPane.showInputDialog(null,"Día de cumpleaños","Cumpleaños: día",
        JOptionPane.INFORMATION_MESSAGE,null,lista,lista[0]);
        JOptionPane.showMessageDialog(null,"Numero: "+respuesta,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        */
    }
}
