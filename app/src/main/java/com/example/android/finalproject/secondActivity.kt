package com.example.android.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class secondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val chosenLocationName = findViewById(R.id.idLocationName) as EditText
        val chosenType = findViewById(R.id.idType) as Spinner
        val chosenAddress = findViewById(R.id.idAddress) as EditText
        val chosenDate = findViewById(R.id.idDate) as EditText
        val chosenTime = findViewById(R.id.idTime) as EditText
        val btnNext = findViewById(R.id.btnNext) as Button

        btnNext.setOnClickListener{
            if (checkData()){
                val nextScreen = Intent(this@secondActivity, thirdActivity::class.java)
                nextScreen.putExtra("LocationName", chosenLocationName.text.toString())
                nextScreen.putExtra("Address", chosenAddress.text.toString())
                nextScreen.putExtra("Date", chosenDate.text.toString())
                nextScreen.putExtra("Time", chosenTime.text.toString())

                //Start Activity
            startActivity(nextScreen)
            }
        }
    }

    private fun checkData():Boolean {
        val chosenLocationName = findViewById(R.id.idLocationName) as EditText
        val chosenAddress = findViewById(R.id.idAddress) as EditText
        val chosenDate = findViewById(R.id.idDate) as EditText
        val chosenTime = findViewById(R.id.idTime) as EditText

        if(chosenLocationName.text.toString().isEmpty())
        {
            chosenLocationName.error = "Invalid Location Name"
            chosenLocationName.requestFocus()
            return false
        }

        if(chosenAddress.text.toString().isEmpty())
        {
            chosenAddress.error = "Invalid Address"
            chosenAddress.requestFocus()
            return false
        }

        if(chosenDate.text.toString().isEmpty())
        {
            chosenDate.error = "Invalid Date"
            chosenDate.requestFocus()
            return false
        }

        if(chosenTime.text.toString().isEmpty())
        {
            chosenTime.error = "Invalid Time"
            chosenTime.requestFocus()
            return false
        }
        return true
    }
}
