package shb.wrd.finalprojshab.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import shb.wrd.finalprojshab.R;
import shb.wrd.finalprojshab.viewmodel.UserViewModel;

public class activity_register extends AppCompatActivity {
    private TextView Text_View;
    private EditText et_FullName;
    private EditText et_Email;
    private EditText et_Password;
    private EditText et_Phone;
    private Button btn_Register;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Text_View = findViewById(R.id.TextView);
        et_FullName = findViewById(R.id.etFullName);
        et_Email = findViewById(R.id.etEmail);
        et_Password = findViewById(R.id.etPassword);
        et_Phone = findViewById(R.id.etPhone);
        btn_Register = findViewById(R.id.btnRegister);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
    }

    private void signup()
    {
        String fullname
    }
}
