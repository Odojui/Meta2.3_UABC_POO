/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carlo
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fecha = null;
        String fechaEscrita = "29/06/2001";
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaEscrita);
        } catch (ParseException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        Contacto contacto1 = new Contacto("6863310614" , "Juan",fecha);
        
        System.out.println("Numero: " + contacto1.numero + "  Nombre: " + contacto1.nombre + "  Cumpleaños" + contacto1.cumple);
    }
    
}
