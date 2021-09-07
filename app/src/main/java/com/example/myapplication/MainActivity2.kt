package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import kotlin.math.abs

class MainActivity2 : AppCompatActivity(), GestureDetector.OnGestureListener{

    lateinit var  gestureDetector: GestureDetector

    var x2: Float = 0.0f
    var x1: Float = 0.0f
    var y2: Float = 0.0f
    var y1: Float = 0.0f

    companion object{
        const val  MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        gestureDetector= GestureDetector(this,this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        when (event?.action){

            //when we start to swipe
            0->
            {
                x1 = event.x
                y1 = event.y
            }

            //when we end the swipe
            1->
            {
                x2 = event.x
                y2 = event.y

                val valueX:Float=x2-x1
                val valueY:Float=y2-y1

                if (abs(valueX) > MIN_DISTANCE)
                {
                    //detect right side swipe
                    if (x2 > x1)
                    {
                        onBackPressed()
                        //Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        //detect left side swipe
                        Toast.makeText(this,"Left swipe", Toast.LENGTH_SHORT).show()
                    }
                }
                else if (abs(valueY) > MIN_DISTANCE)
                {
                    //detect top to bottom swipe
                    if (y2 > y1)
                    {
                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
                    }
                    //detect bottom to top swipe
                    else
                    {
                        Toast.makeText(this, "Top swipe", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        return super.onTouchEvent(event)
    }

    override fun onBackPressed() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
    }


    override fun onShowPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

}