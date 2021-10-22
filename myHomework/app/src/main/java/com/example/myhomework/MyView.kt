package com.example.myhomework

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView : View {
    var rect:Int=0;
    var xEvent:Float=0F;
    var yEvent:Float=0F
    val paint= Paint();
    constructor(context: Context,attrs: AttributeSet):super(context,attrs)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color= Color.BLUE
        if(rect===0)
            canvas?.drawCircle(xEvent,yEvent,50F,paint)
        else if(rect===1){
            var path=Path()
            path.moveTo(xEvent,yEvent)
            path.lineTo(xEvent-50F,yEvent)
            path.lineTo(xEvent,yEvent+50F)
            path.lineTo(xEvent,yEvent)
            path.close()
            path.fillType=Path.FillType.EVEN_ODD
            canvas?.drawPath(path,paint);
        }
        else
            canvas?.drawRect(xEvent+50F,yEvent+50F,xEvent-50F,yEvent-50F,paint)
         }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action==MotionEvent.ACTION_DOWN){
            rect=(Math.random()*3).toInt()
            xEvent=event.x
            yEvent=event.y
            invalidate()


            performClick()
            return true
        }
        return super.onTouchEvent(event)
    }
}