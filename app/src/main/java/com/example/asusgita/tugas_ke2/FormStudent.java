package com.example.asusgita.tugas_ke2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by ASUS GITA on 10/16/2016.
 */

public class FormStudent extends AppCompatActivity {
    private EditText edit_id, edit_nama, edit_nim, edit_email, edit_phone;
    private FloatingActionButton save_btn, cancel_btn;
    private boolean isEdit = false;
    ArrayList<Student> studentList;
    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_student_activity);
        studentList = StudentActivity.student;

        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_nim = (EditText) findViewById(R.id.edit_nim);
        edit_nama = (EditText) findViewById(R.id.edit_nama);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)) {
            isEdit = true;
            Student student = (Student) i.getSerializableExtra("student");
			edit_id.setText(String.valueOf(student.getId()));
          // edit_id.setText(student.getId());
            edit_nim.setText(student.getNoreg());
            edit_nama.setText(student.getName());
            edit_email.setText(student.getMail());
            edit_phone.setText(student.getPhone());
            position = i.getIntExtra("position", 0);
        } else {
            edit_id.setText(String.valueOf(studentList.size()));
        }

        save_btn = (FloatingActionButton) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				saveStudent();
                //finish();
            }
        });

        cancel_btn = (FloatingActionButton) findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

      public void saveStudent(){

        if (isEdit){
            Student tmpStudent = new Student(Integer.parseInt(edit_id.getText().toString()),
            edit_nim.getText().toString(),
            edit_nama.getText().toString(),
            edit_email.getText().toString(),
            edit_phone.getText().toString());
            studentList.set(position, tmpStudent);
            finish();
        } else {
            Student tmpStudent = new Student(Integer.parseInt(edit_id.getText().toString()),
            edit_nim.getText().toString(),
            edit_nama.getText().toString(),
             edit_email.getText().toString(),
             edit_phone.getText().toString());
            studentList.add(tmpStudent);
            finish();
        }
    }
}

