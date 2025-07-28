package com.appfrutaria.model;

import com.appfrutaria.model.enums.TipoLegume;

public class Legume extends Produto<TipoLegume> {
	
	public Legume(int id, String nome, double preco, int quantidade, double peso, TipoLegume tipo) {
		super(id, nome, preco, quantidade, peso, tipo);
	}
	
	// Mostrar dados de uma Fruta
	
	@Override
    protected void imprimir() {
        System.out.println(
            String.format(
                	"[Legume] %d\n"
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