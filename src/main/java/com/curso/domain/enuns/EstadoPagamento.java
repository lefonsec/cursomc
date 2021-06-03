package com.curso.domain.enuns;

public enum EstadoPagamento {

	PENDENTE(1, "pendente"), 
	QUIOTADO(2, "quitado"), 
	CANCELADO(3, "cancelado");

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnun(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Cod invalado " + cod);
	}

}