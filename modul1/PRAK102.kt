fun math(x: Int):Int = 2*x*x + 5*x - 8

fun main(){
    print("Nilai x: ")
    val x = readLine()
    print(math(x?.toInt() ?: 0))

}