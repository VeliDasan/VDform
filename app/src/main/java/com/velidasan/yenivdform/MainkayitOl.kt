package com.velidasan.yenivdform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.velidasan.yenivdform.databinding.ActivityMainkayitOlBinding

class MainkayitOl : AppCompatActivity() {
    lateinit var binding: ActivityMainkayitOlBinding
    private lateinit var auth: FirebaseAuth
    var database: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainkayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("kullaniciler")
        super.onCreate(savedInstanceState)


        binding.btnkaydet.setOnClickListener {
            var uyeadsoyad=binding.adsoyad.text.toString()
            var uyemail = binding.kayitemail.text.toString()
            var uyeparola = binding.kayitParola.text.toString()

            if (TextUtils.isEmpty(uyemail)) {
                binding.kayitemail.error = "Lütfen mail adresinizi giriniz"
                return@setOnClickListener
            } else if (TextUtils.isEmpty(uyeparola)) {
                binding.kayitParola.error = "Lütfen parola adresinizi giriniz"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(uyeadsoyad)){
                binding.adsoyad.error = "Lütfen ad soyad giriniz"
                return@setOnClickListener
            }



                auth.createUserWithEmailAndPassword(uyemail,uyeparola)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful)
                        {
                            // kullanıcı bilgilerini alalım.
                            var currentUser = auth.currentUser
                            // id'sini alıp o id adı altında adımızı ve soyadımızı kaydedelim.
                            var currentUserDb=currentUser?.let { it1 ->databaseReference?.child(it1.uid) }
                            currentUserDb?.child("adisoyadi")?.setValue(binding.adsoyad.text.toString())


                            Toast.makeText(this@MainkayitOl,"Kayıt Başarılı",Toast.LENGTH_LONG).show()




                        }
                        else
                        {
                            Toast.makeText(this@MainkayitOl,"Kayıt Hatalı",Toast.LENGTH_LONG).show()
                        }
                    }

            }


        /*
        super.onCreate(savedInstanceState)
        val binding=ActivityMainkayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnkaydet.setOnClickListener {
            var kullanicibilgisi=binding.kayitKullaniciAdi.text.toString()
            var kullaniciparola=binding.kayitParola.text.toString()

            var SharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor=SharedPreferences.edit()

            //veri ekleme
            editor.putString("kullanici","$kullanicibilgisi").apply()
            editor.putString("parola","$kullaniciparola").apply()
            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()
        }
*/
        binding.btngirisedon.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

    }
}