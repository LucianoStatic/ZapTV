package ui

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.myapp.zaptv.R
import kotlinx.android.synthetic.main.activity_splash_screen.*


@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity(){

    private lateinit var lottieView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)

        lottieView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

                Log.d("AA", "animation start")
            }

            override fun onAnimationEnd(animation: Animator) {
                Log.d("AA", "end of animation")
            }

            override fun onAnimationCancel(animation: Animator) {
                Log.d("AA", "animation cancel")
            }

            override fun onAnimationRepeat(animation: Animator) {

                Log.d("AA", "animation executes attribute animation every time it is called")
            }
        })
    }


}