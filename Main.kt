import kotlin.random.Random

fun main() {
    val rounds = 100
    var playerAWins = 0
    var playerBWins = 0
    var draws = 0

    for (i in 1..rounds) {
        val playerAChoice = "ROCK"
        val playerBChoice = getRandomChoice()
        val result = evaluateGame(playerAChoice, playerBChoice)

        when (result) {
            "WIN" -> playerAWins++
            "LOSE" -> playerBWins++
            "DRAW" -> draws++
        }
    }

    println("Player A wins $playerAWins of $rounds games")
    println("Player B wins $playerBWins of $rounds games")
    println("Draws: $draws of $rounds games")
}

fun getRandomChoice(): String {
    val choices = listOf("ROCK", "PAPER", "SCISSORS")
    return choices[Random.nextInt(choices.size)]
}

fun evaluateGame(playerAChoice: String, playerBChoice: String): String {
    return when {
        playerAChoice == playerBChoice -> "DRAW"
        playerAChoice == "ROCK" && playerBChoice == "SCISSORS" -> "WIN"
        playerAChoice == "PAPER" && playerBChoice == "ROCK" -> "WIN"
        playerAChoice == "SCISSORS" && playerBChoice == "PAPER" -> "WIN"
        else -> "LOSE"
    }
}
