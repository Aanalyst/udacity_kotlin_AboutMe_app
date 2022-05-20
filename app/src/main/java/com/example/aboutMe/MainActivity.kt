package com.example.aboutMe

//import android.content.ActivityNotFoundException
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutMe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Ahmed Amin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName


        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //addName(it)
        //}
        binding.doneButton.setOnClickListener {
            addName(it)
        }
    }

    private fun addName(view: View) {
        //val editText = findViewById<EditText>(R.id.your_name_please)
        //val yourself = findViewById<TextView>(R.id.textView2)
        //val doneButton = findViewById<Button>(R.id.done_button)
        binding.apply {
            //*textView2.text = binding.yourNamePlease.text
            myName?.nickname = textView2.text.toString()
            invalidateAll()
            //yourNamePlease.visibility = View.GONE
            textView2.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
        }
        // Hide the keyboard.
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


