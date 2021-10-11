/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.ParseException;
import java.util.*;


public class Contacto {
    String numero;
    String nombre;
    Calendar cumple = new GregorianCalendar();
    
    public Contacto(String numero, String nombre, int dia, int mes, int año)
    {
        this.numero = numero;
        this.nombre = nombre;
        cumple.set(Calendar.YEAR, año);
        cumple.set(Calendar.MONTH, mes);
        cumple.set(Calendar.DAY_OF_MONTH, dia);
    }
    
    public String getNumero()
    {
        return this.numero;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public Date getCumple()
    {
        return this.cumple;
    }
    
    public void setCumple(String fecha)
    {
        try {
            cumple = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
