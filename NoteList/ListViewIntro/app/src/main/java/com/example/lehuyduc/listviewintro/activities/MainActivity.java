package com.example.lehuyduc.listviewintro.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lehuyduc.listviewintro.R;
import com.example.lehuyduc.listviewintro.fragments.DetailFragment;
import com.example.lehuyduc.listviewintro.fragments.OnStudentUpdateListener;
import com.example.lehuyduc.listviewintro.models.Student;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements OnStudentUpdateListener {

    public static final String TAG = "MainActivity";
    public static final String OPERATION_KEY = "operation";

    private ArrayList<Student> students;
    private ArrayAdapter<Student> studentArrayAdapter;

    ListView lvStudent;
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();
    }

    void getReferences() {
        lvStudent = (ListView) findViewById(R.id.lv_student);
        students = Student.list;
        btAdd = (Button) findViewById(R.id.bt_add);
    }

    void setupUI() {
        studentArrayAdapter = new ArrayAdapter<Student>(
                this, android.R.layout.simple_list_item_1,students);
        lvStudent.setAdapter(studentArrayAdapter);
    }

    void addListener() {
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = students.get(i);
                Log.d(TAG,String.format("%s was tapped",student.toString()));

                if (findViewById(R.id.fl_detail)!=null) {
                    DetailFragment detailFragment = DetailFragment.create(student,Student.OP_UPDATE);
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment,true);
                }
                else {
                     Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                   //  intent.putExtra(DetailActivity.STUDENT_KEY,students.get(i));
                     intent.putExtra(DetailActivity.POSITION_KEY,i);
                     intent.putExtra(OPERATION_KEY, Student.OP_UPDATE);
                     Log.d(TAG,intent.toString());
                     startActivity(intent);
                }
            }
        });

        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = students.get(i);
                students.remove(i);
                studentArrayAdapter.notifyDataSetChanged();
                Log.d(TAG,String.format("%s was long clicked",student.toString()));

                return true;
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //  intent.putExtra(DetailActivity.STUDENT_KEY,students.get(i));

                intent.putExtra(OPERATION_KEY, Student.OP_ADD);
                Log.d(TAG,intent.toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        studentArrayAdapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        studentArrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    @Override
    public void onUpdate() {
        studentArrayAdapter.notifyDataSetChanged();
    }
}
