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
        boolean salir;
        
        do{
            salir = pruebaApp.menuUsuario();
        }while(salir==false);
    }
    
    Agenda agenda;
    
    public PruebaAplicacion()
    {
       agenda = new Agenda();
    }
    
    public boolean menuUsuario()
    {
        boolean salir = false;
        Object[] botones = {"Agregar contacto", "Mostrar contactos", "Buscar contacto", "Modificar contacto", "Borrar contacto", "Salir"};
        int respuesta = JOptionPane.showOptionDialog(null,"Seleccione la acción a realizar","Agenda",
        JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]);
        switch(respuesta)
        {
            case 0:
               agregarContacto();
                break;
            case 1:
                consultaAvanzada();
                break;
            case 2:
                busquedaContacto();
                break;
            case 3:
                modificarContacto();
                break;
            case 4:
                removerContacto();
                break;
            case 5:
                respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro de querer salir?","Salir",JOptionPane.YES_NO_OPTION);
                if(respuesta==0)
                {
                    JOptionPane.showMessageDialog(null,"Hasta pronto!","Salir",JOptionPane.INFORMATION_MESSAGE);
                    salir = true;
                }
                break;
        }
        
        return salir;
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
        Object respuestaMes = JOptionPane.showInputDialog(null,"Mes de cumpleaños","Cumpleaños: mes",
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
                if(((mes==4)||(mes==6)||(mes==9)||(mes==11))&&(respuestaDia>30))
                    esValido = false;
                      
        if(esValido==false)
            JOptionPane.showMessageDialog(null,"Ingrese un día válido.","Error",JOptionPane.ERROR_MESSAGE);
        else
            dia = respuestaDia;
        }while(esValido == false);
                
        
        agenda.agregarContacto(numero, nombre, dia, mes, año);
    }
    
    public void consultaAvanzada(){
        int consultaOpcion;
        
        if(agenda.contactos.size()>0)
        {
            Object[] opcionesConsulta = {"Por nombre","Por fecha"};
            Object opcionElegida = JOptionPane.showOptionDialog(null,"Mostrar agenda ordenado: ","Consulta de agenda ordenada",
            JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcionesConsulta,opcionesConsulta[0]);
            consultaOpcion = (Integer)opcionElegida +1;
            JOptionPane.showMessageDialog(null, agenda.mostrarContactos(consultaOpcion));
        }
        else
            JOptionPane.showMessageDialog(null,"La agenda está vacia","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void busquedaContacto(){
        int pregunta;
        boolean esValido;
        String contactoBuscar, contactoEncontrado;
        
        if(agenda.contactos.size()>0)
            do
            {
                contactoBuscar = JOptionPane.showInputDialog(null,"Búsqueda en agenda","Nombre o número");
                contactoEncontrado = agenda.busquedaContacto(contactoBuscar,true);
                if(contactoEncontrado.length()<1)
                {
                    pregunta = JOptionPane.showConfirmDialog(null,"El contacto "+ contactoBuscar +" no existe en la agenda\n¿Intentar de nuevo?",
                    "Error: Contacto no encontrado",JOptionPane.YES_NO_OPTION);
                    esValido = pregunta==1;
                }
                else
                {
                    esValido = true;
                    JOptionPane.showMessageDialog(null,"Datos de contacto:\n"+contactoEncontrado,
                    "Busqueda en agenda",JOptionPane.INFORMATION_MESSAGE);
                }
            }while(esValido==false);
        else
            JOptionPane.showMessageDialog(null,"La agenda está vacia","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void removerContacto(){
        int pregunta;
        boolean esValido;
        String contactoBuscar, contactoEncontrado;
        
        if(agenda.contactos.size()>0)
        {
            do
            {
                contactoBuscar = JOptionPane.showInputDialog(null,"Ingrese contacto a eliminar","Nombre o número");
                contactoEncontrado = agenda.busquedaContacto(contactoBuscar,false);
                if(contactoEncontrado.length()<1)
                {
                    pregunta = JOptionPane.showConfirmDialog(null,
                    "El contacto "+ contactoBuscar +" no existe en la agenda\n¿Intentar de nuevo?",
                    "Error: Contacto no encontrado",JOptionPane.YES_NO_OPTION);
                    esValido = pregunta==1;
                }
                else
                {
                    agenda.eliminarContacto(contactoEncontrado);
                    JOptionPane.showMessageDialog(null,"El contacto "+ contactoEncontrado +" ha sido eliminado",
                    "Eliminar contacto",JOptionPane.ERROR_MESSAGE);
                    esValido = true;
                }
            }while(esValido==false);
        }
        else
            JOptionPane.showMessageDialog(null,"La agenda está vacia","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void modificarContacto(){
        String contactoBuscar, contactoEncontrado;
        boolean esValido;
        String numero;
        String nombre;
        int dia=0, mes=0, año=0,pregunta;
        
        if(agenda.contactos.size()>0)
            do
            {
                contactoBuscar = JOptionPane.showInputDialog(null,"Contacto a modificar","Nombre o número");
                contactoEncontrado = agenda.busquedaContacto(contactoBuscar,true);
                if(contactoEncontrado.length()<1)
                {
                    pregunta = JOptionPane.showConfirmDialog(null,"El contacto "+ contactoBuscar +" no existe en la agenda\n¿Intentar de nuevo?",
                    "Error: Contacto no encontrado",JOptionPane.YES_NO_OPTION);
                    esValido = pregunta==1;
                }
                else
                {
                    esValido = true;
                    //NUEVOS DATOS DEL CONTACTO
                    //Numero de telefono del contacto
                    do
                    {
                        esValido = true;
                        String regex = "[0-9]+";//Todos los digitos del 0 al 9
                        numero = JOptionPane.showInputDialog(null,"Nuevo número de Telefono","###-###-####");
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
                    nombre = JOptionPane.showInputDialog(null,"Nuevo nombre del contacto","Nombre");


                    //Año de cumpleaños del contacto
                    int añoActual = Calendar.getInstance().get(Calendar.YEAR);
                    do
                    {
                        esValido = true;
                        String añoString = JOptionPane.showInputDialog(null,"Nuevo año de cumpleaños","####");


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
                    Object respuestaMes = JOptionPane.showInputDialog(null,"Nuevo mes de cumpleaños","Cumpleaños: mes",
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
                        Integer respuestaDia = (Integer)JOptionPane.showInputDialog(null,"Nuevo día de cumpleaños","Cumpleaños: día",
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
            }while(esValido==false);
        else
            JOptionPane.showMessageDialog(null,"La agenda está vacia","Error",JOptionPane.ERROR_MESSAGE);
    }
    
}
