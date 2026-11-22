package shb.wrd.finalprojshab.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import shb.wrd.finalprojshab.R;
import shb.wrd.finalprojshab.model.MyUserTable.MyUser;
import shb.wrd.finalprojshab.viewmodel.UserViewModel;

public class activity_register extends AppCompatActivity {
    private TextView TextView;
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private Button btnRegister;
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
        TextView = findViewById(R.id.TextView);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    private void signup() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        //فحص المعطيات
        if (fullName.isEmpty()){
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Phone is required");
            etPhone.requestFocus();
            return;
        }

        // حفظ في قاعدة البلنات
        MyUser user = new MyUser();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassw(password);
        user.setPhone(phone);
        userViewModel.insert(user);
        Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
        finish();

    }
}
