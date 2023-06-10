package com.thameem.learningprocess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thameem.learningprocess.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }
    private fun calculateTip(){
        val cost=binding.etCostofServiceEditText.text.toString().toDoubleOrNull()
        if(cost==null||cost==0.0){
displayTip(0.0)
            return
        }
        val tipPercentage=when(binding.tipOptions.checkedRadioButtonId){
            R.id.amazing->0.20
            R.id.good->0.15
            else->0.10
        }
        var tip=cost*tipPercentage
        if(binding.roundSwitch.isChecked){
             tip = kotlin.math.ceil(tip)
        }
displayTip(tip)
    }
    private fun displayTip(tip: Double){
        val formattedTip=NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_amount,formattedTip)
    }
}