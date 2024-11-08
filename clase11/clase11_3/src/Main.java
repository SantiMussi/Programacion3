public class Main {
    static int N = 4;
    static int[][] tablero = new int[N][N];

    public static boolean esSeguro(int[][] tablero, int fila, int col, int tipo) {
        // Verificar fila y columna para el tipo actual (1: computadora, 2: impresora)
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == tipo || tablero[i][col] == tipo) {
                return false;
            }
        }
        return true;
    }

    public static boolean colocarEquipos(int[][] tablero, int fila, int tipo) {
        if (fila == N) {
            if (tipo == 1) { // Si terminamos con computadoras, ahora colocamos impresoras
                return colocarEquipos(tablero, 0, 2);
            }
            // Si también colocamos impresoras, imprimimos la configuración
            imprimirTablero(tablero);
            return true;
        }

        boolean exito = false;
        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col, tipo)) {
                tablero[fila][col] = tipo;
                exito |= colocarEquipos(tablero, fila + 1, tipo);
                tablero[fila][col] = 0; // Backtrack
            }
        }
        return exito;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C ");
                } else if (tablero[i][j] == 2) {
                    System.out.print("I ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        colocarEquipos(tablero, 0, 1); // Colocamos primero las computadoras (1), luego impresoras (2)
    }
}
