package shb.wrd.finalprojshab.viewPkg;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import shb.wrd.finalprojshab.R;
import shb.wrd.finalprojshab.data.AppDataBase;
import shb.wrd.finalprojshab.data.MySubjectTable.MySubject;
import shb.wrd.finalprojshab.data.MySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //بناء قاعدة بيانات وارجاع مؤشر عليها1
        AppDataBase db=AppDataBase.getDB(getApplicationContext());
        //2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.title="Computers";
        //4 اضافة كائن للجدول
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            ///
        });
    }
}
