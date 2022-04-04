package com.example.weatherapp.experiment

import android.content.Context
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.weatherapp.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.util.stream.Collectors

class MainActivityEx: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commit()
//        }
//        binding.ok.setOnClickListener(clickListener)
//        binding.webview.settings.javaScriptEnabled = true
//        binding.webview.addJavascriptInterface(JsInterface(), "jsInterface")

    }

    var clickListener: View.OnClickListener = object : View.OnClickListener {

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onClick(v: View?) {
//            binding.webview.loadUrl("https://gb.ru/")
//            try {
//                val uri = URL(binding.url.text.toString())
//                val handler = Handler() //Запоминаем основной поток
//                Thread {
//                    var urlConnection: HttpsURLConnection? = null
//                    try {
//                        urlConnection = uri.openConnection() as HttpsURLConnection
//                        urlConnection.requestMethod =
//                            "GET" //установка метода получения данных — GET
//                        urlConnection.readTimeout = 10000 //установка таймаута — 10 000 миллисекунд
//                        val reader =
//                            BufferedReader(InputStreamReader(urlConnection.inputStream)) //читаем данные в поток
//                        val result = getLines(reader)
//
//                        // Возвращаемся к основному потоку
//                        handler.post {
//                            // binding.webview.loadData(result, "text/html; charset=utf-8", "utf-8")
//                            binding.webview.loadDataWithBaseURL(null, result, "text/html; charset=utf-8", "utf-8", null)
//                        }
//                    } catch (e: Exception) {
//                        Log.e("", "Fail connection", e)
//                        e.printStackTrace()
//                    } finally {
//                        urlConnection?.disconnect()
//                    }
//                }.start()
//            } catch (e: MalformedURLException) {
//                Log.e("", "Fail URI", e)
//                e.printStackTrace()
//            }
        }

        @RequiresApi(Build.VERSION_CODES.N)
        private fun getLines(reader: BufferedReader): String {
            return reader.lines().collect(Collectors.joining("\n"))
        }

    }

    inner class JsInterface {
        @JavascriptInterface
        @Throws(Exception::class)
        fun GetMyLocation(): String? {
            val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            return if (statusOfGPS) {
                "true"
            } else "false"
        }


    }
}