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
}
