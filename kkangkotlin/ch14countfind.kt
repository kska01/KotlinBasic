fun main() {
    class User(val name: String, val age: Int)
    var list = listOf(User("kkang",33), User("lee", 28))

    println("count test : ${list.count{ it.age > 25 }}")
    val user = list.find { it.age > 25 }
    println("find test : ${user?.name} ${user?.age}")
}