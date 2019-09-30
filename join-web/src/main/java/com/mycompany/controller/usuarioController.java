/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.CuentaDTO;
import com.mycompany.dto.InversorDTO;
import com.mycompany.interfaz.cuentaFacadeLocal;
import com.mycompany.interfaz.usuarioFacadeLocal;
import com.mycompany.pojo.cuenta;
import com.mycompany.pojo.usuario;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 *
 * @author juan
 */
@Named(value = "usuarioController")
@ViewScoped
public class usuarioController implements Serializable {

    @EJB
    private usuarioFacadeLocal userEJB;
    @EJB
    private cuentaFacadeLocal cuentaEJB;
    private CuentaDTO cuentadto;
    private InversorDTO inverdto;
    
    private String nombre;
    private String apellido;
    
    @PostConstruct
    public void init(){
         cuentadto = new CuentaDTO();
         inverdto = new InversorDTO();
    }
    
    public usuarioController() {
    }
    
    
    public void crearUsuario(InversorDTO user){
        usuario invers = new usuario(user.getNombre(), user.getApellido());
        cuenta cuen = new cuenta(this.cuenta(), invers);
        invers.setCuenta(cuen);
        userEJB.create(invers);
        System.out.println("ingresó correctamente");
    }
    
   
    public void crearUserSolo(){
        usuario invers = new usuario(nombre, apellido);
        if(invers.getCuenta() == null){
            userEJB.create(invers);
        }
    }
    
     public void crearCuentaUser(InversorDTO u){
        usuario user = userEJB.find(u.getId());
        
        if(user.getCuenta() == null){
            cuenta cuen = new cuenta(this.cuenta(), user);
            cuentaEJB.create(cuen);
        }else{
            System.out.println("hay una cuenta existente");
        }
    }
    
    public List<usuario> obtenerDatos (){
        return this.userEJB.findAll();
    }
    
    public List<usuario>actualizar(){
        return this.userEJB.findAll();
    }
    
    public String cuenta(){
        int random = (int)(Math.random() * 10000) + 1;
        String num = String.valueOf(random);
        return num;
    }

    public CuentaDTO getCuentadto() {
        return cuentadto;
    }

    public void setCuentadto(CuentaDTO cuentadto) {
        this.cuentadto = cuentadto;
    }

    public InversorDTO getInverdto() {
        return inverdto;
    }

    public void setInverdto(InversorDTO inverdto) {
        this.inverdto = inverdto;
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
