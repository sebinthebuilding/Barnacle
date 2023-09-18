package dapp.barnacle

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val holdingsButton: Button = findViewById(R.id.holdings_button);
        holdingsButton.setOnClickListener {
            Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show()
        }
    }
}