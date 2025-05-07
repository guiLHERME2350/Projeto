package model;

public class Ferramenta {
    private int id;
    private String nome;
    private String marca;
    private double precoCusto;

    public Ferramenta(int id, String nome, String marca, double precoCusto) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.precoCusto = precoCusto;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + marca + ") - R$" + precoCusto;
    }

    // Getters e Setters omitidos por brevidade
}
