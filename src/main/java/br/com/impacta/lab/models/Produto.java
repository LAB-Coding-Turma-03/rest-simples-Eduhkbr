package br.com.impacta.lab.models;

public class Produto {

//    Criar uma classe Produto Com os atributos
//
//    codigo do tipo int descricao do tipo Sring valor do tipo double

    private int codigo;
    private String descricao;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
