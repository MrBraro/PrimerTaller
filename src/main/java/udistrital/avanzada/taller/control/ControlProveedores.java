/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.Evento;
import udistrital.avanzada.taller.modelo.TipoProveedor;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador encargado de gestionar a los proveedores del sistema.
 *
 * <p>
 * Permite registrar, eliminar y buscar proveedores, además de publicar eventos
 * asociados a ellos. También ofrece métodos para consultar información
 * detallada y filtrar proveedores por tipo.</p>
 *
 * <p>
 * Se integra con {@link ControlAutenticacion} y {@link ControlUsuarios} para
 * ofrecer validaciones y consultas completas en el sistema.</p>
 *
 * @author Juan Sebastián Bravo Rojas <<<<<<< HEAD @v ersion 1.2 25/09/2025 La
 * clase controlProveedores ha sido creada para manejar la logica de estos
 * ======= @version 1.5 26/09/2025 >>>>>>>
 * ce6ab0c005683ed04df5b602a5d7414eaba217e4
 */
public class ControlProveedores {

    private ArrayList<Proveedor> proveedores;

    /**
     * Constructor por defecto. Inicializa la lista vacía de proveedores.
     */
    public ControlProveedores() {
        this.proveedores = new ArrayList<>();
    }

    /**
     * Registra un proveedor en el sistema si aún no está registrado.
     *
     * @param proveedor proveedor a registrar
     * @return true si se registró exitosamente, false si ya existía
     */
    public boolean registrarProveedor(Proveedor proveedor) {
        if (!this.proveedores.contains(proveedor)) {
            this.proveedores.add(proveedor);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un proveedor del sistema.
     *
     * @param proveedor proveedor a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarProveedor(Proveedor proveedor) {
        return this.proveedores.remove(proveedor);
    }

    /**
     * Busca un proveedor por su identificador único.
     *
     * @param id identificador del proveedor
     * @return proveedor encontrado o null si no existe
     */
    public Proveedor buscarProveedorPorId(String id) {
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }

    /**
     * Publica un evento en nombre de un proveedor específico.
     *
     * @param idProveedor identificador del proveedor
     * @param evento evento a publicar
     * @return true si el evento fue publicado, false si el proveedor no existe
     */
    public boolean publicarEventoProveedor(String idProveedor, Evento evento) {
        Proveedor proveedor = buscarProveedorPorId(idProveedor);
        if (proveedor != null) {
            proveedor.publicarEvento(evento);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la lista inmutable de todos los proveedores registrados.
     *
     * @return lista inmutable de proveedores
     */
    public List<Proveedor> getProveedores() {
        return Collections.unmodifiableList(this.proveedores);
    }

    /**
     * Busca proveedores por tipo específico (parqueadero, lavadero, taller,
     * venta de partes).
     *
     * @param tipoProveedor tipo de proveedor a buscar
     * @return lista de proveedores del tipo especificado
     */
    public List<Proveedor> buscarProveedoresPorTipo(TipoProveedor tipoProveedor) {
        return this.proveedores.stream()
                .filter(proveedor -> proveedor.getTipoProveedor() == tipoProveedor)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene información detallada de proveedores por tipo.
     *
     * @param tipoProveedor tipo de proveedor
     * @return lista con información completa de los proveedores del tipo
     * especificado
     */
    public List<String> getInformacionProveedoresPorTipo(TipoProveedor tipoProveedor) {
        return buscarProveedoresPorTipo(tipoProveedor).stream()
                .map(Proveedor::getInformacionCompleta)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene información detallada de todos los proveedores registrados.
     *
     * @return lista con la información completa de cada proveedor
     */
    public List<String> getInformacionProveedores() {
        return this.proveedores.stream().map(Proveedor::getInformacionCompleta).collect(Collectors.toList());
    }

    /**
     * Autentica un proveedor validando su correo y contraseña.
     *
     * @param correo correo electrónico del proveedor
     * @param contraseña contraseña del proveedor
     * @return proveedor autenticado o null si no coincide
     */
    public Proveedor autenticarProveedor(String correo, String contraseña) {
        if (correo == null || contraseña == null) {
            return null;
        }

        Proveedor proveedor = buscarProveedorPorCorreo(correo);
        if (proveedor != null && proveedor.getContraseña().equals(contraseña)) {
            return proveedor;
        }
        return null;
    }

    /**
     * Busca un proveedor por su correo electrónico.
     *
     * @param correo correo electrónico del proveedor
     * @return proveedor encontrado o null si no existe
     */
    public Proveedor buscarProveedorPorCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return null;
        }

        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getCorreo().equalsIgnoreCase(correo)) {
                return proveedor;
            }
        }
        return null;
    }

    /**
     * Genera un modelo de tabla listo para mostrar en un JTable con la
     * información de todos los proveedores registrados en el sistema.
     *
     * Cada fila corresponde a un proveedor y las columnas incluyen:
     * <ul>
     * <li>ID: Identificador único del proveedor.</li>
     * <li>Nombre: Nombre del proveedor.</li>
     * <li>Tipo: Tipo de proveedor (ej. Lavadero, Taller, etc.).</li>
     * <li>Correo: Correo electrónico del proveedor.</li>
     * <li>Cantidad Items: Número de ítems que ofrece el proveedor.</li>
     * <li>Cantidad Eventos: Número de eventos publicados por el proveedor.</li>
     * </ul>
     *
     * Este método delega toda la lógica de obtención de datos al
     * ControlProveedores, de manera que la vista solo necesita asignar este
     * modelo al JTable.
     *
     * @return DefaultTableModel con los datos de los proveedores.
     */
    public DefaultTableModel getModeloTablaProveedores() {
        // Definimos las columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Tipo", "Correo", "Cantidad Items", "Cantidad Eventos"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        // Llenamos el modelo con los datos de los proveedores
        for (Proveedor proveedor : this.proveedores) {
            Object[] fila = new Object[]{
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getTipoProveedor() != null ? proveedor.getTipoProveedor().getDescripcion() : "N/A",
                proveedor.getCorreo(),
                proveedor.getItems().size(),
                proveedor.getEventos().size()
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    /**
     * Filtra y ordena la lista de proveedores según los parámetros indicados.
     *
     * @param texto texto a buscar en el nombre del proveedor (puede ser vacío)
     * @param tipo tipo de proveedor a filtrar ("Todos" muestra todos)
     * @param orden criterio de ordenamiento ("Nombre A-Z", "Nombre Z-A")
     * @return lista filtrada y ordenada de proveedores
     */
    public List<Proveedor> filtrarProveedores(String texto, String tipo, String orden) {
        List<Proveedor> filtrados = new ArrayList<>();

        // Filtrar por texto y tipo
        for (Proveedor p : proveedores) {
            boolean cumpleTexto = texto == null || texto.isEmpty()
                    || p.getNombre().toLowerCase().contains(texto.toLowerCase());
            boolean cumpleTipo = tipo.equals("Todos")
                    || p.getTipoProveedor().getDescripcion().equalsIgnoreCase(tipo);

            if (cumpleTexto && cumpleTipo) {
                filtrados.add(p);
            }
        }

        // Ordenar según la opción seleccionada
        if (orden.equals("Nombre A-Z")) {
            filtrados.sort((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        } else if (orden.equals("Nombre Z-A")) {
            filtrados.sort((a, b) -> b.getNombre().compareToIgnoreCase(a.getNombre()));
        }

        return filtrados;
    }
    /**
     * Actualiza la tabla con una lista de proveedores dada. Este método se
     * llama desde el controlador para reflejar los resultados de búsqueda o
     * filtrado.
     *
     * @param lista lista de proveedores a mostrar en la tabla
     */
    public DefaultTableModel getModeloTablaProveedores(List<Proveedor> lista) {
        String[] columnas = {"ID", "Nombre", "Tipo", "Correo", "Calificación"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        for (Proveedor p : lista) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getTipoProveedor() != null ? p.getTipoProveedor().getDescripcion() : "N/A",
                p.getCorreo(),
                0
            });
        }

        return modelo;
    }
    
    

    
    
}
