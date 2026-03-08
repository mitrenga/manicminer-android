package cz.libmit.manicminer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val minimumDisplayDuration = 1500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setBackgroundColor(android.graphics.Color.BLACK)

            val willyImage = ImageView(context).apply {
                setImageResource(R.drawable.willy)
                scaleType = ImageView.ScaleType.FIT_CENTER
                layoutParams = LinearLayout.LayoutParams(240.dp, 240.dp).apply {
                    bottomMargin = 48.dp
                }
            }

            val title = TextView(context).apply {
                text = "MANIC MINER"
                textSize = 32f
                setTextColor(android.graphics.Color.YELLOW)
                gravity = android.view.Gravity.CENTER
                typeface = android.graphics.Typeface.MONOSPACE
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 24.dp }
            }

            val author = TextView(context).apply {
                text = "Original game © 1983 Matthew Smith\nThis game is an unofficial remake."
                textSize = 14f
                setTextColor(android.graphics.Color.WHITE)
                gravity = android.view.Gravity.CENTER
                typeface = android.graphics.Typeface.MONOSPACE
            }

            addView(willyImage)
            addView(title)
            addView(author)
        }

        setContentView(layout)
        hideSystemUI()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, minimumDisplayDuration)
    }

    private val Int.dp: Int get() = (this * resources.displayMetrics.density).toInt()

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )
    }
}
