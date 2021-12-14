package ec.edu.ups.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.VehiculoDAO;
import ec.edu.ups.model.Vehiculo;

@Stateless
public class VehiculoON implements VehiculoONRemote{
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	
	public void insertar(Vehiculo v) throws Exception {
		daoVehiculo.insert(v);
	}
	
	public List<Vehiculo> getVehiculos(){
		return daoVehiculo.getList();
		
	}
	
	public void actualizar(Vehiculo v) throws Exception {
		daoVehiculo.update(v);;
	}
	
	public Vehiculo getDatos(String Placa) {
		return daoVehiculo.read(Placa);
	}

}
