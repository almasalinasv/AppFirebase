package com.example.appfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("ejemplo").child("1").setValue(Card("1","rojo","corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("2","negro","corazones"))
        myRef.child("ejemplo").child("3").setValue(Card("3","rojo","corazones"))

        myRef.child("ejemplo").child("3").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }



        ///////////////////Usuarios//////////////////////////////////////////////////////////

        myRef.child("usuarios").child("1").setValue(Usuarios("Alma","21","Mujer"))
        myRef.child("usuarios").child("2").setValue(Usuarios("Rebeca","23","Mujer"))
        myRef.child("usuarios").child("3").setValue(Usuarios("Artemio","32","Hombre"))

        myRef.child("usuarios").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

    }
}