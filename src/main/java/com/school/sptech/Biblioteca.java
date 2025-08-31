package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    // Caso necessário
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Biblioteca (String nome, Double multaDiaria){
        qtdLivros = 0;
        ativa = true;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade > 0 && quantidade != null && ativa == true){
            qtdLivros++;
        } else {
            System.out.println("Não é possível registrar livros.");
        }
    }

    public Integer emprestar(Integer quantidade){
        if (ativa == true && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            System.out.println("Não é possível emprestar livros.");
            return null;
        }
    }

    public Integer devolver(Integer quantidade) {
        if (ativa == true && quantidade > 0 && quantidade != null) {
            qtdLivros += quantidade;
            return quantidade;
        } else {
            System.out.println("Não é possível devolver livros");
            return null;
        }
    }

    public Integer desativar() {
        if (ativa == false) {
            return null;
        } else {
            ativa = false;
            Integer qtdAnterior = qtdLivros;
            qtdLivros = 0;
            return qtdAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if (destino.ativa == true && ativa == true && quantidade <= qtdLivros) {
            qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual > 0 && percentual != null) {
            multaDiaria *= percentual;
            return true;
        } else {
            return false;
        }
    }

}
