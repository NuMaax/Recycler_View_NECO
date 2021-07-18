package com.example.recycler_view_numaax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_numaax.databinding.NamesItemBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    // список, откуда адаптер берет данные, может быть БД
    private val personList = ArrayList<Person>()

    // наполнение. изменить в "fun bind"
    class PersonHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = NamesItemBinding.bind(item)

        fun bind(person: Person) {
            binding.imPersonPhoto.setImageResource(person.imageId)
            binding.tvPersonName.text = person.personName
            binding.tvPersonAge.text = person.personAge
        }
    }

    // изменить plant_item. эта ф-ция берет пустой шаблон и надувает его
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.names_item, parent, false)
        return PersonHolder(view)
    }

    // изменить personList.
    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }

    // изменить personList
    override fun getItemCount(): Int {
        return personList.size
    }

    // доп. ф-ция, добавляет элемент в массив, изменить (person: Person), personList
    fun addPerson(person: Person) {
        personList.add(person)
        notifyDataSetChanged()
    }

    // https://youtu.be/4pevVON0v-U?list=PLmjT2NFTgg1fdHN-9Wn4XYr-IOuadxMm5&t=3291
    // добавление целого списка сразу
    fun addAll(list: List<Person>) {
        personList.clear()
        personList.addAll(list)
        notifyDataSetChanged()

    }
}