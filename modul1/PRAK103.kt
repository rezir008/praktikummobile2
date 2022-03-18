fun main(){
    print("Input Bilangan: ")
    val x = readLine()
    var hasil = x?.toInt() ?:0
    repeat(5){
        print(hasil)
        hasil += x?.toInt() ?:0
    }

}