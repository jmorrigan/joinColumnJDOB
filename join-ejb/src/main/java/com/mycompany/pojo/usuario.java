/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juan
 */

@Entity
@Table (name = "inversor")
public class usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;
    
    @Column
    private String apellido;
    
    @OneToOne(mappedBy = "inversor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private cuenta cuenta;

    public usuario() {
    }

    public usuario( String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
