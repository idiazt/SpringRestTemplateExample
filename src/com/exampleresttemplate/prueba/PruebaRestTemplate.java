package com.exampleresttemplate.prueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.exampleresttemplate.prueba.dto.RolDTO;
import com.exampleresttemplate.prueba.dto.UsuarioDTO;

public class PruebaRestTemplate {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(getMessageConverters());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		guardarUsuario(restTemplate, entity);
		obtenerUsuarios(restTemplate, entity);
	}

	private static void guardarUsuario(RestTemplate restTemplate, HttpEntity<String> entity) {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNombre("Secundino");
		List<RolDTO> roles = new ArrayList<RolDTO>();
		RolDTO rol = new RolDTO();
		rol.setDescripcion("ROL_CUSTOM");
		roles.add(rol);
		usuario.setRoles(roles);
		restTemplate.postForObject("http://localhost:8081/services/usuario/alta", usuario, UsuarioDTO.class);
	}

	private static void obtenerUsuarios(RestTemplate restTemplate, HttpEntity entity) {
		ResponseEntity<UsuarioDTO[]> response = (ResponseEntity<UsuarioDTO[]>) restTemplate.exchange(
				"http://localhost:8081/services/usuario/todos", HttpMethod.GET, entity, new UsuarioDTO[] {}.getClass(),
				"1");
		UsuarioDTO[] usuarios = response.getBody();
		for (UsuarioDTO usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}

	}

	private static List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		return converters;
	}
}
