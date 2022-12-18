package com.velidasan.yenivdform

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.velidasan.yenivdform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()



        //Giriş yap butonuna tıklandığında
        binding.btngirisyap.setOnClickListener {
            var girisemail = binding.girisEmail.text.toString()
            var girissifre = binding.girisParola.text.toString()

            if (TextUtils.isEmpty(girisemail)) {
                binding.girisEmail.error = "Lütfen email adresinisi yazınız."
                return@setOnClickListener
            } else if (TextUtils.isEmpty(girissifre)) {
                binding.girisParola.error = "Lütfen şifrenizi yazınız."
                return@setOnClickListener
            }


            //Giriş bilgilerimizi doğrulayıp giriş yapıyoruz.
            auth.signInWithEmailAndPassword(girisemail, girissifre).addOnCompleteListener(this) {
                if (it.isSuccessful) {

                    if (girisemail=="veli6343@hotmail.com"&&girissifre=="veli6343")
                    {
                        intent = Intent(applicationContext, MainAdminsayfasi::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        intent = Intent(applicationContext, Mainhosgeldiniz::class.java)
                        startActivity(intent)
                        finish()
                    }


                } else {
                    Toast.makeText(
                        applicationContext,
                        "Şifre ya da E-mail yanlış.",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
        // Kayit olma sayfasına gitmek için.
        binding.btnkayTol.setOnClickListener {
            intent = Intent(applicationContext, MainkayitOl::class.java)
            startActivity(intent)

        }


        /*
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)

        binding.btngirisyap.setOnClickListener {
            var kayitlikullanici = preferences.getString("kullanici", "")
            var kayitliparola = preferences.getString("parola", "")

            var giriskullanici = binding.girisEmail.text.toString()
            var girisparola = binding.girisParola.text.toString()

            if ((kayitlikullanici == giriskullanici) && (kayitliparola == girisparola)) {
                intent = Intent(applicationContext, Mainhosgeldiniz::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext, "Giriş Bilgileri Hatalı", Toast.LENGTH_LONG)
                    .show()


            }

        }
        binding.btnkayTol.setOnClickListener{
            intent=Intent(applicationContext,MainkayitOl::class.java)
            startActivity(intent)
        }
    }
    */
    }
}

