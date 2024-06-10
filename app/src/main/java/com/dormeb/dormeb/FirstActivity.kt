package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.values.AlphaValues
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var checkDontShow: CheckBox

    private lateinit var textWelcome: TextView
    private lateinit var textFirst: TextView
    private lateinit var textSecond: TextView
    private lateinit var textThird: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
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
        val sharedPreferences =
            getSharedPreferences("UserPreference", MODE_PRIVATE) // instanciando e dando o nome
        val edit = sharedPreferences.edit() // instanciando o editor, onde eu posso botar os dados
        edit.apply {
            putString("Preference", checkDontShow.tag.toString())
        }.apply() // botando os dados dentro

        Toast.makeText(this, "Preferência salva", Toast.LENGTH_SHORT).show()

    }

    private fun loadData(): String { // carregando os dados
        var preference = ""
        val sharedPreferences =
            getSharedPreferences("UserPreference", MODE_PRIVATE) // instanciando e dando o nome
        val savedPreferences = sharedPreferences.getString(
            "Preference",
            null
        ) // pegando a chave que instanciei (null é se tivesse alguma segurança)

        preference = savedPreferences.toString()
        return preference
    }

    private fun initialAnimation() {
        textWelcome.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MAX)

        textFirst.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
        textSecond.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
        textThird.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)

        btnStart.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)

        checkDontShow.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MED)

    }

    private fun initInterfaceComponents() {
        checkDontShow = findViewById(R.id.dontshowBox)
        checkDontShow.alpha = AlphaValues.TRANSPARENCY_INITIAL
        checkDontShow.tag = "false"

        btnStart = findViewById(R.id.btnStart)
        btnStart.alpha = AlphaValues.TRANSPARENCY_INITIAL

        textWelcome = findViewById(R.id.textWelcome)
        textWelcome.alpha = AlphaValues.TRANSPARENCY_INITIAL

        textFirst = findViewById(R.id.textFirst)
        textFirst.alpha = AlphaValues.TRANSPARENCY_INITIAL

        textSecond = findViewById(R.id.textSecond)
        textSecond.alpha = AlphaValues.TRANSPARENCY_INITIAL

        textThird = findViewById(R.id.textThird)
        textThird.alpha = AlphaValues.TRANSPARENCY_INITIAL
    }

    private fun initActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}