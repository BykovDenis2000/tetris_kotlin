package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.myfirstapplication.storage.AppPreferences
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    var tvHighScore : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnExit: Button = findViewById<Button>(R.id.btn_exit)
        val btnNewGame: Button = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore: Button = findViewById<Button>(R.id.btn_reset_score)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)
        btnExit.setOnClickListener(this::handleExitEvent)
        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnResetScore.setOnClickListener(this::onBtnResetScoreClick)
    }
    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view,"Score successfully reset",Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text = "High score= ${preferences.getHighScore()}"
    }
    private fun handleExitEvent(view: View){
        exitProcess(0)
    }
    private fun onBtnNewGameClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}