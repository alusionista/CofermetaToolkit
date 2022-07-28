package br.com.cofermeta.loginactivity

import android.content.Context
import android.util.Log
import android.widget.Toast
import br.com.cofermeta.loginactivity.Utils.getJsessionId
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class Auth {
    fun login(user: String = "integracao", password:String = "654321", context: Context) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url(Utils.baseUrl)
            .post(Utils.loginBody(user, password).toRequestBody(Utils.mediaType))
            .build()

        client.newCall(request).enqueue(
            object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("onFalure", e.toString())
                }
                override fun onResponse(call: Call, response: Response)
                {
                    response.use {
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")
                        val rs = getJsessionId(response.body!!.string())
                        Log.d("login_onResponse", response.body!!.string())
                        //Toast.makeText(context,rs, Toast.LENGTH_LONG )
                    }
                }
            }
        )
    }
}