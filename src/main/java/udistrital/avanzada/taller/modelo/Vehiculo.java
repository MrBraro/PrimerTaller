/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 *
 * @author juans
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
