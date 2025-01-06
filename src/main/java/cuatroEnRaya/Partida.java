package cuatroEnRaya;

public class Partida {
    Tablero juego;

    public static void main(String[] args) throws Exception{


        Partida partida = new Partida();
        partida.juego.startMatch();
        clear();
    }

    public Partida() {
        juego = new Tablero(Jugador.BLACK);
    }

    public static void clear() {
    }
}
