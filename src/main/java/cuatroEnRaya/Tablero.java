package cuatroEnRaya;

public class Tablero {
    final private int columna = 7;
    final private int fila = 6;
    Ficha[][] board = new Ficha[fila][columna];
    int[] numPieces = new int[columna];

    /**
     * Init the array named board to be all null
     * and init numPieces to be 0
     */
    private void initTablero() {

    }

    public Tablero() {
        this.initTablero();
    }

    /**
     *
     * @param column to add the piece. Require to not be full
     * @param piece to add to the column
     */
    public void addFichaToColumn(int column, Ficha piece) {

    }

    /**
     * This method returns who wins the game.
     * Require to have only one possible winner
     * @return
     */
    public boolean isThereWinner() {
        return false;
    }
}
