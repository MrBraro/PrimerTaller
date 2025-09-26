/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Representa un proveedor especializado en la prestación de servicios.
 * 
 * <p>Extiende la clase {@link Proveedor} y mantiene la misma funcionalidad,
 * diferenciándose únicamente en el tipo de proveedor al que pertenece
 * dentro del sistema.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class ProveedorServicios extends Proveedor {

    /**
     * Construye un proveedor de servicios con los datos especificados.
     * 
     * @param nombre nombre del proveedor
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico
     * @param id identificador único
     * @param tipoProveedor tipo de proveedor (ej. taller, lavadero, parqueadero, etc.)
     */
    public ProveedorServicios(String nombre, String contraseña, String correo, String id, TipoProveedor tipoProveedor) {
        super(nombre, contraseña, correo, id, tipoProveedor);
    }    
}

