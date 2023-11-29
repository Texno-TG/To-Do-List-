package air.texnodev.todolist

import air.texnodev.todolist.databinding.ItemTodoBinding
import air.texnodev.todolist.databinding.ItemTodoHistoryBinding
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class TodoHistoryAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<TodoHistoryAdapter.TodoViewHolder>() {



    inner class TodoViewHolder(val binding: ItemTodoHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding =
            ItemTodoHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        with(holder) {
            with(list[position]) {

                val colors = holder.itemView.resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                binding.viewColorTag.setBackgroundColor(randomColor)
                binding.txtShowTitle.text = this.title
                binding.txtShowTask.text = this.description
                binding.txtShowCategory.text = this.category

                val myformatt = "h:mm a"
                val sdff = SimpleDateFormat(myformatt)
                binding.txtShowTime.text = sdff.format(Date(time))
                val myformat = "EEE, d MMM yyyy"
                val sdf = SimpleDateFormat(myformat)
                binding.txtShowDate.text = sdf.format(Date(time))
                if (this.isFinished == 1){
                    binding.status.text = "Success"
                    binding.status.setTextColor(Color.GREEN)
                }else if (this.isFinished == 2){
                    binding.status.text = "Delete"
                    binding.status.setTextColor(Color.RED)
                }

            }
        }
    }


    override fun getItemId(position: Int): Long {
        return list[position].id
    }



}


