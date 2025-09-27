/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.Registro;

/**
 *
 * @author Paula Martínez
 * @version 1.5
 * 23/09/2025
 * La clase ControlLogica.java ha sido creada con el fin de manejar la vista
 * respetando los principios solid y el mvc.
 */
public class ControlLogica {
    private ControlInterfaz cInterfaz;
    private Inicio inicio;
    private Registro registro;
    private ControlUsuarios controlUsuarios;
    private ControlProveedores controlProveedores;

    public ControlLogica() {
        // Inicializar dependencias
        inicio = new Inicio();
        registro = new Registro();
        controlProveedores = new ControlProveedores();
        controlUsuarios = new ControlUsuarios(controlProveedores);

        // Pasar dependencias al controlador de interfaz
        cInterfaz = new ControlInterfaz(this, inicio, registro, controlUsuarios);
    }

    public ControlUsuarios getControlUsuarios() {
        return controlUsuarios;
    }
}

