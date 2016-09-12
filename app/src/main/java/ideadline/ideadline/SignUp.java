package ideadline.ideadline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClickbtnSingUp(View view) {
        startActivity(new Intent(SignUp.this, Login.class));
        Toast toast = Toast.makeText(getApplicationContext(),
                "Registered", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 100, 0);
        toast.show();
    }
}
