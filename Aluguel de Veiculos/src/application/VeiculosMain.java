package application;

import entities.enums.Vehicletype;
import entities.objects.Veiculo;

import java.util.List;
import java.util.Scanner;

public class VeiculosMain {
    public static void cadastrarVeiculo(List<Veiculo> listaDeVeiculos, Scanner sc) {
        System.out.println("Cadastro de Veículo");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Placa: ");
        String placa = sc.next();
        System.out.print("Tamanho (PEQUENO, MEDIO, SUV): ");
        String tamanho = sc.next();
        Vehicletype tipo = Vehicletype.valueOf(tamanho);
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Disponível (true/false): ");
        boolean disponivel = sc.nextBoolean();
        Veiculo novoVeiculo = new Veiculo(nome, placa, tipo, ano, disponivel);
        listaDeVeiculos.add(novoVeiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public static void alterarVeiculoCadastrado(List<Veiculo> listaDeVeiculos, Scanner sc) {
        System.out.println("Alteração de Placa de Veículo");
        System.out.print("Informe a placa atual do veículo: ");
        String placaAtual = sc.nextLine();
        Veiculo alterarVeiculo = null;
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placaAtual)) {
                alterarVeiculo = veiculo;
                break;
            }
        }
        if (alterarVeiculo != null) {
            System.out.print("Informe a nova placa: ");
            String novaPlaca = sc.nextLine();
            alterarVeiculo.setPlaca(novaPlaca);
            System.out.println("Placa alterada com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static void buscarVeiculo(List<Veiculo> listaDeVeiculos, Scanner sc) {
        System.out.println("Busca de Veículo por Parte do Nome");
        System.out.print("Informe a parte do nome do veículo: ");
        String parteDoNome = sc.nextLine();
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getNome().toLowerCase().contains(parteDoNome.toLowerCase())) {
                System.out.println("Nome: " + veiculo.getNome());
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Tamanho: " + veiculo.getTamanho());
                System.out.println("Ano: " + veiculo.getAno());
                System.out.println("Estado: " + (veiculo.isDisponivel() ? "Disponível" : "Indisponível"));
                System.out.println();
            }
        }
    }

}
