package com.asterekhin.serializationsample


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondsActivity : AppCompatActivity() {

    var userinfo: Userinfo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconds)
        val data = findViewById<TextView>(R.id.data)
        userinfo = intent.getSerializableExtra("serialzable") as Userinfo?
        val name = userinfo!!.name
        val phone = userinfo!!.phone
        data.text = "Your entered name is $name number is $phone"
    }

    override fun onPause() {
        super.onPause()
        userinfo = null
    }
}