/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import udistrital.avanzada.taller.modelo.Proveedor;

import udistrital.avanzada.taller.modelo.Usuario;
import udistrital.avanzada.taller.vista.Inicio;
import udistrital.avanzada.taller.vista.MenuPrincipal;
import udistrital.avanzada.taller.vista.PanelProveedores;
import udistrital.avanzada.taller.vista.Registro;

/**
 *
 * @author Paula Martínez
 * @version 1.5 23/09/2025 La clase ControlInterfaz.java ha sido creada con el
 * fin de controlar la interfaz del programa
 */
public class ControlInterfaz implements ActionListener {

    private ControlLogica cLogica;
    private Inicio inicio;
    private Registro registro;
    private ControlUsuarios cUsuarios;
    private MenuPrincipal menu;
    private PanelProveedores panelUno;
    private ControlProveedores cProveedores;

    private CardLayout cl;

    public ControlInterfaz(ControlLogica cLogica, Inicio inicio, Registro registro, ControlUsuarios cUsuarios, MenuPrincipal menu, PanelProveedores panelUno, ControlProveedores cProveedores) {

        /*Hacemos una inyección de dependencias de ControlLogica
        e instanciamos inicio (La primera ventana del programa)*/
        this.cLogica = cLogica;
        this.cUsuarios = cUsuarios;
        this.inicio = inicio;
        this.registro = registro;
        this.menu = menu;
        this.panelUno = panelUno;

        menu.setVisible(true);

        this.cl = (CardLayout) menu.getPanelCentral().getLayout();

//        inicio.setVisible(true);
        //Iniciamos este metodo desde el constructor
        configurarEventos();
        //Añado los action listener de los botones de la ventana inicio
        this.inicio.botonRegistro.addActionListener(this);
        this.inicio.botonIngresar.addActionListener(this);
        //Añado los action listener de los botones de la ventana registro
        this.registro.botonIngresar.addActionListener(this);
        //Añado los action listener del menu
        this.menu.getBtnProveedores().addActionListener(this);

    }

    /**
     * Configura todos los eventos de la ventana inicio
     */
    public void configurarEventos() {
        //Agregar un FocusListener a la cajaUsuario
        this.inicio.cajaUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu Correo".equals(inicio.cajaUsuario.getText().trim())) {
                    inicio.cajaUsuario.setText("");
                    inicio.cajaUsuario.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (inicio.cajaUsuario.getText().trim().isEmpty()) {
                    inicio.cajaUsuario.setText("Ingresa tu Correo");
                    inicio.cajaUsuario.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.inicio.cajaContraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu Contraseña".equals(inicio.cajaContraseña.getText().trim())) {
                    inicio.cajaContraseña.setText("");
                    inicio.cajaContraseña.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (inicio.cajaContraseña.getText().trim().isEmpty()) {
                    inicio.cajaContraseña.setText("Ingresa tu contraseña");
                    inicio.cajaContraseña.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        //Ahora generamos los metodos de los placeholders en registro
        this.registro.cajaUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu usuario".equals(registro.cajaUsuario.getText().trim())) {
                    registro.cajaUsuario.setText("");
                    registro.cajaUsuario.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaUsuario.getText().trim().isEmpty()) {
                    registro.cajaUsuario.setText("Ingresa tu usuario");
                    registro.cajaUsuario.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.registro.cajaContraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu contraseña".equals(registro.cajaContraseña.getText().trim())) {
                    registro.cajaContraseña.setText("");
                    registro.cajaContraseña.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaContraseña.getText().trim().isEmpty()) {
                    registro.cajaContraseña.setText("Ingresa tu contraseña");
                    registro.cajaContraseña.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
        this.registro.cajaCorreo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //Si el campo contiene el placeholder, lo limpia
                if ("Ingresa tu correo".equals(registro.cajaCorreo.getText().trim())) {
                    registro.cajaCorreo.setText("");
                    registro.cajaCorreo.setForeground(Color.BLACK); //Texto Normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si el campo está vacío al perder el foco, restaura el placeholder
                if (registro.cajaCorreo.getText().trim().isEmpty()) {
                    registro.cajaCorreo.setText("Ingresa tu correo");
                    registro.cajaCorreo.setForeground(Color.GRAY); //Texto Placeholder
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando el usuario presiona el botón de "Registro" desde la ventana inicio
        if (e.getSource() == this.inicio.botonRegistro) {
            this.registro.setVisible(true);   // mostrar ventana de registro
            this.inicio.setVisible(false);    // opcional: ocultar ventana inicio
        }
        // Cuando el usuario presiona el botón de "Iniciar sesion" desde la ventana registro
        if (e.getSource() == this.registro.botonIngresar) {
            this.inicio.setVisible(true);    // opcional: ocultar ventana inicio
            this.registro.setVisible(false);   // mostrar ventana de registro
        }
        /**
         * Evento asociado al botón "Iniciar Sesión".
         * <p>
         * Obtiene los datos del formulario de inicio (correo y contraseña), los
         * envía al {@link ControlUsuarios} para validarlos y, según el
         * resultado, muestra un mensaje de bienvenida o un error.
         * </p>
         *
         * <ul>
         * <li>Si el usuario existe y la contraseña coincide → se muestra un
         * mensaje de éxito y puede abrirse la ventana principal.</li>
         * <li>Si las credenciales no son válidas → se muestra un mensaje de
         * error en pantalla.</li>
         * </ul>
         *
         * @param e evento de tipo {@link java.awt.event.ActionEvent} disparado
         * al hacer clic en el botón de inicio de sesión.
         */
        if (e.getSource() == this.inicio.botonIngresar) {
            String correo = inicio.cajaUsuario.getText();
            String contrasena = inicio.cajaContraseña.getText();

            // Llamar a la lógica de usuarios
            Usuario usuario = cUsuarios.autenticarUsuario(correo, contrasena);

            if (usuario != null) {
                JOptionPane.showMessageDialog(inicio, "✅ Bienvenido " + usuario.getNombre());
                inicio.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(inicio, "❌ Usuario o contraseña incorrectos");
            }
        }
        /**
         * Evento asociado al botón "Registrar".
         * <p>
         * Captura los datos ingresados en el formulario de registro (nombre,
         * correo y contraseña), valida que sean correctos y, si todo está bien,
         * crea un nuevo {@link Usuario} y lo registra en el sistema mediante
         * {@link ControlUsuarios}.
         * </p>
         *
         * <ul>
         * <li>Si los datos son válidos y no hay duplicados → se registra el
         * usuario, se muestra un mensaje de éxito y se vuelve a la ventana de
         * inicio de sesión.</li>
         * <li>Si los datos no son válidos o el usuario ya existe → se muestra
         * un mensaje de error en pantalla.</li>
         * </ul>
         *
         * @param e evento de tipo {@link java.awt.event.ActionEvent} disparado
         * al hacer clic en el botón de registro.
         */
        if (e.getSource() == this.registro.botonRegistro) {
            // 1. Obtener valores del formulario de registro
            String usuario = registro.cajaUsuario.getText();
            String correo = registro.cajaCorreo.getText();
            String contrasena = registro.cajaContraseña.getText();

            // 2. Validar datos básicos antes de registrar
            if (!cUsuarios.validarDatosUsuario(usuario, correo, contrasena, "tmp")) {
                JOptionPane.showMessageDialog(registro, "❌ Datos inválidos. Revísalos por favor.");
                return; // salir si hay error
            }
            // 3. Crear un nuevo usuario 
//            Usuario nuevo = new Usuario(usuario, correo, contrasena);

            // 4. Intentar registrar en el sistema
//            if (cUsuarios.registrarUsuario(nuevo)) {
//                // Registro exitoso
//                JOptionPane.showMessageDialog(registro, "✅ Usuario registrado con éxito\nID asignada: " + nuevo.getId());
//
//                // Regresar a la ventana de inicio de sesión
//                registro.setVisible(false);
//                inicio.setVisible(true);
//            } else {
//                // Usuario duplicado (ya existe con ese correo o ID)
//                JOptionPane.showMessageDialog(registro, "⚠️ Ya existe un usuario con ese correo");
//            }
        }
        if (e.getSource() == this.menu.getBtnProveedores()) {
            mostrarPanel("Proveedores");
        }
        if (e.getSource() == this.menu.getBtnInicio()){
            mostrarPanel("Inicio");
        }
        /**
         * Agrega el ActionListener al botón de buscar proveedores. Al hacer
         * clic, obtiene los valores de búsqueda y filtros del panel, llama a
         * ControlProveedores para obtener la lista filtrada y actualiza la
         * tabla de la vista.
         */
        if (e.getSource() == this.panelUno.getBotonBuscar()) {
            filtrarYActualizarTabla();
        }
    }

    /**
     * Muestra un panel específico dentro del panel central del menú principal.
     *
     * Este método utiliza el CardLayout asociado a 'panelCentral' en la clase
     * MenuPrincipal para mostrar el panel que corresponda al nombre pasado como
     * parámetro.
     *
     * @param nombrePanel nombre del panel que se desea mostrar. Debe coincidir
     * con el nombre con el que se añadió el panel al CardLayout.
     */
    public void mostrarPanel(String nombrePanel) {
        cl.show(menu.getPanelCentral(), nombrePanel);
    }

    /**
     * Actualiza la JTable de proveedores en el panel de proveedores.
     *
     * Este método obtiene el modelo de tabla directamente desde el
     * ControlProveedores, garantizando que la vista solo muestre los datos y no
     * tenga que conocer la lógica interna de los proveedores.
     *
     * Se recomienda llamar a este método cada vez que se agregue, elimine o
     * modifique un proveedor, o al inicializar el panel de proveedores.
     */
    public void actualizarTabla() {
        List<Proveedor> lista = cProveedores.getProveedores();
        DefaultTableModel modelo = cProveedores.getModeloTablaProveedores(lista);
        panelUno.getTablaProveedores().setModel(modelo);
    }
    /**
     * Aplica filtros de búsqueda, tipo y orden, y actualiza la tabla.
     */
    public void filtrarYActualizarTabla() {
        String texto = panelUno.getCajaBuscar().getText();
        String tipo = (String) panelUno.getCajaTipoProveedor().getSelectedItem();
        String orden = (String) panelUno.getCajaOrden().getSelectedItem();

        List<Proveedor> filtrados = cProveedores.filtrarProveedores(texto, tipo, orden);
        DefaultTableModel modelo = cProveedores.getModeloTablaProveedores(filtrados);
        panelUno.getTablaProveedores().setModel(modelo);
    }
}
