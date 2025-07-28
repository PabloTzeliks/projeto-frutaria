package com.appfrutaria.model;

import com.appfrutaria.model.enums.TipoFruta;

public class Fruta extends Produto<TipoFruta> {
	
	public Fruta(int id, String nome, double preco, int quantidade, double peso, TipoFruta tipo) {
		
		super(id, nome, preco, quantidade, peso, tipo);
		
	}

	
	
	// Mostrar dados de uma Fruta
	
	@Override
    protected void imprimir() {
        System.out.println(
            String.format(
                	"[Fruta] %d\n"
					+ "\nNome: %s" 
					+ "\nPreço: R$ %.2f" 
					+ "\nQuantidade: %d" 
					+ "\nPeso: %.2fkg"
					+ "\nTipo: %s (%s)\n",
                id,
                nome,
                preco,
                quantidade,
                peso,
                tipoEspecifico.getNome(),
                tipoEspecifico.getDescricao()
            )
        );
    }
}