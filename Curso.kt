//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

class Curso (

    val nome: String,
    val codigo: String,
    val qtdMaxAlunos: Int,

    ) {

    val alunosMatriculados: MutableMap<String, Aluno> = mutableMapOf()
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    override fun equals(other: Any?): Boolean {
        return (other as? Curso)?.let {
            codigo == it.codigo
        } ?: false
    }

    override fun hashCode(): Int {
        return codigo.hashCode()
    }

    override fun toString(): String {
        return "O nome do curso é: $nome / Código: $codigo)"
    }

    fun adicionarAluno(aluno: Aluno, id: String): Boolean {
        return (aluno as? Aluno)?.let {
            if(!alunosMatriculados.containsKey(id)){
                alunosMatriculados.put(id, aluno)
                true
            } else {
                println("Desculpe, não há vagas disponíveis!")
                false
            }
        } ?: run {
            println("Não foi possível adicionar o aluno.")
            false
        }
    }

    fun excluirAluno(aluno: Aluno, id: Int): Boolean {
        return (aluno as? Aluno)?.let {
            if(alunosMatriculados.containsKey(id)){
                alunosMatriculados.remove(id)
                true
            } else {
                println("Desculpe, este aluno não pertence a esta turma. Impossível remover")
                false
            }
        } ?: run {
            println("Não foi possível remover o aluno.")
            false
        }
    }

    fun alocarProfessores(Titular: Professor?, Adjunto: Professor?){
        (Titular as? ProfessorTitular)?.let { titular ->
            (Adjunto as? ProfessorAdjunto)?.let { adjunto ->
                this.professorTitular = titular
                this.professorAdjunto = adjunto
                println("Professores alocados com sucesso no curso $this.")
            } ?: println("Errp ao alocar: professor adjunto inválido")
        } ?: println("Erro ao alocar: professor titular inválido")
    }

    fun desalocarProfessor(professor: Professor?) {
        when {
            professor is ProfessorTitular && this.professorTitular == professor -> {
                this.professorTitular = null
                println("Professor(a) titular $professor desalocado(a) com sucesso no curso $this.")
            }
            professor is ProfessorAdjunto && this.professorAdjunto == professor -> {
                this.professorAdjunto = null
                println("Professor(a) adjunto $professor desalocado(a) com sucesso no curso $this.")
            }
            else -> {
                println("Erro ao desalocar: professor inválido.")
            }
        }
    }



}

