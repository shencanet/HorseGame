package com.produccioneslavaca.horsegame

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.graphics.Point
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var cellSelected_x = 0
    private var cellSelected_y = 0
    private var options = 0
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
        board[x][y] = 1
        paintHorseCell(cellSelected_x, cellSelected_y, "previous_cell")

        cellSelected_x = x
        cellSelected_y = y

        paintHorseCell(x, y, "selected_cell")

        checkOptions(x, y)
    }

    // ... (rest of the code remains unchanged)

    private fun paintHorseCell(x: Int, y: Int, color: String) {
        val iv: ImageView = findViewById(resources.getIdentifier("c$x$y", "id", packageName))
        iv.setBackgroundColor(ContextCompat.getColor(this, resources.getIdentifier(color, "color", packageName)))
        // Make sure to have the image resource "giphy" available in your resources
        iv.setImageResource(R.drawable.giphy)
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
}

