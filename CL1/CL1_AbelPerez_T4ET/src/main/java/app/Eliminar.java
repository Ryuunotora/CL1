package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empleado;

public class Eliminar {
   

    public void eliminarEmpleado(String idEmpleado) {
        try (Connection conn = DriverManager.getConnection("conecta")) {
           
            Empleado empleadoExistente = buscarEmpleado(idEmpleado);

            if (empleadoExistente != null) {
               
                String sql = "DELETE FROM empleados WHERE idempleado = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, idEmpleado);
                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("Empleado no encontrado. No se puede eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

   
    
        public Empleado buscarEmpleado(String idEmpleado) {
            Empleado empleado = null;

            try (Connection conn = DriverManager.getConnection("")) {
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

