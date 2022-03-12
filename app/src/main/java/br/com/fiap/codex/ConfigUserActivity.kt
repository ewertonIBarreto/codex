package br.com.fiap.codex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfigUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_user)

        val pesquisaCEP = findViewById<Button>(R.id.btn_searchByCep)
        val cep = findViewById<EditText>(R.id.edt_cep)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val rua = findViewById<EditText>(R.id.edt_street)
        val cidade = findViewById<EditText>(R.id.edt_city)
        val uf = findViewById<EditText>(R.id.edt_state)
        val pesquisaRCE = findViewById<Button>(R.id.btn_searchByRCE)



        pesquisaCEP.setOnClickListener {

            progressBar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.body()?.let {
                        Log.i("CEP", it.toString())
                        Toast.makeText(this@ConfigUserActivity, it.toString(), Toast.LENGTH_LONG)
                            .show()


                        progressBar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(
                        this@ConfigUserActivity,
                        "CEP não localizado",
                        Toast.LENGTH_LONG
                    )
                        .show()

                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progressBar.visibility = View.INVISIBLE
                }
            })
        }


        pesquisaRCE.setOnClickListener {

            progressBar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getRCE(
                uf.text.toString(),
                cidade.text.toString(),
                rua.text.toString()
            )

            call.enqueue(object : Callback<List<CEP>> {

                override fun onResponse(call: Call<List<CEP>>?, response: Response<List<CEP>>?) {

                    response?.body()?.let {
                        Log.i("CEP", it.toString())
                        Toast.makeText(this@ConfigUserActivity, it.toString(), Toast.LENGTH_LONG)
                            .show()
                        progressBar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(
                        this@ConfigUserActivity,
                        "Endereço não localizado ",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<List<CEP>>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progressBar.visibility = View.INVISIBLE
                }
            })
        }

    }

}

