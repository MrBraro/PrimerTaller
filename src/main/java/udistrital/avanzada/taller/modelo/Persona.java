/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * 
 * <p>Se utiliza como superclase de {@link Usuario}, {@link Proveedor} 
 * y {@link Administrador}. Contiene atributos comunes como nombre, 
 * contraseña, correo e identificación única.</p>
 * 
 * <p>El identificador ({@code id}) se mantiene inmutable una vez creado,
 * mientras que los demás atributos pueden modificarse.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
abstract class Persona {
    private String nombre;
    private String contraseña;
    private String correo;
    private final String id;

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre nombre de la persona
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico de la persona
     * @param id identificador único (inmutable)
     */
    public Persona(String nombre, String contraseña, String correo, String id) {
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.correo = correo;
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la contraseña de la persona.
     * 
     * @return contraseña de la persona
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Obtiene el correo de la persona.
     * 
     * @return correo de la persona
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Modifica el nombre de la persona.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica la contraseña de la persona.
     * 
     * @param contraseña nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Modifica el correo de la persona.
     * 
     * @param correo nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el identificador único de la persona.
     * 
     * @return identificador único
     */
    public String getId() {
        return id;
    } 
}

