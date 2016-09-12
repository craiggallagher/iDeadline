package ideadline.ideadline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListDeadlines extends AppCompatActivity {


    public ArrayList<String> arrayList;
    public ArrayAdapter<String> adapter;
    public ArrayAdapter<String> newad;
    public EditText txtInput;
    public EditText txtDate;
    public int ADD_DEADLINE_REQUEST=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_deadlines);
        final ListView listView = (ListView)findViewById(R.id.listv);
        String[] items= {""};
        arrayList=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,arrayList);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_DEADLINE_REQUEST){
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra("result");
                arrayList.add(item);
                adapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Deadline has been added", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 100, 0);
                toast.show();
            }
        }
    }
    public void onClickbtnPlus(View view) {
        Intent intent = new Intent(this, ToDoActivity.class);
        startActivityForResult(intent, ADD_DEADLINE_REQUEST);
    }

}
