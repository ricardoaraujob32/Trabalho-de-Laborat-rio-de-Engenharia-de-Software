package model;

import java.io.Serializable;

public abstract class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private double valor;
	private String descricao;
	private long numeroPedido;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
}
