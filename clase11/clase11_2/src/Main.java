public class Main {
    static int N = 4;

    public static boolean esSeguroEscritorio(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }
        return true;
    }


    public static boolean esSeguroSilla(int tablero[][], int fila, int col) {

        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 2) {
                return false;
            }
        }
        return true;
    }
    public static void resolverDisenoInteriores() {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío
        colocarEscritorios(tablero, 0, 0); // Iniciar colocando los escritorios
    }


    public static boolean colocarEscritorios(int[][] tablero, int fila, int escritoriosColocados) {
        if (escritoriosColocados == 4) { // Si hemos colocado 4 escritorios, pasar a colocar sillas
            colocarSillas(tablero, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroEscritorio(tablero, i, j)) {

                    tablero[i][j] = 1;


                    colocarEscritorios(tablero, i + 1, escritoriosColocados + 1);

                    tablero[i][j] = 0;
                }
            }
        }

        return false;
    }

    public static boolean colocarSillas(int[][] tablero, int fila, int sillasColocadas) {
        if (sillasColocadas == 4) {
            imprimirTablero(tablero);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroSilla(tablero, i, j) && tablero[i][j] == 0) {
                    tablero[i][j] = 2;

                    colocarSillas(tablero, i + 1, sillasColocadas + 1);

                    // Backtrack: quitar silla
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("E ");
                } else if (tablero[i][j] == 2) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDisenoInteriores();
    }
}
