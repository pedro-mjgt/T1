package pe.edu.cibertec.T1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T1.remote.service.ManejoArchivosService;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class ManejoHilosService {

    private final ManejoArchivosService manejoArchivosService;

    public CompletableFuture<String> crearArchivos() throws Exception {
        CompletableFuture<String> tarea1 = manejoArchivosService.crearArchivo1();
        CompletableFuture<String> tarea2 = manejoArchivosService.crearArchivo2();
        CompletableFuture<String> tarea3 = manejoArchivosService.crearArchivo3();

        return CompletableFuture.allOf(tarea1, tarea2, tarea3)
                .thenApply(result -> {
                    try {
                        String valorTarea1 = tarea1.join();
                        String valorTarea2 = tarea2.join();
                        String valorTarea3 = tarea3.join();

                        return  "Resultado de tareas: " +
                                valorTarea1 + " - " +
                                valorTarea2 + " - " +
                                valorTarea3;
                    }
                    catch (Exception ex) {
                        return "Error al combinar los datos";
                    }
                })
                .exceptionally(ex -> "Error al ejecutar tareas: " + ex.getMessage());
    }

}
