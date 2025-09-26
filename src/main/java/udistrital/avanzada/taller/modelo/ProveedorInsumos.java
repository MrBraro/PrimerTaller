/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 *
 * @author Juan Estevan Ariza Ortiz
 * @version 1.4
 * 21/09/2025
 * La clase ProveedoresInsumos se modifica para establecer con un tipo de proveedor
 */
public class ProveedorInsumos extends Proveedor{

    public ProveedorInsumos(String nombre, String contraseña, String correo, String id, TipoProveedor tipoProveedor) {
        super(nombre, contraseña, correo, id, tipoProveedor);
    }
    
    
    
}
