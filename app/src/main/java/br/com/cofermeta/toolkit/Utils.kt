package br.com.cofermeta.toolkit

import com.google.gson.JsonParser
import okhttp3.MediaType.Companion.toMediaType

object Utils {

    const val baseUrl = "http://teste.cofermeta.com.br:8880/mge/service.sbr?serviceName=MobileLoginSP.login&outputType=json"

    val mediaType = "application/json; charset=utf-8".toMediaType()

    fun loginBody(user: String, password:String) =
        """
           {
           "serviceName": "MobileLoginSP.login",
              "requestBody": {
                   "NOMUSU": {
                      "$": "$user"
                   },
                   "INTERNO":{
                      "$": "$password"
                   },
                  "KEEPCONNECTED": {
                      "$": "S"
                  }
              }
          }
        """.trimIndent()

    fun getJsessionId(body: String): String = JsonParser.parseString(body)
        .asJsonObject["responseBody"]
        .asJsonObject["jsessionid"]
        .asJsonObject["$"]
        .asString

}