/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Valor;
import JPAUtil.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Douglas
 */
public class ValorDAO {

    public Valor ValoresEstacionamento() {
        EntityManager em = new JPAUtil().getConnection();
        Valor val = null;
        try {
            val = (Valor) em.createQuery("from Valor ").getSingleResult();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return val;
    }

}
