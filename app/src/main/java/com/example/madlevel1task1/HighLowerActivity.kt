package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HighLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    private var duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.equalsBtn.setOnClickListener{onEqualClick()}
        binding.higherBtn.setOnClickListener { onHigherClick() }
        binding.lowerBtn.setOnClickListener { onLowerClick() }
        updateUI()
    }

    private fun updateUI(){
        binding.lastThrowText.text = getString(R.string.lastThrowText, lastThrow)

        when (currentThrow) {
            1 -> binding.imageView.setImageResource(R.drawable.dice1)
            2 -> binding.imageView.setImageResource(R.drawable.dice2)
            3 -> binding.imageView.setImageResource(R.drawable.dice3)
            4 -> binding.imageView.setImageResource(R.drawable.dice4)
            5 -> binding.imageView.setImageResource(R.drawable.dice5)
            6 -> binding.imageView.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct), duration).show()
    }

    private fun onAnswerIncorrect(){
        Toast.makeText(this, getString(R.string.incorrect), duration).show()
    }

    private fun onHigherClick(){
        rollDice()
        if (currentThrow > lastThrow){
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }

    private fun onLowerClick(){
        rollDice()
        if (currentThrow < lastThrow){
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }

    private fun onEqualClick(){
        rollDice()
        if (currentThrow == lastThrow){
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }
}