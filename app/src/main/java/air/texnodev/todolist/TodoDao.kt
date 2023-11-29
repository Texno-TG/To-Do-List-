package air.texnodev.todolist

import air.texnodev.todolist.TodoModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert()
    suspend fun insertTask(todoModel: TodoModel):Long

    @Query("Select * from TodoModel where isFinished == 0")
    fun getTask():LiveData<List<TodoModel>>

    @Query("Select * from TodoModel where isFinished > 0")
    fun getFinished():LiveData<List<TodoModel>>

    @Query("Update TodoModel Set isFinished = 1 where id=:uid")
    fun finishTask(uid:Long)

    @Query("Update TodoModel Set isFinished = 2 where id=:uid")
    fun deleteTask(uid:Long)
}