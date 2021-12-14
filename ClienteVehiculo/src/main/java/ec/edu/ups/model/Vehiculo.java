package ec.edu.ups.model;

import java.io.Serializable;




public class Vehiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Placa;
	

	private String tipo;
	

	private String modelo;
	
	
	private String anio;

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	

}
