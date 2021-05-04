package com.example.leavingthekithcen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main7.*

class Main7Activity : AppCompatActivity() {
    //classe dos descontos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        var ticket = intent.getStringExtra("ticket")
        var ticketText = intent.getStringExtra("ticketText")
        if(textViewTicketValor != null){
            textViewTicketValor.text = ticket
            textViewTexto.text = ticketText
        }else{
            textViewTicketValor.text = "Error "
        }

    }
}
