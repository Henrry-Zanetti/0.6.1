import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class JogodaForca {
    public static void escolhePalavra(String[] palavra) {
        for (int i = 0; i < palavra.length; i++) {
            System.out.print(palavra[i]);
        }
    }
    public static String[] AleatoriaPalavra() {
        Random rn = new Random();
        String[] palavras = {"CAVEIRA", "ROXO", "MUSICA", "HISTORIA", "FANTASIA", "SOMBRIO", "CHURRASCO"};

        return palavras[rn.nextInt(palavras.length)].split("");
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] palavra1 = AleatoriaPalavra();
        String[] letras = new String[palavra1.length];

        int enforcou = 0;
        boolean acertouPalavra = false;
        int letrasFaltantes = palavra1.length;

        for (int x = 0; x < palavra1.length; x++) {
            letras[x] = "_";
        }
        System.out.println("Esta palavra tem " + palavra1.length + " Letras" + "\n");
        escolhePalavra(letras);
        do {
            System.out.print("\nEscolha uma letra: \n");
            String tentativa = teclado.next();
            boolean tentativaCorreta = false;
            for (int i = 0; i < palavra1.length; i++) {
                if (palavra1[i].equalsIgnoreCase(tentativa)) {
                    letras[i] = palavra1[i];
                    tentativaCorreta = true;
                    letrasFaltantes--;

                }
            }
            if (!tentativaCorreta){
                enforcou++;
                System.out.println(" Errou.");

            }
            escolhePalavra(letras);
        }
        while (enforcou < 6 && letrasFaltantes > 0);
        System.out.println(" Acertou!Parabens!");
        while (enforcou > 6 && letrasFaltantes >= 0);
        System.out.println(" Fim de Jogo");
    }
}