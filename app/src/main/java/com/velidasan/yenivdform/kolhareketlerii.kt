package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityBackhareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityKolhareketleriiBinding

class kolhareketlerii : AppCompatActivity() {
    lateinit var  binding:ActivityKolhareketleriiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKolhareketleriiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btngerigel4.setOnClickListener {
            intent = Intent(applicationContext, Mainvideooyna::class.java)
            startActivity(intent)

        }

    }
}