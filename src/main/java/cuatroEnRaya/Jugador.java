package cuatroEnRaya;

public enum Jugador {
    WHITE,
    BLACK,
    NONE;

    public Jugador getOpponent() {
        if(this == WHITE) {
            return BLACK;
        } else if(this == BLACK) {
            return WHITE;
        } else {
            return NONE;
        }
    }

    public static Jugador getJugadorFromFicha(Ficha piece) {
        if(piece == Ficha.YELLOW) {
            return WHITE;
        } else if(piece == Ficha.RED) {
            return BLACK;
        } else {
            return NONE;
    }
    }
}
