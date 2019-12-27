package com.mr.nointernetlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.wessam.library.NetworkChecker
import com.wessam.library.NoInternetLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button =findViewById<Button>(R.id.internet)
        button.setOnClickListener{
            isConnectionStable()
        }
    }

    fun isConnectionStable(){
        try {
            if(NetworkChecker.isNetworkConnected(this@MainActivity)){
                Toast.makeText(this@MainActivity, "Network stable",Toast.LENGTH_SHORT).show()
            } else {
                NoInternetLayout.Builder(this,  R.layout.activity_main)
                    .animate()
                    .mainTitle("No Internet Connection")
                    .secondaryText("Please check your connetion")
                    .buttonText("Retry")
                    .setImage(R.drawable.animated1)
            }
        } catch (e : Exception){
            null
        }
    }
}
