package com.appfrutaria.model.enums;

public enum TipoLegume implements TipoProdutoEspecifico {
    
    FRUTOS("Frutos", "Legumes que se desenvolvem a partir do ovário da flor e contêm sementes."),
    SEMENTES("Sementes", "Leguminosas consumidas principalmente pelas suas sementes nutritivas."),
    RAIZES("Raízes", "Legumes que são partes subterrâneas da planta, responsáveis pela absorção de nutrientes.");

    private final String nome;
    private final String descricao;

    TipoLegume(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

    }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public String getNome() { return nome; }

}
