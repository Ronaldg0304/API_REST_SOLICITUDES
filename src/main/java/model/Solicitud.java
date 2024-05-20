package model;

/**
 *
 * @author rolan
 */
import java.util.Date;

public class Solicitud {

    private int idSolicitud;
    private String descripcion;
    private String solicitante;
    private int idEstado;
    private Date fechaInicioSolicitud;
    private Date fechaFinSolicitud;
    private int idOperatividad;
    private int idEquipo;
    private int idTipoSolicitud;

    // Constructor
    public Solicitud(int idSolicitud, String descripcion, String solicitante, int idEstado, Date fechaInicioSolicitud, Date fechaFinSolicitud, int idOperatividad, int idEquipo, int idTipoSolicitud) {
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
        this.idEstado = idEstado;
        this.fechaInicioSolicitud = fechaInicioSolicitud;
        this.fechaFinSolicitud = fechaFinSolicitud;
        this.idOperatividad = idOperatividad;
        this.idEquipo = idEquipo;
        this.idTipoSolicitud = idTipoSolicitud;
    }
    
    public Solicitud(){
        
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFechaInicioSolicitud() {
        return fechaInicioSolicitud;
    }

    public void setFechaInicioSolicitud(Date fechaInicioSolicitud) {
        this.fechaInicioSolicitud = fechaInicioSolicitud;
    }

    public Date getFechaFinSolicitud() {
        return fechaFinSolicitud;
    }

    public void setFechaFinSolicitud(Date fechaFinSolicitud) {
        this.fechaFinSolicitud = fechaFinSolicitud;
    }

    public int getIdOperatividad() {
        return idOperatividad;
    }

    public void setIdOperatividad(int idOperatividad) {
        this.idOperatividad = idOperatividad;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }
    
}
