package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityMainAdminsayfasiBinding
import com.velidasan.yenivdform.databinding.ActivityMainBinding

class MainAdminsayfasi : AppCompatActivity() {
    lateinit var  binding: ActivityMainAdminsayfasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainAdminsayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnuygulamayKapat.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnanasayfa.setOnClickListener {
            intent = Intent(applicationContext, Mainhosgeldiniz::class.java)
            startActivity(intent)
        }
        binding.btnVUCUT.setOnClickListener {
            intent = Intent(applicationContext, Mainvucutendeksi::class.java)
            startActivity(intent)
        }
        binding.btnHAREKETLER.setOnClickListener {
            intent = Intent(applicationContext, Mainhareketler::class.java)
            startActivity(intent)
        }


    }
}