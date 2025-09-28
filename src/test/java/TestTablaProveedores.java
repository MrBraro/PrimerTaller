import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.TipoProveedor;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import udistrital.avanzada.taller.control.ControlProveedores;

class ControlProveedoresTest {

    private ControlProveedores control;

    @BeforeEach
    void setUp() {
        control = new ControlProveedores();

        // Agregar algunos proveedores de prueba
        control.registrarProveedor(new Proveedor("Juan", "123", "juan@mail.com", "001", TipoProveedor.LAVADERO));
        control.registrarProveedor(new Proveedor("Ana", "abc", "ana@mail.com", "002", TipoProveedor.TALLER));
        control.registrarProveedor(new Proveedor("Luis", "xyz", "luis@mail.com", "003", TipoProveedor.LAVADERO));
    }

    @Test
    void testBuscarProveedorPorId() {
        Proveedor p = control.buscarProveedorPorId("001");
        assertNotNull(p);
        assertEquals("Juan", p.getNombre());

        Proveedor noExiste = control.buscarProveedorPorId("999");
        assertNull(noExiste);
    }

    @Test
    void testFiltrarProveedoresPorTexto() {
        List<Proveedor> filtrados = control.filtrarProveedores("ana", "Todos", "Nombre A-Z");
        assertEquals(1, filtrados.size());
        assertEquals("Ana", filtrados.get(0).getNombre());
    }

    @Test
    void testFiltrarProveedoresPorTipo() {
        List<Proveedor> filtrados = control.filtrarProveedores("", "Lavadero", "Nombre A-Z");
        assertEquals(2, filtrados.size());
    }

    @Test
    void testOrdenarProveedores() {
        List<Proveedor> filtrados = control.filtrarProveedores("", "Todos", "Nombre Z-A");
        assertEquals("Luis", filtrados.get(0).getNombre()); // Debe ser el último alfabéticamente
    }

    @Test
    void testModeloTabla() {
        DefaultTableModel modelo = control.getModeloTablaProveedores();
        assertEquals(3, modelo.getRowCount());
        assertEquals("Juan", modelo.getValueAt(0, 1)); // Columna Nombre
    }
}
