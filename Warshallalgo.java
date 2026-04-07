import java.util.Scanner;

public class Warshallalgo {

    static final int max = 20;
    static int a[][];
    static int n;

    public static void main(String args[]) {

        a = new int[max][max];
        Scanner scanner = new Scanner(System.in);

        System.out.println("**** Warshall's Algorithm ****");

        ReadMatrix(scanner);

        long startTime = System.nanoTime();

        Warshall();

        long stopTime = System.nanoTime();

        PrintMatrix();

        long elapsedTime = stopTime - startTime;

        System.out.println("Time Complexity in ms for n = " + n + " is: "
                + (double) elapsedTime / 1000000);

        scanner.close();
    }

    static void ReadMatrix(Scanner scanner) {

        System.out.println("Enter the number of vertices:");
        n = scanner.nextInt();

        System.out.println("Enter the adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
    }

    static void Warshall() {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if (a[i][j] == 1 || (a[i][k] == 1 && a[k][j] == 1)) {
                        a[i][j] = 1;
                    }
                }
            }
        }
    }

    static void PrintMatrix() {

        System.out.println("The transitive closure matrix is:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}