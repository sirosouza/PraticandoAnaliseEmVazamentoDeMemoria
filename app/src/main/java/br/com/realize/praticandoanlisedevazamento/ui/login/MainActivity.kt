package br.com.realize.praticandoanlisedevazamento.ui.login

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import br.com.realize.praticandoanlisedevazamento.R
import br.com.realize.praticandoanlisedevazamento.broadcastreceiver.TestBroadCastReceicer
import br.com.realize.praticandoanlisedevazamento.data.model.Circle
import br.com.realize.praticandoanlisedevazamento.data.model.Outer
import br.com.realize.praticandoanlisedevazamento.data.model.Square
import br.com.realize.praticandoanlisedevazamento.listeners.TestListener
import br.com.realize.praticandoanlisedevazamento.ui.login.LoginActivity.Companion.number

class MainActivity : AppCompatActivity() {
    private lateinit var listener: TestListener
    private val receiver: BroadcastReceiver = TestBroadCastReceicer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        // Receptores não cancelados
        val intentFilter = IntentFilter(SMS_RETRIEVED_ACTION)
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, intentFilter)

        // Ouvintes não cancelados
        listener = object : TestListener {
            override fun callHelloWorld() {
                Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()
            }
        }

        Handler().postDelayed({
            listener.callHelloWorld()
        }, DELAY)

        number = 5

        // Visualizações estáticas
        Log.i(TAG, "Número: $number")
        // Contexto Estático
        Toast.makeText(context, "Usando Toast com contexto estático", Toast.LENGTH_LONG).show()

        val square = Square(side = "side")
        val circle = Circle(ray = "ray")

        square.area() // A abstração de código com frequência
        circle.area() // A abstração de código com frequência

        Log.i(TAG, "side: ${square.side}")
        Log.i(TAG, "side: ${circle.ray}")

        // Referência de classe interna
        val nested = Outer.Nested()
        println(nested.callMe())
    }

    companion object {
        lateinit var context: Context
        val TAG: String = MainActivity::class.java.name
        const val DELAY = 3000L
        const val SMS_RETRIEVED_ACTION = "SMS_RETRIEVED_ACTION"
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                // Passar informação com Parcelable e não Serializable
            }
        }
    }
}