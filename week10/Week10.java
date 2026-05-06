/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week10;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aya
 */
public class Week10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("week10PU");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        //
        em.getTransaction().commit();
        em.close();
    }
    
}
