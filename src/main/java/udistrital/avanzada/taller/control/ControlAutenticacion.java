/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import udistrital.avanzada.taller.modelo.Administrador;
import udistrital.avanzada.taller.modelo.Usuario;
import udistrital.avanzada.taller.modelo.Proveedor;

/**
 * Controlador encargado de gestionar la autenticación de usuarios, proveedores
 * y administradores dentro del sistema. Permite validar credenciales de acceso
 * y determinar el rol asociado a cada entidad.
 *
 * <p>Se apoya en {@link ControlUsuarios} y {@link ControlProveedores} para
 * realizar la validación, y utiliza una instancia de {@link Administrador}
 * como referencia del administrador general del sistema.</p>
 *
 * @author juans
 * @version 1.5
 * 26/09/2025
 */
public class ControlAutenticacion {

    private ControlUsuarios controlUsuarios;
    private ControlProveedores controlProveedores;
    private Administrador administrador;

    /**
     * Constructor de la clase.
     *
     * @param controlUsuario instancia de {@link ControlUsuarios} para validación de usuarios
     * @param controlProveedores instancia de {@link ControlProveedores} para validación de proveedores
     * @param administrador administrador principal del sistema
     */
    public ControlAutenticacion(ControlUsuarios controlUsuario, ControlProveedores controlProveedores, Administrador administrador) {
        this.controlProveedores = controlProveedores;
        this.controlUsuarios = controlUsuario;
        this.administrador = administrador;
    }

    /**
     * Valida credenciales de login y retorna el rol asociado.
     *
     * <p>Si las credenciales corresponden a un usuario registrado se retorna
     * "USUARIO". Si corresponden a un proveedor, "PROVEEDOR". Si coinciden con
     * el administrador, "ADMIN". Si no hay coincidencias retorna {@code null}.</p>
     *
     * @param correo correo electrónico ingresado
     * @param clave clave de acceso ingresada
     * @return "USUARIO", "PROVEEDOR", "ADMIN" o null si no hay coincidencia
     */
    public String autenticar(String correo, String clave) {
        Usuario usuario = controlUsuarios.autenticarUsuario(correo, clave);
        if (usuario != null) {
            return "USUARIO";
        }
        Proveedor proveedor = controlProveedores.autenticarProveedor(correo, clave);
        if (proveedor != null) {
            return "PROVEEDOR";
        }

        if (administrador.getCorreo().equals(correo) && administrador.getContraseña().equals(clave)) {
            return "ADMIN";
        }
        return null;
    }

    /**
     * Valida credenciales de login y retorna la entidad correspondiente.
     *
     * <p>Si las credenciales corresponden a un usuario registrado, retorna
     * la instancia de {@link Usuario}. Si corresponden a un proveedor, retorna
     * la instancia de {@link Proveedor}. Si coinciden con el administrador,
     * retorna la instancia de {@link Administrador}. Si no hay coincidencias
     * retorna {@code null}.</p>
     *
     * @param correo correo electrónico ingresado
     * @param clave clave de acceso ingresada
     * @return objeto de tipo Usuario, Proveedor o Administrador; null si no hay coincidencia
     */
    public Object obtenerEntidadPorCredenciales(String correo, String clave) {
        Usuario usuario = controlUsuarios.autenticarUsuario(correo, clave);
        if (usuario != null) {
            return usuario;
        }

        Proveedor proveedor = controlProveedores.autenticarProveedor(correo, clave);
        if (proveedor != null) {
            return proveedor;
        }

        if (administrador.getCorreo().equals(correo) && administrador.getContraseña().equals(clave)) {
            return administrador;
        }

        return null;
    }
}

