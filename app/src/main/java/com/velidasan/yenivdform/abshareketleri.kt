package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velidasan.yenivdform.databinding.ActivityAbshareketleriBinding
import com.velidasan.yenivdform.databinding.ActivityLeghareketleriBinding

class abshareketleri : AppCompatActivity() {
    lateinit var  binding:ActivityAbshareketleriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAbshareketleriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btngerigel6.setOnClickListener {
            intent = Intent(applicationContext, Mainvideooyna::class.java)
            startActivity(intent)

        }
    }
}