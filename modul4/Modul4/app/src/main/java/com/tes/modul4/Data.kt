package com.tes.modul4

object Data {
    private val kucing = arrayOf(
        "kucing 1",
        "kucing 2",
        "kucing 3",
        "kucing 4",
        "kucing 5"
    )
    private val kelinci = arrayOf(
        "kelinci 1",
        "kelinci 2",
        "kelinci 3",
        "kelinci 4"
    )
    private val panda = arrayOf(
        "panda 1",
        "panda 2",
        "panda 3",
        "panda 4",
        "panda 5",
        "panda 6"
    )

    val listDtKucing: ArrayList<Kucing>
    get() {
        val list = arrayListOf<Kucing>()
        for (position in kucing.indices){
            val kucings = Kucing()
            kucings.name = kucing[position]
            list.add(kucings)
        }
        return list
    }
    val listDtKelinci: ArrayList<Kelinci>
        get() {
            val list = arrayListOf<Kelinci>()
            for (position in kelinci.indices){
                val kelincis = Kelinci()
                kelincis.name = kelinci[position]
                list.add(kelincis)
            }
            return list
        }
    val listDtPanda: ArrayList<Panda>
        get() {
            val list = arrayListOf<Panda>()
            for (position in panda.indices){
                val pandas = Panda()
                pandas.name = panda[position]
                list.add(pandas)
            }
            return list
        }
}