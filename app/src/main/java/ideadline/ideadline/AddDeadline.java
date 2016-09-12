package ideadline.ideadline;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.util.Calendar;

public class AddDeadline extends AppCompatActivity {
    public EditText editText;
    public EditText editDate;
    public TextView input;
    private MobileServiceClient mClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mClient = new MobileServiceClient(
                    "https://ideadlineapp.azure-mobile.net/",
                    "vCafZSONADDtUWYjgWTUJhYbTTzpTV45",
                    this
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Item item = new Item();
        item.Text = "new";
        item.Title= "A Title";




        mClient.getTable(Item.class).insert(item, new TableOperationCallback<Item>() {
            public void onCompleted(Item entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                } else {
                    // Insert failed
                }
            }
        });
        setContentView(R.layout.activity_add_deadline);
        editText = (EditText)findViewById(R.id.editText2);
        editDate = (EditText)findViewById(R.id.editText3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       final ListDeadlines lst= new ListDeadlines();

        lst.txtInput=(EditText)findViewById(R.id.txtinput);

        ImageView btAdd=(ImageView)findViewById(R.id.btnAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("result", lst.txtInput.getText().toString());
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });




            final EditText etext = (EditText) findViewById(R.id.editText2);
            etext.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddDeadline.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        etext.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();

            }
            }



            );





            final EditText edate = (EditText) findViewById(R.id.editText3);
            edate.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(AddDeadline.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth = selectedmonth + 1;
                        edate.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
            }

            );
        }

    public void onClickbtnBin(View view) {
        editText.getText().clear();
    }

    }
