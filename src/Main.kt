import kotlin.collections.HashSet

fun main(){
    println("Введите количество строк будующего массива: ")
    val rows = readLine()!!.toInt()
    println("Введите количество столбцев будующего массива: ")
    val columns = readLine()!!.toInt()

    val array = Array(rows) { Array(columns) { 0 } }
    println("Введите ${rows*columns} трехзначных чисел: ")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            var number = readLine()!!.toInt()
            if (number !in 100..999)  throw
            IllegalArgumentException("Введенное число не трехзначное( ")
            array[i][j] = number
        }
    }
    val unicDigits = HashSet<Int>()
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            val digits = array[i][j].toString().toCharArray().map { it.toString().toInt() }
            unicDigits.addAll(digits)
        }
    }
    println("Двумерный массив:")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            print("${array[i][j]}  ")
        }
        println()
    }

    println("В массиве использовано ${unicDigits.size} различных цифр.")
}
