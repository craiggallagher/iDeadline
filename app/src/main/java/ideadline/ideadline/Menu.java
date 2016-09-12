package ideadline.ideadline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClickbtnDeadline(View view) {
        startActivity(new Intent(Menu.this, ListDeadlines.class));
    }
    public void onClickbtnStudyNotes(View view) {
        startActivity(new Intent(Menu.this, StudyNotes.class));
    }
    public void onClickbtnCalendar(View view) {
        startActivity(new Intent(Menu.this, Calender.class));
    }
}
