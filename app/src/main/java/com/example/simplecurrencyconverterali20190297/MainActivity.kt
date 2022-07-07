package com.example.simplecurrencyconverterali20190297
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val JOR: EditText = findViewById(R.id.JOR)
        val result: TextView = findViewById(R.id.Result)
        val spinnerVal: Spinner = findViewById(R.id.spinner)
        var options =
            arrayOf("Select a country","USA Dollar", "Euro", "Iraqi Dinar", "Egyptian Pound")
        var flag: String = "Country"
        spinnerVal.adapter =ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        button.setOnClickListener { view ->
            var x: Double = JOR.text.toString().toDouble()

            if (flag == "USA Dollar")
            {
                result.text = usaConvert(x).toString()
            }
           else if (flag == "Euro") {
                result.text = EuroConvert(x).toString()
            }
         else  if (flag == "Iraqi Dinar") {
                result.text = IraqConvert(x).toString()
            }
            else if (flag == "Egyptian Pound") {
                result.text = Egyptconvert(x).toString()

            }

            spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    flag = options.get(p2)
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }



            }
        }

    }
    public fun usaConvert(a: Double): Double {
        return a * 1.41
    }
    public fun EuroConvert(b: Double): Double {
        return b * 1.39
    }

    public fun IraqConvert(c: Double): Double {
        return c * 2058.33
    }

    public fun Egyptconvert(d: Double): Double {
        return d * 26.64
    }


}