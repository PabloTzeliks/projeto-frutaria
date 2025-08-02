package com.appfrutaria.model;

import com.appfrutaria.model.enums.*;;

public abstract class Produto {
    
    protected int id;
	protected String nome;
	protected double preco;
	protected int quantidade;
    protected double peso;
    protected TipoProdutoEspecifico tipoEspecifico;

    protected Produto(int id, String nome, double preco, int quantidade, double peso, TipoProdutoEspecifico tipoEspecifico) {
        
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.peso = peso;
        this.tipoEspecifico = tipoEspecifico;
    
    }

    protected abstract void imprimir();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
    }

    public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public abstract TipoProduto getTipoProduto();

	public TipoProdutoEspecifico getTipoProdutoEspecifico() { return tipoEspecifico; }

    @Override
    public String toString() {
        // toString genérico
        return String.format(
            "ID: %d | %s | R$ %.2f | Qtde: %d | Peso: %.2fkg | Tipo: %s – %s",
            id,
            nome,
            preco,
            quantidade,
            peso,
            tipoEspecifico.getNome(),
            tipoEspecifico.getDescricao()
        );
    }

}
