/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table (name = "cuenta")
public class cuenta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String numero;
    
    @OneToOne
    @JoinColumn(name = "inversor_id")
    private usuario inversor;
    
    public cuenta() {
    }

    public cuenta(String numero, usuario inversor) {
        this.numero = numero;
        this.inversor = inversor;
    }

    
   
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public usuario getInversor() {
        return inversor;
    }

    public void setInversor(usuario inversor) {
        this.inversor = inversor;
    }
    
    
    
}
