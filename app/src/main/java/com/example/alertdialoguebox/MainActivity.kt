package com.example.alertdialoguebox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{

            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure ?")
            builder1.setMessage("Do you want to close the app")
            builder1.setIcon(R.drawable.baseline_arrow_forward_ios_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener{ dialogInterface, i ->
                // What action should be performed when Yes is clicked?
                finish()
            })

            builder1.setNegativeButton("No",DialogInterface.OnClickListener{ dialogInterface, i ->
                // What action should be performed when No is clicked?
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener{
            val options = arrayOf("Gulab Jamun","Rasmalai" ,"Pineapple Pastry")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options,0) { dialog, which ->
                // what action to be performed when user clicks on any option ?
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            }
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener{ dialogInterface, i ->
                // What action should be performed when Yes is clicked?
            })

            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener{ dialogInterface, i ->
                // What action should be performed when No is clicked?
            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmalai", "Pineapple Pastry")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your favourite sweet?")
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener{dialog, which, isChecked ->
                // what action to be performed when user clicks on any option ?
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // What action should be performed when Yes is clicked?
                })

            builder3.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // What action should be performed when No is clicked?
                })
            builder3.show()

        }
    }
}