package com.velidasan.yenivdform

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.velidasan.yenivdform.databinding.ActivityMainhosgeldinizBinding

class Mainhosgeldiniz : AppCompatActivity() {
    lateinit var binding: ActivityMainhosgeldinizBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference?=null
    var database: FirebaseDatabase?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainhosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()
        databaseReference=database?.reference!!.child("kullaniciler")

        //Email bilgisini çekme
        var currentUser=auth.currentUser
        var userReference=databaseReference?.child(currentUser?.uid!!)
        userReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.kullaniciBilgisi.text = snapshot.child("adisoyadi").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        binding.btnCKSYap.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }

        binding.btndevam.setOnClickListener {
            intent= Intent(applicationContext,Mainvucutendeksi::class.java)
            startActivity(intent)
            finish()

        }
        binding.btnhesapsil.setOnClickListener{

            //Authentication kısmından verileri silme
            currentUser?.delete()?.addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(applicationContext,"Hesabınız Silindi",Toast.LENGTH_LONG).show()
                    auth.signOut()
                    startActivity(Intent(this@Mainhosgeldiniz,MainActivity::class.java))
                    finish()

                    //Realtime Database kısmından bilgileri silme
                    var currentUserDb=currentUser?.let { md1 ->databaseReference!!.child(md1.uid) }
                    currentUserDb?.removeValue()
                }
            }
            }





    }
}