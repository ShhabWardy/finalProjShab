package shb.wrd.finalprojshab.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import shb.wrd.finalprojshab.data.MySubjectTable.MySubject;
import shb.wrd.finalprojshab.data.MySubjectTable.MySubjectQuery;
import shb.wrd.finalprojshab.data.MyTaskTable.MyTask;
import shb.wrd.finalprojshab.data.MyTaskTable.MyTaskQuery;
import shb.wrd.finalprojshab.data.MyUserTable.MyUser;
import shb.wrd.finalprojshab.data.MyUserTable.MyUserQuery;


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
