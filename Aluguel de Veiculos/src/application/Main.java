package application;

import entities.enums.Vehicletype;
import entities.objects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Veiculo> listaDeVeiculos = new ArrayList<>();
        List<Pessoa> listaDeClientes = new ArrayList<>();

        Veiculo veiculo1 = new Veiculo("Carro A", "ABC123", Vehicletype.PEQUENO, 2020, true);
        Veiculo veiculo2 = new Veiculo("Carro B", "DEF456", Vehicletype.MEDIO, 2019, false);
        Veiculo veiculo3 = new Veiculo("Carro C", "GHI789", Vehicletype.SUV, 2021, true);

        PessoaFisica pessoa1 = new PessoaFisica("João Silva", "Rua A, 123", "(11) 1234-5678", "joao@email.com", "123.456.789-00");
        PessoaFisica pessoa2 = new PessoaFisica("Maria Santos", "Rua B, 456", "(22) 9876-5432", "maria@email.com", "987.654.321-00");
        PessoaFisica pessoa3 = new PessoaFisica("Carlos Pereira", "Rua C, 789", "(33) 5678-1234", "carlos@email.com", "345.678.901-00");
        listaDeClientes.add(pessoa1);
        listaDeClientes.add(pessoa2);
        listaDeClientes.add(pessoa3);

        listaDeVeiculos.add(veiculo1);
        listaDeVeiculos.add(veiculo2);
        listaDeVeiculos.add(veiculo3);

        boolean loop = true;
        while(loop) {
            System.out.println("Gerenciador de aluguel de veículos \n1 - Cadastrar veículo\n2 - Alterar veículo cadastro\n3 - Buscar veículo por parte do nome\n4 - Cadastrar cliente\n5 - Alterar cliente \n6 - Alugar veículo \n7 - Devolver veículo \n8 - Sair");
            int escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1 -> {
                    VeiculosMain.cadastrarVeiculo(listaDeVeiculos, sc);
                }
                case 2 -> {
                    VeiculosMain.alterarVeiculoCadastrado(listaDeVeiculos,sc);
                }
                case 3 -> {
                    VeiculosMain.buscarVeiculo(listaDeVeiculos, sc);
                }
                case 4 -> {
                   ClienteMain.cadastrarCliente(listaDeClientes, sc);
                }
                case 5 -> {
                    ClienteMain.alterarClienteCadastrado(listaDeClientes, sc);
                }
                case 6 -> {
                    ClienteMain.alugarVeiculoParaCliente(listaDeClientes,listaDeVeiculos,sc);
                }
                case 7 -> {
                    ClienteMain.clienteDevolverVeiculo(listaDeClientes,listaDeVeiculos,sc);
                }
                case 8 -> {
                    loop = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}