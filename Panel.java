package tareaRuleta;

public class Panel {
	private String fraseOriginal;
    private String pista;
    private String estadoFrase;

    public Panel(String frase, String pista) {
        this.fraseOriginal = frase;
        this.pista = pista;
        this.estadoFrase = ocultarLetras(frase);
    }

    // Método que reemplaza las letras por asteriscos
    private String ocultarLetras(String frase) {
        String fraseOcultada = "";
        for (int i = 0; i < frase.length(); i++) {
            char caracterActual = frase.charAt(i);
            if (caracterActual >= 65 && caracterActual <= 90 || caracterActual >= 97 && caracterActual <= 122) {  // Comprobar si es letra
                fraseOcultada += "*";  // Ocultar letra con *
            } else {
                fraseOcultada += caracterActual;  // No ocultar caracteres como espacios, comas, etc.
            }
        }
        return fraseOcultada;
    }

    public String getPista() {
        return pista;
    }

    public String getEstadoActual() {
        return estadoFrase;
    }

    // Método que revela las letras de la frase que coinciden con la letra ingresada
    public boolean descubrirLetra(char letraAdivinada) {
        boolean letraEncontrada = false;
        String nuevaEstadoFrase = "";
        
        for (int i = 0; i < fraseOriginal.length(); i++) {
            char caracterOriginal = fraseOriginal.charAt(i);
            if (caracterOriginal == letraAdivinada && estadoFrase.charAt(i) == '*') {
                nuevaEstadoFrase += caracterOriginal;  // Si la letra coincide, mostrarla
                letraEncontrada = true;
            } else {
                nuevaEstadoFrase += estadoFrase.charAt(i);  // De lo contrario, mantener el estado actual
            }
        }
        
        if (letraEncontrada) {
            estadoFrase = nuevaEstadoFrase;  // Actualizar el estado
        }
        return letraEncontrada;
    }

    // Método que resuelve la frase completa
    public boolean resolverFrase(String intentoFrase) {
        return fraseOriginal.equals(intentoFrase);  // Verifica si el intento es igual a la frase completa
    }
}


