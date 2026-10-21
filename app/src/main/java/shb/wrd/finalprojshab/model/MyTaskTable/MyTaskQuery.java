package shb.wrd.finalprojshab.model.MyTaskTable;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
    public interface MyTaskQuery {

        /**
         * إعادة جميع معطيات جدول المهمات
         * @return قائمة من المهمات
         */
        @Query("SELECT * FROM MyTask ORDER BY importance DESC")
        LiveData<  List<MyTask>> getAllTasks();

        /**
         * إرجاع المهمات حسب المستعمل وإذا انتهت أم لا ومرتبة تنازلياً حسب الأهمية
         * @param userid_p* رقم المستعمل
         * @return تعيد قائمة مهمات كان يتحدث بكل تغيير
         */
        @Query("SELECT * FROM MyTask WHERE userId=:userid_p ORDER BY startTime DESC")
        LiveData<List<MyTask>> getAllTaskOrderBy(long userid_p);

        /**
         * إرجاع المهمات حسب المستعمل وإذا انتهت أم لا ومرتبة تنازلياً حسب الأهمية
         * @param userid_p* رقم المستعمل
         * @param isCompleted_p* هل تمت أم لا
         * @return قائمة مهمات مرتبة داخل كائن يتحدث بكل تغيير
         */
        @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p" +
                " ORDER BY importance DESC")
        LiveData<List<MyTask>> getAllTaskOrderedBy(long userid_p, boolean isCompleted_p);
    /**
     * ادخال مهام
     * @param t مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t);

    /**
     * تعديل المهمات
     * @param tasks مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void updateTask(MyTask... tasks);

    /**
     * حذف مهمة أو مهام
     * @param tasks حذف المهام (حسب المفتاح الرئيسي)
     */
    @Delete
    void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")
    void deleteTask(long kid);

    /**
     * استرجاع جميع المهام التابعة لرقم الموضوع
     * @param key_id رقم الموضوع
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE subId=:key_id " +
            "ORDER BY importance DESC")
    List<MyTask> getTasksBySubId(long key_id);
    @Query("SELECT * FROM MyTask WHERE keyId=:taskId " +
            "ORDER BY importance DESC")
    LiveData<List<MyTask>>  getTaskById(long taskId);

    LiveData<List<MyTask>> getTasksByTitle(String title);
    @Query("SELECT * FROM MyTask WHERE importance=:priority " +
            "ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByPriority(int priority);
    @Query("SELECT * FROM MyTask WHERE importance=:priority " +
            "ORDER BY importance DESC")
    void insert(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE importance=:priority " +
            "ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title);
    @Query("SELECT * FROM MyTask WHERE importance=:priority " +
            "ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByDescription(String description);
    @Query("SELECT * FROM MyTask WHERE importance=:tasks " +
            "ORDER BY importance DESC")
    void update(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE importance=:tasks " +
            "ORDER BY importance DESC")
    void delete(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE importance=:taskId " +
            "ORDER BY importance DESC")
    void deleteTaskById(long taskId);
}
