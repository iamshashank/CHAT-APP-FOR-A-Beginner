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
 * Created by Shashank on 02-09-2016.
 */

//in this method 10 fragments will be created 1 for each student and thenwill be reused if clicked again
    //int he other class we create only one fragment and replace the data according to our need

public class StudentFragment extends Fragment {



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

        ((TextView)v.findViewById(R.id.name)).setText("NAME : "+getArguments().getString("name","Anonymous"));
        ((TextView)v.findViewById(R.id.age)).setText("AGE : "+getArguments().getString("age","Anonymous"));
        ((TextView)v.findViewById(R.id.addr)).setText("ADDRESS : "+getArguments().getString("addr","Anonymous"));
        ((TextView)v.findViewById(R.id.sex)).setText("SEX : "+getArguments().getString("sex","Anonymous"));
        ((TextView)v.findViewById(R.id.roll)).setText("ROLL NO :"+getArguments().getString("roll","Anonymous"));
        ((ImageView)v.findViewById(R.id.my_pic)).setImageBitmap((Bitmap)getArguments().getParcelable("photo"));
        v.setTag(getArguments().getString("roll","Anonymous"));

        return v;
    }
}
