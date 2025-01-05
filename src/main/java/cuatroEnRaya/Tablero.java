package cuatroEnRaya;

import java.util.Scanner;

public class Tablero {
    static Scanner scanner = new Scanner(System.in);
    final private int columna = 7;
    final private int fila = 6;
    private Ficha[][] board = new Ficha[fila][columna];
    private int[] numPieces = new int[columna];
    private Jugador jugadorToPlay;
    private int numPlays = 0;

    /**
     * Init the array named board to be all null
     * and init numPieces to be 0
     */
    private void initTablero() {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                board[i][j] = null;
            }
        }
        for (int i = 0; i < columna; i++) {
            numPieces[i] = 0;
        }
    }

    public Tablero(Jugador jugador) {
        this.initTablero();
        jugadorToPlay = jugador;
    }

    public boolean isGameFull() {
        return this.numPlays == this.columna * this.fila;
    }

    public void showTablero() {
        for(int i = 0; i < this.fila; i++) {
            for(int j = 0; j < this.columna; j++) {
                if (j == this.columna - 1) {
                    System.out.print(this.board[i][j].getCircleColor());
                } else {
                    System.out.println(this.board[i][j].getCircleColor() + " |");
                }
            }
        }
    }

    /**
     *
     * @param column to add the piece. Require to not be full
     * @param piece to add to the column
     */
    private void addFichaToColumn(int column, Ficha piece) {
        int row = numPieces[column];
        board[fila - row][column] = piece;
        numPieces[column]++;
    }

    /**
     * Adds the ficha that is set beforehand to the desire column
     * @param column to add the piece. Require to not be full
     */
    public void addFichaToColum(int column) {
        addFichaToColumn(column, Ficha.associateJugadorToFicha(jugadorToPlay));
        jugadorToPlay = jugadorToPlay.getOpponent();
        numPlays++;
    }

    /**
     * This method returns who wins the game.
     * Require to have only one possible winner
     * @return
     */
    public Jugador isThereWinner() {
        Jugador horizontalWinner = this.isThereHorizontalWinner();
        if (horizontalWinner != Jugador.NONE) {
            return horizontalWinner;
        }
        Jugador verticalWinner = this.isThereVerticalWinner();
        if (verticalWinner != Jugador.NONE) {
            return verticalWinner;
        }

        return this.isThereDiagonalWinner();
    }

    /**
     * This method returns who wins the game.
     * Require to have only one possible winner
     * @return the player that won. If there's none, return Jugador.NONE
     */
    private Jugador isThereHorizontalWinner() {
        for(int i = 0; i < fila; i++) {
            for(int j = 0; j < columna - 3; j++) {
                if(board[i][j] != null && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
                    return Jugador.getJugadorFromFicha(board[i][j]);
                }
            }
        }
        return Jugador.NONE;
    }

    /**
     * This method returns who wins the game vertically.
     * Require to have only one possible winner
     * @return the player that won. If there's none, return Jugador.NONE
     */
    private Jugador isThereVerticalWinner() {
        for(int i = 0; i < fila - 3; i++) {
            for(int j = 0; j < columna; j++) {
                if(board[i][j] != null && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
                    return Jugador.getJugadorFromFicha(board[i][j]);
                }
            }
        }
        return Jugador.NONE;
    }

    /**
     * This method returns who wins the game diagonally.
     * Require to have only one possible winner
     * @return the player that won. If there's none, return Jugador.NONE
     */
    private Jugador isThereDiagonalWinner() {
        for(int i = 0; i < fila - 3; i++) {
            for(int j = 0; j < columna - 3; j++) {
                if(board[i][j] != null && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3]) {
                    return Jugador.getJugadorFromFicha(board[i][j]);
                }
            }
        }
        return Jugador.NONE;
    }

    public int askUserColumn() {
        System.out.println("Enter a column (from 1 to " + this.columna + ")");
        int columnaIngresada;
        do {
            System.out.println("Enter a column (from 1 to " + this.columna + ")");
            columnaIngresada = Tablero.scanner.nextInt();
        } while(columnaIngresada < 1 || columnaIngresada > this.columna);
        return columnaIngresada;
    }

}
