package ec.edu.ups.bussines;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.model.Vehiculo;

@Remote
public interface VehiculoONRemote {

	public void insertar(Vehiculo v) throws Exception;
	
	public List<Vehiculo> getVehiculos();
	
	public void actualizar(Vehiculo v) throws Exception;
	public Vehiculo getDatos(String Placa);
}
