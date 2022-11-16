class Product(info_string: String) {
    private var InitialString: String = ""
    var Name: String = ""
    var Cost: Float = 0.0F
    var FormatIsBroken: Boolean = false

    init {
        InitialString = info_string.trim()

        if ((InitialString == "") || (InitialString.indexOf(" ") == -1)) {
            FormatIsBroken = true
        } else {
            Name = InitialString.substring(0, InitialString.indexOf(" "))

            try {
                Cost = InitialString.substring(InitialString.indexOf(" "), InitialString.length).toFloat()
            } catch (e: Exception) {
                FormatIsBroken = true
            }

            if ((Name == "") || (Cost < 0.0F)) {
                FormatIsBroken = true
            }
        }
    }
}