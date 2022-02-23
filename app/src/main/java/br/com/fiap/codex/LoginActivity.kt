package br.com.fiap.codex


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}

//Classe Log - mostra informações em execução (Exemplo: Log.i(tag:"lifeCycle", msg:"onCreate")
//lifeCycle: onCreate > onStart > onResume > onPause > onStop > onRestart > onStart > onResume > onDestroy