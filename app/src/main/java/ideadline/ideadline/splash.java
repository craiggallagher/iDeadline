package ideadline.ideadline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

public class splash extends AppCompatActivity {
    private MobileServiceClient mClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        Thread logoTimer = new Thread() {
            public void run(){
                try{
                    int logoTimer = 0;
                    while(logoTimer < 3000){
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
                    startActivity(new Intent("com.example.splash.CLEARSCREEN"));
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                finally{
                    finish();
                }
            }
        };

        logoTimer.start();

    }
}
