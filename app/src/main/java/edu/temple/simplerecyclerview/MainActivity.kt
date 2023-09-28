import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.simplerecyclerview.NumberDisplayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView display responsibility
        val numbers = Array(100) { it + 1 }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        recyclerView.layoutManager = GridLayoutManager(this, 4)

        // Define a lambda to modify displayTextView size
        val modifyDisplayText: (Int) -> Unit = { clickedNumber ->
            displayTextView.text = "Clicked number: $clickedNumber"
        }

        // Pass the lambda to the adapter
        recyclerView.adapter = NumberDisplayAdapter(numbers, modifyDisplayText)
    }
}
