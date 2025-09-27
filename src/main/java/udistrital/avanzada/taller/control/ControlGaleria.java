/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.Item;
import udistrital.avanzada.taller.modelo.TipoProveedor;

/**
 * Controlador encargado de gestionar la galería de productos y servicios
 * ofrecidos por los proveedores registrados en el sistema.
 *
 * <p>Permite listar todos los ítems disponibles, aplicar filtros según el tipo
 * de ítem o de proveedor, así como ordenar los resultados por precio.</p>
 *
 * <p>Funciona como un punto central de consulta para los usuarios, de manera
 * que no se accede directamente a cada proveedor, sino que se utiliza esta
 * clase como fachada.</p>
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class ControlGaleria {

    private ArrayList<Proveedor> proveedores;

    /**
     * Constructor de la clase.
     *
     * @param proveedores lista inicial de proveedores registrados
     */
    public ControlGaleria(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * Lista todos los ítems ofrecidos por todos los proveedores.
     *
     * @return lista inmutable con todos los productos y servicios disponibles
     */
    public List<Item> listarItems() {
        ArrayList<Item> todos = new ArrayList<>();
        for (Proveedor proveedor : this.proveedores) {
            todos.addAll(proveedor.getItems());
        }
        return Collections.unmodifiableList(todos);
    }

    /**
     * Filtra los ítems de todos los proveedores por tipo de ítem.
     *
     * @param tipo tipo de ítem a buscar (ejemplo: "Producto", "Servicio")
     * @return lista de ítems que coinciden con el tipo especificado
     */
    public List<Item> filtrarPorTipo(String tipo) {
        ArrayList<Item> filtrados = new ArrayList<>();
        for (Proveedor proveedor : this.proveedores) {
            for (Item item : proveedor.getItems()) {
                if (item.getTipo().equalsIgnoreCase(tipo)) {
                    filtrados.add(item);
                }
            }
        }
        return filtrados;
    }

    /**
     * Filtra los ítems ofrecidos por un proveedor específico.
     *
     * @param nombreProveedor nombre del proveedor a buscar
     * @return lista de ítems del proveedor, o una lista vacía si no existe
     */
    public List<Item> filtrarPorProveedor(String nombreProveedor) {
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getNombre().equalsIgnoreCase(nombreProveedor)) {
                return proveedor.getItems();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Ordena todos los ítems disponibles de menor a mayor precio.
     *
     * @return lista de ítems ordenada ascendentemente por precio
     */
    public List<Item> filtrarPorPrecioAscendente() {
        List<Item> todos = new ArrayList<>(listarItems());
        todos.sort(Comparator.comparingDouble(Item::getPrecio));
        return todos;
    }

    /**
     * Ordena todos los ítems disponibles de mayor a menor precio.
     *
     * @return lista de ítems ordenada descendentemente por precio
     */
    public List<Item> filtrarPorPrecioDescendente() {
        List<Item> todos = new ArrayList<>(listarItems());
        todos.sort(Comparator.comparingDouble(Item::getPrecio).reversed());
        return todos;
    }

    /**
     * Filtra los ítems según el tipo de proveedor que los ofrece.
     *
     * @param tipo tipo de proveedor (ejemplo: {@link TipoProveedor#TALLER})
     * @return lista de ítems ofrecidos por proveedores del tipo especificado
     */
    public List<Item> filtrarPorTipoProveedor(TipoProveedor tipo) {
        ArrayList<Item> filtrados = new ArrayList<>();
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getTipoProveedor() == tipo) {
                filtrados.addAll(proveedor.getItems());
            }
        }
        return filtrados;
    }
}

