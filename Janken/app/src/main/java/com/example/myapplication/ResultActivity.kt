package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    val gu = 0
    val choki = 1
    val  pa = 2
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("My_HAND",0)

        val myHand:Int
        myHand = when(id){
            R.id.gu -> {
                binding.myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki ->{
                binding.myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa ->{
                binding.myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else -> gu
        }
        // コンピューターの手を決める
        val comHand = (Math.random() *3).toInt()
        when(comHand){
            gu ->binding.comHandImage.setImageResource(R.drawable.com_gu)
            choki ->binding.comHandImage.setImageResource(R.drawable.com_choki)
            pa ->binding.comHandImage.setImageResource(R.drawable.com_pa)
        }

        //勝敗を判定する
        val gemeResult = (comHand-myHand+3) % 3
        when(gemeResult){
            0 -> binding.resultLabel.setText(R.string.result_draw)
            1 -> binding.resultLabel.setText(R.string.result_win)
            2 -> binding.resultLabel.setText(R.string.result_lose)
        }
        binding.backButton.setOnClickListener{finish()}
    }
}