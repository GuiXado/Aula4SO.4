package controller;

public class SapoThread extends Thread {

	
	private static int colocacao = 0;
	private int distanciaMax = 100;
	private int distPulo = 0;
	private static boolean linhaImpressa = false; // pra garatir que só tenha uma quebra
	
	public SapoThread() {}
	
	int tid = (int) threadId();
	
	
	public void run() {
		
		while (distPulo < distanciaMax) {
				int pulo = (int) (Math.random() * 6);
				distPulo += pulo;
				System.out.println("Sapo "+tid+", pulou "+pulo+ " metros");
		}
		
 
    	
		
		try {
			sleep(50);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		// Única forma que encontrei para não repetir as colocações
		synchronized (SapoThread.class) {
			if (!linhaImpressa) {
				System.err.println("============================");
				linhaImpressa = true;
			}
			
			colocacao++;
			System.out.println("Sapo " + tid + " CHEGOU! Colocação: " + colocacao);
		}
	}
	
}