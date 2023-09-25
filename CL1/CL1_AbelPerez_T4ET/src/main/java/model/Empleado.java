package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idEmpleado;

	private String apellidos;

	private int edad;

	private String nombres;

	private double salario;

	private char sexo;

	

	public String getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", apellidos=" + apellidos + ", edad=" + edad + ", nombres="
				+ nombres + ", salario=" + salario + ", sexo=" + sexo + "]";
	}

	
	// Método para actualizar los datos del empleado
    public void actualizarDatos(String nuevoApellido, double nuevoSalario) {
        this.apellidos = nuevoApellido;
        this.salario = nuevoSalario;
    }
}
	
	
	
