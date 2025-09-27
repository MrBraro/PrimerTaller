/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import java.util.ArrayList;

/**
 * Representa a un usuario dentro del sistema.
 * 
 * <p>Un usuario hereda de {@link Persona} y cuenta con la capacidad de registrar
 * vehículos y mantener una lista de amigos (otros usuarios) dentro de la aplicación.</p>
 * 
 * <p>Los vehículos permiten asociar scooters o motos eléctricas a cada usuario,
 * mientras que la lista de amigos establece relaciones sociales dentro del sistema.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Usuario extends Persona {
    private ArrayList<Usuario> amigos;
    private ArrayList<Vehiculo> vehiculos;

    /**
     * Construye un nuevo usuario con los datos especificados.
     * 
     * @param nombre nombre del usuario
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico
     * @param id identificador único
     */
    public Usuario(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.amigos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    /**
     * Obtiene la lista de amigos del usuario.
     * 
     * @return lista de usuarios amigos
     */
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * Obtiene la lista de vehículos registrados por el usuario.
     * 
     * @return lista de vehículos del usuario
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
