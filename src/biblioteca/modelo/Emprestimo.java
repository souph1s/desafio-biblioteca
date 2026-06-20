package biblioteca.modelo;

import java.time.Instant;

public class Emprestimo {
    Long id;
    Livro livro;
    Cliente cliente;
    Instant dataEmprestimo;
    Instant dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        if (livro == null || cliente == null) {
            throw new IllegalArgumentException("Para realizar um empréstimo, é necessário um livro e um cliente.");
        }

        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = Instant.now();
        this.dataDevolucao = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instant getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Instant dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Instant getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
