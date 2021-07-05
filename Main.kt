//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

// Classe para execução do código e para criação dos objetos

fun main() {

    val dhm = DigitalHouseManager()

     // Registrar Professores

    dhm.registrarProfessorTitular("Cesar","Rodrigues", "DevAdroid", "0", "0")
    dhm.registrarProfessorAdjunto("Eduardo", "Missina", "1", 100, "1")
    dhm.listarProfessores()

    // Registrar Curso

    dhm.registrarCurso("Curso Mobile Android", "CMA00", 20, "CMA00")

    //Alocar Professores

    dhm.alocarProfessores("0", "1", "CMA00")

    //Erro ao alocar Professores

    dhm.alocarProfessores("0", "1", "0")

    //Listar Cursos

    dhm.listarCursos()

    //Registrar Aluno

    dhm.registrarAluno("Lucas", "Esteves", "001", "001")

    //Matricular Aluno

    dhm.matricularAluno("001", "CMA00", "Matricula00")

    //ListarMatriculas

    dhm.listarMatriculas()

    //Erro ao cancelar matrícula

    dhm.cancelarMatricula("Matricula01")

    //Cancelar Matrícula

    dhm.cancelarMatricula("Matricula00")

    //Cancelar Aluno

    dhm.excluirAluno("001")

   //Desalocar Professor

    dhm.desalocarProfessor("1", "CMA00")














}