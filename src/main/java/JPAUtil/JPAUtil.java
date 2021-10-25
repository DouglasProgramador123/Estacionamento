/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Douglas
 */
public class JPAUtil {
    
   private static  EntityManagerFactory emf= Persistence.createEntityManagerFactory("EstacionamentoPU");
    
  public EntityManager getConnection()
  {
      return emf.createEntityManager();
  }
    
}