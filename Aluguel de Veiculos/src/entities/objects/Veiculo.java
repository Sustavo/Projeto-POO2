package entities.objects;

import entities.enums.Vehicletype;

public class Veiculo {
    private String nome;
    private String placa;
    private Vehicletype tamanho;
    private int ano;
    private boolean disponivel;
    private double precoPorDia;

    public Veiculo(String nome, String placa, Vehicletype tamanho, int ano, boolean disponivel) {
        this.nome = nome;
        this.placa = placa;
        this.tamanho = tamanho;
        this.ano = ano;
        this.disponivel = disponivel;
        definirPreco();
    }

    public void definirPreco() {
        switch (tamanho) {
            case PEQUENO:
                this.precoPorDia = 100.0;
                break;
            case MEDIO:
                this.precoPorDia = 150.0;
                break;
            case SUV:
                this.precoPorDia = 200.0;
                break;
            default:
                this.precoPorDia = 0.0;
                break;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Vehicletype getTamanho() {
        return tamanho;
    }

    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public void alugado() {
        disponivel = false;
    }

}
