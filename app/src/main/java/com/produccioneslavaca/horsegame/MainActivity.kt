package com.produccioneslavaca.horsegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initScreenGame()
        setFirstPosistion()


    }

    private fun setFirstPosition(){
        var x = 0
        var y = 0
        x = (0..7).random()
        y = (0..7).randorm()
        selectCell(x , y)
        
    }
    private fun selectCell(x: Int, y: Int){
        paintHorseCell(x, y, "selected_cell")
    }

    private fun paintHorseCell(){
        var iv: ImageView = findViewById(resources.getIdentifier("c$x$y","id" , packageName))
        iv.setBackgroundColor(ContextCompat.getColor(this, resources.getIdentifier(color, "color", packageName)))
        iv.setImageResource(R.drawable.giphy)
    }
    

    private fun initScreenGame(){
        setSizeBoard()
        hide_message()

    }


    private fun setSizeBoard(){
        var iv: ImageView
        val display = windowManager.defaultDisplay
        val size = point()
        display.getsize(size)
        val widht = size.x
        val width_dp = (width / getResources().getDisplayMetrics().density)
        val lateralMarginDP = 0
        val widht_cell (width_dp - lateralMarginsDP)/8
        val height_cell = widht_cell

        
        for (i in 0..7){
            for(j in 0..7){
                iv = findViewById(resources.getIdentifier("c$i$j","id" , packageName))
                var height = TypedValue.applyDimension(TypeValue.COMPLEX_UNIT_DIP, height_cell, getResources().getDisplayMetrics()).toInt()
                var width  = TypedValue.applyDimension(TypeValue.COMPLEX_UNIT_DIP, height_cell, getResources().getDisplayMetrics()).toInt()
                iv.setLayoutParams(TableRow.layoutParams(width, height))

            }
        }

    }

    private fun hide_message(){
        var lyMessage = findViewById<LinearLayout>(R.id.lyMessage)
        lyMessage.visibility = View.INVISIBLE
    }
}
