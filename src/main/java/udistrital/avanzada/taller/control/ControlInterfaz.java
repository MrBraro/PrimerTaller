/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import udistrital.avanzada.taller.vista.Inicio;

/**
 *
 * @author Paula Martínez
 * @version 1.1
 * 23/09/2025
 * La clase ControlLogica.java ha sido creada con el fin de controlar toda la lógica 
 * del programa
 */
public class ControlInterfaz {
    
    private ControlLogica cLogica;
    private Inicio inicio;
    
    public ControlInterfaz(ControlLogica cl){
        
        /*Hacemos una inyección de dependencias de ControlLogica
        e instanciamos inicio (La primera ventana del programa)*/
        this.cLogica = cLogica;
        inicio = new Inicio();       
        
        inicio.setVisible(true);
    }
    
}
