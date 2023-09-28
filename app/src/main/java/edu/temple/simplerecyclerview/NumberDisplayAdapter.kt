import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberDisplayAdapter(
    private val numbers: Array<Int>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    inner class NumberViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        val textView = layout.findViewById<TextView>(R.id.textView)

        init {
            textView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(numbers[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }
}
