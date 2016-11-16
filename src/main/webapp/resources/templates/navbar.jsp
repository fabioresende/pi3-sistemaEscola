    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath() %>/">Sistema de Escola</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath() %>/curso/listar">Cadastro de Cursos</a></li>
            <li><a href="<%=request.getContextPath() %>/turma/cursos">Cadastro de Turmas</a></li>
            <li><a href="<%=request.getContextPath() %>/aluno/listar">Cadastro de Alunos</a></li>
            <li><a href="<%=request.getContextPath() %>/curso/pesquisar">Pesquisar Cursos</a></li>
            <li><a href="<%=request.getContextPath() %>/matricula/cursoListar">Realizar Matrícula</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
