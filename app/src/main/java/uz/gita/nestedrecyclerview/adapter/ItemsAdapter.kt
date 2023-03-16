package uz.gita.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.gita.nestedrecyclerview.R
import uz.gita.nestedrecyclerview.model.ItemsData

class ItemsAdapter(private val list: List<ItemsData>) :
    RecyclerView.Adapter<ItemsAdapter.CategoryViewHolder>() {

    private var listener: ((String) -> Unit)? = null

    inner class CategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val category: TextView = view.findViewById(R.id.category)
        private val listProductView: RecyclerView = view.findViewById(R.id.horizontal_rv)

        fun bind() {
            list[adapterPosition].apply {
                val adapter = ImageAdapter(this.items)
                adapter.setListener {
                    listener?.invoke(it)
                }
                listProductView.adapter = adapter
                listProductView.layoutManager =
                    LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

                category.text = this.categoryName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vertical_item, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind()
    }

    fun setListener(listener: (String) -> Unit){
        this.listener = listener
    }
}