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
        pruebaApp.agregarContacto();
        pruebaApp.agregarContacto();
        pruebaApp.consultaAvanzada();
        pruebaApp.busquedaContacto();
        pruebaApp.modificarContacto();
        pruebaApp.consultaAvanzada();
        pruebaApp.removerContacto();
        pruebaApp.consultaAvanzada();
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
        boolean esValido;
        String numero;
        String nombre;
        //Hay que inicializar la variable para su uso posterior
        int dia=0;
        int mes=0;
        int año=0;
        
        //Numero de telefono del contacto
        do
        {
            esValido = true;
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            numero = JOptionPane.showInputDialog(null,"Número de Telefono","###-###-####");
            if(numero.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                esValido = false;
            }
            else
            {
                if((numero.length())!=10)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese número a 10 dígitos.","Error",JOptionPane.ERROR_MESSAGE);
                    esValido = false;
                }
            }
        }
        while(esValido == false);
        
        
        //Nombre del contacto
        nombre = JOptionPane.showInputDialog(null,"Nombre del contacto","Nombre");
        
        
        //Año de cumpleaños del contacto
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        do
        {
            esValido = true;
            String añoString = JOptionPane.showInputDialog(null,"Año de cumpleaños","####");
            
            
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            if(añoString.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                esValido = false;
            }
            else
            {
                año = Integer.parseInt(añoString);
                if(año>añoActual)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese un año válido.","Error",JOptionPane.ERROR_MESSAGE);
                    esValido = false;
                }
            }
        }while(esValido == false);
        
        
        //Mes de cumpleaños del contacto
        Object[] listaMes = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        Object respuestaMes = JOptionPane.showInputDialog(null,"Escoge tu mes de cumpleaños","Cumpleaños: mes",
        JOptionPane.INFORMATION_MESSAGE,null,listaMes,listaMes[0]);
        String mesString = respuestaMes.toString();
        switch(mesString)
        {
            case "Enero":
                    mes = 1;
                    break;
            case "Febrero":
                    mes = 2;
                    break;
            case "Marzo":
                    mes = 3;
                    break;
            case "Abril":
                    mes = 4;
                    break;
            case "Mayo":
                    mes = 5;
                    break;
            case "Junio":
                    mes = 6;
                    break;
            case "Julio":
                    mes = 7;
                    break;
            case "Agosto":
                    mes = 8;
                    break;
            case "Septiembre":
                    mes = 9;
                    break;
            case "Octubre":
                    mes = 10;
                    break;
            case "Noviembre":
                    mes = 11;
                    break;
            case "Diciembre":
                    mes = 12;
                    break;
        }
        
        
        //Día de cumpleaños del contacto
        do
        {
            esValido = true;
            Integer[] listaDia = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
            Integer respuestaDia = (Integer)JOptionPane.showInputDialog(null,"Día de cumpleaños","Cumpleaños: día",
            JOptionPane.INFORMATION_MESSAGE,null,listaDia,listaDia[0]);
            if(mes==2)
            {
                if (((año % 4 == 0) && (año % 100!= 0)) || (año%400 == 0))
                {
                    if(respuestaDia>29)
                        esValido = false;
                }  
                else
                    if(respuestaDia>28)
                        esValido = false;
            }
            else
                if(((mes==2)||(mes==4)||(mes==6)||(mes==9)||(mes==11))&&(respuestaDia>30))
                    esValido = false;
                      
        if(esValido==false)
            JOptionPane.showMessageDialog(null,"Ingrese un día válido.","Error",JOptionPane.ERROR_MESSAGE);
        else
            dia = respuestaDia;
        }while(esValido == false);
                
        
        agenda.agregarContacto(numero, nombre, dia, mes, año);
    }
    
    /*public void consulta(){
        JOptionPane.showMessageDialog(null, agenda.contactosGuardados());
    }*/
    public void consultaAvanzada(){
        int consultaOpcion=0;
        Object[] consultaOrdeada = {"Por fecha","Por nombre"};
        Object opcionConsulta = JOptionPane.showInputDialog(null,"Escoge tu ordenado","Consulta de agenda ordenada",
        JOptionPane.INFORMATION_MESSAGE,null,consultaOrdeada,consultaOrdeada[0]);
        String consultaOrdenada = opcionConsulta.toString();
        switch(consultaOrdenada){
            case "Por nombre":
                    consultaOpcion = 1;
            break;
            case "Por fecha":
                    consultaOpcion = 2;
            break;
        }
        JOptionPane.showMessageDialog(null, agenda.mostrarContactos(consultaOpcion));
    }
    public void busquedaContacto(){
        String contactoBuscar = JOptionPane.showInputDialog(null,"Búsqueda en agenda","Nombre o número");
        JOptionPane.showMessageDialog(null, agenda.busquedaContacto(contactoBuscar));
    }
    public void removerContacto(){
        String contactoBuscar = JOptionPane.showInputDialog(null,"Ingrese contacto a eliminar","Nombre o número");
        agenda.eliminarContacto(contactoBuscar);
        JOptionPane.showMessageDialog(null,"El contacto ha sido eliminado","Error",JOptionPane.ERROR_MESSAGE);
    }
    public void modificarContacto(){
        String contactoBuscar = JOptionPane.showInputDialog(null,"Búsqueda en agenda","Nombre o número");
        //JOptionPane.showMessageDialog(null, agenda.busquedaContacto(contactoBuscar));
        boolean esValido;
        String numero;
        String nombre;
        //Hay que inicializar la variable para su uso posterior
        int dia=0;
        int mes=0;
        int año=0;
        
        //Numero de telefono del contacto
        do
        {
            esValido = true;
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            numero = JOptionPane.showInputDialog(null,"Número de Telefono","###-###-####");
            if(numero.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                esValido = false;
            }
            else
            {
                if((numero.length())!=10)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese número a 10 dígitos.","Error",JOptionPane.ERROR_MESSAGE);
                    esValido = false;
                }
            }
        }
        while(esValido == false);
        
        
        //Nombre del contacto
        nombre = JOptionPane.showInputDialog(null,"Nombre del contacto","Nombre");
        
        
        //Año de cumpleaños del contacto
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        do
        {
            esValido = true;
            String añoString = JOptionPane.showInputDialog(null,"Año de cumpleaños","####");
            
            
            String regex = "[0-9]+";//Todos los digitos del 0 al 9
            if(añoString.matches(regex)!=true)
            {
                JOptionPane.showMessageDialog(null,"Ingrese solo dígitos numéricos.","Error",JOptionPane.ERROR_MESSAGE);
                esValido = false;
            }
            else
            {
                año = Integer.parseInt(añoString);
                if(año>añoActual)
                {
                    JOptionPane.showMessageDialog(null,"Ingrese un año válido.","Error",JOptionPane.ERROR_MESSAGE);
                    esValido = false;
                }
            }
        }while(esValido == false);
        
        
        //Mes de cumpleaños del contacto
        Object[] listaMes = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        Object respuestaMes = JOptionPane.showInputDialog(null,"Escoge tu mes de cumpleaños","Cumpleaños: mes",
        JOptionPane.INFORMATION_MESSAGE,null,listaMes,listaMes[0]);
        String mesString = respuestaMes.toString();
        switch(mesString){
            case "Enero":
                    mes = 1;
            break;
            case "Febrero":
                    mes = 2;
            break;
            case "Marzo":
                    mes = 3;
            break;
            case "Abril":
                    mes = 4;
            break;
            case "Mayo":
                    mes = 5;
            break;
            case "Junio":
                    mes = 6;
            break;
            case "Julio":
                    mes = 7;
            break;
            case "Agosto":
                    mes = 8;
            break;
            case "Septiembre":
                    mes = 9;
            break;
            case "Octubre":
                    mes = 10;
            break;
            case "Noviembre":
                    mes = 11;
            break;
            case "Diciembre":
                    mes = 12;
            break;
        }
        //Día de cumpleaños del contacto
        do{
            esValido = true;
            Integer[] listaDia = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
            Integer respuestaDia = (Integer)JOptionPane.showInputDialog(null,"Día de cumpleaños","Cumpleaños: día",
            JOptionPane.INFORMATION_MESSAGE,null,listaDia,listaDia[0]);
            if(mes==2){
                if (((año % 4 == 0) && (año % 100!= 0)) || (año%400 == 0)){
                    if(respuestaDia>29)
                        esValido = false;
                }else
                    if(respuestaDia>28)
                        esValido = false;
            }else
                if(((mes==2)||(mes==4)||(mes==6)||(mes==9)||(mes==11))&&(respuestaDia>30))
                    esValido = false;
                      
        if(esValido==false)
            JOptionPane.showMessageDialog(null,"Ingrese un día válido.","Error",JOptionPane.ERROR_MESSAGE);
        else
            dia = respuestaDia;
        }while(esValido == false);
        JOptionPane.showMessageDialog(null, agenda.modificarContacto(contactoBuscar, numero, nombre, dia, mes, año));
    }
}
