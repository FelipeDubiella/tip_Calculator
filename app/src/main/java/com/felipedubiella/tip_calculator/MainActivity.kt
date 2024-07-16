package com.felipedubiella.tip_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.felipedubiella.tip_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {

            btnCalculate.setOnClickListener {

                val totalBill: String = edtTotalBill.text.toString()
                val split: String = edtsplit.text.toString()
                var percentage = 0f

                if (rbOptionOne.isChecked){
                    percentage = 10f
                }else if (rbOptionTwo.isChecked){
                    percentage = 15f
                }else if (rbOptionThree.isChecked){
                    percentage = 20f
                }


                val intent = Intent(this@MainActivity, resultActivity::class.java)

                if (totalBill.isNotEmpty() && split.isNotEmpty()) {
                    intent.putExtra("totalBill", totalBill.toFloat())
                    intent.putExtra("percentage", percentage.toFloat())
                    intent.putExtra("split", split.toFloat())
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Fill all the fields to calculate",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }


        }


    }
}
