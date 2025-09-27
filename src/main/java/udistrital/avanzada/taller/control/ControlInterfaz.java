/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.Registro;

/**
 *
 * @author Paula Martínez
 * @version 1.5 23/09/2025 La clase ControlInterfaz.java ha sido creada con el
 * fin de controlar la interfaz del programa
 */
public class ControlInterfaz {

    private ControlLogica cLogica;
    private Inicio inicio;
    private Registro registro;

    public ControlInterfaz(ControlLogica cLogica, Inicio inicio, Registro registro) {

        /*Hacemos una inyección de dependencias de ControlLogica
        e instanciamos inicio (La primera ventana del programa)*/
        this.cLogica = cLogica;
        this.inicio = inicio;

//        inicio.setVisible(true);
        registro.setVisible(true);
        //Iniciamos este metodo desde el constructor
        configurarEventosInicio();
    }
    /**
     * Configura todos los eventos de la ventana inicio
     */
    public void configurarEventosInicio(){
        //Agregar un FocusListener a la cajaUsuario
        this.inicio.cajaUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu usuario".equals(inicio.cajaUsuario.getText().trim())) {
                    inicio.cajaUsuario.setText("");
                    inicio.cajaUsuario.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (inicio.cajaUsuario.getText().trim().isEmpty()) {
                    inicio.cajaUsuario.setText("Ingresa tu usuario");
                    inicio.cajaUsuario.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.inicio.cajaContraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu Contraseña".equals(inicio.cajaContraseña.getText().trim())) {
                    inicio.cajaContraseña.setText("");
                    inicio.cajaContraseña.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (inicio.cajaContraseña.getText().trim().isEmpty()) {
                    inicio.cajaContraseña.setText("Ingresa tu usuario");
                    inicio.cajaContraseña.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
    }
}
