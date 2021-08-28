package namnh.android.deeplinksample

import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.dynamiclinks.ktx.shortLinkAsync
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val edtQuery: AppCompatEditText by lazy {
        findViewById(R.id.edtQueryName)
    }
    private val tvLink: AppCompatTextView by lazy {
        findViewById(R.id.tvLink)
    }
    private val btnGenerateDynamicLink: Button by lazy {
        findViewById(R.id.btnGenerateDynamicLink)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGenerateDynamicLink.setOnClickListener {
            generateDynamicLinks()
        }
    }

    private fun generateDynamicLinks() {
        var query = edtQuery.text?.toString()
        if (query.isNullOrBlank()) {
            query = "Dynamic Link"
        }
        Firebase.dynamicLinks.shortLinkAsync { // or Firebase.dynamicLinks.shortLinkAsync
            link = Uri.parse("https://namnh-0652.github.io/profile?userName=$query")
            domainUriPrefix = "https://mobilesetup.page.link"
            androidParameters {
                minimumVersion = 1
                // if app is not installed, go to this url instead of PlayStore
                fallbackUrl = Uri.parse("https://namnh-0652.github.io/")
            }

        }.addOnSuccessListener {
            tvLink.apply {
                text = it.shortLink?.toString()
                movementMethod = LinkMovementMethod.getInstance()
                Linkify.addLinks(this, Linkify.ALL)
                setTextIsSelectable(true)
                Log.i("MainActivity", "Generated link $text")
            }
        }.addOnFailureListener {
            tvLink.text = it.message
        }
    }
}
