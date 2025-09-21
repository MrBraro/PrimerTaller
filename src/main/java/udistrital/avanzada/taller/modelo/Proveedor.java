
package udistrital.avanzada.taller.modelo;

import java.util.ArrayList;

public class Proveedor extends Persona {
    
    private ArrayList<Producto> productos;
    private ArrayList<Servicio> servicios;
    
    public Proveedor(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
    }
    
    public void gestionar(){
        //TODO: Revisar el funcionamiento del metodo gestionar()
    }
}
