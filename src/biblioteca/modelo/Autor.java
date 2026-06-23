package biblioteca.modelo;

import java.time.Instant;

public class Autor {
    Long id;
    String nome;
    Instant dataDeNascimento;

    public Autor(String nome, Instant dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instant getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Instant dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
