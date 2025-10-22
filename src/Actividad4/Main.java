package Actividad4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static Queue<Integer> bandeja = new LinkedList<>();
	static ArrayList<Integer> bandeja2 = new ArrayList<Integer>();
	static int CAPACIDADMAXIMA = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Productor p = new Productor();
		Consumidor c = new Consumidor("Carlos");
		p.start();
		c.start();
		
	}

}
