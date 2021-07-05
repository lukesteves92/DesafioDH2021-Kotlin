//Dev: Lucas Esteves Albuquerque Coelho - Year: 2021

package DesafioKotlinDH2021

class Aluno (
    val nome: String,
    val sobrenome: String,
    val codigo: String
) {
    override fun equals(other: Any?): Boolean {
        return (other as? Aluno)?.let {
            codigo == it.codigo
        } ?: false
    }

    override fun hashCode(): Int {
        return codigo.hashCode()
    }

    override fun toString(): String {
        return "O nome do aluno é : $nome $sobrenome / Código:  $codigo)"
    }
}