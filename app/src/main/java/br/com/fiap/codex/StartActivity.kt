package br.com.fiap.codex


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

//Primeiro método que roda, quando o app é aberto
class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //redesenha a tela e mantém os dados do usuário
        setContentView(R.layout.activity_start) //vinculação entre o kotlyn e o layout

        //Chamada para outra activity interna
        val btnAbrirAdm = findViewById<Button>(R.id.buttonAdm)
        val btnAbrirColab = findViewById<Button>(R.id.buttonColab)

        btnAbrirAdm.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        btnAbrirColab.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}
