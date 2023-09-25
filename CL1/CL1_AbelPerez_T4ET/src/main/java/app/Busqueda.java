package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empleado;

public class Busqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//public class GestorEmpleados {
		  //  private String url;

		//    public GestorEmpleados(String url) {
		//        this.url = url;
		    }

		    public Empleado buscarEmpleado(String idEmpleado) {
		        Empleado empleado = null;

		        try (Connection conn = DriverManager.getConnection("conecta")) {
		            String sql = "SELECT idempleado, apellido, nombre, edad, sexo, salario FROM empleados WHERE idempleado = ?";
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, idEmpleado);

		            ResultSet rs = pstmt.executeQuery();

		            if (rs.next()) {
		                String apellido = rs.getString("apellido");
		                String nombre = rs.getString("nombre");
		                int edad = rs.getInt("edad");
		                char sexo = rs.getString("sexo").charAt(0);
		                double salario = rs.getDouble("salario");

		                empleado = new Empleado();
		            }

		            rs.close();
		            pstmt.close();
		        } catch (SQLException e) {
		            System.err.println("Error al buscar empleado: " + e.getMessage());
		        }

		        return empleado;
		    
		
		

	}

}
