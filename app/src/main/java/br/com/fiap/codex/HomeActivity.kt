package br.com.fiap.codex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnNewAction = findViewById<Button>(R.id.btn_newAction)
        val accessConfig = findViewById<ImageView>(R.id.iv_editUser)

        btnNewAction.setOnClickListener {
            val intent = Intent(this, RegisterActionActivity::class.java)
            startActivity(intent)
        }

        accessConfig.setOnClickListener {
            val intent = Intent(this, ConfigUserActivity::class.java)
            startActivity(intent)
        }

    }
}