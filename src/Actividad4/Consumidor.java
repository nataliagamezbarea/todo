package Actividad4;

public class Consumidor extends Thread {

    private String nombre;

    public Consumidor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (Main.bandeja) {
                    // Espera mientras la bandeja está vacía
                    while (Main.bandeja.isEmpty()) {
                        System.out.println("Bandeja vacía. " + nombre + " espera...");
                        Main.bandeja.wait();
                    }

                    // Toma una pizza de la bandeja
                    int id = Main.bandeja.poll();
                    System.out.println("Repartidor " + nombre + " entrega la pizza " + id);

                    // Notifica a los productores que hay espacio libre
                    Main.bandeja.notifyAll();
                }

                // Simula el tiempo de entrega
                Thread.sleep(2500); // tiempo de entrega

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
