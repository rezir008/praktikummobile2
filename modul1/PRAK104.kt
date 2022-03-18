class PRAK104(color: String, numberOfWindows: String) {
    val color: String = color
    val numberOfWindows: String = numberOfWindows
}
fun main(){
    print("Warna Rumah: ")
    val color = readLine() ?: "White"
    print("Jumlah Jendela: ")
    val numberOfWindows = readLine() ?: "5"
    val myHouse = PRAK104(color, numberOfWindows)
    val Hasil ="""
        Warna Rumah : ${myHouse.color}
        Jumlah Jendela : ${myHouse.numberOfWindows}
    """.trimIndent()
    println(Hasil)
}