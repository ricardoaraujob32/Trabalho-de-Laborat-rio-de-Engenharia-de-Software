<jsp:include page="common-header.jsp" />

<style>
*{
color:white;
}
.plus, .minus {
border-radius: 20px;
height:35px;
width:35px;
background-color:gray;
	text-align:center;

}
.card {
	min-width: 250px;
    max-width: 300px;
    border-radius: 5px;
    background-color: #40030f;
	padding:15px;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 40%;
    margin: 10px;
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    padding: 2px 16px;
}
.container h4, p{
	text-align:center;
}
.menu-pizza{
	display:flex;
    justify-content: space-between;
	}
</style>

<div class="container">
	<div class="row">
		<div class="card">
			<img src="https://cdn.pixabay.com/photo/2016/07/24/16/39/beer-1538754_960_720.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>SKOL</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>
		<div class="card">
			<img src="https://cdn.pixabay.com/photo/2016/07/24/16/39/beer-1538754_960_720.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>SKOL</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>
		<div class="card">
			<img src="https://cdn.pixabay.com/photo/2016/07/24/16/39/beer-1538754_960_720.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>SKOL</b>
				</h4>
				<p>R$: 30,00</p>
				
			</div>
		</div>
		<div class="card">
			<img src="https://cdn.pixabay.com/photo/2016/07/24/16/39/beer-1538754_960_720.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>SKOL</b>
				</h4>
				<p>R$: 30,00</p>
			</div>
		</div>


	</div>
</div>

<jsp:include page="common-footer.jsp" />

