package com.example.asusgita.tugas_ke2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asusgita.tugas_ke2.R;
import com.example.asusgita.tugas_ke2.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ASUS GITA on 10/16/2016.
 */

public class StudentArrayAdapter extends ArrayAdapter<Student> {

    public StudentArrayAdapter(Context context, ArrayList<Student> studentArrayList) {
        super(context, 0, studentArrayList);
    }

    public View getView(int position, View view, ViewGroup parent){
        Student student = getItem(position);
        if(view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.student_instance,parent,false);
        }

        TextView idView = (TextView) view.findViewById(R.id.id);
        TextView noregView = (TextView) view.findViewById(R.id.noreg);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView mailView = (TextView) view.findViewById(R.id.email);
        TextView phoneView = (TextView) view.findViewById(R.id.phone);

        //set content
        idView.setText(student.getId() + "");
        noregView.setText(student.getNoreg());
        nameView.setText(student.getName());
        mailView.setText(student.getMail());
        phoneView.setText(student.getPhone());
        return view;
    }
}
