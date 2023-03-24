package application;

import entities.Autor;
import entities.Biblioteca;
import entities.Livros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criando uma lista de autores
        List<Autor> autores = new ArrayList<>();
        // Criando uma lista de livros
        List<Livros> livros = new ArrayList<>();

        // Criando um autor e adicionando à lista de autores
        System.out.println("Cadastrando Autores");
        char opcao = 's';
        while (opcao == 's') {
            System.out.print("Nome: ");
            String nomeAutor = sc.next();
            System.out.println("Data de Nascimento");
            System.out.print("Ano: ");
            int anoAutor = sc.nextInt();
            System.out.print("Mes: ");
            int mesAutor = sc.nextInt();
            System.out.print("Dia: ");
            int diaAutor = sc.nextInt();
            LocalDate dataNascimento = LocalDate.of(anoAutor, mesAutor, diaAutor);
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Nascionalidade: ");
            String nacionalidade = sc.next();
            Autor.cadastrarAutor(autores, nomeAutor, dataNascimento, email, nacionalidade);
            System.out.println("\nDeseja continuar cadastrando autores ? Digite 's' para Sim");
            opcao = sc.next().toLowerCase().charAt(0);
        }

        // Criando um livro e adicionando à lista de livros
        System.out.println("Cadastrando Livros");
        opcao = 's';
        while (opcao == 's') {
            System.out.println("\nO livro tem Autor ? Digite 's' para Sim");
            char opcaoAutor = sc.next().toLowerCase().charAt(0);
            if (opcaoAutor == 's') {
                // Obtendo o autor da lista de autores criada anteriormente
                System.out.println("Qual nome do autor ?");
                String buscarAutor = sc.next();
                Autor autor = autores.stream().filter(a -> a.getNome().equals(buscarAutor)).findFirst().orElse(null);
                System.out.print("Titulo: ");
                String titulo = sc.next();
                System.out.println("Data de Lançamento");
                System.out.print("Ano: ");
                int anoLivro = sc.nextInt();
                System.out.print("Mes: ");
                int mesLivro = sc.nextInt();
                System.out.print("Dia: ");
                int diaLivro = sc.nextInt();
                LocalDate dataLancamento = LocalDate.of(anoLivro, mesLivro, diaLivro);
                System.out.print("Genero: ");
                String genero = sc.next();
                Livros.cadastrarLivro(livros, titulo, dataLancamento, autor, genero);
            } else {
                System.out.print("Titulo: ");
                String titulo = sc.next();
                System.out.println("Data de Lançamento");
                System.out.print("Ano: ");
                int anoLivro = sc.nextInt();
                System.out.print("Mes: ");
                int mesLivro = sc.nextInt();
                System.out.print("Dia: ");
                int diaLivro = sc.nextInt();
                LocalDate dataLancamento = LocalDate.of(anoLivro, mesLivro, diaLivro);
                System.out.print("Genero: ");
                String genero = sc.next();
                Livros.cadastrarLivroSemAutor(livros, titulo, dataLancamento, genero);
            }
            System.out.println("\nDeseja continuar cadastrando livros ? Digite 's' para Sim");
            opcao = sc.next().toLowerCase().charAt(0);
        }

        // Criando uma biblioteca com a lista de livros criada anteriormente
        Biblioteca biblioteca = new Biblioteca("Palmas", livros);

        // Imprimindo autor pelo atributo 'nome'
        System.out.println("\nQual autor deseja imprimir");
        String getAutor = sc.next();
        Autor autor = autores.stream().filter(a -> a.getNome().equals(getAutor)).findFirst().orElse(null);
        System.out.println(autor);

        // Imprimindo todos Autores
        System.out.println(autores.stream().map(Autor::toString).collect(Collectors.joining("\n")));

        // Imprimindo livro pelo atributo 'titulo'
        System.out.println("\nQual livro deseja imprimir");
        String buscarLivro = sc.next();
        Livros livro = livros.stream().filter(l -> l.getTitulo().equals(buscarLivro)).findFirst().orElse(null);
        System.out.println(livro);

        // Imprimindo todos livros
        System.out.println(livros.stream().map(Livros::toString).collect(Collectors.joining("\n")));

        //    Adicionando um novo livro à biblioteca
        System.out.println("\nDeseja adicionar um novo livro á biblioteca ? Digite 's' para Sim");
        opcao = sc.next().toLowerCase().charAt(0);
        while (opcao == 's') {
            System.out.println("\nO livro tem Autor ? Digite 's' para Sim");
            char opcaoAutor = sc.next().toLowerCase().charAt(0);
            if (opcaoAutor == 's') {
                System.out.println("Qual nome do autor ?");
                String buscarAutor = sc.next();
                autor = autores.stream().filter(a -> a.getNome().equals(buscarAutor)).findFirst().orElse(null);
                System.out.print("Titulo: ");
                String titulo = sc.next();
                System.out.println("Data de Lançamento");
                System.out.print("Ano: ");
                int anoLivro = sc.nextInt();
                System.out.print("Mes: ");
                int mesLivro = sc.nextInt();
                System.out.print("Dia: ");
                int diaLivro = sc.nextInt();
                LocalDate dataLancamento = LocalDate.of(anoLivro, mesLivro, diaLivro);
                System.out.print("Genero: ");
                String genero = sc.next();
                Biblioteca.cadastrarLivroNaBiblioteca(biblioteca, new Livros(titulo, dataLancamento, autor, genero));
            } else {
                System.out.print("Titulo: ");
                String titulo = sc.next();
                System.out.println("Data de Lançamento");
                System.out.print("Ano: ");
                int anoLivro = sc.nextInt();
                System.out.print("Mes: ");
                int mesLivro = sc.nextInt();
                System.out.print("Dia: ");
                int diaLivro = sc.nextInt();
                LocalDate dataLancamento = LocalDate.of(anoLivro, mesLivro, diaLivro);
                System.out.print("Genero: ");
                String genero = sc.next();
                Biblioteca.cadastrarLivroNaBiblioteca(biblioteca, new Livros(titulo, dataLancamento, genero));
            }
            System.out.println("Deseja continuar cadastrando livros na biblioteca ? Digite 's' para Sim");
            opcao = sc.next().toLowerCase().charAt(0);
        }

        // Imprimindo livro da biblioteca pelo atributo 'titulo'
        System.out.println("\nQual livro deseja imprimir");
        String buscarLivroBiblioteca = sc.next();
        Livros livrosBiblioteca = biblioteca.getLivros().stream().filter(l -> l.getTitulo().equals(buscarLivroBiblioteca)).findFirst().orElse(null);
        System.out.println(livrosBiblioteca);


        // Imprimindo todos livros da biblioteca
        System.out.println("\nLista de livros da biblioteca:");
        String listaLivros = biblioteca.getLivros().stream()
                .map(Livros::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(listaLivros);


        sc.close();
    }
}