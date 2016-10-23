package com.example.asusgita.tugas_ke2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS GITA on 10/16/2016.
 */

public class StudentActivity extends AppCompatActivity {
    static ArrayList<Student> student;
    private StudentArrayAdapter studentAdapter;
    private ListView listView;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentActivity.this, FormStudent.class);
                i.putExtra("isEdit", false);
                startActivity(i);
            }
        });

        if (student == null) student = new ArrayList<Student>();
        studentAdapter = new StudentArrayAdapter(this, student);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentItem = student.get(position);
                Intent i = new Intent(StudentActivity.this, FormStudent.class);
            }
        });
    }

    private void populateStudentDummies(){
        student.add(new Student(1,"3145136203","Ghina Rosika Amalina","085716336727","ghina.rosika@gmail.com"));
        student.add(new Student(2,"3145136204","Dinda Kharisma","089606176825","dindakudo@gmail.com"));
        studentAdapter = new StudentArrayAdapter(this, student);
        listView.setAdapter(studentAdapter);
    }
	
	   @Override
    protected void onResume() {
        super.onResume();
        emptyTextView = (TextView) findViewById(R.id.empty_view);
        if(student.size() == 0) {
            studentAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
            listView.setEmptyView(emptyTextView);
            emptyTextView.setText("Student Not Found");
        } else {
            studentAdapter = new StudentArrayAdapter(this, student);
            emptyTextView.setText("");
        }
        listView.setAdapter(studentAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_list:
                student.clear();
                studentAdapter = new StudentArrayAdapter(this, student);
                listView.setAdapter(studentAdapter);
                return true;
            case R.id.create_dummy:
                populateStudentDummies();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
