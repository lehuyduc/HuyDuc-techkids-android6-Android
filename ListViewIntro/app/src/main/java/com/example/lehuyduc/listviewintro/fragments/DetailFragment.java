package com.example.lehuyduc.listviewintro.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lehuyduc.listviewintro.R;
import com.example.lehuyduc.listviewintro.models.Student;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    public static final String TAG = "DetailFragment";

    private Student student;
    int operation;

    private EditText etName, etGender, etAge;
    private Button btSave;

    private OnStudentUpdateListener onStudentUpdateListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void setOnStudentUpdateListener(OnStudentUpdateListener v) {
        this.onStudentUpdateListener = v;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListener();

        return view;
    }

    public static DetailFragment create(Student student, int operation) {
        //1: Create fragment
        DetailFragment detailFragment = new DetailFragment();

        //2 (optional): pass arguments
        detailFragment.setStudent(student);
        detailFragment.setOperation(operation);

        return detailFragment;
    }

    void getReferences(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etGender = (EditText) view.findViewById(R.id.et_gender);
        etAge = (EditText) view.findViewById(R.id.et_age);
        btSave = (Button) view.findViewById(R.id.bt_save);
    }

    void setupUI() {
        etName.setText(student.getName());
        etGender.setText(student.getGender());
        etAge.setText(""+student.getAge());
    }

    void addListener() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("detailActivity",""+operation);
                if (operation== Student.OP_UPDATE) {
                    student.setName(etName.getText().toString());
                    student.setGender(etGender.getText().toString());
                    student.setAge(Integer.parseInt(etAge.getText().toString()));

                    if (onStudentUpdateListener!=null) onStudentUpdateListener.onUpdate();
                }

                if (operation==Student.OP_ADD) {
                    student.setName(etName.getText().toString());
                    student.setGender(etGender.getText().toString());
                    student.setAge(Integer.parseInt(etAge.getText().toString()));
                    Student.list.add(student);

                    if (onStudentUpdateListener!=null) onStudentUpdateListener.onUpdate();
                }
            }
        });
    }
}
