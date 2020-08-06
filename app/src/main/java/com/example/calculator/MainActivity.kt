package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberClick(view: View){
        //val entryData= etShowNumber.text.toString()
        if(isScreenReset){
            etShowNumber.setText("")
        }
        isScreenReset=false
        val btnSelect = view as Button
        var onScreenValue = etShowNumber.text.toString()

        when(btnSelect.id){
            R.id.btn0->{
                onScreenValue+="0"
            }
            R.id.btn1->{
                onScreenValue+="1"

            }
            R.id.btn2->{
                onScreenValue+="2"

            }
            R.id.btn3->{
                onScreenValue+="3"

            }
            R.id.btn4->{
                onScreenValue+="4"

            }
            R.id.btn5->{
                onScreenValue+="5"

            }
            R.id.btn6->{
                onScreenValue+="6"
            }
            R.id.btn7->{
                onScreenValue+="7"

            }
            R.id.btn8->{
                onScreenValue+="8"

            }
            R.id.btn9->{
                onScreenValue+="9"

            }
            R.id.btnPoint->{
                onScreenValue+="."
            }
            R.id.btnPlusOrMinus->{
                onScreenValue = "-"+onScreenValue
            }

        }
        etShowNumber.setText(onScreenValue)
    }
    var screenValue1 =""
    var arithmetic = ""
    var isScreenReset=false

    fun btnArithmetic(view: View){
        var btnSelect = view as Button
        when(btnSelect.id){
            R.id.btnAddition->{
                arithmetic ="+"
                screenValue1=etShowNumber.text.toString()
                isScreenReset=true
            }
            R.id.btnSubtract->{
                arithmetic="-"
                screenValue1+=etShowNumber.text.toString()
                isScreenReset=true
            }
            R.id.btnMultiply->{
                arithmetic = "*"
                screenValue1=etShowNumber.text.toString()
                isScreenReset=true
            }
            R.id.btnDivide->{
                arithmetic = "/"
                screenValue1=etShowNumber.text.toString()
                isScreenReset=true
            }
        }
    }
    fun result(view:View){
       var screenValue2= etShowNumber.text.toString().toDouble()
        var operation:Double=0.0;
        when(arithmetic){
            "+" -> operation = screenValue1.toDouble() + screenValue2
            "-" -> operation = screenValue1.toDouble() - screenValue2
            "*" -> operation = screenValue1.toDouble() * screenValue2
            "/" -> operation = screenValue1.toDouble() / screenValue2
        }
        etShowNumber.setText(operation.toString())
        isScreenReset=true
    }
    fun percentage(view: View){
        var percent:Double= etShowNumber.text.toString().toDouble()/100
        etShowNumber.setText(percent.toString())
        isScreenReset=true
    }

    fun screenReset(view: View){
    etShowNumber.setText("0")
        isScreenReset=true
    }
}