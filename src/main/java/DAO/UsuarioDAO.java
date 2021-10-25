/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Usuario;
import JPAUtil.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Douglas
 */
public class UsuarioDAO {

    public Usuario login(Usuario usr) {

        EntityManager em = new JPAUtil().getConnection();
        try {
         
           String usuario=usr.getUsuario();
           String senha=usr.getSenha();
            
          
            em.getTransaction().begin();
            usr = (Usuario) em.createQuery("from Usuario c where usuario=:usuario and senha=:senha").setParameter("usuario", usuario).setParameter("senha", senha).getSingleResult();
            em.getTransaction().commit();
            return usr;
            

        } catch (NoResultException e) {
            System.err.println(e);
            em.getTransaction().rollback();
            return null;
           
        } finally {
            em.close();

        }

    }
    
   


}
