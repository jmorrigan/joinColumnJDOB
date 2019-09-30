/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.interfaz.AbstractFacade;
import com.mycompany.interfaz.usuarioFacadeLocal;
import com.mycompany.pojo.usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan
 */
@Stateless
public class usuarioFacade extends AbstractFacade<usuario> implements usuarioFacadeLocal {
    @PersistenceContext(unitName = "joinPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public usuarioFacade() {
        super(usuario.class);
    }
    
}
