package shb.wrd.finalprojshab.data.MySubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
    public interface MySubjectQuery {

        // جلب جميع المواضيع
        @Query("SELECT * FROM MySubject")
        List<MySubject> getAllSubjects();

        // إضافة مهمة
        @Insert
        void insert(MySubject... s);

        // تعديل مهمة
        @Update
        void update(MySubject... s);

        // حذف مهمة/مهام حسب المفتاح الرئيسي
        @Delete
        void deleteTask(MySubject... s);

        // حذف حسب keyid
        @Query("DELETE FROM MySubject WHERE keyid = :keyid")
        void deleteTask(long keyid);

        // البحث عن موضوع حسب العنوان
        @Query("SELECT * FROM MySubject WHERE title=:sub")
        MySubject checkSubject(String sub);
    }
