<jsp:include page="common-header.jsp" />
<div class="container">
    <!-- Start form -->
    <form action="./Authenticator" method="post">
        <div class="form-group">
            <label for="EMAIL">EMAIL</label>
            <input name="email" type="text" class="form-control" id="EMAIL" aria-describedby="EMAIL" placeholder="EMAIL">
        </div>
        <div class="form-group">
            <label for="Login">Login</label>
            <input name="Login" type="text" class="form-control" name="Login" id="Login" placeholder="Login">
        </div>
        <div class="form-group">
            <label for="Senha">Senha</label>
            <input name="Senha" type="password" class="form-control" name="Senha" id="Senha" placeholder="Senha">
        </div>
        <div class="form-group">
            <label for="Nome">Nome</label>
            <input name="Nome" type="Nome" class="form-control" name="Nome" id="Nome" placeholder="Nome">
        </div>
        <div class="form-group">
            <label for="Bairro">Bairro</label>
            <input name="Bairro" type="text" class="form-control" name="Bairro" id="Bairro" placeholder="Bairro">
        </div>
        <div class="form-group">
            <label for="Logradouro">Logradouro</label>
            <input name="Logradouro" type="text" class="form-control" name="Logradouro" id="Logradouro"
                placeholder="Logradouro">
        </div>
        <div class="form-group">
            <label for="Telefone">Telefone</label>
            <input name="Telefone" type="text" class="form-control" name="Telefone" id="Telefone" placeholder="Telefone">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Email</label>
            <input name="Email" type="text" class="form-control" name="Email" id="Email" placeholder="Email">
        </div>



        <div class="form-check">
            <button type="submit" class="btn btn-primary">Finaliza cadastro</button>
        </div>

    </form>



</div>
<jsp:include page="common-footer.jsp" />