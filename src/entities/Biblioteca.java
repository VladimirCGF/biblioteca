package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livros> livros;

    public Biblioteca(String nome, List<Livros> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public static void cadastrarLivroNaBiblioteca(Biblioteca biblioteca, Livros livro) {
        biblioteca.getLivros().add(livro);
    }
    @Override
    public String toString() {
        return "\nNome Biblioteca: " + nome +
                "\nLivros" + livros;

    }
}
