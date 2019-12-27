package com.mr.nointernetlayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wessam.library.NetworkChecker
import com.wessam.library.NoInternetLayout
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isNetworkConnected()) {
            var button = findViewById<Button>(R.id.internet)
            button.setOnClickListener {
                if (isNetworkConnected()) {
                    toast("Network stable")
                } else {
                    showNotConnected()
                }
            }
        } else {
            showNotConnected()
        }
    }

    private fun isNetworkConnected(): Boolean {
        return NetworkChecker.isNetworkConnected(this@MainActivity)
    }

    private fun showNotConnected() {
        NoInternetLayout.Builder(this, R.layout.activity_main)
            .animate()
            .mainTitle("No Internet Connection")
            .secondaryText("Please check your connetion")
            .buttonText("Retry")
            .setImage(R.drawable.animated1)
    }
}
