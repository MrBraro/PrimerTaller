/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import udistrital.avanzada.taller.modelo.Usuario;

/**
 *
 * @author Juan Estevan Ariza Ortiz
 * @version 1.0 
 * 25/09/2025 
 * La clase ControlUsuarios ha sido creada, con el control de registro y validaciones
 */
public class ControlUsuarios {

    private ArrayList<Usuario> usuarios;
    private ControlProveedores controlProveedores;

    public ControlUsuarios(ControlProveedores controlProveedores) {
        this.usuarios = new ArrayList<>();
        this.controlProveedores = controlProveedores;
    }

    /**
     * Registro de un Usuario en el sistema
     * @param usuario Usuario a registrar
     * @return true si se registró exitosamente, false si ya existe
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        
        // Verificar si ya existe un usuario con el mismo ID o correo
        if (buscarUsuarioPorId(usuario.getId()) != null || 
            buscarUsuarioPorCorreo(usuario.getCorreo()) != null) {
            return false;
        }
        
        this.usuarios.add(usuario);
        return true;
    }
    /**
     * Identifiación de usuarios por el Id
     *
     * @param id ID del usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Usuario usuario : this.usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

     /**
     * Identifiación de usuarios por el Correo
     *
     * @param correo Correo del usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return null;
        }

        for (Usuario usuario : this.usuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Método para autenticar el registro de un usuario 
     * @param correo Correo del Usuario
     * @param contraseña Contraseña del Usuario
     * @return Usuiario si el usuario coincide con la contraseña, null si no corresponden
     */
    public Usuario autenticarUsuario(String correo, String contraseña) {
        if (correo == null || contraseña == null) {
            return null;
        }

        
        Usuario usuario = buscarUsuarioPorCorreo(correo);
        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            return usuario;
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(this.usuarios);
    }
    
     /**
     * Validación para registrar los datos del usuario cómo debería
     * @param nombre Nombre del usuario
     * @param correo Correo del usuario
     * @param contraseña Contraseña del usuario
     * @param id ID del usuario
     * @return true si los datos son válidos, false en caso contrario
     */
    public boolean validarDatosUsuario(String nombre, String correo, String contraseña, String id) {
        // Validaciones básicas
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        
        if (correo == null || correo.trim().isEmpty() || !correo.contains("@")) {
            return false;
        }
        
        if (contraseña == null || contraseña.trim().isEmpty() || contraseña.length() < 8) {
            return false;
        }
        
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        
        return true;
    }
}

