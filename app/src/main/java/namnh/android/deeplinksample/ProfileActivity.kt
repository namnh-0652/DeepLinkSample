package namnh.android.deeplinksample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

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
        if (intent == null || intent.data == null) {
            textView.text = "Come from MainActivity"
            return
        }
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                val data: Uri?
                if (pendingDynamicLinkData != null) {
                    data = pendingDynamicLinkData.link
                    textView.text =
                        "Welcome: ${data?.getQueryParameter("userName").orEmpty()}"
                } else {
                    textView.text = "No dynamic links received"
                }
            }
            .addOnFailureListener(this) {
                Log.e("Profile", "Can not access Firebase dynamic links")
                Toast.makeText(this, "An error occurs", Toast.LENGTH_SHORT).show()
            }
    }
}
