package br.com.realize.praticandoanlisedevazamento.data.model

import android.util.Log

class Square(
    val side: String? = null, color: String? = null
) : Figure(color) {
    override fun area() {
        Log.i(TAG, "Squad Area")
    }

    companion object {
        val TAG = Square::class.java.name
    }
}
