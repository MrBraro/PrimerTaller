/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import java.util.ArrayList;
/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.0
 * 21/09/2025
 * La clase Usuario ha sido creada, estableciendo su funcionamiento 
 */
public class Usuario extends Persona {
    private ArrayList<Usuario> amigos;
    private ArrayList<Vehiculo> vehiculos;

    public Usuario(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.amigos=new ArrayList<>();
        this.vehiculos= new ArrayList<>();
    }
}
