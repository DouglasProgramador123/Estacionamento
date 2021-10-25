/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Movimentacao;
import Classes.Usuario;
import JPAUtil.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Douglas
 */
public class MovimentacaoDAO {
    
     public Movimentacao saveOrUpdate(Movimentacao mov) {
        EntityManager em = new JPAUtil().getConnection();
        try {
            em.getTransaction().begin();
            if (mov.getId() == null) {
                em.persist(mov);
            } else {
                em.merge(mov);
            }
           
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return mov;
    }
     
    public Movimentacao UpdateEnt(Movimentacao mov) {
        EntityManager em = new JPAUtil().getConnection();
        
        String placa=mov.getPlaca();
        String modelo=mov.getModelo();
        Long id=mov.getId();
        
        try {
            em.getTransaction().begin();
            em.createQuery("update Movimentacao m set m.modelo=:modelo,m.placa=:placa where id=:id ").setParameter("modelo", modelo).setParameter("placa", placa).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return mov;
    } 
    
       public Movimentacao UpdateSaid(Movimentacao mov) {
        EntityManager em = new JPAUtil().getConnection();
        
        Long id=mov.getId();
        String data_saida=mov.getData_saida();
        String horario_saida=mov.getHorario_saida();
        String tempo=mov.getTempo();
        Double valor_pago=mov.getValor_pago();
        
     
        
        try {
            em.getTransaction().begin();
            em.createQuery("update Movimentacao m set m.data_saida=:data_saida,m.horario_saida=:horario_saida,m.tempo=:tempo,m.valor_pago=:valor_pago where id=:id ").setParameter("data_saida",data_saida).setParameter("horario_saida",horario_saida).setParameter("tempo",tempo).setParameter("valor_pago",valor_pago).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return mov;
    } 
     
    
    public List<Movimentacao> tableVeiculosEnt() {
        EntityManager em = new JPAUtil().getConnection();
        List<Movimentacao> medicos = null;
        try {
            medicos = em.createQuery("from Movimentacao m where data_saida is null").getResultList();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return medicos;
    }  
     
     public List<Movimentacao> tableVeiculosSaid() {
        EntityManager em = new JPAUtil().getConnection();
        List<Movimentacao> medicos = null;
        try {
            medicos = em.createQuery("from Movimentacao m where data_saida is not null").getResultList();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return medicos;
    }  
     
     
    
    
}
