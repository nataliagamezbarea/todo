package Actividad4;

public class Productor extends Thread {
	int pizza = 0;
	
	public void run() {
		
		while(true) {
			try {
				synchronized (Main.bandeja) {
					while (Main.bandeja.size() == Main.CAPACIDADMAXIMA) {
						
						System.out.println("Bandeja llena");
						Main.bandeja.wait();
					
					}
					System.out.println("Pizzero hace la pizza "+ pizza);
                    Main.bandeja.add(pizza);
                    pizza++;
					Main.bandeja.notifyAll();
				}
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
