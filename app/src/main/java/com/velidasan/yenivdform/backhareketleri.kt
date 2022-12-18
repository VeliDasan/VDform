package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityBackhareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityShoulderhareketleriBinding

class backhareketleri : AppCompatActivity() {
    lateinit var  binding: ActivityBackhareketleriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBackhareketleriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btngerigel3.setOnClickListener {
            intent = Intent(applicationContext, Mainvideooyna::class.java)
            startActivity(intent)

        }
    }
}