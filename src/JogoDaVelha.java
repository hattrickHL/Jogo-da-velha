import java.util.Scanner;
public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;
        char jogadorAtual = 'X';
        boolean jogoAcabou = false;
        while (!jogoAcabou) {
            // Imprime o tabuleiro
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }
            // Pede ao jogador para fazer uma jogada
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada (linha coluna):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();
            // Verifica se a jogada é válida
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '\0') {
                System.out.println("Jogada inválida, tente novamente.");
                continue;
            }
            // Faz a jogada
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;
            // Verifica se o jogador atual ganhou
            if (tabuleiro[linha][0] == jogadorAtual && tabuleiro[linha][1] == jogadorAtual && tabuleiro[linha][2] == jogadorAtual
                    || tabuleiro[0][coluna] == jogadorAtual && tabuleiro[1][coluna] == jogadorAtual && tabuleiro[2][coluna] == jogadorAtual
                    || linha == coluna && tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual
                    || linha + coluna == 2 && tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " ganhou!");
                jogoAcabou = true;
            } else if (jogadas == 9) {
                System.out.println("O jogo terminou empatado!");
                jogoAcabou = true;
            }
            // Troca de jogador
            jogadorAtual = jogadorAtual == 'X' ? 'O' : 'X';
        }
        // Imprime o tabuleiro final
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}