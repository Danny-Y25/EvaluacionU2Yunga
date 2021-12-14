package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.model.Vehiculo;

@Stateless
public class VehiculoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo op) {
		em.persist(op);
	}
	
	public void update(Vehiculo  op) {
		em.merge(op);
	}
	
	public Vehiculo read(String id) {
		Vehiculo  op=em.find(Vehiculo.class, id);
		return(op);
	}
	
	public void delete(String id) {
		Vehiculo op=em.find(Vehiculo.class, id);
		em.remove(op);
	}
	
	public List<Vehiculo> getList(){
		
		List<Vehiculo> listado= new ArrayList<Vehiculo>();
		
		String jpql ="SELECT vh FROM Vehiculo vh";
		Query query=em.createQuery(jpql, Vehiculo.class);
		listado=query.getResultList();
		
		return listado;
		
	}
	
}
