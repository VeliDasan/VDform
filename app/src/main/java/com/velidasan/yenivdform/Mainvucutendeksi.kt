package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
import com.velidasan.yenivdform.databinding.ActivityMainvucutendeksiBinding

class Mainvucutendeksi : AppCompatActivity() {
    private lateinit var binding: ActivityMainvucutendeksiBinding
    private lateinit var weightPicker: NumberPicker
    private lateinit var heightPicker: NumberPicker
    private lateinit var bmiResultTV: TextView
    private lateinit var healthyMessageTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainvucutendeksiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weightPicker = findViewById<NumberPicker>(R.id.weightPicker)
        heightPicker = findViewById<NumberPicker>(R.id.heightPicker)
        bmiResultTV= findViewById<TextView>(R.id.bmiResultTV)
        healthyMessageTV= findViewById<TextView>(R.id.healthyMessageTV)
        binding.btnhareketgec.setOnClickListener{
            intent= Intent(applicationContext,Mainhareketler::class.java)
            startActivity(intent)
        }

        weightPicker.minValue=30
        weightPicker.maxValue=150

        heightPicker.minValue=100
        heightPicker.maxValue=250
        //'weightPicker isimli companentin değeri değiştiğinde çalışan fonksiyon
        weightPicker.setOnValueChangedListener { _, _, _ ->

            calculateBMI()
        }

        //'heightPicker' isimli companentin değeri değiştiğinde çalışan fonksiyon
        heightPicker.setOnValueChangedListener {_,_,_ ->
            calculateBMI()
        }


    }
        private fun calculateBMI() {

            val height = heightPicker.value
            val doubleHeight = height.toDouble() / 100
            val weight = weightPicker.value
            val bmı = weight.toDouble() / (doubleHeight * doubleHeight)
            bmiResultTV.text = String.format(": %.2f", bmı)
            healthyMessageTV.text = String.format("Sağlık Durumu: %s", healthyMessageTV(bmı))
        }

    private fun healthyMessageTV(bmı: Double):String {
        if (bmı<18.5)
            return "Zayıf"
        if (bmı<25.0)
            return "Sağlıklı"
        if (bmı<30.0)
            return "Kilolu"
        return "Obez"
    }




}
