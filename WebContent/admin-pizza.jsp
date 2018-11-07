<jsp:include page="common-header.jsp" />

<div class="container">
	<form>
		<h1>Cadastre novo sabor de pizza</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">nome da pizza</label> <input
				type="email" class="form-control" id="exampleFormControlInput1"
				placeholder="nome da pizza">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">preço</label> <input
				type="email" class="form-control" id="exampleFormControlInput1"
				placeholder="R$">
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</div>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">nome</th>
				<th scope="col">preço</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>queijo</td>
				<td>2,00</td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>tomate</td>
				<td>2,00</td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>4queijos</td>
				<td>2,00</td>
			</tr>
		</tbody>
	</table>
</div>

<jsp:include page="common-footer.jsp" />

