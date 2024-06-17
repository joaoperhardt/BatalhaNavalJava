import java.util.Scanner;
public class Main {
    public static void criarMapa() {
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < 8; i++) {
            System.out.println(i+1 + " ~ ~ ~ ~ ~ ~ ~ ~");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        criarMapa();
    }
}