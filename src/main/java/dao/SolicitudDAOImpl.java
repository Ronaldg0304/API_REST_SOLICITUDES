/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Solicitud;
import recursos.DBConnection;


public class SolicitudDAOImpl implements SolicitudDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz SolicitudDAO
    @Override
    public void crearSolicitud(Solicitud solicitud) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO SOLICITUDES (Descripcion, Solicitante, IdEstado, FechaInicioSolicitud, FechaFinSolicitud, IdOperatividad, IdEquipo, IdTipoSolicitud) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, solicitud.getDescripcion());
            statement.setString(2, solicitud.getSolicitante());
            statement.setInt(3, solicitud.getIdEstado());
            statement.setDate(4, new java.sql.Date(solicitud.getFechaInicioSolicitud().getTime()));
            statement.setDate(5, null);
            statement.setInt(6, solicitud.getIdOperatividad());
            statement.setInt(7, solicitud.getIdEquipo());
            statement.setInt(8, solicitud.getIdTipoSolicitud());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();

            System.out.println("Solicitud creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear la solicitud.");
        }
    }

    @Override
    public Solicitud obtenerSolicitud(int idSolicitud) {

        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM SOLICITUDES WHERE IdSolicitud = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idSolicitud);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Solicitud con los datos obtenidos de la base de datos
                Solicitud solicitud = new Solicitud(
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getString("Descripcion"),
                        resultSet.getString("Solicitante"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioSolicitud"),
                        resultSet.getDate("FechaFinSolicitud"),
                        resultSet.getInt("IdOperatividad"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdTipoSolicitud")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();
                // Retornar la solicitud obtenida
                return solicitud;
            }

            // Si no se encontró la solicitud, retornar null
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la solicitud.");
            return null;
        }
    }

    @Override
    public void actualizarSolicitud(Solicitud solicitud) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE SOLICITUDES SET Descripcion = ?, Solicitante = ?, IdEstado = ?, "
                + "FechaInicioSolicitud = ?, FechaFinSolicitud = ?, IdOperatividad = ?, "
                + "IdEquipo = ?, IdTipoSolicitud = ? WHERE IdSolicitud = " + solicitud.getIdSolicitud();

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, solicitud.getDescripcion());
            statement.setString(2, solicitud.getSolicitante());
            statement.setInt(3, solicitud.getIdEstado());
            statement.setDate(4, new java.sql.Date(solicitud.getFechaInicioSolicitud().getTime()));
            statement.setDate(5, null);
            statement.setInt(6, solicitud.getIdOperatividad());
            statement.setInt(7, solicitud.getIdEquipo());
            statement.setInt(8, solicitud.getIdTipoSolicitud());
            

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Solicitud actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la solicitud.");
        }
    }

    @Override
    public void eliminarSolicitud(int idSolicitud) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM SOLICITUDES WHERE IdSolicitud =  ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idSolicitud);

            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Solicitud eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una solicitud con el ID especificado.");
            }
            // Cerrar la declaración
            statement.close();

            System.out.println("Solicitud eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la solicitud.");
        }
    }

    @Override
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        List<Solicitud> solicitudes = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM SOLICITUDES ORDER BY IdSolicitud DESC";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Solicitud solicitud = new Solicitud(
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getString("Descripcion"),
                        resultSet.getString("Solicitante"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioSolicitud"),
                        resultSet.getDate("FechaFinSolicitud"),
                        resultSet.getInt("IdOperatividad"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdTipoSolicitud")
                );
                // Agregar la solicitud a la lista
                solicitudes.add(solicitud);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todas las solicitudes.");
        }

        return solicitudes;
    }

}
