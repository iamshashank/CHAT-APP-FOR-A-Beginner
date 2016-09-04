package com.ahdollars.crazyeights.studentfragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahdollars.crazyeights.studentfragment.model.Student;

/**
 * Created by Shashank on 03-09-2016.
 */
public class ReUsableFragment extends Fragment {


    TextView name,roll,addr,sex,age;
    ImageView photo;


    public static StudentFragment newInstance(Student item) {

        Bundle args = new Bundle();
        args.putString("name",item.name);
        args.putString("age",item.age+"");
        args.putString("roll",item.roll+"");
        args.putString("addr",item.address);
        args.putString("sex",item.sex);
        args.putParcelable("photo",item.photo);
        StudentFragment fragment = new StudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.student_fragment,container,false);

        (name=(TextView)v.findViewById(R.id.name)).setText("NAME : "+getArguments().getString("name","Anonymous"));
        (age=(TextView)v.findViewById(R.id.age)).setText("AGE : "+getArguments().getString("age","Anonymous"));
        (addr=(TextView)v.findViewById(R.id.addr)).setText("ADDRESS : "+getArguments().getString("addr","Anonymous"));
        (sex=(TextView)v.findViewById(R.id.sex)).setText("SEX : "+getArguments().getString("sex","Anonymous"));
        (roll=(TextView)v.findViewById(R.id.roll)).setText("ROLL NO :"+getArguments().getString("roll","Anonymous"));
        (photo=(ImageView)v.findViewById(R.id.my_pic)).setImageBitmap((Bitmap)getArguments().getParcelable("photo"));
        //here we set the universal tag for our fragment
        //because we only create one fragment and just change data
        v.setTag("student");

        return v;
    }

    public void changeData(Student item){
        name.setText("NAME : "+item.name);
        age.setText("NAME : "+item.age);
        sex.setText("NAME : "+item.sex);
        roll.setText("NAME : "+item.roll);
        addr.setText("NAME : "+item.address);
        photo.setImageBitmap(item.photo);

    }

}
