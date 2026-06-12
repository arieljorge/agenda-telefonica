package com.github.arieljorge;

import com.github.arieljorge.model.Contato;
import com.github.arieljorge.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.Scanner;

public class AgendaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("""
            
            ===== AGENDA TELEFÔNICA =====
        
            1 - Adicionar contato
            2 - Remover contato
            3 - Buscar contato
            4 - Listar contatos
            5 - Atualizar contato
            6 - Sair
            
            """);

            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (opcao) {
                    case 1: {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        agenda.adicionarContato(
                                new Contato(nome, telefone, email)
                        );

                        System.out.println("Contato cadastrado!");
                        break;
                    }

                    case 2: {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        if (agenda.removerContato(nome)) {
                            System.out.println("Contato removido.");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }

                        break;
                    }

                    case 3: {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        Contato contato = agenda.buscarContato(nome);

                        if (contato != null) {
                            System.out.println(contato);
                        } else {
                            System.out.println("Contato não encontrado.");
                        }

                        break;
                    }

                    case 4: {
                        agenda.listarContatos().forEach(System.out::println);
                        break;
                    }

                    case 5: {
                        System.out.print("Nome do contato: ");
                        String nome = scanner.nextLine();

                        Contato contatoExistente = agenda.buscarContato(nome);

                        if (contatoExistente == null) {
                            System.out.println("Contato não encontrado.");
                            break;
                        }

                        System.out.print("Novo telefone: ");
                        String novoTelefone = scanner.nextLine();

                        System.out.print("Novo email: ");
                        String novoEmail = scanner.nextLine();

                        contatoExistente.setTelefone(
                                novoTelefone
                        );

                        contatoExistente.setEmail(
                                novoEmail
                        );

                        agenda.atualizarContato(
                                contatoExistente
                        );

                        System.out.println("Contato atualizado com sucesso.");

                        break;
                    }

                    case 6:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            } catch (SQLException e) {
                System.out.println(
                        "Erro ao acessar banco de dados: "
                                + e.getMessage()
                );
            }
        }

        scanner.close();
    }
}
