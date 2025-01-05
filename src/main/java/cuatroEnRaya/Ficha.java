package cuatroEnRaya;

public enum Ficha {
    YELLOW,
    RED,
    NONE;

    public static Ficha fichaOpuesta(Ficha piece) {
        if (piece == Ficha.RED) return Ficha.YELLOW;
        if (piece == Ficha.YELLOW) return Ficha.RED;
        return Ficha.NONE;
    }

    public static Ficha associateJugadorToFicha(Jugador jug) {
        if (jug == Jugador.BLACK) return Ficha.RED;
        if (jug == Jugador.WHITE) return Ficha.YELLOW;
        return Ficha.NONE;
    }
}
