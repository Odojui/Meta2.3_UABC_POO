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
        PruebaAplicacion pruebApp = new PruebaAplicacion();
        
        pruebApp.pruebaJOption();
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
        JOptionPane.YES_NO_OPTION es SI o NO
        JOptionPane.YES_NO_CANCEL_OPTION es SI, NO o CANCELAR
        JOptionPane.OK_CANCEL_OPTION es ACEPTAR o CANCELAR
        JOptionPane.DEFAULT_OPTION es ACEPTAR
        SI = 0
        NO = 1
        CANCEL = 2
    
        Para preguntas con salida String
        String respuesta = JOptionPane.showInputDialog(null,"Mensaje","Text por defecto (Argumento opcional)");
        JOptionPane.showMessageDialog(null,"Respuesta: "+respuesta,"Nombre ventana",JOptionPane.INFORMATION_MESSAGE);
        CANCEL = null
    
        Para preguntas de seleccion multiple
        Object[] botones = {1, 2, 3};
        int respuesta = JOptionPane.showOptionDialog(null,"Mensaje","Nombre ventana",
        JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]);
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
    
}
