/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.interfaz.AbstractFacade;
import com.mycompany.interfaz.cuentaFacadeLocal;
import com.mycompany.pojo.cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan
 */
@Stateless
public class cuentaFacade extends AbstractFacade<cuenta> implements cuentaFacadeLocal {
    @PersistenceContext(unitName = "joinPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public cuentaFacade() {
        super(cuenta.class);
    }
    
}
