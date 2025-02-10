package tareaRuleta;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Preguntar número de jugadores
	        System.out.print("Ingrese la cantidad de jugadores: ");
	        int cantidadJugadores = scanner.nextInt();
	        scanner.nextLine(); // Limpiar buffer
	        
	        ArrayList<Jugador> jugadores = new ArrayList<>();
	        for (int i = 0; i < cantidadJugadores; i++) {
	            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
	            String nombreJugador = scanner.nextLine();
	            jugadores.add(new Jugador(nombreJugador));
	        }
	        
	        // Preguntar número de paneles
	        System.out.print("Ingrese la cantidad de paneles: ");
	        int cantidadPaneles = scanner.nextInt();
	        scanner.nextLine(); // Limpiar buffer
	        
	        ArrayList<Panel> paneles = new ArrayList<>();
	        for (int i = 0; i < cantidadPaneles; i++) {
	            System.out.print("Ingrese la frase para el panel " + (i + 1) + ": ");
	            String frase = scanner.nextLine();
	            System.out.print("Ingrese la pista para el panel " + (i + 1) + ": ");
	            String pista = scanner.nextLine();
	            paneles.add(new Panel(frase, pista));
	        }
	        
	        Ruleta ruleta = new Ruleta();
	        
	        // Jugar cada panel
	        for (Panel panel : paneles) {
	            System.out.println("\n--- Nuevo Panel ---");
	            System.out.println("Pista: " + panel.getPista());
	            boolean panelResuelto = false;
	            
	            while (!panelResuelto) {
	                for (Jugador jugador : jugadores) {
	                    System.out.println("\nEstado actual del panel: " + panel.getEstadoActual());
	                    System.out.println("Turno de " + jugador.getNombre());
	                    
	                    System.out.print("¿Quiere intentar resolver la frase? (s/n): ");
	                    String respuesta = scanner.nextLine();
	                    
	                    if (respuesta.equalsIgnoreCase("s")) {
	                        System.out.print("Ingrese la frase completa: ");
	                        String intento = scanner.nextLine();
	                        if (panel.resolverFrase(intento)) {
	                            System.out.println("¡Correcto! " + jugador.getNombre() + " ha resuelto el panel.");
	                            jugador.finalizarPanel();
	                            panelResuelto = true;
	                            break;
	                        } else {
	                            System.out.println("Respuesta incorrecta. Turno perdido.");
	                        }
	                    } else {
	                        int valorRuleta = ruleta.lanzar();
	                        if (valorRuleta == -1) {
	                            System.out.println("¡Quiebra! Pierdes todo el dinero de este panel.");
	                            jugador.reiniciarPuntosPanel();
	                        } else {
	                            System.out.print("Ingrese una letra: ");
	                            char letra = scanner.nextLine().charAt(0);
	                            
	                            if (panel.descubrirLetra(letra)) {
	                                int cantidadLetras = contarOcurrencias(panel.getEstadoActual(), letra);
	                                int puntosGanados = valorRuleta * cantidadLetras;
	                                jugador.sumarPuntos(puntosGanados);
	                                System.out.println("¡Letra encontrada! Has ganado " + puntosGanados + " puntos.");
	                            } else {
	                                System.out.println("Letra no encontrada. Turno perdido.");
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        // Determinar ganador final
	        Jugador ganador = jugadores.get(0);
	        for (Jugador jugador : jugadores) {
	            if (jugador.getPuntuacionTotal() > ganador.getPuntuacionTotal()) {
	                ganador = jugador;
	            }
	        }
	        
	        System.out.println("\n¡El ganador final es " + ganador.getNombre() + " con " + ganador.getPuntuacionTotal() + " puntos!");
	        scanner.close();
	    }
	    
	    private static int contarOcurrencias(String texto, char letra) {
	        int contador = 0;
	        for (int i = 0; i < texto.length(); i++) {
	            if (texto.charAt(i) == letra) {
	                contador++;
	            }
	        }
	        return contador;
	    }
	}

    
   