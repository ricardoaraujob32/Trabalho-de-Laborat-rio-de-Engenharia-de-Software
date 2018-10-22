package model;

import java.util.LinkedList;
import java.util.List;

public class Pizza extends ItemPedido {

	private static final long serialVersionUID = 1L;
	private int tamanho;
	private int qtdSabores;
	private boolean bordaRecheada;
	private LinkedList<Sabor> listaSabores;
	
	public static final int PEQUENA = 4;
	public static final int MEDIA = 6;
	public static final int GRANDE = 8;
	
	public static final int UM_SABOR = 1;
	public static final int DOIS_SABORES = 2;
	public static final int QUATRO_SABORES = 4;
	
	public Pizza() {
		listaSabores = new LinkedList<>();
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getQtdSabores() {
		return qtdSabores;
	}
	
	public void setQtdSabores(int qtdSabores) {
		this.qtdSabores = qtdSabores;
	}
	
	public boolean isBordaRecheada() {
		return bordaRecheada;
	}
	
	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	
	public List<Sabor> getSabores(){		
		return listaSabores;
	}

	public void setListaSabores(List<Sabor> l) {
		listaSabores = ( LinkedList<Sabor> ) l;
	}
}
