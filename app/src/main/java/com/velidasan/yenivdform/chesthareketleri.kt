package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityChesthareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityMainBinding

class chesthareketleri : AppCompatActivity() {
    lateinit var  binding: ActivityChesthareketleriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChesthareketleriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btngerigel.setOnClickListener {
            intent = Intent(applicationContext, Mainvideooyna::class.java)
            startActivity(intent)

        }
    }
}