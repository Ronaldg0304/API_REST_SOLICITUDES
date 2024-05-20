package com.sena.webservice.proyecto.gpm;

import java.util.List; 
import jakarta.ws.rs.*; 
import jakarta.ws.rs.core.MediaType; 
import jakarta.ws.rs.core.Response; 
import dao.SolicitudDAOImpl; 
import model.Solicitud; 

@Path("/solicitudes") // Define la ruta base para acceder a este servicio
public class SolicitudService { 

    private SolicitudDAOImpl solicitudDAO = new SolicitudDAOImpl();

    @GET // Define que este método responderá a solicitudes GET
    @Produces(MediaType.APPLICATION_JSON) // Indica que el método producirá respuestas en formato JSON
    public List<Solicitud> getSolicitudes() { 
        return solicitudDAO.obtenerTodasLasSolicitudes();
    }

    @GET // Define que este método responderá a solicitudes GET mas una subruta que acepta un parámetro de ruta {id}
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getSolicitud(@PathParam("id") int id) { 
        Solicitud solicitud = solicitudDAO.obtenerSolicitud(id); 
        if (solicitud == null) { // Verifica si la solicitud no existe
            return Response.status(Response.Status.NOT_FOUND).build(); // Retorna una respuesta 404 si no se encuentra la solicitud
        }
        return Response.ok(solicitud).build(); // Retorna una respuesta 200 con la solicitud en formato JSON
    }

    @POST // Define que este método responderá a solicitudes POST
    @Consumes(MediaType.APPLICATION_JSON) // Indica que el método consumirá datos en formato JSON
    @Produces(MediaType.APPLICATION_JSON) // Indica que el método producirá respuestas en formato JSON
    public Response createSolicitud(Solicitud solicitud) { 
        solicitudDAO.crearSolicitud(solicitud);
        return Response.status(Response.Status.CREATED).entity(solicitud).build(); // Retorna una respuesta 201 con la solicitud creada en formato JSON
    }

    @PUT // Define que este método responderá a solicitudes PUT
    @Path("/{id}") // Define un subruta que acepta un parámetro de ruta {id}
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response updateSolicitud(@PathParam("id") int id, Solicitud solicitud) { 
        solicitud.setIdSolicitud(id); 
        solicitudDAO.actualizarSolicitud(solicitud); 
        return Response.ok(solicitud).build(); // Retorna una respuesta 200 con la solicitud actualizada en formato JSON
    }

    @DELETE // Define que este método responderá a solicitudes DELETE
    @Path("/{id}") // Define un subruta que acepta un parámetro de ruta {id}
    public Response deleteSolicitud(@PathParam("id") int id) { 
        solicitudDAO.eliminarSolicitud(id); 
        return Response.noContent().build(); // Retorna una respuesta 204 indicando que la solicitud fue eliminada
    }
}
