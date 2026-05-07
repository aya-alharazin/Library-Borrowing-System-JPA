/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import config.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;



/**
 *
 * @author aya
 */
public class StudentDAO {
    
    public List<Integer> getAllStudentsids(){
        EntityManager em=null;
        try{
            em =JPAUtil.getEntityManager();
            return em.createQuery("select s.studentId from Student s")
                .getResultList();
        }finally{
            em.close();
        }
        
        
        
        
        
    }
    
}
