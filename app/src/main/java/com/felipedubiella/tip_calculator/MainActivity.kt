package com.felipedubiella.tip_calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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


            var numOfPeopleSelected = 0


            val adapter = ArrayAdapter.createFromResource(
                this@MainActivity,
                R.array.num_people,
                android.R.layout.simple_spinner_item
            )

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSplit.adapter = adapter

            spinnerSplit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    numOfPeopleSelected = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }


            }

            btnCalculate.setOnClickListener {

                var split: Float = numOfPeopleSelected.toFloat()
                var percentage: Int = 0
                val totalBill: String = edtTotalBill.text.toString()

                if (rbOptionOne.isChecked) {
                    percentage = 10
                } else if (rbOptionTwo.isChecked) {
                    percentage = 15
                } else if (rbOptionThree.isChecked) {
                    percentage = 20
                }


                val intent = Intent(this@MainActivity, resultActivity::class.java)

                if (totalBill.isNotEmpty()) {
                    intent.putExtra("totalBill", totalBill.toFloat())
                    intent.putExtra("percentage", percentage.toFloat())
                    intent.putExtra("split", split)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.toast_warning),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


        }


    }


}

