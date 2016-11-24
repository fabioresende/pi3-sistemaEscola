    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top cor-menu">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath() %>/" style="color:silver">Sistema de Escola</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav item-menu">
            <li><a href="<%=request.getContextPath() %>/curso/listar" style="color:silver" class=""><span class="glyphicon glyphicon-education"></span> Curso</a></li>
            <li><a href="<%=request.getContextPath() %>/turma/cursos" style="color:silver"><span class="glyphicon glyphicon-th-large"></span> Turma</a></li>
            <li><a href="<%=request.getContextPath() %>/aluno/listar" style="color:silver"><span class="glyphicon glyphicon-user"></span> Aluno</a></li>
            <li><a href="<%=request.getContextPath() %>/curso/pesquisar" style="color:silver"><span class="glyphicon glyphicon-search"></span> Pesquisar Cursos</a></li>
            <li><a href="<%=request.getContextPath() %>/matricula/cursoListar" style="color:silver"><span class="glyphicon glyphicon-folder-open"></span> Matrícula</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
