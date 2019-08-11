package com.rastha.roomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etFaculty;
    private EditText etRoll;
    private EditText etAddress;
    private Button btnsaveDetails;
    private Button btnupdate;
    private Button btndelete;
    private Button btnread;
    private TextView tview;


    private static final String DB_NAME = "StudentDb";
    private MyAppDatabase myAppDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();


        etName = findViewById(R.id.ui_name);
        etFaculty = findViewById(R.id.ui_faculty);
        etRoll = findViewById(R.id.ui_roll);
        etAddress = findViewById(R.id.ui_address);
        tview = findViewById(R.id.textView);

        btnsaveDetails = findViewById(R.id.ui_savedetails);
        btnupdate = findViewById(R.id.ui_update);
        btndelete = findViewById(R.id.ui_delete);
        btnread = findViewById(R.id.ui_read);
        btnsaveDetails.setOnClickListener(this);
        btnread.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ui_savedetails:

                String name = etName.getText().toString();
                String faculty = etFaculty.getText().toString();
                String roll = etRoll.getText().toString();
                String address = etAddress.getText().toString();

                Student student = new Student();
                student.setName(name);
                student.setFaculy(faculty);
                student.setAddress(address);
                student.setId(Integer.parseInt(roll));

                myAppDatabase.StudentDao().addStudent(student);
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_LONG).show();
                etName.setText("");
                etFaculty.setText("");
                etAddress.setText("");
                etRoll.setText("");
                break;

            case R.id.ui_read:
                List<Student> studentList = myAppDatabase.StudentDao().getAllStudent();

                String data = "";
                for (Student allStudent : studentList) {
                    String studentName = allStudent.getName();
                    String studentFaculty = allStudent.getFaculy();
                    String studentAddress = allStudent.getAddress();
                    int studentRoll = allStudent.getId();

                    data = data + studentName + "\n" + studentRoll + "\n" + studentFaculty + "\n" + studentAddress + "\n\n";


                    tview.setText(data);
                }
                break;
            case R.id.ui_update:
                String name1 = etName.getText().toString();
                String faculty1 = etFaculty.getText().toString();
                String roll1 = etRoll.getText().toString();
                String address1 = etAddress.getText().toString();

                Student updatedStudent = new Student();
                updatedStudent.setName(name1);
                updatedStudent.setFaculy(faculty1);
                updatedStudent.setAddress(address1);
                updatedStudent.setId(Integer.parseInt(roll1));

                myAppDatabase.StudentDao().updateStudent(updatedStudent);
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_LONG).show();
                etName.setText("");
                etFaculty.setText("");
                etAddress.setText("");
                etRoll.setText("");
                break;
            case R.id.ui_delete:{
                int id = Integer.parseInt(etRoll.getText().toString());
                Student deleteStudent = new Student();
                deleteStudent.setId(id);
                myAppDatabase.StudentDao().deleteStudent(deleteStudent);
                break;
            }


        }
    }


}

