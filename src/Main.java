import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void preencherMatrizes(String mapa[][], String mapaNavios[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapa[i][j] = "~";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapaNavios[i][j] = "O";
            }
        }
    }
    public static void criarMapa(String mapa[][]) {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < mapa.length; i++) {
            System.out.print(i);
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j]);
            }
            System.out.println();
        }
    }

    public static void criarNavios(String mapaNavios[][], int navios) {
        Random gerador = new Random();

        int coordenadaY = 0;
        int coordenadaX = 0;

        for (int i = 0; i < navios; i++) {
            coordenadaY = gerador.nextInt(8);
            coordenadaX = gerador.nextInt(8);

            if (mapaNavios[coordenadaY][coordenadaX] == "X") {
                i--;
                continue;
            }
            mapaNavios[coordenadaY][coordenadaX] = "X";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String mapa[][] = new String [8][8];
        String mapaNavios[][] = new String[8][8];
        int navios = 5, tentativas = 5;

        preencherMatrizes(mapa, mapaNavios);

        criarNavios(mapaNavios, navios);

        while (true) {
            try {
                if (tentativas == 0) {
                    break;
                }
                criarMapa(mapa);

                scan.useDelimiter("[\\s,]+");
                System.out.println("Digite a coordenada:");
                int coordenadaY = scan.nextInt();
                int coordenadaX = scan.nextInt();


                if (mapa[coordenadaY][coordenadaX] == "O" || mapa[coordenadaY][coordenadaX] == "X") {
                    System.out.println("A coordenada já foi jogada.");
                    continue;
                }
                else if (mapaNavios[coordenadaY][coordenadaX] == "X") {
                    mapa[coordenadaY][coordenadaX] = mapaNavios[coordenadaY][coordenadaX];
                    navios--;
                }
                else if (mapaNavios[coordenadaY][coordenadaX] == "O") {
                    mapa[coordenadaY][coordenadaX] = mapaNavios[coordenadaY][coordenadaX];
                }

                if (navios == 0) {
                    break;
                }
                tentativas--;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Digite uma coordenada válida.");
            } catch (InputMismatchException i) {
                System.out.println("Digite um número para as coordenadas.");
            }
        }

        if (navios == 0) {
            criarMapa(mapa);
            System.out.println("Você ganhou!");
        }
        else {
            criarMapa(mapa);
            System.out.println("Suas tentativas acabaram.");
        }

        scan.close();
    }
}