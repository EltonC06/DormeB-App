package com.dormeb.dormeb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dormeb.dormeb.databinding.ActivityFirstBinding
import com.dormeb.dormeb.values.AlphaValues

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val preference = loadData()
        if (preference == "true") {
            initMainActivity()
        }
        initInterfaceComponents()
        initialAnimation()

        binding.btnStart.setOnClickListener {
            initMainActivity()
        }

        binding.checkDontShow.setOnClickListener {
            if (binding.checkDontShow.tag == "false") {
                binding.checkDontShow.tag = "true"
            } else if (binding.checkDontShow.tag == "true") {
                binding.checkDontShow.tag = "false"
            }
            saveData()
        }
    }

    private fun saveData() {
        val sharedPreferences =
            getSharedPreferences("UserPreference", MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.apply {
            putString("Preference", binding.checkDontShow.tag.toString())
        }.apply()
        Toast.makeText(this, getString(R.string.saved_preference), Toast.LENGTH_SHORT).show()
    }

    private fun loadData(): String {
        val preference: String
        val sharedPreferences =
            getSharedPreferences("UserPreference", MODE_PRIVATE)
        val savedPreferences = sharedPreferences.getString(
            "Preference",
            null
        )
        preference = savedPreferences.toString()
        return preference
    }

    private fun initialAnimation() {
        binding.textWelcome.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MAX)
        binding.textFirst.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
        binding.textSecond.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
        binding.textThird.animate().setDuration(1500).alpha(AlphaValues.TRANSPARENCY_MAX)
        binding.btnStart.animate().setDuration(2500).alpha(AlphaValues.TRANSPARENCY_MAX)
        binding.checkDontShow.animate().setDuration(1000).alpha(AlphaValues.TRANSPARENCY_MED)
    }

    private fun initInterfaceComponents() {
        binding.checkDontShow.alpha = AlphaValues.TRANSPARENCY_INITIAL
        binding.checkDontShow.tag = "false"
        binding.btnStart.alpha = AlphaValues.TRANSPARENCY_INITIAL
        binding.textWelcome.alpha = AlphaValues.TRANSPARENCY_INITIAL
        binding.textFirst.alpha = AlphaValues.TRANSPARENCY_INITIAL
        binding.textSecond.alpha = AlphaValues.TRANSPARENCY_INITIAL
        binding.textThird.alpha = AlphaValues.TRANSPARENCY_INITIAL
    }

    private fun initMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("KeepMainActivity", 2)
        startActivity(intent)
        finish()
    }
}