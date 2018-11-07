<jsp:include page="common-header.jsp" />
<div class="container">
	<form>
		<h1>Cadastre nova bebida</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">nome da bebida</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="nome da bebida">
		</div>
		<div class="form-group">
			<label for="exampleFormControlSelect1">Example select</label> <select
				class="form-control" id="exampleFormControlSelect1">
				<option>refri</option>
				<option>cerveja</option>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">preço</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
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
				<th scope="col">tipo</th>
				<th scope="col">preço</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>coca</td>
				<td>refri</td>
				<td>2,00</td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>coca</td>
				<td>refri</td>
				<td>2,00</td>
			</tr>
			<tr>
				<th scope="row">1</th>
				<td>coca</td>
				<td>refri</td>
				<td>2,00</td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="common-footer.jsp" />
