fun main(){
    print("Waktu Sekarang: ")
    val waktu = readLine()
    print("Nama Anda: ")
    val nama = readLine()
    print("Umur Anda: ")
    val umur = readLine()
    print("Suhu Tubuh Anda: ")
    val suhu = readLine()

    val hasil ="""
        Selamat $waktu, $nama Umur anda $umur Tahun.
        Suhu Tubuh anda $suhu derajat Celcius.
    """.trimIndent()
    println(hasil)
}