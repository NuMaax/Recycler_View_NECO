package com.example.recycler_view_numaax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_numaax.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    // список, откуда адаптер берет данные, может быть БД
    private val plantList = ArrayList<Plant>()

    // наполнение. изменить в "fun bind"
    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = PlantItemBinding.bind(item)

        fun bind(plant: Plant) {
            binding.im.setImageResource(plant.imageId)
            binding.tvTitle.text = plant.title
        }
    }
    // изменить plant_item. эта ф-ция берет пустой шаблон и надувает его
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }
    // изменить plantList.
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    // изменить plantList
    override fun getItemCount(): Int {
        return plantList.size
    }

    // доп. ф-ция, добавляет элемент в массив, изменить (plant: Plant), plantList
    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }

    // https://youtu.be/4pevVON0v-U?list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&t=3291
    // добавление целого списка сразу
    fun addAll(list: List<Plant>){
        plantList.clear()
        plantList.addAll(list)
        notifyDataSetChanged()

    }
}