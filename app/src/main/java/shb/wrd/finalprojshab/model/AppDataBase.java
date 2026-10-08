package shb.wrd.finalprojshab.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import shb.wrd.finalprojshab.model.MySubjectTable.MySubject;
import shb.wrd.finalprojshab.model.MySubjectTable.MySubjectQuery;
import shb.wrd.finalprojshab.model.MyTaskTable.MyTask;
import shb.wrd.finalprojshab.model.MyTaskTable.MyTaskQuery;
import shb.wrd.finalprojshab.model.MyUserTable.MyUser;
import shb.wrd.finalprojshab.model.MyUserTable.MyUserQuery;


/**
 * الفئة المسؤولة عن إنشاء قاعدة البيانات الخاصة
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase
{
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDataBase db;

    /**
     * يعيد كائن لعمليات جدول المستخدمين
     * @return
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول المواضيع
     * @return
     */
    public abstract MySubjectQuery getMySubjectQuery();

    /**
     * يعيد كائن لعمليات جدول المهام
     * @return
     */
    public abstract MyTaskQuery getMyTaskQuery();


    /**
     * بناء قاعدة البيانات وإعادة كائن يوفر عليها
     * @param context
     * @return
     */
    public static AppDataBase getDB(Context context){
        if(db==null)
        {
            db = Room.databaseBuilder(
                            context,
                            AppDataBase.class,
                            "samihDataBase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}
