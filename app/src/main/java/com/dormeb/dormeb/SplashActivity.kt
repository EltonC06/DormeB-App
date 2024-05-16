package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {

    private lateinit var btnStart: Button

    private lateinit var textWelcome: TextView
    private lateinit var textFirst: TextView
    private lateinit var textSecond: TextView
    private lateinit var textThird: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initInterfaceComponents()
        initialAnimation()

        btnStart.setOnClickListener {
            initActivity() // mesmo assim o usuario consegue voltar, logo eu tenho que finalizar essa atividade
            finish() // finalizando
        }

    }

    private fun initialAnimation() {
        textWelcome.animate().setDuration(1000).alpha(1F)

        textFirst.animate().setDuration(1500).alpha(1F)
        textSecond.animate().setDuration(2000).alpha(1F)
        textThird.animate().setDuration(2500).alpha(1F)

        btnStart.animate().setDuration(3000).alpha(1F)

    }

    private fun initInterfaceComponents() {
        btnStart = findViewById(R.id.btnStart)
        btnStart.alpha = 0F

        textWelcome = findViewById(R.id.textWelcome)
        textWelcome.alpha = 0F

        textFirst = findViewById(R.id.textFirst)
        textFirst.alpha = 0F

        textSecond = findViewById(R.id.textSecond)
        textSecond.alpha = 0F

        textThird = findViewById(R.id.textThird)
        textThird.alpha = 0F
    }

    private fun initActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}