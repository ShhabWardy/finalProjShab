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

@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version = 1)

/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
    public abstract class AppDataBase extends RoomDatabase {

        /**
         * كائن للتعامل مع قاعدة البيانات
         */
        private static AppDataBase db;

        /**
         * يعيد كائن لعمليات جدول المستخدمين
         *
         * @return
         */
        public abstract MyUserQuery getMyUserQuery();

        /**
         * يعيد كائن لعمليات جدول الموضوع
         *
         * @return
         */
        public abstract MySubjectQuery getMySubjectQuery();

        /**
         * يعيد كائن لعمليات جدول المهامات
         *
         * @return
         */
        public abstract MyTaskQuery getMyTaskQuery();

        /**
         * بناء قاعدة البيانات وإعادة كائن يشير عليها
         *
         * @param context
         * @return
         */
        public static AppDataBase getDB(Context context) {

            if (db == null) {

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

}
