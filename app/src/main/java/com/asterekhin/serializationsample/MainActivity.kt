package com.asterekhin.serializationsample

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var phone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<EditText>(R.id.name)
        phone = findViewById<EditText>(R.id.phone)
        val send = findViewById<Button>(R.id.send)
        send.setOnClickListener {
            if (TextUtils.isEmpty(name.getText().toString()) && TextUtils.isEmpty(
                    phone.getText().toString()
                )
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Something is wrong kindly check",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                sendUserData(name.getText().toString(), phone.getText().toString())
            }
        }
    }

    private fun sendUserData(username: String, userPhone: String) {
        val userinfo = Userinfo()
        userinfo.name = username
        userinfo.phone = userPhone
        val send = Intent(this@MainActivity, SecondsActivity::class.java)
        val b = Bundle()
        b.putSerializable("serialzable", userinfo)
        send.putExtras(b)
        startActivity(send)
    }
}