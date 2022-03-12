package br.com.fiap.codex

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//Qualquer outra classe que necessite consumir algum recurso da API, ela é chamada

interface RetrofitService {

    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP : String) : Call<CEP>

    //https://viacep.com.br/ws/SP/Sao%20Paulo/Avenida%20Lins%20de%20Vasconcelos/json/
    @GET("{estado}/{cidade}/{endereco}/json/")
    fun getRCE(@Path("estado") estado: String,
               @Path("cidade") cidade: String,
               @Path("endereco") endereco: String): Call<List<CEP>>
}
