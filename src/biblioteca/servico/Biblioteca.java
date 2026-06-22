package biblioteca.servico;

import biblioteca.modelo.Autor;
import biblioteca.modelo.Cliente;
import biblioteca.modelo.Emprestimo;
import biblioteca.modelo.Livro;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

   private long proximoIdAutor = 1;
   private long proximoIdLivro = 1;
   private long proximoIdCliente = 1;
   private long proximoIdEmprestimo = 1;

    public Autor cadastrarAutor(String nome, Instant dataDeNascimento) {
        Autor autor = new Autor(nome, dataDeNascimento);
        autor.setId(proximoIdAutor);
        autores.add(autor);          // adiciona na lista certa
        proximoIdAutor++;        // incrementa o contador
        return autor;
    }

    public Cliente cadastrarCliente(String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        cliente.setId(proximoIdCliente);
        clientes.add(cliente);
        proximoIdCliente++;
        return cliente;
    }

    public Livro cadastrarLivro(String titulo, Long autorId) {
        Autor autor = buscarAutorPorId(autorId);
        Livro livro = new Livro(titulo, autor);
        livro.setId(proximoIdLivro);
        livros.add(livro);
        proximoIdLivro++;
        return livro;
    }

    private Autor buscarAutorPorId(Long id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                return autor;
            }
        }
        return null;
    }

    private Livro buscarLivroPorId(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    private Cliente buscarClientePorId(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public Emprestimo realizarEmprestimo(Long livroId, Long clienteId) {
        Livro livro = buscarLivroPorId(livroId);

        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado.");
        }
        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("Livro não disponível para empréstimo.");
        }

        Cliente cliente = buscarClientePorId(clienteId);

        Emprestimo emprestimo = new Emprestimo(livro, cliente);

        livro.setDisponivel(false);
        emprestimo.setId(proximoIdEmprestimo);
        emprestimos.add(emprestimo);
        proximoIdEmprestimo++;

        return emprestimo;
    }
}
