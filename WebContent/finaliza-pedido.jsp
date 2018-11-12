
<jsp:include page="common-header.jsp" />

<%@ page import="model.Sabor, java.util.List, java.util.ArrayList"%>

<%
	String msg = (String) session.getAttribute("MENSAGEM");
	List<Sabor> lista = (List<Sabor>) session.getAttribute("LISTA");
	if (lista == null) {
		lista = new ArrayList<Sabor>();
	} else {
		session.setAttribute("LISTA", null);
	}

	if (msg != null) {
		session.setAttribute("MENSAGEM", null);
%>
<h3 class="alert alert-danger"><%=msg%></h3>
<%
	}
%>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">item</th>
				<th scope="col">quantidade</th>
				<th scope="col">total</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>pizza</td>
				<td>2</td>
				<td>R$ 4:00</td>
				<td><a class="btn btn-primary" href="./admin-pedido"
					role="button">remover</a></td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>coca</td>
				<td>2</td>
				<td>R$ 4:00</td>
				<td><a class="btn btn-primary" href="./admin-pedido"
					role="button">remover</a></td>
			</tr>
			<tr>
			<tr>
				<th scope="row"></th>
				<td></td>
				<td></td>
				<td></td>
				<td>R$ 40,00</td>
			</tr>
		</tbody>
	</table>
	<button type="submit" class="btn btn-primary">fechar pedido</button>
</div>



<jsp:include page="common-footer.jsp" />
