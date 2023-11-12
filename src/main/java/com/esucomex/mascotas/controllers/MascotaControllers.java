package com.esucomex.mascotas.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.esucomex.mascotas.daos.IMascotaDao;
import com.esucomex.mascotas.models.Mascota;



@RestController
@RequestMapping("/api/mascota")
//http://localhost:8100/
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MascotaControllers {
	@Autowired
	private IMascotaDao MascotaDao;
	
	@GetMapping ("/getAllMascota/{id}")
	public String mascotaPorId (@PathVariable("id") Integer id) {
		return "id";
		}
	
	

	
	@GetMapping("/getAllMascota")
	public List<Mascota> getAllMascota(){
		return (List<Mascota>)MascotaDao.findAll();//Select * from MASCOTA
		}
	@PostMapping("/guardarMascota")
	public Mascota guardarMascota(Mascota masc) {
		return MascotaDao.save(masc); //Insert into MASCOTA
	}
	
	@PutMapping("/actualizarMascota")
	public Mascota actualizarMascota(Mascota masc) {
		Mascota mascotaBd = MascotaDao.findById(masc.getId()).orElse(null);
		
		if (mascotaBd.equals(null)) {
			return mascotaBd;
		}
		return MascotaDao.save(masc); //Update MASCOTA
	}
	@DeleteMapping("/eliminarMascota")
	public Boolean eliminarMascota(Mascota mascota) {
		Boolean respuesta = false;
			try {
				MascotaDao.delete(mascota);
				respuesta = true;
			} catch (Exception e) {
				respuesta = false;
			}
			return respuesta;
	}


//URL dinamica 
  @DeleteMapping("/eliminar/{id}")
  public Mascota eliminar (@PathVariable Integer id) {
	  Mascota mascota = MascotaDao.findById(id).orElse( new Mascota());
	  
	  if (mascota.equals(null)) {
		  return mascota;
	  }
	  try {
		  MascotaDao.delete(mascota); //Delete from
	  } catch (Exception e) {
		  return new Mascota();
	  }
	  return mascota;
	  } 
	  
}