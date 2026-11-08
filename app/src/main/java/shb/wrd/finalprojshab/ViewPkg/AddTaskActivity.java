package shb.wrd.finalprojshab.ViewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import shb.wrd.finalprojshab.R;

public class AddTaskActivity extends AppCompatActivity {
    private TextView Text_View;
    private EditText et_Title;
    private EditText et_Description;
    private EditText et_Priority;
    private Button btnSave_Task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        Text_View = findViewById(R.id.TextView);
        et_Title = findViewById(R.id.etTitle);
        et_Description = findViewById(R.id.etDescription);
        et_Priority = findViewById(R.id.etPriority);
        btnSave_Task = findViewById(R.id.btnSaveTask);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
