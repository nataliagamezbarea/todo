package Actividad3_Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioDescargas {

    private final int MAX_DESCARGAS_SIMULTANEAS = 3;
    public boolean activo = true;

    private final List<Integer> descargasPendientes = new ArrayList<>();
    private int descargasActivas = 0;


    public ServicioDescargas(int numeroSolicitudes) {
        for (int i = 1; i <= numeroSolicitudes; i++) {
            descargasPendientes.add(i);
        }
    }

    public void iniciar() throws InterruptedException {
        System.out.println("Servicio iniciado");

        while (activo) {
            synchronized (this) {
                // Reproduce Mientras descargas activas sean menor que las permitidas y descargas pendientes
                while (descargasActivas < MAX_DESCARGAS_SIMULTANEAS && !descargasPendientes.isEmpty()) {
                    int id = descargasPendientes.removeFirst(); // toma y elimina la primera descarga pendiente
                    new DescargaArchivo(id, this).start();
                    descargasActivas++;
                }

                // Si no quedan descargas pendientes y no hay activas, termina
                if (descargasPendientes.isEmpty() && descargasActivas == 0) {
                    activo = false;
                }
            }
            Thread.sleep(2000); // pequeño delay antes de intentar lanzar más
        }

        System.out.println("Servicio terminado");
    }

    // Llamado por cada hilo al terminar
    public synchronized void descargaCompletada() {
        descargasActivas--;
    }
}