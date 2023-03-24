package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Livros {
    private String titulo;
    private LocalDate dataLancamento;
    private Autor autor;
    private String genero;

    public Livros() {

    }

    public Livros(String titulo, LocalDate dataLancamento, Autor autor, String genero) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.autor = autor;
        this.genero = genero;
    }

    public Livros(String titulo, LocalDate dataLancamento, String genero) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public static void cadastrarLivro(List<Livros> livros, String titulo, LocalDate dataLancamento, Autor autor, String genero) {
        Livros livro = new Livros(titulo, dataLancamento, autor, genero);
        livros.add(livro);
    }

    public static void cadastrarLivroSemAutor(List<Livros> livros, String titulo, LocalDate dataLancamento, String genero) {
        Livros livro = new Livros(titulo, dataLancamento, genero);
        livros.add(livro);
    }

    @Override
    public String toString() {
        if (autor != null) {
            return
                    "\nTitulo: " + titulo +
                            "\nData de Lançamento: " + dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                            "\nAutor: " + autor.getNome() +
                            "\nGenero: " + genero;
        } else {
            return
                    "\nTitulo: " + titulo +
                            "\nData de Lançamento: " + dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                            "\nGenero: " + genero;

        }
    }
}
