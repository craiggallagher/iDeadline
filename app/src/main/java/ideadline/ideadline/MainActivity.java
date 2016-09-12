package ideadline.ideadline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void onClickbtnLogin(View view) {
        startActivity(new Intent(MainActivity.this, Login.class));
    }
    public void onClickbtnSignUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUp.class));
    }

}
