package ec.edu.ups.ppw63.Examen63Pardo.dao;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CuentaDAO {
     @PersistenceContext
        private EntityManager em;

        public void insert(Cuenta cuenta) {
            em.persist(cuenta);
        }

        public void update(Cuenta cuenta) {
            em.merge(cuenta);
        }

        public Cuenta read(int numeroCuenta) {
            return em.find(Cuenta.class, numeroCuenta);
        }

        public List<Cuenta> getAll(){
            String jpql = "SELECT c FROM Cuenta c";
            Query q = em.createQuery(jpql, Cuenta.class);
            return q.getResultList();
        }

}
