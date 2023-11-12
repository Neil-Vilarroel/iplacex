package com.esucomex.mascotas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esucomex.mascotas.daos.IClienteDao;
import com.esucomex.mascotas.models.Cliente;



@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteControllers {
	
	@Autowired
	private IClienteDao ClienteDao;
	
	@GetMapping("/getAllCliente")
	public List<Cliente> getAllCliente(){
		return (List<Cliente>) ClienteDao.findAll();//Select * from MASCOTA
		}
	@PostMapping("/guardarCiente")
	public Cliente guardarPersona(Cliente masc) {
		return  ClienteDao.save(masc); //Insert into MASCOTA
	}
	
	@PutMapping("/actualizarCliente")
	public Cliente actualizarPersona(Cliente masc) {
		Cliente PersonaBd =  ClienteDao.findById(masc.getId()).orElse(null);
		
		if (PersonaBd.equals(null)) {
			return PersonaBd;
		}
		return  ClienteDao.save(masc); //Update MASCOTA
	}
	@DeleteMapping("/eliminarCliente")
	public Boolean eliminarMascota(Cliente persona) {
		Boolean respuesta = false;
			try {
				 ClienteDao.delete(persona);
				respuesta = true;
			} catch (Exception e) {
				respuesta = false;
			}
			return respuesta;
	}
}
