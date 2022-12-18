package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityMainBinding
import com.velidasan.yenivdform.databinding.ActivityMainhareketlerBinding

class Mainhareketler : AppCompatActivity() {
    lateinit var  binding:ActivityMainhareketlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainhareketlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chest.setOnClickListener {
            intent= Intent(applicationContext,chesthareketleri::class.java)
            startActivity(intent)
        }
        binding.shoulders.setOnClickListener {
            intent= Intent(applicationContext,shoulderhareketleri::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            intent= Intent(applicationContext,backhareketleri::class.java)
            startActivity(intent)
        }
        binding.arms.setOnClickListener {
            intent= Intent(applicationContext,kolhareketlerii::class.java)
            startActivity(intent)
        }
        binding.legs.setOnClickListener {
            intent= Intent(applicationContext,leghareketleri::class.java)
            startActivity(intent)
        }
        binding.abs.setOnClickListener {
            intent= Intent(applicationContext,abshareketleri::class.java)
            startActivity(intent)
        }
        binding.btnhosgeldinizegit.setOnClickListener {
            intent= Intent(applicationContext,Mainhosgeldiniz::class.java)
            startActivity(intent)
        }



    }

}