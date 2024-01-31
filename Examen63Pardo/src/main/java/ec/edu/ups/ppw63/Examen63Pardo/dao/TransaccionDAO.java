package ec.edu.ups.ppw63.Examen63Pardo.dao;

import ec.edu.ups.ppw63.Examen63Pardo.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TransaccionDAO {
    @PersistenceContext
    private EntityManager em;

    public void insert(Transaccion transaccion) {
        em.persist(transaccion);
    }

}