/**
 * @desc
 * Dentro de contacto se tienen los tipos de datos primordiales con los que se
 * trabajarán dentro de la agenda. Se tienen métodos básicos y comunes como el
 * get y toString, dado que la clase que realmente los trabaja es la
 * agenda.
 *
 * @author José Carlos Ponce Odohui & Luis Alberto Alvarado Mendoza
 * @version 16/10/2021
 */


package agenda;

import java.util.*;
import java.text.*;


public class Contacto {
    String numero;
    String nombre;
    Calendar cumple = new GregorianCalendar();
    
    public Contacto()
    {
        numero = "0";
        nombre = "A";
        cumple.set(Calendar.YEAR, 0);
        cumple.set(Calendar.MONTH, 0);
        cumple.set(Calendar.DAY_OF_MONTH, 0);
    }
    
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
    public Calendar getCumple()
    {
        return cumple;
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String formatoEnString = formato.format(cumple.getTime());
        return "Nombre: " + nombre + ". Número: " + numero + ". Cumpleaños: " + formatoEnString;
    }
}
