/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import udistrital.avanzada.taller.modelo.Item;
import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.TipoProveedor;
import udistrital.avanzada.taller.modelo.Usuario;
import udistrital.avanzada.taller.modelo.Vehiculo;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los
 * usuarios dentro del sistema.
 *
<<<<<<< HEAD
 * @author Juan Estevan Ariza Ortiz
 * @version 1.0 
 * 25/09/2025 
 * La clase ControlUsuarios ha sido creada, con el control de registro y validaciones
=======
 * <p>Permite registrar, autenticar y validar usuarios, además de ofrecer
 * funcionalidades de consulta de proveedores, ítems y vehículos. También
 * gestiona las relaciones de amistad entre usuarios.</p>
 *
 * <p>Se integra con {@link ControlProveedores} para consultar información
 * asociada a proveedores e ítems.</p>
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
>>>>>>> ce6ab0c005683ed04df5b602a5d7414eaba217e4
 */
public class ControlUsuarios {

    private ArrayList<Usuario> usuarios;
    private ControlProveedores controlProveedores;

    /**
     * Constructor de la clase.
     *
     * @param controlProveedores instancia de {@link ControlProveedores} para
     * permitir consultas relacionadas
     */
    public ControlUsuarios(ControlProveedores controlProveedores) {
        this.usuarios = new ArrayList<>();
        this.controlProveedores = controlProveedores;
    }

    /**
     * Registra un usuario en el sistema.
     *
     * @param usuario usuario a registrar
     * @return true si se registró exitosamente, false si ya existía
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }

        // Verificar si ya existe un usuario con el mismo ID o correo
        if (buscarUsuarioPorId(usuario.getId()) != null
                || buscarUsuarioPorCorreo(usuario.getCorreo()) != null) {
            return false;
        }

        this.usuarios.add(usuario);
        return true;
    }

    /**
     * Busca un usuario por su identificador único.
     *
     * @param id identificador del usuario
     * @return usuario encontrado o null si no existe
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
     * Busca un usuario por su correo electrónico.
     *
     * @param correo correo del usuario
     * @return usuario encontrado o null si no existe
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
     * Autentica a un usuario validando correo y contraseña.
     *
     * @param correo correo del usuario
     * @param contraseña contraseña del usuario
     * @return usuario autenticado o null si no coincide
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
  
    /**
     * Devuelve la lista inmutable de todos los usuarios registrados.
     *
     * @return lista inmutable de usuarios
     */
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(this.usuarios);
    }

    /**
     * Valida los datos básicos de un usuario antes de su registro.
     *
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     * @param contraseña contraseña del usuario
     * @param id identificador único del usuario
     * @return true si los datos son válidos, false en caso contrario
     */
    public boolean validarDatosUsuario(String nombre, String correo, String contraseña, String id) {
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


    /**
     * Permite a los usuarios consultar todos los proveedores registrados.
     *
     * @return lista inmutable de proveedores
     */
    public List<Proveedor> consultarTodosLosProveedores() {
        return this.controlProveedores.getProveedores();
    }

    /**
     * Consulta la información detallada de todos los proveedores.
     *
     * @return lista con información de cada proveedor
     */
    public List<String> consultarInformacionProveedores() {
        return this.controlProveedores.getInformacionProveedores();
    }

    /**
     * Consulta todos los ítems disponibles en el sistema.
     *
     * @return lista de productos y servicios disponibles
     */
    public List<Item> consultarTodosLosItems() {
        List<Item> todosLosItems = new ArrayList<>();
        for (Proveedor proveedor : this.controlProveedores.getProveedores()) {
            todosLosItems.addAll(proveedor.getItems());
        }
        return todosLosItems;
    }

    /**
     * Consulta los ítems de un proveedor específico.
     *
     * @param idProveedor identificador del proveedor
     * @return lista de ítems o lista vacía si no se encuentra
     */
    public List<Item> consultarItemsDeProveedor(String idProveedor) {
        Proveedor proveedor = this.controlProveedores.buscarProveedorPorId(idProveedor);
        if (proveedor != null) {
            return proveedor.getItems();
        }
        return new ArrayList<>();
    }

    /**
     * Consulta ítems disponibles según el tipo de proveedor.
     *
     * @param tipoProveedor tipo de proveedor
     * @return lista de ítems ofrecidos por proveedores de ese tipo
     */
    public List<Item> consultarItemsPorTipoProveedor(TipoProveedor tipoProveedor) {
        List<Item> items = new ArrayList<>();
        List<Proveedor> proveedoresTipo = this.controlProveedores.buscarProveedoresPorTipo(tipoProveedor);

        for (Proveedor proveedor : proveedoresTipo) {
            items.addAll(proveedor.getItems());
        }

        return items;
    }

    /**
     * Busca un proveedor específico por su identificador.
     *
     * @param id identificador del proveedor
     * @return proveedor encontrado o null si no existe

     */
    public Proveedor consultarProveedorPorId(String id) {
        return this.controlProveedores.buscarProveedorPorId(id);
    }

    /**
     * Agrega un amigo a un usuario validando existencia y evitando duplicados.
     *
     * @param idUsuario identificador del usuario
     * @param idAmigo identificador del amigo a agregar
     * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean agregarAmigo(String idUsuario, String idAmigo) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Usuario amigo = buscarUsuarioPorId(idAmigo);
        if (usuario == null || amigo == null) {
            return false;
        }
        if (usuario.getAmigos().contains(amigo)) {
            return false;
        }

        usuario.getAmigos().add(amigo);
        return true;
    }

    /**
     * Consulta los vehículos registrados por un usuario específico.
     *
     * @param idUsuario identificador del usuario
     * @return lista de vehículos del usuario o vacía si no existe
     */
    public List<Vehiculo> consultarVehiculosUsuario(String idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            return usuario.getVehiculos();
        }
        return new ArrayList<>();
    }
}

