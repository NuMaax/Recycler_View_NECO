package com.example.recycler_view_numaax
// https://www.youtube.com/watch?v=4pevVON0v-U&list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&index=30
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_numaax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PersonAdapter()
    private val imageIdList = listOf(
        R.drawable.plant01,
        R.drawable.plant02,
        R.drawable.plant03,
        R.drawable.plant04,
        R.drawable.plant05,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.rcView.layoutManager = ConstraintLayout(this@MainActivity)
        binding.rcView.adapter = adapter

        for(i in 0..10) {
            if (index > 4) index = 0
            val person = Person(imageIdList[index],
                "Person Name $index", "personAge = $index")
            adapter.addPerson(person)
            index++
        }
    }
}