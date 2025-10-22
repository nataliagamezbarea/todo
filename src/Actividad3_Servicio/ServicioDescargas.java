package Actividad3_Servicio;

import java.util.ArrayList;

public class ServicioDescargas extends Thread {
    private boolean activo = true;
    private static int descargasActivas;
    private int descargasSimultaneas = 3;
    ArrayList <Integer> descargasPendientes;
    // tiene que haber unas descargas simultaneas
    // totales
    // ahora
    // inicializar el contructor con las descargas

    // while true

    // sincronizar

    public ServicioDescargas (int numeroDescargas) {
        descargasPendientes = new ArrayList<>();
        for (int i = 0; i < numeroDescargas; i++) {
            descargasPendientes.add(i);
        }
    }

    public void run() {
        while (activo) {
            synchronized (this) {
                while (descargasActivas <  descargasSimultaneas && !descargasPendientes.isEmpty()) {
                    int id = descargasPendientes.remove(0);
                    new DescargaArchivo(id , this).start();
                    descargasActivas++;
                }
            }
            if (descargasPendientes.isEmpty() && descargasActivas == 0) {
                activo = false;
            }
        }


    }

    public static synchronized  void descargaCompletada() {
        descargasActivas--;
    }


}