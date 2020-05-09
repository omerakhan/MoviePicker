package com.omerkhan.moviepicker

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = arrayListOf<String>()
        decideBtn.setOnClickListener {

            if(movieList.isEmpty()){
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("No Movie :(")
                builder.setMessage("Please add a movie first!")

                builder.setPositiveButton("Ok"){_,_ ->

                }

                val dialog: AlertDialog = builder.create()

                dialog.show()
            }
            else{
                val random = Random()
                val randFood = random.nextInt(movieList.count())
                selectedMovie.text = movieList[randFood]
            }

        }

        addFoodBtn.setOnClickListener{
            val newFood = addMovie.text.toString()
            movieList.add(newFood)
            addMovie.text.clear()
        }
    }
}
