//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

import java.time.LocalDate

class ProfessorAdjunto (
    nome: String,
    sobrenome: String,
    codProfessor: String,
    var qtdHorasMonitoria: Int
): Professor(nome, sobrenome, codProfessor){

    val tipo: String = "Adjunto"

    val tempoCasa: LocalDate = LocalDate.now()


    override fun toString(): String {
        return " - O nome do professor é: $nome $sobrenome / Código: $codProfessor / Tipo: $tipo / Tempo de casa $tempoCasa"
    }

}