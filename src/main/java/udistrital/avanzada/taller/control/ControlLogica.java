/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.List;
import udistrital.avanzada.taller.modelo.Evento;
import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.MenuPrincipal;
import udistrital.avanzada.taller.vista.PanelInicio;
import udistrital.avanzada.taller.vista.PanelEventos;
import udistrital.avanzada.taller.vista.PanelProveedores;
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
    private ControlEventos cEventos;

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
        cEventos = new ControlEventos();

        // Pasar dependencias al controlador de interfaz
        cInterfaz = new ControlInterfaz(this, inicio, registro, controlUsuarios, menu, panelUno, controlProveedores, panelInicio, panelItems, cEventos);
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

}
