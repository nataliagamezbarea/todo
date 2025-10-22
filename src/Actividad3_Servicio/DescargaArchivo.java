package Actividad3_Servicio;

public class DescargaArchivo extends Thread {
    private final int id;
    private final ServicioDescargas servicio;

    public DescargaArchivo(int id, ServicioDescargas servicio) {
        this.id = id;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        System.out.println("Descarga " + id + " empezada en el servicio");

        try {
            Thread.sleep(2000); // simula tiempo de descarga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Descarga " + id + " terminada en el servicio");

        // avisamos al servicio que esta descarga terminó
        servicio.descargaCompletada();
    }
}