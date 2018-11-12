
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
				<th scope="col">nome do cliente</th>
				<th scope="col">descrição</th>
				<th scope="col">endereço</th>
					<th scope="col">finalizar</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Maria</td>
				<td>duas pizza e uma coca</td>
				<td>Aguia de Haia, 2000</td>
				<td><a class="btn btn-primary" href="./admin-pedido" role="button">finalizar</a></td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>Maria</td>
				<td>duas pizza e uma coca</td>
				<td>Aguia de Haia, 2000</td>
				<td><a class="btn btn-primary" href="./admin-pedido" role="button">finalizar</a></td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>Maria</td>
				<td>duas pizza e uma coca</td>
				<td>Aguia de Haia, 2000</td>
				<td><a class="btn btn-primary" href="./admin-pedido" role="button">finalizar</a></td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>Maria</td>
				<td>duas pizza e uma coca</td>
				<td>Aguia de Haia, 2000</td>
				<td><a class="btn btn-primary" href="./admin-pedido" role="button">finalizar</a></td>
			</tr>
		</tbody>
	</table>
</div>

<jsp:include page="common-footer.jsp" />
