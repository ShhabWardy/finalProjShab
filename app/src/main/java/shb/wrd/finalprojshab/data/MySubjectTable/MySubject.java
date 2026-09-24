package shb.wrd.finalprojshab.data.MySubjectTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity
    public class MySubject
    {

        @PrimaryKey(autoGenerate = true)
        public long key_id;

        public String title;
    }
