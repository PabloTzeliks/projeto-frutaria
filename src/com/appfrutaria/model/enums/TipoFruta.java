package com.appfrutaria.model.enums;

public enum TipoFruta implements TipoProdutoEspecifico {
    
    CITRICA("Cítrica", "Frutas ricas em vitamina C e ácido cítrico."),
    VERMELHA("Vermelha", "Frutas de coloração vermelha ou arroxeada, ricas em antioxidantes."),
    TROPICAL("Tropical", "Frutas originárias de regiões tropicais, geralmente suculentas e doces."),
    SECA("Seca", "Frutas com baixo teor de água, geralmente desidratadas ou naturalmente secas."),
    EXOTICA("Exótica", "Frutas incomuns em certas regiões, geralmente importadas ou raras.");

    private final String nome;
    private final String descricao;

    TipoFruta(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

    }

    @Override
    public String getDescricao() { return descricao; }

    @Override
    public String getNome() { return nome; }

}