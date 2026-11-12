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

public class SignInActivity extends AppCompatActivity {
    private TextView textView;
    private EditText etEmailAddress;
    private EditText etPassword2;
    private Button btnLogIn;
    private Button btnREGISTER2;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView=findViewById(R.id.textView);
        etEmailAddress=findViewById(R.id.etEmailAddress);
        etPassword2=findViewById(R.id.etPassword2);
        btnLogIn=findViewById(R.id.btnLogIn);
        btnREGISTER2=findViewById(R.id.btnREGISTER2);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SignInUser();
            }
        });
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    private void SignInUser()
    {
        String email = etEmailAddress.getText().toString().trim();
        String password = etPassword2.getText().toString().trim();

        if (email.isEmpty()) {
            etEmailAddress.setError("Email is required");
            etEmailAddress.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword2.setError("Password is required");
            etPassword2.requestFocus();
            return;
        }
//gfhfdghfdgh
        MyUser user = userViewModel.logIn(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
