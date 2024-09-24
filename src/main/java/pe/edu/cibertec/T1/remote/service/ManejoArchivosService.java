package pe.edu.cibertec.T1.remote.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ManejoArchivosService {

    private static final String FILE_PATH_1 = "archivo1.txt";
    private static final String FILE_PATH_2 = "archivo2.txt";
    private static final String FILE_PATH_3 = "archivo3.txt";

    @Async
    public CompletableFuture<String> crearArchivo1() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_1);
                DataOutputStream dataOutputStream = new DataOutputStream(
                fileOutputStream)) {

            dataOutputStream.writeUTF("Este es el archivo 1");
            log.info("Archivo 1 creado");
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return CompletableFuture.completedFuture("Archivo 1 creado");
    }

    @Async
    public CompletableFuture<String> crearArchivo2() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_2);
             DataOutputStream dataOutputStream = new DataOutputStream(
                     fileOutputStream)) {
            dataOutputStream.writeUTF("Este es el archivo 2");
            log.info("Archivo 2 creado");
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return CompletableFuture.completedFuture("Archivo 2 creado");
    }

    @Async
    public CompletableFuture<String> crearArchivo3() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_3);
             DataOutputStream dataOutputStream = new DataOutputStream(
                     fileOutputStream)) {
            dataOutputStream.writeUTF("Este es el archivo 3");
            log.info("Archivo 3 creado");
            TimeUnit.SECONDS.sleep(7);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return CompletableFuture.completedFuture("Archivo 3 creado");
    }

}
