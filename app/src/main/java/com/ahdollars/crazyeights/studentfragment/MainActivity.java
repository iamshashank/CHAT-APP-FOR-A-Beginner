package com.ahdollars.crazyeights.studentfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ahdollars.crazyeights.studentfragment.model.Student;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Bitmap photo;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo);
        Student.items.add(new Student("Vice City",20,"Niko", photo,"MALE",12345));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo1);
        Student.items.add(new Student("San Andreas",20,"Carl", photo,"MALE",35445));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo2);
        Student.items.add(new Student("Grand Line",20,"Luffy", photo,"MALE",12655));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo3);
        Student.items.add(new Student("Baker Street",20,"Conan",photo,"MALE",67845));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo4);
        Student.items.add(new Student("Pallet Town",20,"Ash",photo,"MALE",98745));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo);
        Student.items.add(new Student("Hidden Leaf Village",20,"Naruto", photo,"MALE",41145));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo1);
        Student.items.add(new Student("Hidden Sand Village",20,"Gara", photo,"MALE",11145));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo2);
        Student.items.add(new Student("Vice City",20,"Niko",photo,"MALE",90005));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo2);
        Student.items.add(new Student("KaraKura Japan",20,"Ichigo", photo,"MALE",12655));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo3);
        Student.items.add(new Student("Baker Street",20,"Light Yagami",photo,"MALE",67845));
        photo=BitmapFactory.decodeResource(getResources(),R.drawable.photo4);
        Student.items.add(new Student("Gotham",20,"Batman",photo,"MALE",98745));

        rv=(RecyclerView)findViewById(R.id.rv_container);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());
         manager=getSupportFragmentManager();

    }

    public class MyHolder extends RecyclerView.ViewHolder{

        Student item;

        public MyHolder(View itemView) {
            super(itemView);

            rootView=itemView;
            name=(TextView)itemView.findViewById(R.id.tv_name);

            myPhoto=(ImageView) itemView.findViewById(R.id.my_photo);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    FragmentTransaction transporter=manager.beginTransaction();
                    Toast.makeText(getApplicationContext(), "No of Fragments : "+(manager.getBackStackEntryCount()+1), Toast.LENGTH_SHORT).show();
                    // if(manager.findFragmentByTag(String.valueOf(item.roll))==null){
                    // above line is for the old method
                    // now we search with our new tag 'student'
                    ReUsableFragment f=(ReUsableFragment) manager.findFragmentByTag("student");
                    if(f==null){
                         transporter.replace(R.id.fragment_container,StudentFragment.newInstance(item));
                        transporter.commit();

                    }else{
                        // transporter.replace(R.id.fragment_container,manager.findFragmentByTag());
                        f.changeData(item);
                    }


                }
            });
        }

        View rootView;
        TextView name;
        ImageView myPhoto;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyHolder holder=new MyHolder(getLayoutInflater().inflate(R.layout.card,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.name.setText(Student.items.get(position).name);
            holder.myPhoto.setImageBitmap(Student.items.get(position).photo);
            holder.item=Student.items.get(position);

        }

        @Override
        public int getItemCount() {
            return Student.items.size();
        }
    }
}
