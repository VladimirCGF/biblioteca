package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Autor {

    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String nacionalidade;

    public Autor(String nome, LocalDate dataNascimento, String email, String pais) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nacionalidade = pais;
    }
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public static void cadastrarAutor(List<Autor> autores, String nome, LocalDate dataNascimento, String email, String nacionalidade) {
        Autor autor = new Autor(nome, dataNascimento, email, nacionalidade);
        autores.add(autor);
    }
    @Override
    public String toString() {
        return "\nNome: " + nome +
                " \nData de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " \nEmail: " + email +
                " \nNacionalidade: " + nacionalidade;
    }
}
