package br.com.fiap.codex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Obrigatoriedade de input
        val btnLogin = findViewById<Button>(R.id.btn_logIn)
        var user = findViewById<EditText>(R.id.edt_email)
        var password = findViewById<EditText>(R.id.edt_password)

        val tvRegister = findViewById<LinearLayout>(R.id.tv_register)

        btnLogin.setOnClickListener {
            if (user.text.trim().isNotEmpty() && password.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Seja bem vindo!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Dado(s) solicitados", Toast.LENGTH_LONG).show()
            }
        }

        //Redireciona para se registrar no sistema
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}

//Classe Log - mostra informações em execução (Exemplo: Log.i(tag:"lifeCycle", msg:"onCreate")
//lifeCycle: onCreate > onStart > onResume > onPause > onStop > onRestart > onStart > onResume > onDestroy