/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import java.util.ArrayList;

public class Usuario extends Persona {
    private ArrayList<Usuario> amigos;
    private ArrayList<Vehiculo> vehiculos;

    public Usuario(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
        this.amigos=new ArrayList<>();
        this.vehiculos= new ArrayList<>();
    }
}
