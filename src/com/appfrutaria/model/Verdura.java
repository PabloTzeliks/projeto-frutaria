package com.appfrutaria.model;

import com.appfrutaria.model.enums.TipoProduto;
import com.appfrutaria.model.enums.TipoProdutoEspecifico;
import com.appfrutaria.model.enums.TipoVerdura;

public class Verdura extends Produto {
	
	public Verdura(int id, String nome, double preco, int quantidade, double peso, TipoProdutoEspecifico tipo) {
		super(id, nome, preco, quantidade, peso, tipo);
	}

	@Override
	public TipoProduto getTipoProduto() {

		return TipoProduto.VERDURA;

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