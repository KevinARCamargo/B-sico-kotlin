//Cadastros Prévios
val conteudo = ConteudoEducacional("HTML")
val conteudo1 = ConteudoEducacional("CSS")
val conteudo2 = ConteudoEducacional("JS")
val conteudo3 = ConteudoEducacional("Python")
val conteudo4 = ConteudoEducacional("SQL")
val conteudo5 = ConteudoEducacional("Java")
val conteudo6 = ConteudoEducacional("Kotlin")

val formacoes: MutableList<Formacoes> = mutableListOf(
    Formacoes("Front", Nivel.Basico, listOf(conteudo, conteudo1, conteudo2) ),
    Formacoes("Dados", Nivel.Basico, listOf(conteudo3, conteudo4)),
    Formacoes("Back", Nivel.Intermediario, listOf(conteudo5, conteudo6))
)

//Classes
enum class Nivel{
    Basico, Intermediario, Avancado
}

data class ConteudoEducacional(val nome: String)

data class Aluno(val id: Int, val nome: String, val formacoes: Formacoes)

data class Formacoes (val nome: String, val nivel: Nivel, val conteudosEducacionais: List<ConteudoEducacional>)

fun escolha(num: Int): Formacoes {
    return when (num) {
        1 -> return Formacoes("Front", Nivel.Basico, listOf(conteudo, conteudo1, conteudo2) )
        2 -> return Formacoes("Dados", Nivel.Basico, listOf(conteudo3, conteudo4))
        3 -> return Formacoes("Back", Nivel.Intermediario, listOf(conteudo5, conteudo6))
        else -> throw IllegalArgumentException("Número de escolha inválido")
    }
}


fun main(){



    val alunos: MutableList<Aluno> = mutableListOf()

    var opcao: Int = 1
    var id: Int = 1

    do{
        println("***** Menu *****")
        println("1- Listar Formacoes")
        println("2- Listar alunos")
        println("3- Matricular um aluno")
        println("0- Sair\n")
        print("Digite a opcao desejada: ")
        opcao = readLine()?.toIntOrNull() ?: -1

        when(opcao){
            1->{
                for (formacao in formacoes){
                    println(formacao.nome)
                }
            }
            2->{
                for (aluno in alunos){
                    println(aluno)
                }
            }
            3->{
                println("***** Formaulário de Matricula *****\n")
                print("Digite o nome do aluno: ")
                val nome = readLine() ?: "Pedro"
                println("1- Front")
                println("2- Dados")
                println("3- Back")
                print("Qual Formação deseja escolher? : ")
                val formacao = escolha(readLine()?.toIntOrNull() ?: -1)
                alunos.add(Aluno(id, nome, formacao))
                id = id + 1
            }
            else->{
                println("Opção Inválida")
            }
        }


    }while (opcao != 0)

}
