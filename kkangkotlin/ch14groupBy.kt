fun main() {
    class User(val name: String, val age: Int)

    val list = listOf<User>(User("kkang", 33), User("lee", 28), User("kim", 28))
    list.groupBy { it.age }
        .forEach {
            println("key : ${it.key} ... count : ${it.value.count()}")
            it.value.forEach { println("${it.name} .. ${it.age}")}
        }
}