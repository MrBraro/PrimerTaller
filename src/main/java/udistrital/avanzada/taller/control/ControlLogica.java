/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import udistrital.avanzada.taller.modelo.Evento;
import udistrital.avanzada.taller.modelo.Usuario;
import udistrital.avanzada.taller.modelo.Vehiculo;
import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.MenuPrincipal;
import udistrital.avanzada.taller.vista.PanelAmigos;
import udistrital.avanzada.taller.vista.PanelInicio;
import udistrital.avanzada.taller.vista.PanelEventos;
import udistrital.avanzada.taller.vista.PanelProveedores;
import udistrital.avanzada.taller.vista.PanelVehiculos;
import udistrital.avanzada.taller.vista.Registro;

/**
 *
 * @author Paula Martínez
 * @version 1.5 23/09/2025 La clase ControlLogica.java ha sido creada con el fin
 * de manejar la vista respetando los principios solid y el mvc.
 */
public class ControlLogica {

    private ControlInterfaz cInterfaz;
    private Inicio inicio;
    private Registro registro;
    private ControlUsuarios controlUsuarios;
    private ControlProveedores controlProveedores;
    private MenuPrincipal menu;
    private PanelProveedores panelUno;
    private PanelInicio panelInicio;
    private PanelEventos panelItems;
    private PanelVehiculos panelVehiculos;
    private PanelAmigos panelAmigos;
    private ControlEventos cEventos;
    
    private List<Vehiculo> listaVehiculos;
    private Usuario usuarioActual;

    public ControlLogica() {
        // Inicializar dependencias
        inicio = new Inicio();
        registro = new Registro();
        controlProveedores = new ControlProveedores();
        controlUsuarios = new ControlUsuarios(controlProveedores);
        menu = new MenuPrincipal();
        panelUno = new PanelProveedores();
        panelInicio = new PanelInicio();
        panelItems = new PanelEventos();
        panelVehiculos = new PanelVehiculos();
        panelAmigos = new PanelAmigos();
        cEventos = new ControlEventos();
        
        listaVehiculos = new ArrayList<>();

        // Pasar dependencias al controlador de interfaz
        cInterfaz = new ControlInterfaz(this, inicio, registro, controlUsuarios, menu, panelUno, controlProveedores, panelInicio, panelItems, cEventos, panelVehiculos,panelAmigos);
    }

    public ControlUsuarios getControlUsuarios() {
        return controlUsuarios;
    }

    public ControlProveedores getControlProveedores() {
        return controlProveedores;
    }

    public void actualizarTablaEventos() {
        String texto = panelItems.getTextoBusqueda();
        List<Evento> eventos = cEventos.listarEventos();

        // Filtrar por texto
        List<Evento> filtrados = eventos.stream()
                .filter(e -> texto == null || texto.isEmpty()
                || e.getTitulo().toLowerCase().contains(texto.toLowerCase()))
                .toList();

        panelItems.actualizarTabla(filtrados);
    }
    
    public DefaultTableModel getModeloTablaVehiculos(List<Vehiculo> lista) {
    String[] columnas = {"Marca", "Modelo", "Autonomía", "Tipo"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);

    for (Vehiculo v : lista) {
        Object[] fila = new Object[]{
            v.getMarca(),
            v.getModelo(),
            v.getAutonomia(),
            v.getTipo()
        };
        modelo.addRow(fila);
    }
    return modelo;
}
    public void actualizarTablaVehiculos(PanelVehiculos panel, String texto, String tipo) {
    List<Vehiculo> filtrados = filtrarVehiculos(texto, tipo);
    panel.getTablaVehiculos().setModel(getModeloTablaVehiculos(filtrados));
}
    
    public List<Vehiculo> filtrarVehiculos(String texto, String tipo) {
    List<Vehiculo> filtrados = new ArrayList<>();
    for (Vehiculo v : listaVehiculos) {
        boolean cumpleTexto = texto == null || texto.isEmpty() ||
                v.getMarca().toLowerCase().contains(texto.toLowerCase()) ||
                v.getModelo().toLowerCase().contains(texto.toLowerCase());
        boolean cumpleTipo = tipo == null || tipo.equals("Todos") || v.getTipo().equalsIgnoreCase(tipo);

        if (cumpleTexto && cumpleTipo) {
            filtrados.add(v);
        }
    }
    return filtrados;
}
    
    // Buscar usuarios no amigos
public List<Usuario> buscarUsuarios(String texto) {
    List<Usuario> resultado = new ArrayList<>();
    for (Usuario u : controlUsuarios.getUsuarios()) {
        if (!u.getAmigos().contains(u) && u.getNombre().toLowerCase().contains(texto.toLowerCase())) {
            resultado.add(u);
        }
    }
    return resultado;
}

// Actualiza la tabla de usuarios
public void actualizarTablaUsuarios(List<Usuario> lista) {
    DefaultTableModel modelo = (DefaultTableModel) panelAmigos.getTablaUsuarios().getModel();
    modelo.setRowCount(0);
    for (Usuario u : lista) {
        modelo.addRow(new Object[]{u.getNombre(), u.getCorreo()});
    }
}

// Agregar amigo desde la fila seleccionada
public void agregarAmigoSeleccionado() {
    int fila = panelAmigos.getTablaUsuarios().getSelectedRow();
    if (fila >= 0) {
        String nombre = (String) panelAmigos.getTablaUsuarios().getValueAt(fila, 0);
        Usuario u = null;
        for (Usuario user : controlUsuarios.getUsuarios()) {
            if (user.getNombre().equals(nombre)) {
                u = user;
                break;
            }
        }
        if (u != null) {
            // asumiendo que hay un usuario logueado llamado usuarioActual
            controlUsuarios.agregarAmigo(usuarioActual.getId(), u.getId());
            actualizarTablaAmigos();
        }
    }
}

// Actualiza la tabla de amigos
public void actualizarTablaAmigos() {
    DefaultTableModel modelo = (DefaultTableModel) panelAmigos.getTablaAmigos().getModel();
    modelo.setRowCount(0);
    for (Usuario amigo : usuarioActual.getAmigos()) {
        modelo.addRow(new Object[]{amigo.getNombre(), amigo.getCorreo()});
    }
}

// Eliminar amigo desde la tabla
public void eliminarAmigoSeleccionado() {
    int fila = panelAmigos.getTablaAmigos().getSelectedRow();
    if (fila >= 0) {
        String nombre = (String) panelAmigos.getTablaAmigos().getValueAt(fila, 0);
        Usuario u = null;
        for (Usuario user : usuarioActual.getAmigos()) {
            if (user.getNombre().equals(nombre)) {
                u = user;
                break;
            }
        }
        if (u != null) {
            usuarioActual.getAmigos().remove(u);
            actualizarTablaAmigos();
        }
    }
}

public boolean login(String correo, String contraseña) {
    Usuario u = controlUsuarios.autenticarUsuario(correo, contraseña);
    if (u != null) {
        this.usuarioActual = u; // guardamos el usuario actual
        return true;
    }
    return false;
}

public Usuario getUsuarioActual() {
    return this.usuarioActual;
}



}
