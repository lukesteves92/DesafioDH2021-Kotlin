//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

import java.time.LocalDate

class Matricula (
    val aluno: Aluno,
    val curso: Curso
) {
    init {
    }

    var dataMatricula: LocalDate = LocalDate.now()


    override fun toString(): String {
        return "$aluno $curso"
    }
}


