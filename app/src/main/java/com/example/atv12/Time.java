package com.example.atv12;

//Otavio Gabriel Ribeiro Scabio - RA 1110482223043

public class Time {
    private int codigo;
    private String nome;
    private String cidade;

    public Time(int codigo, String nome, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return "Time: " + nome + " - Cidade: " + cidade;
    }


}
