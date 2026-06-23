package application;

import entities.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Livro livro[] = new Livro[5];
        int op;
        int qtd = 0;
        char op2;

        do{
            do{
                System.out.println("1 - Cadastrar livros");
                System.out.println("2 - Listar livros");
                System.out.println("3 - Emprestar livros");
                System.out.println("4 - Devolver livros");
                System.out.println("5 - Sair");

                System.out.print("\nSelecione a opção: ");
                op = sc.nextInt();
                sc.nextLine();
                if(op < 1 || op> 5){
                    System.out.println("\nOpção inválida!\n");
                }
            }while(op < 1 || op> 5);

            switch(op){
                case 1:
                    if(qtd < 5){
                        System.out.print("\nTítulo: ");
                        String titulo = sc.nextLine();

                        System.out.print("Autor: ");
                        String autor = sc.nextLine();

                        System.out.print("Ano de publicação: ");
                        int ano = sc.nextInt();

                        System.out.println("\nLivro cadastrado com sucesso!");
                        livro[qtd] = new Livro(titulo, autor, ano, true);
                        qtd++;
                        break;
                    }
                    else{
                        System.out.println("Estante cheia!");
                        break;
                    }

                case 2:
                    if(qtd == 0){
                        System.out.println("\nEstante vazia!\n");
                        break;
                    }
                    else{
                        for(int i = 0; i < qtd; i++){
                            System.out.printf("\n-- Livro %d --\n\n", i+1);

                            System.out.printf("Título: %s", livro[i].getTitulo());
                            System.out.printf("\nAutor: %s", livro[i].getAutor());
                            System.out.printf("\nAno: %d", livro[i].getAno());
                            if(livro[i].getDisponivel()){
                                System.out.println("\nStatus: Disponível");
                            }
                            else{
                                System.out.println("\nStatus: Indisponível");
                            }
                            System.out.println();
                        }
                        break;
                    }

                case 3:
                    System.out.println("Qual livro você deseja pegar emprestado (Digite o número do livro): ");
                    int n = sc.nextInt();
                    if(livro[n-1].getDisponivel()){
                        livro[n-1].emprestar();
                        System.out.println("\nLivro emprestado com sucesso.");
                        break;
                    }
                    else{
                        System.out.println("Livro indisponível!");
                        break;
                    }

                case 4:
                    System.out.println("Qual livro você deseja devolver (Digite o número do livro): ");
                    n = sc.nextInt();
                    livro[n-1].devolver();
                    System.out.println("\nLivro devolvido com sucesso.");
                    break;

                case 5:
                    System.out.println("\nObrigado por usar o programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Deseja retornar ao menu? (s/n) ");
            op2 = sc.next().charAt(0);
        }while(op2 != 'n');

        sc.close();
    }
}