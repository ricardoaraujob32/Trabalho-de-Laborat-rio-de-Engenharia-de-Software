<jsp:include page="common-header.jsp" />

<style>
* {
	color: white;
}

.plus, .minus {
	border-radius: 20px;
	height: 35px;
	width: 35px;
	background-color: gray;
	text-align: center;
}

.card {
	min-width: 250px;
	max-width: 300px;
	border-radius: 5px;
	background-color: #40030f;
	padding: 15px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 40%;
	margin: 10px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}

.container h4, p {
	text-align: center;
}

.menu-pizza {
	display: flex;
	justify-content: space-between;
}
</style>

<script>
	$(document).ready(function() {
		$(".card").on("click", function() {
		
			console.log($(this).attr("id"))
			$(".submit").val($(this).attr("id"));
			$(".form").submit();
			
		})
	
	});
</script>
<form class="form" action="./Pizza" method="POST">
  <input type="hidden" class="submit"name="pizza" value="">
</form> 

<div class="container">
	<div class="row">
		<div class="card" id="1">
			<img src="https://www.freeiconspng.com/uploads/pizza-png-13.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>TOMATE COM QUEIJO MINAS E AZEITONA</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>
		<div class="card" id="1">
			<img src="https://www.freeiconspng.com/uploads/pizza-png-13.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>TOMATE COM QUEIJO MINAS E AZEITONA</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>
		<div class="card" id="1">
			<img src="https://www.freeiconspng.com/uploads/pizza-png-13.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>TOMATE COM QUEIJO MINAS E AZEITONA</b>
				</h4>
				<p>R$: 30,00</p>

			</div>
		</div>
		<div class="card" id="1">
			<img src="https://www.freeiconspng.com/uploads/pizza-png-13.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>TOMATE COM QUEIJO MINAS E AZEITONA</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>


	</div>
</div>

<jsp:include page="common-footer.jsp" />

