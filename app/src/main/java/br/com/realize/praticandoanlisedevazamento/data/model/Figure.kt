package br.com.realize.praticandoanlisedevazamento.data.model

abstract class Figure(
    val color: String? = null
) {
    abstract fun area()
}