package com.example.atv12;

public class Jogador {
    private int id;
    private String nome;
    private String dataNasc;
    private double altura;
    private double peso;
    private int timeCodigo;

    //Otavio Gabriel Ribeiro Scabio - RA 1110482223043

    public Jogador(int id, String nome, String dataNasc, double altura, double peso, int timeCodigo) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.altura = altura;
        this.peso = peso;
        this.timeCodigo = timeCodigo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDataNasc() { return dataNasc; }
    public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public int getTimeCodigo() { return timeCodigo; }
    public void setTimeCodigo(int timeCodigo) { this.timeCodigo = timeCodigo; }
}
