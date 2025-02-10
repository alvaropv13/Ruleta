package tareaRuleta;

public class Jugador {
	 private String nombre;
	 private int puntuacionTotal;
	 private int puntuacionPanel;

	 public Jugador(String nombre) {
	     this.nombre = nombre;
	     this.puntuacionTotal = 0;
	     this.puntuacionPanel = 0;
	 }

	 public String getNombre() {
	     return nombre;
	 }

	 public int getPuntuacionTotal() {
	     return puntuacionTotal;
	 }

	 public int getPuntuacionPanel() {
	     return puntuacionPanel;
	 }

	 public void sumarPuntos(int puntos) {
	     this.puntuacionPanel += puntos;
	 }

	 public void finalizarPanel() {
	     this.puntuacionTotal += puntuacionPanel;
	     this.puntuacionPanel = 0;
	 }

	 public void reiniciarPuntosPanel() {
	     this.puntuacionPanel = 0;
	 }
}
