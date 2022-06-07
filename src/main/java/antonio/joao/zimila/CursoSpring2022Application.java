package antonio.joao.zimila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import antonio.joao.zimila.Service.DBservice;


@SpringBootApplication
public class CursoSpring2022Application implements CommandLineRunner {
	@Autowired
private DBservice servico;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpring2022Application.class, args);
	System.out.println("Ola mundo");	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//servico.instaciaBaseDeDados();
		
		
	}

}
