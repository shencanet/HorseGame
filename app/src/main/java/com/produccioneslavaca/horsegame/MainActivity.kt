package com.produccioneslavaca.horsegame

import android.graphics.Point
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var cellSelected_x = 0
    private var cellSelected_y = 0
    private var options = 0
    private var movesRequired = 4
    private var moveoptions = 64
    private lateinit var board: Array<IntArray>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initScreenGame()
        resetboard()
        setFirstPosition()
    }

    private fun checkCellClicked(v: View) {
        val name = v.tag.toString()
        val x = name.subSequence(1, 2).toString().toInt()
        val y = name.subSequence(2, 3).toString().toInt()

        checkCell(x, y)
    }

    private fun checkCell(x: Int, y: Int) {
        var dif_x = x - cellSelected_x
        var dif_y = y - cellSelected_y
        var checkTrue = false

        if (dif_x == 1 && dif_y == 2) checkTrue = true //right top long
        if (dif_x == 1 && dif_y == -2) checkTrue = true //right bottom long
        if (dif_x == 2 && dif_y == 1) checkTrue = true //right long top
        if (dif_x == 2 && dif_y == -1) checkTrue = true //right long bottom
        if (dif_x == -1 && dif_y == 2) checkTrue = true //lef top long
        if (dif_x == -1 && dif_y == -2) checkTrue = true //left bottom long
        if (dif_x == -2 && dif_y == 1) checkTrue = true //left long top
        if (dif_x == -2 && dif_y == -1) checkTrue = true //left long bottom

        if (board[x][y] == 1) checkTrue = false
        if (checkTrue) selectCell(x, y)
    }

    private fun selectCell(x: Int, y: Int) {
        moves--
        var tvMovesData = findViewById<TextView>(R.id.tvMovesData)
        tvMovesData.text = moves.toString()
        board[x][y] = 1
        paintHorseCell(cellSelected_x, cellSelected_y, "previous_cell")

        cellSelected_x = x
        cellSelected_y = y
        clearOptions()
        paintHorseCell(x, y, "selected_cell")

        checkOptions(x, y)

        if (moves > 0 ){
            checkNewBonus()
         //   checkGameOver(x, y)
        }
       // else checkSucessfulEnd()
    }

    private fun checkNewBonus()  {
        if(moves%movesRequired == 0){
            var bonusCell_x = 0
            var bonusCell_Y = 0
            var bonuscell = false
            while (bonuscell == false) {
                bonusCell_x = (0..7).random()
                bonusCell_Y = (0..7).random()
            }
            
        }
    }
    

    private fun clearOption(x:Int, y:Int){
        var : iv ImageView = findViewById(resources.getIdentifier("c$x$y", "id", packageName))
        if(checkColorCell(x, y) == "black")
        iv.setBackgroundColor(ContextCompat.getColor(this,
        resources.getIdentifier(nameColorBlack, "color", packageName)))
        else
        iv.setBackgroundColor(ContextCompat.getColor(this, 
        resources.getIdentifier(nameColorBalck, "color", packaheName)))
        if (board[x][y] == 1 ) iv.setBackgroundColor(this, 
        resources.getIdentifier("previous-cell", "color"))
    }

    private fun clearOptions(){
        for (i in 0..7){
            for(j in 0..7){
                if (board[i][j] == 9 || board[i][j] == 2){
                    if(board[i][j] == 9 ) board [i][j] = 0
                    clearOptions(i, j)
                }
            }
        }
    }

    private fun checkOptions(x: Int, y: Int) {
        options = 0
        checkMove(x, y, 1, 2) //check move right - top long
        checkMove(x, y, 2, 1) //check move right long -top
        checkMove(x, y, 1, -2)//check move  right - bottom long
        checkMove(x, y, 2, -1)//check move right -long - bottom
        checkMove(x, y, -1, 2)//check move  left -top long
        checkMove(x, y, -2, 1)//check move left -long top
        checkMove(x, y, -1, -2)//check move left - bottom long
        checkMove(x, y, -2, -1)//check move left long - bottom
    }

    private fun checkMove(x: Int, y: Int, mov_x: Int, mov_y: Int) {
        var option_x = x + mov_x
        var option_y = y + mov_y

        if (option_x >= 0 && option_y >= 0 && option_x < 8 && option_y < 8) {
            if (board[option_x][option_y] == 0 || board[option_x][option_y] == 2) {
                options++
                paintOptions(option_x, option_y)
                board[option_x][option_y] = 9
            }
        }
    }


    private fun checkColorCell(x: Int , y: Int): String {
        var color =""
        var blackColumn_x = arrayOf(0,2,4,6)
        var blackRow_x = arrayOf(1,3,5,7)
        if((blackColumn_x.contains(x) && blackColumn_x.contains(y))
          || (blackRow_x.contains(x) &&blackRows_x.contains(y)))
        color="black"
        else color= "white"
        return color
    }
private fun paintOptions(x:Int, y:Int){
    var iv:ImageView = findViewById(resources.getIdenteifier("c$x$y, Id, packageName"))
    if ()iv.setbackgroundResource(R.drawable.option_black)
    else iv.setBackgroundResource(R.drawable.option_black)
    
}
    
    private fun paintHorseCell(x: Int, y: Int, color: String) {
        val iv: ImageView = findViewById(resources.getIdentifier("c$x$y", "id", packageName))
        iv.setBackgroundColor(ContextCompat.getColor(this, resources.getIdentifier(color, "color", packageName)))
        // Make sure to have the image resource "giphy" available in your resources
        iv.setImageResource(R.drawable.giphy)
    }

    private fun resetboard() {
        board = Array(8) { IntArray(8) { 0 } }
    }

    private fun setFirstPosition() {
        var x = 0
        var y = 0

        x = (0..7).random()
        y = (0..7).random()
        cellSelected_x = x
        cellSelected_y = y
        selectCell(x, y)
    }

    private fun paintOptions(x:Int, y:Int){
    var iv:ImageView = findViewById(resources.getIdenteifier("c$x$y, Id, packageName"))
    if (checkColorCell(x, y) == "black")iv.setbackgroundResource(R.drawable.option_black)
    else iv.setBackgroundR esource(R.drawable.option_black)
    
}

    private fun initScreenGame() {
        setSizeBoard()
        hide_message()
    }

    private fun setSizeBoard() {
        var iv: ImageView
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        val width_dp = (width / resources.displayMetrics.density)
        val lateralMarginDP = 0
        val width_cell = (width_dp - lateralMarginDP) / 8
        val height_cell = width_cell

        for (i in 0..7) {
            for (j in 0..7) {
                iv = findViewById(resources.getIdentifier("c$i$j", "id", packageName))
                val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height_cell, resources.displayMetrics).toInt()
                val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width_cell, resources.displayMetrics).toInt()
                iv.layoutParams = LinearLayout.LayoutParams(width, height)
            }
        }
    }

    private fun hide_message() {            
        val lyMessage = findViewById<LinearLayout>(R.id.lyMessage)
        lyMessage.visibility = View.INVISIBLE
    }
}


