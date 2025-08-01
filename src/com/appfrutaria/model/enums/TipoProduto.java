package com.appfrutaria.model.enums;

public enum TipoProduto {

    FRUTA(TipoFruta.CITRICA),
    VERDURA(TipoVerdura.FLORES),
    LEGUME(TipoLegume.FRUTOS);

    private final TipoProdutoEspecifico tipoProduto;

    TipoProduto(TipoProdutoEspecifico tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

//    public static void main(String[] args) {
//        TipoProduto.FRUTA.tipoProduto.mostrarTipos();
//    }
}
