/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author JaGaRo
 */
public class Campanya {
    private int idcampanya;
    private String nombrecampanya;
    private Date fecha;
    Modulo moduloIdmodulo;

    public int getIdcampanya() {
        return idcampanya;
    }

    public void setIdcampanya(int idcampanya) {
        this.idcampanya = idcampanya;
    }

    public String getNombrecampanya() {
        return nombrecampanya;
    }

    public void setNombrecampanya(String nombrecampanya) {
        this.nombrecampanya = nombrecampanya;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Modulo getModuloIdmodulo() {
        return moduloIdmodulo;
    }

    public void setModuloIdmodulo(Modulo moduloIdmodulo) {
        this.moduloIdmodulo = moduloIdmodulo;
    }
}
