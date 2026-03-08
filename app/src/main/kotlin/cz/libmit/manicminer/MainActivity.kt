package cz.libmit.manicminer

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val gameUrl = "https://manicminer.free"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            isVerticalScrollBarEnabled = false
            isHorizontalScrollBarEnabled = false
            webViewClient = GameWebViewClient()
        }

        setContentView(webView)
        loadGame()
    }

    private fun loadGame() {
        webView.loadUrl(gameUrl)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }

    private inner class GameWebViewClient : WebViewClient() {
        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {
            if (request.isForMainFrame) showError()
        }

        private fun showError() {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Cannot load game")
                .setMessage("Check your internet connection and try again.")
                .setPositiveButton("Try again") { _, _ -> loadGame() }
                .show()
        }
    }
}
