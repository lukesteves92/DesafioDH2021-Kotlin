//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021


class DigitalHouseManager {

    private val cursos: MutableMap<String, Curso> = mutableMapOf()
    private val professores: MutableMap<String, Professor> = mutableMapOf()
    private val alunos: MutableMap<String, Aluno> = mutableMapOf()
    private val matriculas: MutableMap<String, Matricula> = mutableMapOf()

    init {
        println("Digital House Manager iniciado")
    }


    fun listarProfessores() {

        var mostrarProfessores = StringBuilder()
        professores.forEach {
            println("${it.key} ${it.value}")
        }
        mostrarProfessores.appendLine()
    }

    fun listarCursos() {

        var mostrarCursos = StringBuilder()
        cursos.forEach {
            println("${it.key} ${it.value}")
        }
        mostrarCursos.appendLine()
    }

    fun listarMatriculas() {

        var mostrarMatriculas = StringBuilder()
        matriculas.forEach {
            println("${it.key} ${it.value.aluno} ${it.value.curso}")
        }
        mostrarMatriculas.appendLine()
    }

    fun alocarProfessores(codTitular: String, codAdjunto: String, codCurso: String) {

        when {
            !cursos.containsKey(codCurso) -> println("Erro ao alocar: não há curso registrado com o código $codCurso")
            !professores.containsKey(codTitular) -> println("Erro ao alocar: não há prodessor com o código $codTitular")
            !professores.containsKey(codAdjunto) -> println("Erro ao alocar: não há professor com o código $codAdjunto")

            else -> {
                cursos[codCurso]?.alocarProfessores(professores[codTitular], professores[codAdjunto])
                        ?: println("Erro ao alocar: curso inválido")
            }

        }

    }

    fun registrarCurso(nome: String, codigo: String, qtdMaxAlunos: Int, id: String): Boolean {
        return if (!cursos.containsKey(id)) {
            val curso = Curso(nome, codigo, qtdMaxAlunos)
            cursos.put(id, curso)
            println("Curso registrado com sucesso")
            true
        } else {
            println("Erro ao registrar! Curso já registrado")
            false
        }

    }

    fun excluirCurso(id: String): Boolean {
        return if (!cursos.containsKey(id)) {
            cursos.remove(id)
            println("Curso removido com sucesso")
            true
        } else {
            println("Erro ao remover o curso, o ID $id não existe")
            false
        }

    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigo: String, qtdHorasMonitoria: Int, id: String): Boolean {
        return if (!professores.containsKey(id)) {
            val profAdjunto = ProfessorAdjunto(nome, sobrenome, codigo, qtdHorasMonitoria)
            professores.put(id, profAdjunto)
            println("Professor Adjunto registrado com sucesso. ")
            true
        } else {
            println("ERRO! Já existe um professor registrado com o ID $id ")
            false
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, especialidade: String, codigo: String, id: String): Boolean {
        return if (!professores.containsKey(id)) {
            val profTitular = ProfessorTitular(nome, sobrenome, codigo, especialidade)
            professores.put(id, profTitular)
            println("Professor Titular registrado com sucesso.")
            true
        } else {
            println("ERRO! Já existe um professor registrado com o código '$codigo'.")
            false
        }
    }

    fun excluirProfessor(id: String): Boolean {
        return if (professores.containsKey(id)) {
            professores.remove(id)
            println("Professor removido com sucesso!")
            true
        } else {
            println("Professor com o ID: $id, não existe")
            false
        }

    }

    fun registrarAluno(nome: String, sobrenome: String, codigo: String, id: String): Boolean {
        return if (!alunos.containsKey(id)) {
            val aluno = Aluno(nome, sobrenome, codigo)
            alunos.put(id, aluno)
            println("Aluno $nome registrado com sucesso.")
            true
        } else {
            println("Erro ao registrar: já existe um aluno com este ID $id")
            false
        }
    }


    fun excluirAluno(id: String): Boolean {
        return if (alunos.containsKey(id)) {
            alunos.remove(id)
            alunos.forEach {
                println("Aluno removido com sucesso. ${it.key} ${it.value}")
            }
            true
        } else {
            println("Aluno com o ID: $id, não existe")
            false
        }
    }




    fun matricularAluno(codAluno: String, codCurso: String, id: String) {
        when {
            !cursos.containsKey(codCurso) -> println("Erro! Não curso registrado com o código $codCurso")
            !alunos.containsKey(codAluno) -> println("Erro! Não há aluno registrado com o código $codAluno")

            else -> {
                cursos[codCurso]?.let { Curso ->
                    alunos[codAluno]?.let { Aluno ->
                        if (Curso.alunosMatriculados.size < Curso.qtdMaxAlunos) {
                            if (Curso.adicionarAluno(Aluno, id)) {
                                matriculas.put(id, Matricula(Aluno, Curso))
                                println("Aluno matriculado com sucesso")
                            }
                        } else {
                            println("Erro ao matricular: Não há vagas disponiveis")
                        }
                    } ?: println("Erro ao matricular:aluno inválido!")
                } ?: println("Erro ao matricular: curso inválido!")
            }
        }
    }

    fun cancelarMatricula(id: String) {
        if (matriculas.containsKey(id)){
            matriculas.remove(id)
            matriculas.forEach {
                println("Matricula cancelada com sucesso. ID: $id / ${it.value}")
            }
        }else{
            println("Não foi possível realizar o cancelamento da matricula")
        }


    }

    fun desalocarProfessor(codProfessor: String, codCurso: String) {
        when {
            !cursos.containsKey(codCurso) -> println("Erro ao desalocar: não há curso registrado com o código '$codCurso'.")
            !professores.containsKey(codProfessor) -> println("Erro ao desalocar: não há professor(a) registrado(a) com o código '$codProfessor'.")
            else -> {
                cursos[codCurso]?.desalocarProfessor(professores[codProfessor]) ?: println("Erro ao desalocar: curso inválido.")
            }
        }
    }








}







