//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

import java.time.LocalDate

abstract class Professor(

    val nome: String,
    val sobrenome: String,
    val codProfessor: String,
    ) {
    init{
        val tempoCasa: LocalDate = LocalDate.now()

    }
    override fun equals(other: Any?): Boolean {
        return (other as? Professor)?.let {
            codProfessor == it.codProfessor
        } ?: false
    }

    override fun hashCode(): Int {
        return codProfessor.hashCode()
    }

    override fun toString(): String {
        return "O nome do professor é: $nome $sobrenome / Código: $codProfessor)"
    }



}