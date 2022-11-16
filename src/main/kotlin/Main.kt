fun mostExpensive(description: String): String {
    var descr_copy: String = description + ";"
    var HighestCostProduct = Product(" 0.0")
    var CurrentProduct: Product
    while (descr_copy.indexOf(";") != -1)
    {
        CurrentProduct = Product(descr_copy.substring(0, descr_copy.indexOf(";")))
        if (CurrentProduct.FormatIsBroken) {
            return ""
        }
        if (CurrentProduct.Cost >= HighestCostProduct.Cost) {
            HighestCostProduct = CurrentProduct
        }
        descr_copy = descr_copy.replaceFirst(descr_copy.substring(0, descr_copy.indexOf(";")+1), "")
    }
    return HighestCostProduct.Name
}

fun plusMinus(expression: String): Int {
    var expr_copy: String = expression.trim() + " "
    var prevWord: String = ""
    var currWord: String = ""

    while (expr_copy.indexOf(" ") != -1) {
        currWord = expr_copy.substring(0, expr_copy.indexOf(" "))
        if (!prevWord.isBlank() && currWord.equals(prevWord)) {
            return expression.indexOf(prevWord)
        }
        prevWord = currWord
        expr_copy = expr_copy.replaceFirst(currWord + " ", "")
    }
    return -1
}

fun main(args: Array<String>) {
    println("Введите предложение: ")
    var expression = readLine()!!.toString().lowercase()
    var result: Int = plusMinus(expression)
    if (result == -1) {
        println("В тексте нету повторяющихся подряд слов")
    } else {
        println("Индекс первого повторяющегося слова = " + result + ".")
    }

    println("Введите описание продуктов: ")
    var description = readLine()!!.toString().trim()
    var name: String = mostExpensive(description)
    if (name == "") {
        println("Формат описания был нарушен.")
    } else {
        println(name + " имеет самую высокую цену.")
    }
}