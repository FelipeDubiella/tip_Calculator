package com.felipedubiella.tip_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.felipedubiella.tip_calculator.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {

                val bundle = intent.extras
                if (bundle != null) {


                    val totalBill = bundle.getFloat("totalBill")
                    val percentage = bundle.getFloat("percentage")
                    val split = bundle.getFloat("split")

                    val percentageResult = (totalBill / split) * (percentage / 100)
                    val result = totalBill / split + percentageResult

                    tvTotalBill.text = "R$ $totalBill"
                    tvPercentage.text = "R$ $percentageResult"
                    tvTotalPerPerson.text = "R$ $result"


                    btnNewCalculate.setOnClickListener {
                    val intent = Intent(this@resultActivity, MainActivity::class.java)
                    startActivity(intent)

                }

            }


        }
    }
}
