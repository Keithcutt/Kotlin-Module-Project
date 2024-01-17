class Menu<T: DataContainer> (private val listOfDataContainers: MutableList<T>, private val onSelected: (T) -> Unit)  {


    fun printMenu(message: String) {
        println("=========================")
        println(message)
        listOfDataContainers.forEachIndexed { index, value -> println("$index. $value") }
        println("=========================")
    }

    fun select(index: Int) {
        onSelected(listOfDataContainers[index])
    }

}


