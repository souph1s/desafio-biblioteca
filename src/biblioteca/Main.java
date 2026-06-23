package biblioteca;

import biblioteca.modelo.Livro;
import biblioteca.servico.Biblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.inicializarDados();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (S/N)");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Tchau!");
                return;
            } else if (resposta.equalsIgnoreCase("S")) {
                List<Livro>  livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                for (Livro livro : livrosDisponiveis) {
                    System.out.println("[" + livro.getId() + "] " + livro.getTitulo() + " - " + livro.getAutor().getNome());
                }

                System.out.println("Qual o ID do livro que você deseja?");
                Long livroId = Long.parseLong(sc.nextLine());

                System.out.println("Qual o ID do cliente?");
                Long clienteId = Long.parseLong(sc.nextLine());

                try {
                    biblioteca.realizarEmprestimo(livroId, clienteId);
                    System.out.println("Empréstimo realizado com sucesso, até a próxima!");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
