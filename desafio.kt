enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int, var nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach {
            println("Adicionando inscrito ${it.nome}... no curso ${this.nome}")
            inscritos.add(it)
        }
    }
}

fun main() {
    
    // Usuarios
    var matheus = Usuario("Matheus")
    var juel = Usuario("Juel")
    var wuel = Usuario("Wuel")
    
    // Conteudos
    var estruturaDados = ConteudoEducacional("Estrutura de Dados", 5, Nivel.INTERMEDIARIO)
    var variaveis = ConteudoEducacional("Variáveis", 2, Nivel.BASICO)
    var condicionais = ConteudoEducacional("Estruturas Condicionais", 3, Nivel.BASICO)
    
    // Formacoes
    var python = Formacao("Python", listOf(variaveis, estruturaDados))
    var kotlin = Formacao("Kotlin", listOf(variaveis, condicionais))
    
    python.matricular(juel, wuel)
    kotlin.matricular(matheus, juel)
    
    println("Alunos inscritos no curso de Python:")
    python.inscritos.forEach {
        println("Aluno: ${it.nome}")
    }
    
    println("Alunos inscritos no curso de Kotlin:")
    kotlin.inscritos.forEach {
        println("Aluno: ${it.nome}")
    }
    
}