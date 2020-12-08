package com.clearminds.servicios;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.clearminds.entidades.Persona;

@Path("/srvpersonas")
public class ServicioPersona {

	@Path("/busqueda")
	@GET
	public String consultar() {
		return "Mensaje cualquiera";
	}

	@Path("/recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona recuperar() {
		return new Persona("Sofia", "Díaz");
	}

	@Path("/ingresar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void ingresar(Persona persona) {
		System.out.println("Ingresando persona: " + persona);
	}

	@Path("/actualizar")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Persona actualizar(Persona persona) {
		try {
			if (persona != null) {
				System.out.println("Persona: " + persona);
				persona.setNombre(persona.getNombre().toUpperCase());
				persona.setApellido(persona.getApellido().toUpperCase());
				System.out.println("Persona modificada: " + persona);
			} else {
				System.out.println("Persona en null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Persona();
		}
		return persona;
	}
}
