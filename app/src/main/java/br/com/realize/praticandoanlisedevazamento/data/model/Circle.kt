package br.com.realize.praticandoanlisedevazamento.data.model

import android.util.Log

class Circle(
    val ray: String? = null, color: String? = null
) : Figure(color) {
    override fun area() {
        Log.i(TAG, "Circle Area")
    }

    companion object {
        val TAG: String = Square::class.java.name
    }
}