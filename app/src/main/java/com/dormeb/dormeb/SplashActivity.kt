package com.dormeb.dormeb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.values.AlphaValues

class SplashActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var checkDontShow: CheckBox

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

        val preference = loadData()
        if (preference == "true") {
            initActivity()
            finish()
        }




        initInterfaceComponents()
        initialAnimation()

        btnStart.setOnClickListener {
            initActivity() // mesmo assim o usuario consegue voltar, logo eu tenho que finalizar essa atividade
            finish() // finalizando
        }

        checkDontShow.setOnClickListener {
            if (checkDontShow.tag == "false") {
                checkDontShow.tag = "true"
            } else if (checkDontShow.tag == "true") {
                checkDontShow.tag = "false"
            }
            saveData()
        }

    }



    private fun saveData() {
        val sharedPreferences = getSharedPreferences("UserPreference", MODE_PRIVATE) // instanciando e dando o nome
        val edit = sharedPreferences.edit() // instanciando o editor, onde eu posso botar os dados
        edit.apply{
            putString("Preference", checkDontShow.tag.toString())
        }.apply() // botando os dados dentro

        Toast.makeText(this, "Preferência salva", Toast.LENGTH_SHORT).show()

    }

    private fun loadData (): String { // carregando os dados
        var preference = ""
        val sharedPreferences = getSharedPreferences("UserPreference", MODE_PRIVATE) // instanciando e dando o nome
        val savedPreferences =  sharedPreferences.getString("Preference", null) // pegando a chave que instanciei (null é se tivesse alguma segurança)

        preference = savedPreferences.toString()
        return preference
    }

    private fun initialAnimation() {
        textWelcome.animate().setDuration(1000).alpha(AlphaValues.TransparencyMax)

        textFirst.animate().setDuration(1500).alpha(AlphaValues.TransparencyMax)
        textSecond.animate().setDuration(1500).alpha(AlphaValues.TransparencyMax)
        textThird.animate().setDuration(1500).alpha(AlphaValues.TransparencyMax)

        btnStart.animate().setDuration(2500).alpha(AlphaValues.TransparencyMax)

        checkDontShow.animate().setDuration(1000).alpha(AlphaValues.TransparencyMin)

    }

    private fun initInterfaceComponents() {
        checkDontShow = findViewById(R.id.dontshowBox)
        checkDontShow.alpha = AlphaValues.initialTransparency
        checkDontShow.tag = "false"

        btnStart = findViewById(R.id.btnStart)
        btnStart.alpha = AlphaValues.initialTransparency

        textWelcome = findViewById(R.id.textWelcome)
        textWelcome.alpha = AlphaValues.initialTransparency

        textFirst = findViewById(R.id.textFirst)
        textFirst.alpha = AlphaValues.initialTransparency

        textSecond = findViewById(R.id.textSecond)
        textSecond.alpha = AlphaValues.initialTransparency

        textThird = findViewById(R.id.textThird)
        textThird.alpha = AlphaValues.initialTransparency
    }

    private fun initActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}