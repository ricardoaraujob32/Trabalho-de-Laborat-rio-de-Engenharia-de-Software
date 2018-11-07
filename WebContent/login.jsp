<jsp:include page="common-header.jsp" />

<div class="container">
	<div class="row">
		<h2>
			<strong>FAÇA O LOGIN PARA PEDIR SUA PIZZA</strong><br />
		</h2>
		<br />
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">	
			<!-- Start form -->
			<form action="./Authenticator" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">EMAIL</label> <input name="TXTUSER"
						type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="SEU EMAIL">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">SENHA</label> <input
						name="TXTPASS" type="password" class="form-control"
						name="password" id="password" placeholder="SENHA">
				</div>
				<div class="form-check">
					<button type="submit" class="btn btn-primary">login</button>
				</div>

			</form>


			<!-- End form -->
		</div>



	</div>
</div>

<jsp:include page="common-footer.jsp" />

