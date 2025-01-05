package cuatroEnRaya;



public class Partida {
    Tablero juego;

    public static void main(String[] args) {
        Partida partida = new Partida();
        partida.juego.startMatch();
    }

    public Partida() {
        juego = new Tablero(Jugador.BLACK);
    }
}
