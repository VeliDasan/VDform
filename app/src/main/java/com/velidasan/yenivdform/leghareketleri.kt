package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityBackhareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityLeghareketleriBinding

class leghareketleri : AppCompatActivity() {
    lateinit var  binding:ActivityLeghareketleriBinding
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                val binding = ActivityLeghareketleriBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.btngerigel5.setOnClickListener {
                    intent = Intent(applicationContext, Mainvideooyna::class.java)
                    startActivity(intent)

                }
    }
}