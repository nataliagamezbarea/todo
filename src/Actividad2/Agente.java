package Actividad2;

public class Agente extends Thread{
	private static int asientos=1000;
	private static int numero_de_asiento=0;
	private static int numero_de_listadeespera=0;
	private static String[] lista = new String[asientos];
	private static String[] lista_de_espera = new String[1000];
	
	public void run() {
		reservar();
	}

	public static synchronized void reservar() {
		if (asientos>0) {
			asientos--;
			lista[numero_de_asiento]="Asiento nº "+numero_de_asiento+ " reservado por "+ Thread.currentThread().getName();
			numero_de_asiento++;
		} else {
			lista_de_espera[numero_de_listadeespera]=Thread.currentThread().getName();
			numero_de_listadeespera++;
		}
	}
	
	public static String[] getLista() {
		return lista;
	}
	public static String[] getListaDeEspera() {
		return lista_de_espera;
	}
	
	public static int getAsientos() {
		return asientos;
	}
}
