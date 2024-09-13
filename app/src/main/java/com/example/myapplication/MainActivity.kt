package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var HelloM = findViewById<TextView>(R.id.HelloMain)
        var Col: Int = 10;

        var editName : EditText = findViewById(R.id.editTextName)
        var editGroup : EditText = findViewById(R.id.editTextGroup)
        var NameV: TextView = findViewById(R.id.NameView)
        var GroupV: TextView = findViewById(R.id.GroupView)
        var SName : String = "0"
        var SGroup : String = "0"

        var ButtonM: Button = findViewById(R.id.buttonMain)
        var SaveData: SharedPreferences? = null
        SaveData = getSharedPreferences("Table", Context.MODE_PRIVATE)
        Col = SaveData?.getInt("Col",0)!!
        SName = SaveData?.getString("SName","0")!!
        SGroup = SaveData?.getString("SGroup","0")!!
        NameV.text = SName
        GroupV.text = SGroup
        HelloM.text = ("Hello World" + " " + Col.toString())


        fun saveData(res: Int, SresName: String , SresGroup : String)
        {
            val editor = SaveData?.edit()
            editor?.putInt("Col", res)
            editor?.putString("SName", SresName)
            editor?.putString("SGroup", SresGroup)
            editor?.apply()
        }


        ButtonM.setOnClickListener()
        {
            Col++
            HelloM.text = ("Hello World" + " " + Col.toString())

            SName = editName.text.toString()
            NameV.text = SName

            SGroup = editGroup.text.toString()
            GroupV.text = SGroup

            saveData(Col, SName, SGroup)
        }

    }
}