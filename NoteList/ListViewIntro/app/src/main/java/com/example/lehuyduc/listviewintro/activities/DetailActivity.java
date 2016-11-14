package com.example.lehuyduc.listviewintro.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lehuyduc.listviewintro.R;
import com.example.lehuyduc.listviewintro.fragments.DetailFragment;
import com.example.lehuyduc.listviewintro.fragments.OnStudentUpdateListener;
import com.example.lehuyduc.listviewintro.models.Student;

public class DetailActivity extends BaseActivity implements OnStudentUpdateListener {

    private static final String TAG = "DetailActivity";
    public static final String POSITION_KEY = "position";
    public static final String STUDENT_KEY = "student";

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        student = null;
        student = (Student) intent.getSerializableExtra(STUDENT_KEY);
        int position = intent.getIntExtra(POSITION_KEY,-1);
        int operation = intent.getIntExtra(MainActivity.OPERATION_KEY,-1);
        if (operation==Student.OP_ADD) position = 0;

//        if (student!=null) {
//
//            DetailFragment detailFragment = DetailFragment.create(student,operation);
//
//            detailFragment.setOnStudentUpdateListener(this);
//
//            changeFragment(R.id.fl_detail,detailFragment,false);
//        }

        if (position!=-1) {
            if (operation==Student.OP_ADD) student = new Student("","",0);
            else student = Student.list.get(position);

            DetailFragment detailFragment = DetailFragment.create(student,operation);

            detailFragment.setOnStudentUpdateListener(this);

            changeFragment(R.id.fl_detail,detailFragment,false);
        }
    }

    @Override
    public void onUpdate() {
        finish();
    }


//    void addListener() {
//        btSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//        });
//    }
}
