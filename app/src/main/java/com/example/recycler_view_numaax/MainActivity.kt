package com.example.recycler_view_numaax
// https://www.youtube.com/watch?v=4pevVON0v-U&list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&index=30
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_numaax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
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
        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter

        for(i in 0..50) {
            if (index > 4) index = 0
            val plant = Plant(imageIdList[index], "Plant Name $index")
            adapter.addPlant(plant)
            index++
        }

//        binding.btnAddPlant.setOnClickListener {
//            if (index > 4) index = 0
//            val plant = Plant(imageIdList[index], "Plant Name $index")
//            adapter.addPlant(plant)
//            index++
//        }
    }
}