package namnh.android.deeplinksample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        val textView = findViewById<AppCompatTextView>(R.id.tvInfo)
        val data = intent?.data
        if (data == null) {
            textView.text = "Come from MainActivity"
        } else {
            textView.text =
                "Welcome: ${data.getQueryParameter("userName").orEmpty()}"
        }
    }
}
