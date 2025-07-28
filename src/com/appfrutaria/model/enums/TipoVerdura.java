package com.appfrutaria.model.enums;

public enum TipoVerdura implements TipoProdutoEspecifico {

    FOLHAS("Folhas", "Verduras cujas partes comestíveis são as folhas da planta."),
    CAULE("Caule", "Verduras em que o caule ou talo é a principal parte consumida."),
    FLORES("Flores", "Verduras em que comemos as flores ou inflorescências da planta.");

    private final String nome;
    private final String descricao;

    TipoVerdura(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

    }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public String getNome() { return nome; }
    
}
