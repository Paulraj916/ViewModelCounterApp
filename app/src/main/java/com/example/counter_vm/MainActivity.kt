package com.example.counter_vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//SIMPLE VIEW MODEL AND LIVE DATA
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        val textView = findViewById<TextView>(R.id.tv1)
        val button = findViewById<TextView>(R.id.btn_cnt)

        //textView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        button.setOnClickListener {
//            ++count
//            textView.text = count.toString()
            viewModel.updateCount()
            //textView.text = viewModel.count.toString()
        }
    }
}