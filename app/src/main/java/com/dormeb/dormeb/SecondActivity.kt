package com.dormeb.dormeb

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.R
import com.dormeb.dormeb.enums.SoundsName

class SecondActivity : AppCompatActivity() {

    private var MediaPlayer = MediaPlayer()
    private lateinit var btnPause: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initInterfaceComponents()


        btnPause.setOnClickListener{
            finish()
        }


    }




    private fun initInterfaceComponents() {
        btnPause = findViewById(R.id.pauseButton)
    }

}