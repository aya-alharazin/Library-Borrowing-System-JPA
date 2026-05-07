/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.JPAUtil;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



/**
 *
 * @author aya
 */
public class BookDAO {
    public List<Integer> getAllbooksids() {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Integer> q = em.createQuery(
                    "select b.bookId from Book b",
                    Integer.class
            );
            return q.getResultList();
        } catch (Exception ex) {
            System.getLogger(BookDAO.class.getName())
                    .log(System.Logger.Level.ERROR, (String) null, ex);
            return Collections.emptyList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
