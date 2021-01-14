package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Siddhant Dua")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        //findViewById<Button>(R.id.done_button).setOnClickListener{
          //  addnickname(it)
        //}
        binding.doneButton.setOnClickListener{
            addnickname(it)
        }
    }

    private  fun addnickname(view: View){

        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
binding.apply {
    //binding.nicknameText.text = binding.nicknameEdit.text
    myName?.nickname = nicknameEdit.text.toString()
    invalidateAll()
    binding.nicknameEdit.visibility = View.GONE
    doneButton.visibility = View.GONE
    nicknameText.visibility = View.VISIBLE
}
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}