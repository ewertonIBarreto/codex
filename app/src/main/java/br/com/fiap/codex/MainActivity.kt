package br.com.fiap.codex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Primeiro método que roda, quando o app é aberto
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //redesenha a tela e mantém os dados do usuário
        setContentView(R.layout.activity_main) //vinculação entre o kotlyn e o layout
    }
}

//Classe Log - mostra informações em execução (Exemplo: Log.i(tag:"lifeCycle", msg:"onCreate")
//lifeCycle: onCreate > onStart > onResume > onPause > onStop > onRestart > onStart > onResume > onDestroy