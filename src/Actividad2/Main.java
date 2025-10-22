package Actividad2;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		int max=2000;
		Agente[] lista_agentes = new Agente[max];
		
		for(int i=0;i<max;i++) {
			lista_agentes[i]=new Agente();
			lista_agentes[i].start();
		}
		
		for(Agente a: lista_agentes) {
			a.join();
		}
		System.out.println("Pasajeros con asiento: ");
		for (String pasajero: Agente.getLista()) {
			System.out.println(pasajero);
		}
		System.out.println("Lista de espera: ");
		for (String pasajero: Agente.getListaDeEspera()) {
			System.out.println(pasajero);
		}
		
		System.out.println("Asientos disponibles: "+Agente.getAsientos());
		
	}

}
