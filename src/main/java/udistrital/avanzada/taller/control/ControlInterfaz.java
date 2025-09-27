/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import udistrital.avanzada.taller.modelo.Usuario;

import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.Registro;

/**
 *
 * @author Paula Martínez
 * @version 1.5 23/09/2025 La clase ControlInterfaz.java ha sido creada con el
 * fin de controlar la interfaz del programa
 */
public class ControlInterfaz implements ActionListener {

    private ControlLogica cLogica;
    private Inicio inicio;
    private Registro registro;
    private ControlUsuarios cUsuarios;

    public ControlInterfaz(ControlLogica cLogica, Inicio inicio, Registro registro, ControlUsuarios cUsuarios) {

        /*Hacemos una inyección de dependencias de ControlLogica
        e instanciamos inicio (La primera ventana del programa)*/
        this.cLogica = cLogica;
        this.cUsuarios = cUsuarios;
        this.inicio = inicio;
        this.registro = registro;

        inicio.setVisible(true);
//        registro.setVisible(true);
        //Iniciamos este metodo desde el constructor
        configurarEventos();
        //Añado los action listener de los botones de la ventana inicio
        this.inicio.botonRegistro.addActionListener(this);
        this.inicio.botonIngresar.addActionListener(this);
        //Añado los action listener de los botones de la ventana registro
        this.registro.botonIngresar.addActionListener(this);

    }

    /**
     * Configura todos los eventos de la ventana inicio
     */
    public void configurarEventos() {
        //Agregar un FocusListener a la cajaUsuario
        this.inicio.cajaUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu Correo".equals(inicio.cajaUsuario.getText().trim())) {
                    inicio.cajaUsuario.setText("");
                    inicio.cajaUsuario.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (inicio.cajaUsuario.getText().trim().isEmpty()) {
                    inicio.cajaUsuario.setText("Ingresa tu correo");
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
                    inicio.cajaContraseña.setText("Ingresa tu contraseña");
                    inicio.cajaContraseña.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        //Ahora generamos los metodos de los placeholders en registro
        this.registro.cajaUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu usuario".equals(registro.cajaUsuario.getText().trim())) {
                    registro.cajaUsuario.setText("");
                    registro.cajaUsuario.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaUsuario.getText().trim().isEmpty()) {
                    registro.cajaUsuario.setText("Ingresa tu usuario");
                    registro.cajaUsuario.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.registro.cajaContraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu contraseña".equals(registro.cajaContraseña.getText().trim())) {
                    registro.cajaContraseña.setText("");
                    registro.cajaContraseña.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaContraseña.getText().trim().isEmpty()) {
                    registro.cajaContraseña.setText("Ingresa tu contraseña");
                    registro.cajaContraseña.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.registro.cajaCorreo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu correo".equals(registro.cajaCorreo.getText().trim())) {
                    registro.cajaCorreo.setText("");
                    registro.cajaCorreo.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaCorreo.getText().trim().isEmpty()) {
                    registro.cajaCorreo.setText("Ingresa tu correo");
                    registro.cajaCorreo.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando el usuario presiona el botón de "Registro" desde la ventana inicio
        if (e.getSource() == this.inicio.botonRegistro) {
            this.registro.setVisible(true);   // mostrar ventana de registro
            this.inicio.setVisible(false);    // opcional: ocultar ventana inicio
        }
        // Cuando el usuario presiona el botón de "Iniciar sesion" desde la ventana registro
        if (e.getSource() == this.registro.botonIngresar) {
            this.inicio.setVisible(true);    // opcional: ocultar ventana inicio
            this.registro.setVisible(false);   // mostrar ventana de registro
        }
         if (e.getSource() == this.inicio.botonIngresar) {
            String correo = inicio.cajaUsuario.getText();
            String contrasena = inicio.cajaContraseña.getText();

            // Llamar a la lógica de usuarios
            Usuario usuario = cUsuarios.autenticarUsuario(correo, contrasena);

            if (usuario != null) {
                JOptionPane.showMessageDialog(inicio, "✅ Bienvenido " + usuario.getNombre());
                inicio.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(inicio, "❌ Usuario o contraseña incorrectos");
            }
        }
    }
}
