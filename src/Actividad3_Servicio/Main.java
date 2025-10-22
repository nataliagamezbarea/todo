package Actividad3_Servicio;

public  class Main {
    public static void main(String[] args) {
        ServicioDescargas servicio = new ServicioDescargas(20);
        servicio.start();
    }
}