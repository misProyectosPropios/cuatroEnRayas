package cuatroEnRaya;



public class Partida {
    Tablero juego;

    public static void main(String[] args) {
        Partida partida = new Partida();
        while (!partida.juego.isGameFull() && partida.juego.isThereWinner() != Jugador.NONE) {
            int column = partida.juego.askUserColumn();
            partida.juego.addFichaToColum(column);
            partida.juego.showTablero();
        }
    }

    public Partida() {
        juego = new Tablero(Jugador.BLACK);
    }
}
