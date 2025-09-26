/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Clase abstracta que representa un vehículo dentro del sistema.
 * 
 * <p>Define los atributos comunes de cualquier tipo de vehículo, como marca,
 * modelo y autonomía. Es la superclase de {@link Scooter} y {@link MotoElectrica}.</p>
 * 
 * <p>Cada subclase concreta debe implementar el método {@link #getTipo()}
 * para especificar el tipo particular de vehículo.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public abstract class Vehiculo {
    private final String marca;
    private final String modelo;
    private final int autonomia;

    /**
     * Construye un vehículo con los datos especificados.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param autonomia autonomía en kilómetros
     */
    public Vehiculo(String marca, String modelo, int autonomia) {
        this.autonomia = autonomia;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Obtiene la autonomía del vehículo en kilómetros.
     * 
     * @return autonomía del vehículo
     */
    public int getAutonomia() {
        return autonomia;
    }

    /**
     * Obtiene la marca del vehículo.
     * 
     * @return marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Retorna el tipo de vehículo.
     * 
     * <p>Este método debe ser implementado por las subclases
     * (ejemplo: "Scooter", "Moto Eléctrica").</p>
     * 
     * @return tipo del vehículo
     */
    public abstract String getTipo();
}

