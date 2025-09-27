/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Representa un servicio ofrecido por un proveedor dentro del sistema.
 * 
 * <p>Extiende la clase {@link Item} e implementa el tipo específico de ítem
 * como "Servicio".</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Servicio extends Item {

    /**
     * Construye un nuevo servicio con los datos especificados.
     * 
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param precio precio del servicio
     */
    public Servicio(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }

    /**
     * Retorna el tipo de ítem.
     * 
     * @return "Servicio"
     */
    @Override
    public String getTipo() {
        return "Servicio";
    }   
}

