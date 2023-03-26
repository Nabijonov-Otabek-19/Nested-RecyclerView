package uz.gita.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.nestedrecyclerview.R
import uz.gita.nestedrecyclerview.model.ImageData

class ImageAdapter(private val list: List<ImageData>) :
    RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    private var onItemClicked: ((title: String) -> Unit)? = null

    inner class ImageHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage: ImageView = view.findViewById(R.id.item_image)
        private val itemTitle: TextView = view.findViewById(R.id.item_title)

        init {
            view.setOnClickListener {
                onItemClicked?.invoke(list[adapterPosition].title)
            }
        }

        fun bind() {
            list[adapterPosition].apply {
                itemImage.setImageResource(this.image)
                itemTitle.text = this.title

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImageHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind()
    }

    fun setListener(listener: (String) -> Unit){
        this.onItemClicked = listener
    }
}