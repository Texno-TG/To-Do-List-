package air.texnodev.todolist

import air.texnodev.todolist.databinding.ActivityHistoryBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class HistoryActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHistoryBinding
    val list = arrayListOf<TodoModel>()
    private lateinit var db:AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(baseContext)



        db.todoDao().getFinished().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                Log.d("LOG_APP", " Lo "+it.size)
                list.clear()
                list.addAll(it)
               binding.todoRv.adapter = TodoHistoryAdapter(it)
            }else{
               binding.todoRv.adapter = TodoHistoryAdapter(list)
            }
        })
    }
}
