public class Main {
    private static final int N = 4;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        resolverTablero(board, 0, 0);
    }

    private static void resolverTablero(int[][] board, int queens, int row) {
        //Caso base donde las reinas son 2
        if (queens == 2) {
            imprimirTablero(board);
            return;
        }

        // Recorremos el tablero intentando colocar la reina
        for (int i = row; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguro(board, i, j)) {
                    // Colocamos la reina
                    board[i][j] = 1;

                    // Intentamos colocar la siguiente reina
                    resolverTablero(board, queens + 1, i);

                    // Si no encontramos una solución, retiramos la reina (backtracking)
                    board[i][j] = 0;
                }
            }
        }
    }

    // Función que verifica si es seguro colocar una reina en la posición (row, col)
    private static boolean esSeguro(int[][] board, int row, int col) {
        //Verificar la misma fila
        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Verificar la misma columna
        for (int i = 0; i < N; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Verificar la diagonal principal (arriba izquierda a abajo derecha)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i - j == row - col || i + j == row + col) {
                    if (board[i][j] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void imprimirTablero(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
