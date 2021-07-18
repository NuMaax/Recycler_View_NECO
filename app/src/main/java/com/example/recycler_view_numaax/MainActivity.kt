package com.example.recycler_view_numaax
// https://www.youtube.com/watch?v=4pevVON0v-U&list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&index=30
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_numaax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PersonAdapter()
    private val imageIdList = listOf(
        R.drawable.person_sergey,
        R.drawable.person_andrey,
        R.drawable.person_igor,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        Log.d("NM_Log", "initRecyclerView() --- worked")
    }

    private fun initRecyclerView() {
        binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rcView.adapter = adapter

        for (i in 1..10) {
            if (index > 2) index = 0
            val person = Person(
                imageIdList[index],
                "Person Name: $i",
                "Person Age: $index",
            )
            adapter.addPerson(person)
            index++
            Log.d("NM_Log", "for(i in 0..10) --- worked")
        }
    }
}