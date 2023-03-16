package uz.gita.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.gita.nestedrecyclerview.adapter.ImageAdapter
import uz.gita.nestedrecyclerview.adapter.ItemsAdapter
import uz.gita.nestedrecyclerview.model.ImageData
import uz.gita.nestedrecyclerview.model.ItemsData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<ItemsData>()

        for (i in 0 until 100) {
            val l = ArrayList<ImageData>()
            for (j in 0 until 20) {
                l.add(ImageData("ImageData $i$j", R.drawable.image1))
                l.add(ImageData("ImageData $i$j", R.drawable.image2))
                l.add(ImageData("ImageData $i$j", R.drawable.image3))
                l.add(ImageData("ImageData $i$j", R.drawable.image1))
                l.add(ImageData("ImageData $i$j", R.drawable.image2))
            }
            l.shuffle()
            list.add(ItemsData("CategoryName $i", l))
        }

        val adapter = ItemsAdapter(list)

        adapter.setListener {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        val rv = findViewById<RecyclerView>(R.id.vertical_rv)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}