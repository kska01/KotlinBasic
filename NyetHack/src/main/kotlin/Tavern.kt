import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

fun main() {
    if (patronList.contains("Eli")) {
        println("술집 주인이 말한다: Eli는 안쪽 방에서 카드하고 있어요.")
    } else {
        println("술집 주인이 말한다: Eli는 여기 없어요.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("술집 주인이 말한다: 네, 모두 있어요.")
    } else {
        println("술집 주인이 말한다: 아니오, 나간 사람도 있습니다.")
    }
    placeOrder("shandy,Dragon's Breath,5.91")

    patronList.forEach { patron ->
        println("좋은 밤입니다, $patron 님")
    }
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("지갑 전체 금액: 금화 $totalPurse")
    println("금화 $price 로 술을 구입함")

    val remainingBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[AaEeIiOoUu]")) {
        when (it.value) {
            "A" -> "4"
            "a" -> "4"
            "E" -> "3"
            "e" -> "3"
            "I" -> "1"
            "i" -> "1"
            "O" -> "0"
            "o" -> "0"
            "U" -> "|_|"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "마드리갈이 말한다: 감사합니다 $name."
    }
    println(phrase)
}