package random.barnacle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LiquidityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liquidity)

        val tokensBtn = findViewById<Button>(R.id.tokens_button)
        val liquidityBtn = findViewById<Button>(R.id.liquidity_button)
        val holdingsBtn = findViewById<Button>(R.id.holdings_button)
        val analyticsBtn = findViewById<Button>(R.id.analytics_button)


        tokensBtn.setOnClickListener {
            intent = Intent(this, TokensActivity::class.java)
            startActivity(intent)
        }

        liquidityBtn.setOnClickListener {
            intent = Intent(this, LiquidityActivity::class.java)
            startActivity(intent)
        }

        holdingsBtn.setOnClickListener {
            intent = Intent(this, HoldingsActivity::class.java)
            startActivity(intent)
        }

        analyticsBtn.setOnClickListener {
            intent = Intent(this, AnalyticsActivity::class.java)
            startActivity(intent)
        }
    }
}