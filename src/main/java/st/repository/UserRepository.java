package st.repository;

import org.springframework.stereotype.Repository;
import st.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "st")
    private EntityManagerFactory emf;

    public void registerUser(User newUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }


    public List<User> getAllUser() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u from User u", User.class);
        List<User> resultList = query.getResultList();

        return resultList;
    }


    public void deleteUser(Integer userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            User user = em.find(User.class, userId);
            em.remove(user);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public List<User>  getAllUserByName(String keyword) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("From User u Where u.name Like :keyword", User.class);
        query.setParameter("keyword" ,"%"+keyword+"%");
        List<User> resultList = query.getResultList();

        return resultList;

    }
}
