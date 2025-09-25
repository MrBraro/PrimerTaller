/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.0
 * 21/09/2025
 * La clase Vehiculo ha sido creada, estableciendo su funcionamiento 
 */
abstract class Vehiculo {
    private final String marca;
    private final String modelo;
    private final int autonomia;

    public Vehiculo(String marca, String modelo, int autonomia) {
        this.autonomia=autonomia;
        this.marca=marca;
        this.modelo=modelo;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public abstract String getTipo();
}
