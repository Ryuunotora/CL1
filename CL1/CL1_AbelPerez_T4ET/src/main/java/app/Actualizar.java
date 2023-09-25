package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empleado;


public class Actualizar {
    private String url;

    public Actualizar(String url) {
        this.url = url;
    }

    public Empleado buscarEmpleado(String idEmpleado) {
        Empleado empleado = null;

        try (Connection conn = DriverManager.getConnection(url)) {
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

    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println("Datos del empleado:");
            System.out.println("ID: " + empleado.getIdEmpleado());
            System.out.println("Apellido: " + empleado.getApellidos());
            System.out.println("Nombre: " + empleado.getNombres());
            System.out.println("Edad: " + empleado.getEdad());
            System.out.println("Sexo: " + empleado.getSexo());
            System.out.println("Salario: " + empleado.getSalario());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void actualizarEmpleado(Empleado empleado, String nuevoApellido, double nuevoSalario) {
        if (empleado != null) {
            empleado.actualizarDatos(nuevoApellido, nuevoSalario);

            try (Connection conn = DriverManager.getConnection(url)) {
                String sql = "UPDATE empleados SET apellido = ?, salario = ? WHERE idempleado = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nuevoApellido);
                pstmt.setDouble(2, nuevoSalario);
                pstmt.setString(3, empleado.getIdEmpleado());
                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("Datos del empleado actualizados con éxito.");
            } catch (SQLException e) {
                System.err.println("Error al actualizar empleado: " + e.getMessage());
            }
        } else {
            System.out.println("Empleado no encontrado. No se pueden actualizar los datos.");
        }
    }

    public static void main(String[] args) {
       
        String url = "jdbc:sqlite:empleados.db"; 

        Actualizar gestor = new Actualizar(url);
   
        String idEmpleado = "E001";

        Empleado empleado = gestor.buscarEmpleado(idEmpleado);
        gestor.mostrarEmpleado(empleado);

        if (empleado != null) {
            gestor.actualizarEmpleado(empleado, "Gómez", 35000.0);
        }
    }
}
