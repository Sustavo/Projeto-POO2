package application;

import entities.objects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ClienteMain {
    public static  void cadastrarCliente(List<Pessoa> listaDeClientes, Scanner sc) {
        System.out.println("Cadastro de Cliente:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        int tipoCliente = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Endereço: ");
        String enderecoClinte = sc.nextLine();
        System.out.print("Telefone: ");
        String telefoneCliente = sc.nextLine();
        System.out.print("Email: ");
        String emailCliente = sc.nextLine();
        switch (tipoCliente) {
            case 1:
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                PessoaFisica clientePF = new PessoaFisica(nomeCliente, enderecoClinte, telefoneCliente, emailCliente, cpf);
                listaDeClientes.add(clientePF);
                System.out.println("Cliente Pessoa Física cadastrado com sucesso!");
                break;

            case 2:
                System.out.print("CNPJ: ");
                String cnpj = sc.nextLine();
                System.out.println("De que é sua empresa ?: ");
                String empresaTipo = sc.nextLine();
                PessoaJuridica clientePJ = new PessoaJuridica(nomeCliente, enderecoClinte, telefoneCliente, emailCliente, cnpj, empresaTipo);
                listaDeClientes.add(clientePJ);
                System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public static  void alterarClienteCadastrado(List<Pessoa> listaDeClientes, Scanner sc) {
        System.out.println("Alteração de Cliente:");
        System.out.print("Informe o nome do cliente que deseja alterar: ");
        String nomeClienteParaAlterar = sc.nextLine();
        Pessoa alterarCliente = null;
        for (Pessoa cliente : listaDeClientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeClienteParaAlterar)) {
                alterarCliente = cliente;
                break;
            }
        }
        if (alterarCliente != null) {
            System.out.println("Selecione o que deseja alterar:");
            System.out.println("1 - Nome");
            System.out.println("2 - Endereço");
            System.out.println("3 - Telefone");
            System.out.println("4 - Email");

            int opcaoAlteracao = sc.nextInt();
            sc.nextLine();

            switch (opcaoAlteracao) {
                case 1:
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    alterarCliente.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso!");
                    break;

                case 2:
                    System.out.print("Novo endereço: ");
                    String novoEndereco = sc.nextLine();
                    alterarCliente.setEndereco(novoEndereco);
                    System.out.println("Endereço alterado com sucesso!");
                    break;

                case 3:
                    System.out.print("Novo telefone: ");
                    String novoTelefone = sc.nextLine();
                    alterarCliente.setTelefone(novoTelefone);
                    System.out.println("Telefone alterado com sucesso!");
                    break;

                case 4:
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();
                    alterarCliente.setEmail(novoEmail);
                    System.out.println("Email alterado com sucesso!");
                    break;


                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void alugarVeiculoParaCliente(List<Pessoa> listaDeClientes, List<Veiculo> listaDeVeiculos, Scanner sc){
        System.out.println("Aluguel de Veículo");
        System.out.print("Informe o CPF ou CNPJ do cliente: ");
        String cpfCnpjAluguel = sc.nextLine();
        Pessoa clienteAluguel = null;
        for (Pessoa cliente : listaDeClientes) {
            if (cliente instanceof PessoaFisica && ((PessoaFisica) cliente).getCPF().equals(cpfCnpjAluguel)) {
                clienteAluguel = cliente;
                break;
            } else if (cliente instanceof PessoaJuridica && ((PessoaJuridica) cliente).getCNPJ().equals(cpfCnpjAluguel)) {
                clienteAluguel = cliente;
                break;
            }
        }
        if (clienteAluguel != null) {
            System.out.print("Informe a placa do veículo que deseja alugar: ");
            String placaAluguel = sc.nextLine();

            Veiculo veiculoAluguel = null;
            for (Veiculo veiculo : listaDeVeiculos) {
                if (veiculo.getPlaca().equalsIgnoreCase(placaAluguel) && veiculo.isDisponivel()) {
                    veiculoAluguel = veiculo;
                    break;
                }
            }

            System.out.print("Quando o veículo será alugado (dd/MM/yyyy HH:mm): ");
            String alugarUsuario = sc.nextLine();
            System.out.print("Quando o veículo será devolvido (dd/MM/yyyy HH:mm): ");
            String devolverUsuario = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHoraAluguel = null;
            LocalDateTime dataHoraDevolucao = null;
            try {
                dataHoraAluguel = LocalDateTime.parse(alugarUsuario, formatter);
                dataHoraDevolucao = LocalDateTime.parse(devolverUsuario, formatter);
            } catch (Exception e) {
                System.err.println("Formato de data e hora inválido. Use o formato dd/MM/yyyy HH:mm.");
            }

            System.out.print("Onde será feito o aluguel ?: ");
            String localAluguelUsuario = sc.nextLine();
            System.out.print("Onde será feita a devolução ?: ");
            String localDevolucaoUsuario = sc.nextLine();

            if (veiculoAluguel != null) {
                if (clienteAluguel instanceof PessoaFisica) {
                    PessoaFisica clientePF = (PessoaFisica) clienteAluguel;
                    clientePF.alugarVeiculo(new Aluguel(veiculoAluguel,
                            dataHoraAluguel,
                            dataHoraDevolucao,
                            localAluguelUsuario,
                            localDevolucaoUsuario));
                    veiculoAluguel.setDisponivel(false);
                    System.out.println("Veículo alugado com sucesso para " + clientePF.getNome() + " (CPF: " + clientePF.getCPF() + ")");
                } else if (clienteAluguel instanceof PessoaJuridica) {
                    PessoaJuridica clientePJ = (PessoaJuridica) clienteAluguel;
                    clientePJ.alugarVeiculo(new Aluguel(veiculoAluguel,
                            dataHoraAluguel,
                            dataHoraDevolucao,
                            localAluguelUsuario,
                            localDevolucaoUsuario));
                    veiculoAluguel.setDisponivel(false);
                    System.out.println("Veículo alugado com sucesso para " + clientePJ.getNome() + " (CNPJ: " + clientePJ.getCNPJ() + ")");
                }
            } else {
                System.out.println("Veículo não encontrado ou não está disponível para aluguel.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void clienteDevolverVeiculo(List<Pessoa> listaDeClientes, List<Veiculo> listaDeVeiculos, Scanner sc) {
        System.out.println("Devolução de Veículo");
        System.out.print("Informe o CPF ou CNPJ do cliente: ");
        String cpfCnpjDevolucao = sc.nextLine();
        Pessoa clienteDevolucao = null;
        for (Pessoa cliente : listaDeClientes) {
            if (cliente instanceof PessoaFisica && ((PessoaFisica) cliente).getCPF().equals(cpfCnpjDevolucao)) {
                clienteDevolucao = cliente;
                break;
            } else if (cliente instanceof PessoaJuridica && ((PessoaJuridica) cliente).getCNPJ().equals(cpfCnpjDevolucao)) {
                clienteDevolucao = cliente;
                break;
            }
        }
        if (clienteDevolucao != null) {
            System.out.print("Informe a placa do veículo que deseja devolver: ");
            String placaDevolucao = sc.nextLine();

            Veiculo veiculoDevolucao = null;
            for (Veiculo veiculo : listaDeVeiculos) {
                if (veiculo.getPlaca().equalsIgnoreCase(placaDevolucao) && !veiculo.isDisponivel()) {
                    veiculoDevolucao = veiculo;
                    break;
                }
            }

            if (veiculoDevolucao != null) {
                if (clienteDevolucao instanceof PessoaFisica) {
                    PessoaFisica clientePF = (PessoaFisica) clienteDevolucao;
                    clientePF.devolverVeiculo(veiculoDevolucao);
                    veiculoDevolucao.setDisponivel(true);
                    System.out.println("Veículo devolvido com sucesso por " + clientePF.getNome() + " (CPF: " + clientePF.getCPF() + ")");
                } else if (clienteDevolucao instanceof PessoaJuridica) {
                    PessoaJuridica clientePJ = (PessoaJuridica) clienteDevolucao;
                    clientePJ.devolverVeiculo(veiculoDevolucao);
                    veiculoDevolucao.setDisponivel(true);
                    System.out.println("Veículo devolvido com sucesso por " + clientePJ.getNome() + " (CNPJ: " + clientePJ.getCNPJ() + ")");
                }
            } else {
                System.out.println("Veículo não encontrado ou não está em processo de aluguel.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
