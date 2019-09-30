/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaz;

import com.mycompany.pojo.cuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface cuentaFacadeLocal {

    void create(cuenta cuenta);

    void edit(cuenta cuenta);

    void remove(cuenta cuenta);

    cuenta find(Object id);

    List<cuenta> findAll();

    List<cuenta> findRange(int[] range);

    int count();
    
}
