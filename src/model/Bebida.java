package model;

public class Bebida extends ItemPedido {

	private static final long serialVersionUID = 1L;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
