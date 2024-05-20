/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Solicitud;

public interface SolicitudDAO {
    void crearSolicitud(Solicitud solicitud);
    Solicitud obtenerSolicitud(int idSolicitud);
    void actualizarSolicitud(Solicitud solicitud);
    void eliminarSolicitud(int idSolicitud);
    List<Solicitud> obtenerTodasLasSolicitudes();
}

