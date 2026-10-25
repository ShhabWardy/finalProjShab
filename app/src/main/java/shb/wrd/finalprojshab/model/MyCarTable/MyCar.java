package shb.wrd.finalprojshab.model.MyCarTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity
    public class MyCar
    {
        @PrimaryKey(autoGenerate = true)
        public long key_id;

        public String title;

        public void setTitle(String math)
        {

        }
    }
