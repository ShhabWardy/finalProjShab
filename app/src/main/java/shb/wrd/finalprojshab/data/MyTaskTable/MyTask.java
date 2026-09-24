package shb.wrd.finalprojshab.data.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
    public class MyTask {

        @PrimaryKey(autoGenerate = true)
        public long keyId;          // رقم المهمة

        public int importance;      // درجة أهمية المهمة من 1 إلى 5

        public String shortTitle;   // عنوان قصير

        public String text;         // نص المهمة

        public long startTime;      // زمن بناء المهمة

        public boolean isCompleted; // هل تمت المهمة؟

        public long subId;          // رقم موضوع المهمة

        public long userId;         // رقم المستخدم الذي أنشأ المهمة

}
