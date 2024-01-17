import java.lang.Exception
import java.util.Scanner

class InputHandler {
    fun menuOptionSelect(): Int {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            try {
                return Integer.parseInt(input)
            } catch (e: Exception) {
                println("Ошибка ввода\nДля выбора опции введите соответствующее ей число")
                continue
            }


        }
    }
    fun textInput(): String {
        while (true) {
            when (val input = Scanner(System.`in`).nextLine()) {
                "" -> {
                    println("Это поле не должно быть пустым")
                    continue
                }
                else -> {
                    println("Данные сохранены\n")
                    return input
                }
            }
        }
    }
}