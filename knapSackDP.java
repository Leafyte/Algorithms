import java.util.Scanner;

public class knapSackDP {

    static final int MAX = 100;

    static int w[];
    static int p[];
    static int n;
    static int m;
    static int v[][];
    static int keep[][];

    public static void main(String args[]) {

        w = new int[MAX];
        p = new int[MAX];
        v = new int[MAX][MAX];
        keep = new int[MAX][MAX];
        int optsoln;
        ReadObjects();
        for (int i = 0; i <= m; i++)
            v[0][i] = 0;
        for (int i = 0; i <= m; i++)
            v[i][0] = 0;
        optsoln = knapsack();
        System.out.println("Optimal solution :" + optsoln);
    }

    static int knapsack() {
        int r;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if ((w[i] <= j) && (p[i] + v[i - 1][j - w[i]] > v[i - 1][j])) {
                    v[i][j] = p[i] + v[i - 1][j - w[i]];
                    keep[i][j] = 1;
                } else {
                    v[i][j] = v[i - 1][j];
                    keep[i][j] = 0;
                }
            }
        }

        r = m;
        System.out.print("Item = ");
        for (int i = n; i > 0; i--) {
            if (keep[i][r] == 1) {
                System.out.print(i + " ");
                r = r - w[i];
            }
        }

        System.out.println();
        return v[n][m];
    }

    static void ReadObjects() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Knapsack Problem - Dynamic Programming Solution:");
        System.out.println("Enter the max capacity of Knapsack:");
        m = scanner.nextInt();

        System.out.println("Enter number of objects:");
        n = scanner.nextInt();

        System.out.println("Enter weights:");
        for (int i = 1; i <= n; i++)
            w[i] = scanner.nextInt();

        System.out.println("Enter profits:");
        for (int i = 1; i <= n; i++)
            p[i] = scanner.nextInt();

        scanner.close();
    }
}