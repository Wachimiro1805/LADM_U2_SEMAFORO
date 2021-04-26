package mx.tecnm.tepic.ladm_u2_semaforo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity):View(p){

    var contador1 = 0
    var contador2 = 0
    var contador3 = 0
    var contador4 = 0
    var contador5 = 0
    var state = true
    var state2 = true
    var state3 = true
    var state4 = true





    override fun onDraw(c: Canvas) {

        var Thread = Hilo1(this)
        if (state){
            Thread.start()
            state = false
        }
        var HiloRojo = Hilo2(this)
        if (state2){
            HiloRojo.start()
            state2 = false
        }
        var HiloAmarillo = Hilo3(this)
        if (state3){
            HiloAmarillo.start()
            state3 = false
        }
        var HiloAzul = Hilo4(this)
        if (state4){
            HiloAzul.start()
            state4 = false
        }
        invalidate()



        super.onDraw(c)
        val p = Paint()

        c.drawColor(Color.WHITE)

        //CALLE
        //HORIZONTAL GRIS
        p.color = Color.GRAY
        c.drawRect(0f, 1200f, 1200f, 600f, p)
        //VERTICAL GRIS
        c.drawRect(300f, 0f, 750f, 2100f, p)

        //HORIZONTAL BLANCA
        p.color=Color.WHITE
        c.drawRect(50f,900f,250f,850f,p)
        c.drawRect(800f,900f,1000f,850f,p)
        //VERTICAL BLANCA
        c.drawRect(500f,50f,550f,200f,p)
        c.drawRect(500f,400f,550f,550f,p)
        c.drawRect(500f,1300f,550f,1450f,p)
        c.drawRect(500f,1650f,550f,1800f,p)

        //SEMAFORO ARRIBA
        p.color=Color.BLACK
        c.drawRect(80f,100f,200f,450f,p)
        p.color=Color.RED
        c.drawCircle(140f,160f,50f,p)
        p.color=Color.YELLOW
        c.drawCircle(140f,270f,50f,p)
        p.color=Color.GREEN
        c.drawCircle(140f,380f,50f,p)
        //SEMAFORO ABAJO
        p.color=Color.BLACK
        c.drawRect(850f,1400f,980f,1800f,p)
        p.color=Color.RED
        c.drawCircle(915f,1480f,50f,p)
        p.color=Color.YELLOW
        c.drawCircle(915f,1590f,50f,p)
        p.color=Color.GREEN
        c.drawCircle(915f,1700f,50f,p)

        //CARROS
        //1 Horizontal Arriba
        p.color=Color.GREEN
        c.drawRect(100f+contador1,700f,170f+contador1,780f,p)
        p.color=Color.BLACK
        c.drawRect(110f+contador1,690f,120f+contador1,700f,p)
        c.drawRect(110f+contador1,780f,120f+contador1,790f,p)
        c.drawRect(140f+contador1,690f,150f+contador1,700f,p)
        c.drawRect(140f+contador1,780f,150f+contador1,790f,p)
        p.color=Color.WHITE
        c.drawRect(150f+contador1,710f,160f+contador1,770f,p)
        //2 Horizontal Abajo
        p.color=Color.RED
        c.drawRect(900f-contador2,1000f,970f-contador2,1080f,p)
        p.color=Color.BLACK
        c.drawRect(910f-contador2,990f,920f-contador2,1000f,p)
        c.drawRect(910f-contador2,1080f,920f-contador2,1090f,p)
        c.drawRect(940f-contador2,990f,950f-contador2,1000f,p)
        c.drawRect(940f-contador2,1080f,950f-contador2,1090f,p)
        p.color=Color.WHITE
        c.drawRect(910f-contador2,1010f,920f-contador2,1070f,p)
        //1 Vertical Izquierda
        p.color=Color.YELLOW
        c.drawRect(350f,400f+contador3,420f,490f+contador3,p)
        p.color=Color.BLACK
        c.drawRect(340f,470f+contador3,350f,480f+contador3,p)
        c.drawRect(340f,430f+contador3,350f,440f+contador3,p)
        c.drawRect(420f,470f+contador3,430f,480f+contador3,p)
        c.drawRect(420f,430f+contador3,430f,440f+contador3,p)
        p.color=Color.WHITE
        c.drawRect(360f,470f+contador3,410f,480f+contador3,p)
        //2 Vertical Derecha
        p.color=Color.BLUE
        c.drawRect(600f,1400f-contador4,670f,1490f-contador4,p)
        p.color=Color.BLACK
        c.drawRect(590f,1470f-contador4,600f,1480f-contador4,p)
        c.drawRect(590f,1430f-contador4,600f,1440f-contador4,p)
        c.drawRect(670f,1470f-contador4,680f,1480f-contador4,p)
        c.drawRect(670f,1430f-contador4,680f,1440f-contador4,p)
        p.color=Color.WHITE
        c.drawRect(610f,1410f-contador4,660f,1420f-contador4,p)
    }

    class Hilo1(p:Lienzo):Thread(){
        var act = p
        override fun run() {
            super.run()
            while (true){
                if (act.contador1==1000){
                    act.contador1=-200
                }

                act.contador1+=5
                sleep(50)
                println(act.contador1)
                if (act.contador5==500){

                }

            }
        }
    }
    class Hilo2(p:Lienzo):Thread(){
        var act = p
        override fun run() {
            super.run()
            while (true){
                if (act.contador2==1000){
                    act.contador2=-200
                }
                act.contador2+=5
                sleep(50)
                println(act.contador2)
            }
        }
    }
    class Hilo3(p:Lienzo):Thread(){
        var act = p
        override fun run() {
            super.run()
            while (true){
                if (act.contador3==1600){
                    act.contador3=-600
                }
                act.contador3+=5
                sleep(15)
                println(act.contador3)
            }
        }
    }
    class Hilo4(p:Lienzo):Thread(){
        var act = p
        override fun run() {
            super.run()
            while (true){
                if (act.contador4==1600){
                    act.contador4=-600
                }
                act.contador4+=5
                sleep(25)
                println(act.contador4)
            }
        }
    }

}
