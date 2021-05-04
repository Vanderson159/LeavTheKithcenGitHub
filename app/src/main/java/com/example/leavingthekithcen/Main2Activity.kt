package com.example.leavingthekithcen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //definindo os locais e adicionando eleas ao array
        //val butecao = Locais(-29.78793522728537, -55.769378414606464, "Butecão do Morais", "https://www.facebook.com/butecaodomorais")
        //val dItalia = Locais(-29.785995162516667, -55.77122384532146, "Pizzaria Sabor D'italia", "https://www.facebook.com/SaborDItaliaPizzaria")
        //val uk = com.example.leavingthekithcen.Locais(-29.78576678605041, -55.776999701995635, "UK Pizza Burger")
        val subway = Locais(-29.78100981012449, -55.78976086986291, "SubWay", "https://www.facebook.com/Subway-Brasil-1357616854406261/", "https://instagram.com/subwaybrasil?igshid=1rcwuebzew20s", null)
        val ricci = Locais(-29.803335475575707, -55.75672624124048, "Ricci Pizzaria", "https://www.facebook.com/riccipizzaria/menu/?ref=page_internal","https://instagram.com/ricci.pizzaria?igshid=1hzo442fayvk8","https://wa.me/555534200555",true,"05%","Em qualquer pizza")
        var locais = arrayOf<Locais>(ricci, subway)

        buttonSortear.setOnClickListener {
            var intent = Intent(this, MapsActivity::class.java)
            var x = locais?.size
            var aleatorio = (0..x).random()
            var latitude = locais.get(aleatorio).latitude
            var longitude = locais.get(aleatorio).longitude
            var nome = locais.get(aleatorio).nome
            var facebook = locais.get(aleatorio).facebook
            var instagram = locais.get(aleatorio).instagram
            var whatsapp = locais.get(aleatorio).whatsaap
            var desconto = locais.get(aleatorio).desconto
            var ticket = locais.get(aleatorio).ticket
            var ticketText = locais.get(aleatorio).ticketText


            //levando a latitude e a longitude para a próxima tela
            intent.putExtra("latitude", latitude)
            intent.putExtra("longitude", longitude)
            intent.putExtra("nome", nome)
            intent.putExtra("facebook",facebook)
            intent.putExtra("instagram",instagram)
            intent.putExtra("whatsapp",whatsapp)
            intent.putExtra("desconto",desconto)
            intent.putExtra("ticket",ticket)
            intent.putExtra("ticketText",ticketText)
            startActivity(intent)
        }

        buttonAviso.setOnClickListener {
            var intent = Intent(this,Main5Activity::class.java)
            startActivity(intent)
        }
    }

    //fnção para gerar o numéro aleatório
    fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start
}
