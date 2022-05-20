// Criar um projeto que faça as operações de CRUD em uma classe a sua escolha
//Criar um controle que utilize o service criado acima e atenda a seguinte especificação de acesso rest:
//GET /todo - retorna todos os “todos”
//GET /todo/{n} - retorna o “todo” com id n
//POST /todo - insere o “todo” 
//PUT /todo/{n} - atualiza os atributos do “todo” com id {n} utilizando os atributos passados no corpo do request em json
//DELETE /todo/{n} -  exclui o “todo” com o id {n} da lista

package org.serratec.backend.exercicio02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio02Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio02Application.class, args);
		
	}

}
