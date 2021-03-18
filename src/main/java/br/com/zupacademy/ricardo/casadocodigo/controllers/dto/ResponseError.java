package br.com.zupacademy.ricardo.casadocodigo.controllers.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseError {

	private Map<String, List<String>> erros = new HashMap<>();

	public Map<String, List<String>> getErros() {
		return erros;
	}

	public void setErros(Map<String, List<String>> erros) {
		this.erros = erros;
	}
	
	public void addErro(String campo, String erro) {
		List<String> errosDeCampo = erros.get(campo);
		if (errosDeCampo == null) {
			erros.put(campo, new ArrayList<String>(Arrays.asList(erro)));
		} else {
			errosDeCampo.add(erro);
			erros.put(campo, errosDeCampo);			
		}
	}
}
