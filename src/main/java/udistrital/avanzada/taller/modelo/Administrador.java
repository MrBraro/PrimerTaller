/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import java.util.List;
import udistrital.avanzada.taller.control.ControlProveedores;

/**
 * Representa al administrador del sistema, encargado de gestionar proveedores.
 * 
 * <p>El administrador puede registrar y eliminar proveedores del sistema,
 * además de consultar el listado de proveedores existentes.</p>
 *
 * <p>Se apoya en la clase {@link ControlProveedores} para realizar estas
 * operaciones.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Administrador extends Persona {
    private ControlProveedores gestor;

    /**
     * Constructor de la clase Administrador.
     * 
     * @param nombre nombre del administrador
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico del administrador
     * @param gestor instancia de {@link ControlProveedores} para gestionar proveedores
     * @param id identificador único
     */
    public Administrador(String nombre, String contraseña, String correo, ControlProveedores gestor, String id) {
        super(nombre, contraseña, correo, id);
        this.gestor = gestor;
    }

    /**
     * Registra un proveedor en el sistema.
     * 
     * @param proveedor proveedor a registrar
     * @return true si se registró exitosamente, false si ya existía
     */
    public boolean registrarProveedor(Proveedor proveedor) {
        return this.gestor.registrarProveedor(proveedor);
    }

    /**
     * Elimina un proveedor del sistema.
     * 
     * @param proveedor proveedor a eliminar
     * @return true si se eliminó exitosamente, false si no existía
     */
    public boolean eliminarProveedor(Proveedor proveedor) {
        return this.gestor.eliminarProveedor(proveedor);
    }

    /**
     * Obtiene la lista de proveedores registrados en el sistema.
     * 
     * <p>Este método reemplaza el uso de {@code System.out.println} en la capa de
     * modelo/control, ya que la presentación debe manejarse desde la vista.</p>
     * 
     * @return lista inmutable de proveedores registrados
     */
    public List<Proveedor> listarProveedores() {
        return this.gestor.getProveedores();
    }
}
