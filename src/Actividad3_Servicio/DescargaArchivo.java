package Actividad3_Servicio;

public class DescargaArchivo extends Thread  {
    private final int id;
    private final ServicioDescargas servicio;
    public DescargaArchivo (int id , ServicioDescargas servicio){
        this.id = id;
        this.servicio = servicio;
    }

    public void run() {
        System.out.println("La descarga ha empezado");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("La descarga ha terminado");
        ServicioDescargas.descargaCompletada();


    }



}