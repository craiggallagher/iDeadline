package ideadline.ideadline;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressLint("SdCardPath")
public class StudyNotes extends AppCompatActivity {
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;
    private ImageView img;
    private static final int CONTENT_REQUEST = 1337;
    private File output = null;
    String mCurrentPhotoPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_notes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        img = (ImageView)findViewById(R.id.imageView1);
        ((ImageView) findViewById(R.id.button1))
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
                    }
                });

    }
    public void onClickbtnSavedArticles(View view) {
        Uri uri = Uri.parse("chrome://bookmarks/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;

    public void onClickbtnTakePhoto(View v) {
        Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Uri uriSavedImage = Uri.fromFile(new File("/storage/emulated/0/DCIM/iDeadline", "QR_" + timeStamp + ".png"));
        imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(imageIntent, 2);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                img.setImageURI(selectedImageUri);
            }
        }
    }


    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}
