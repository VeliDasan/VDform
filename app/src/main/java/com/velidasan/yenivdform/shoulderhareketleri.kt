package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityChesthareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityShoulderhareketleriBinding

class shoulderhareketleri : AppCompatActivity() {
    lateinit var  binding: ActivityShoulderhareketleriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShoulderhareketleriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btngerigel2.setOnClickListener {
            intent = Intent(applicationContext, Mainvideooyna::class.java)
            startActivity(intent)

        }

    }
}