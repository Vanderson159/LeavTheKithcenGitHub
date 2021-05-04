package com.example.leavingthekithcen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var choise:Int = 0
        //utilizar um shared preference  por causa do bug de ver o cardápio mais de uma vez
        var nomeRestaurante = intent.getStringExtra("nome")
        var facebook = intent.getStringExtra("facebook")
        var instagram = intent.getStringExtra("instagram")
        var whatsapp = intent.getStringExtra("whatsapp")
        textViewSorteado.text = nomeRestaurante

        buttonSortearNovamente6.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        buttonFacebook6.setOnClickListener {
            val intent = Intent(this, Main4Activity::class.java)
            intent.putExtra("redeSocial",facebook)
            choise = 1
            intent.putExtra("choise",choise)
            startActivity(intent)
        }
        buttonInstagram6.setOnClickListener {
            val intent = Intent(this, Main4Activity::class.java)
            intent.putExtra("redeSocial",instagram)
            choise = 2
            intent.putExtra("choise",choise)
            startActivity(intent)
        }
        buttonWhatsaap6.setOnClickListener {
            if(whatsapp == null){
                Toast.makeText(this, "Não possui esta rede", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, Main4Activity::class.java)
                intent.putExtra("redeSocial",whatsapp)
                choise = 3
                intent.putExtra("choise",choise)
                startActivity(intent)
            }
        }
    }
}
