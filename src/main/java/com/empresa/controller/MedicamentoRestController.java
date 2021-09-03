package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoRestController {
	

	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>>listaMedicamento(){
		List<Medicamento> lista= service.listaMedicamento();
		return ResponseEntity.ok(lista);
}
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> insertaMedicamento(@RequestBody Medicamento obj){
		if (obj == null) {
			return ResponseEntity.noContent().build();	
		}else {
			obj.setIdMedicamento(0);
			Medicamento objSalida = service.insertaActualizaMedicamento(obj);
			return ResponseEntity.ok(objSalida);
		}
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Medicamento> actualizaMedicamento(@RequestBody Medicamento obj){
		if (obj == null) {
			return ResponseEntity.noContent().build();	
		}else {
			Optional<Medicamento> optMedicamento = service.obtenerPorId(obj.getIdMedicamento());
			if (optMedicamento.isEmpty()) {
				return ResponseEntity.noContent().build();
			}else {
				Medicamento objSalida = service.insertaActualizaMedicamento(obj);
				return ResponseEntity.ok(objSalida);	
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
