public class Main {
    public int promedio() {
        int[][] mat = new int[3][3];
        mat = new int[][]{{4, 5, 6}, {7, 8, 9}, {5, 6, 7}}; //1
        int prom = 0; // 1
        int cant = 0; // 1
        for (int i = 0; i < mat.length; i++) { // 1+2(n+1)+2n
            for (int j = 0; j < mat[i].length; j++) { // 1+3(n+1)+2n
                prom += mat[i][j]; // 4n
                cant++; //2n
            }
        }
        prom /= cant; //2
        return prom; //1
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.promedio());
    }
}
