package basicsolutionsoftware.com.emvdecriptclip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startCountDown()
    }

    fun startCountDown(){
        object : CountDownTimer(2000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

            }
        }.start()
    }

}
