package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	private long numeroPedido;
	private LocalTime hora;
	private LocalDate data;
	private int situacaoPedido;
	private long idCliente;
	private LinkedList<ItemPedido> listaItens;
	
	public static final int AGUARDANDO_PAGAMENTO = 1;
	
	public Pedido() {
		listaItens = new LinkedList<>();
	}
	
	public long getNumeroPedido() {
		return numeroPedido;
	}
	
	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public int getSituacaoPedido() {
		return situacaoPedido;
	}
	
	public void setSituacaoPedido(int situacaoPedido) {
		this.situacaoPedido = situacaoPedido;
	}
	
	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	public ItemPedido removeItem(ItemPedido p) {
		ListIterator<ItemPedido> iterator = listaItens.listIterator();
		
		while ( iterator.hasNext() ) {
			if ( iterator.next().equals(p) ) {
				listaItens.remove(p);
			}
		}
		
		return p;
	}
	
	public List<Pizza> getPizzas(){
		LinkedList<Pizza> lista = new LinkedList<>();		
		ListIterator<ItemPedido> iterator = listaItens.listIterator();
		ItemPedido item;
		
		while ( iterator.hasNext() ) {
			item = iterator.next();
			
			if ( item instanceof Pizza ) {
				lista.addLast( (Pizza) item);
			}
		}
		
		return lista;
	}
	
	public List<Bebida> getBebidas(){
		LinkedList<Bebida> lista = new LinkedList<>();		
		ListIterator<ItemPedido> iterator = listaItens.listIterator();
		ItemPedido item;
		
		while ( iterator.hasNext() ) {
			item = iterator.next();
			
			if ( item instanceof Bebida ) {
				lista.addLast( (Bebida) item);
			}
		}
		
		return lista;
	}

	public void setListaItens(List<ItemPedido> l) {
		listaItens = ( LinkedList<ItemPedido> ) l;
	}
}
