import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void criarMapa(int mapa[][]) {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println(i + " ~ ~ ~ ~ ~ ~ ~ ~");
        }
    }

    public static void criarNavios(int mapa[][]) {
        Random gerador = new Random();

        int coordenadaX = 0;
        int coordenadaY = 0;

        for (int i = 0; i < 10; i++) {
            coordenadaX = gerador.nextInt(8);
            coordenadaY = gerador.nextInt(8);

            if (mapa[coordenadaX][coordenadaY] == 1) {
                i--;
                continue;
            }
            mapa[coordenadaX][coordenadaY] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int mapa[][] = new int [8][8];

        criarMapa(mapa);
        criarNavios(mapa);
    }
}