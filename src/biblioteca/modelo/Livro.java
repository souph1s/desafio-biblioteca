package biblioteca.modelo;

import java.time.Instant;

public class Livro {
    Long id;
    String titulo;
    Autor autor;
    boolean disponivel;
    Instant dataCadastro;
    Instant dataAtualizacao;

    public Livro(String titulo, Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("Um autor deve ser associado ao livro.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = Instant.now();
        this.dataAtualizacao = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}
