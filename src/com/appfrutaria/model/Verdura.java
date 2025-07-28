package com.appfrutaria.model;

import com.appfrutaria.model.enums.TipoVerdura;

public class Verdura extends Produto<TipoVerdura> {
	
	public Verdura(int id, String nome, double preco, int quantidade, double peso, TipoVerdura tipo) {
		super(id, nome, preco, quantidade, peso, tipo);
	}
	
	// Mostrar dados de uma Fruta
	
	@Override
    protected void imprimir() {
        System.out.println(
            String.format(
                	"[Verdura] %d\n"
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