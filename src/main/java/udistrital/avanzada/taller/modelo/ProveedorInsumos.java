/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
<<<<<<< HEAD
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.0
 * 21/09/2025
 * La clase ProveedoresInsumos ha sido creada, estableciendo su funcionamiento 
 */
public class ProveedorInsumos extends Proveedor{
    
    public ProveedorInsumos(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
    }
    
=======
 * Representa un proveedor especializado en la venta de insumos.
 * 
 * <p>Extiende la clase {@link Proveedor} y mantiene la misma funcionalidad,
 * diferenciándose únicamente en el tipo de proveedor al que pertenece
 * dentro del sistema.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class ProveedorInsumos extends Proveedor {

    /**
     * Construye un proveedor de insumos con los datos especificados.
     * 
     * @param nombre nombre del proveedor
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico
     * @param id identificador único
     * @param tipoProveedor tipo de proveedor (ej. venta de partes, repuestos, etc.)
     */
    public ProveedorInsumos(String nombre, String contraseña, String correo, String id, TipoProveedor tipoProveedor) {
        super(nombre, contraseña, correo, id, tipoProveedor);
    }
>>>>>>> ce6ab0c005683ed04df5b602a5d7414eaba217e4
}

