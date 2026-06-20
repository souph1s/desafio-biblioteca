package biblioteca.modelo;

import java.time.Instant;

public class Autor {
    Long id;
    String nome;
    Instant dataDeNascimento;

    // CONSTRUTOR
    public Autor(String nome, Instant dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    // GETTER de id
    public Long getId() {
        return id;
    }

    // SETTER de id
    public void setId(Long id) {
        this.id = id;
    }

    // GETTER de nome
    public String getNome() {
        return nome;
    }

    // SETTER de nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // GETTER de data de nascimento
    public Instant getDataDeNascimento() {
        return dataDeNascimento;
    }

    // SETTER de data de nascimento
    public void setDataDeNascimento(Instant dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
