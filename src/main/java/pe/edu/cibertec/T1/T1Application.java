package pe.edu.cibertec.T1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import pe.edu.cibertec.T1.service.ManejoHilosService;

@EnableAsync
@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class T1Application implements CommandLineRunner {

	private final ManejoHilosService manejoHilosService;

	public static void main(String[] args) {
		SpringApplication.run(T1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Ejecutando tareas");
		manejoHilosService.crearArchivos();
		log.info("Tareas terminadas");
	}

}
