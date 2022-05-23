package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //  um endpoint possa ser acessado
@RequestMapping("/teste") // aplica o endpoint
public class HelloWolrdController {
	
	@RequestMapping("/ola")
	public String olaMundo() {
		return "olá mundo!";
	}
	
	@RequestMapping("/maiuscula")
	public String toUpper(@RequestParam String valor) { //RequestParam solicita que url envie um parametro;
		return valor.toUpperCase(); // transforma em maiusculo;
	}
}
