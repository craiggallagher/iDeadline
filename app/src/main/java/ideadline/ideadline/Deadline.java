package ideadline.ideadline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Deadline extends Activity {
    private EditText txtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);


/*        ListView listView;
        String[] from = { "Electricity","Groceries","Rent","Loan","Entertainment" };
        ArrayAdapter arrayAdapter;
        listView = (ListView) findViewById(R.id.zone_list);
        arrayAdapter = new ArrayAdapter(this,R.layout.activity_list_deadlines, R.id.tvName, from);
        listView.setAdapter(arrayAdapter);
        txtInput=(EditText)findViewById((R.id.txtDeadlineName));
        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((new View.OnClickListener(){
            @Override
        public void onClick(View v){
                String newItem- txtInput.getText().toString();
                arra
            }
        };*/
    }

}
