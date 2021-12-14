package ec.edu.ups.bussines;

import java.util.List;

import ec.edu.ups.model.Vehiculo;

public interface VehiculoONRemote {

	public void insertar(Vehiculo v) throws Exception;
	
	public List<Vehiculo> getVehiculos();
	
	public void actualizar(Vehiculo v) throws Exception;
	
	public Vehiculo getDatos(String Placa);
}
