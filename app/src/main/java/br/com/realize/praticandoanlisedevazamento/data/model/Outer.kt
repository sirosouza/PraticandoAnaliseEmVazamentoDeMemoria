package br.com.realize.praticandoanlisedevazamento.data.model

class Outer {

    val a = "Outside Nested class."

    class Nested {
        val b = "Inside Nested class."
        fun callMe() = "$TAG: Function call from inside Nested class."
    }

    companion object {
        val TAG: String = Outer::class.java.name
    }
}
