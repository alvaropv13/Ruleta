package tareaRuleta;

import java.util.Random;

public class Ruleta {
private static final int[] VALORES = {0, 25, 50, 75, 100, 150, -1};
    
    public int lanzar() {
        Random rnd = new Random();
        int valor = VALORES[rnd.nextInt(VALORES.length)];
        simularGiro();
        return valor;
    }

    private void simularGiro() {
        String[] frames = {
            "     .-------.\n    /       \\\n   |       |       |\n   |-------|-------|\n   |       |       |\n   |-------|-------|\n   |       |       |\n    \\_______/",
            "     .-------.\n    /  100   \\\n   |       |  150 |\n   |-------|-----|\n   |  50  |  25  |\n   |-------|-----|\n   |  0   | QUIE |\n    \\_______/",
            "     .-------.\n    /       \\\n   |  75  |       |\n   |-------|-------|\n   |       |  25  |\n   |-------|-----|\n   |  0   |       |\n    \\_______/"
        };
        
        for (int i = 0; i < 5; i++) {
            System.out.print("\033[H\033[2J"); // Limpia la consola (en sistemas compatibles)
            System.out.flush();
            System.out.println(frames[i % frames.length]);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


