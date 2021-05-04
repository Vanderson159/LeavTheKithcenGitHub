package com.example.leavingthekithcen

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val LOCATION_PERMISSON_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getLocationAccess(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mMap.isMyLocationEnabled = true
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSON_REQUEST)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == LOCATION_PERMISSON_REQUEST){
            if(grantResults.contains(PackageManager.PERMISSION_GRANTED)){
                mMap.isMyLocationEnabled = true
            }else{
                Toast.makeText(this, "O usuário não deu permissão", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        var latitude = intent.getDoubleExtra("latitude",0.0)
        var longitude = intent.getDoubleExtra("longitude",0.0)
       // getLocationAccess()
        val localSorteado = LatLng(latitude, longitude)
        mMap.setMinZoomPreference(21.0f)
        //mMap.setMaxZoomPreference(20.0f)
        mMap.addMarker(MarkerOptions().position(localSorteado).title("Restaurante Sorteado"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localSorteado))
        Toast.makeText(this, "Pressione o Botão de voltar (<) para mais informações",Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        var nome = intent.getStringExtra("nome")
        var facebook = intent.getStringExtra("facebook")
        var instagram = intent.getStringExtra("instagram")
        var whatsapp = intent.getStringExtra("whatsapp")
        var desconto = intent.getBooleanExtra("desconto", false)
        var ticket = intent.getStringExtra("ticket")
        var ticketText = intent.getStringExtra("ticketText")
        if(desconto == false){
            val intent = Intent(this, Main3Activity::class.java)
            intent.putExtra("nome",nome)
            intent.putExtra("facebook",facebook)
            intent.putExtra("instagram",instagram)
            intent.putExtra("whatsapp",whatsapp)
            startActivity(intent)
        }else{
            if(desconto == true){
                val intent = Intent(this, Main6Activity::class.java)
                intent.putExtra("nome",nome)
                intent.putExtra("facebook",facebook)
                intent.putExtra("instagram",instagram)
                intent.putExtra("whatsapp",whatsapp)
                intent.putExtra("desconto",desconto)
                intent.putExtra("ticket",ticket)
                intent.putExtra("ticketText",ticketText)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Error Ticket",Toast.LENGTH_LONG).show()
            }
        }
    }
}
