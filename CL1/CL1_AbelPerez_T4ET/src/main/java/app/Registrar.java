package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	        
	        String idEmpleado = "EMP001";
	        String apellido = "Torres";
	        String nombre = "Jose";
	        int edad = 22;
	        char sexo = 'M';
	        double salario = 1500.00;

	        
	        String url = "jdbc:conecta:dbCL1.db"; 

	        try {
	           
	            Connection conn = DriverManager.getConnection(url);

	           
	            String sql = "INSERT INTO empleados (idempleado, apellido, nombre, edad, sexo, salario) VALUES (?, ?, ?, ?, ?, ?)";

	          
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, idEmpleado);
	            pstmt.setString(2, apellido);
	            pstmt.setString(3, nombre);
	            pstmt.setInt(4, edad);
	            pstmt.setString(5, String.valueOf(sexo));
	            pstmt.setDouble(6, salario);           
	            pstmt.executeUpdate();
	            System.out.println("Empleado registrado con éxito.");
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            System.err.println("Error al registrar empleado: " + e.getMessage());
	        }
	    }
	}



