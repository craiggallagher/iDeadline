package ideadline.ideadline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Saved extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        final ImageView imgView = (ImageView)findViewById(R.id.imageView1);
    }
}
