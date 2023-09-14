package entities.objects;

import java.time.LocalDateTime;
import java.util.Date;

public class Aluguel {
    private Veiculo veiculo;
    private LocalDateTime alugado;
    private LocalDateTime devolucao;
    private String localAluguel;
    private String localDevolucao;

    public Aluguel(Veiculo veiculo, LocalDateTime alugado, LocalDateTime devolucao, String localAluguel, String localDevolucao) {
        this.veiculo = veiculo;
        this.alugado = alugado;
        this.devolucao = devolucao;
        this.localAluguel = localAluguel;
        this.localDevolucao = localDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getAlugado() {
        return alugado;
    }

    public void setAlugado(LocalDateTime alugado) {
        this.alugado = alugado;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDateTime devolucao) {
        this.devolucao = devolucao;
    }

    public String getLocalAluguel() {
        return localAluguel;
    }

    public void setLocalAluguel(String localAluguel) {
        this.localAluguel = localAluguel;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

}
