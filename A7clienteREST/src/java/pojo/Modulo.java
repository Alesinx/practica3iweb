/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.math.BigDecimal;

/**
 *
 * @author JaGaRo
 */
public class Modulo {
    private int idmodulo;
    private String nombremodulo;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private double idealidad;
    private double rendimiento;
    private double resistencia;
    private double valoralpha;
    private double valorbeta;
    private double valorgamma;
    private double valorkappa;

    public int getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(int idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getNombremodulo() {
        return nombremodulo;
    }

    public void setNombremodulo(String nombremodulo) {
        this.nombremodulo = nombremodulo;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public double getIdealidad() {
        return idealidad;
    }

    public void setIdealidad(double idealidad) {
        this.idealidad = idealidad;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public double getValoralpha() {
        return valoralpha;
    }

    public void setValoralpha(double valoralpha) {
        this.valoralpha = valoralpha;
    }

    public double getValorbeta() {
        return valorbeta;
    }

    public void setValorbeta(double valorbeta) {
        this.valorbeta = valorbeta;
    }

    public double getValorgamma() {
        return valorgamma;
    }

    public void setValorgamma(double valorgamma) {
        this.valorgamma = valorgamma;
    }

    public double getValorkappa() {
        return valorkappa;
    }

    public void setValorkappa(double valorkappa) {
        this.valorkappa = valorkappa;
    }   
}
