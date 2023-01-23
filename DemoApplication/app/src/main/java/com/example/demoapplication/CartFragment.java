package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CartFragment extends Fragment implements RecyclerViewInterface {

    ArrayList<CourseModal> courseModalArrayList = new ArrayList<CourseModal>();

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //RECYCLER ACTIVITY

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        courseModalArrayList.add(new CourseModal("DSA in Java", 4, R.drawable.car));
        courseModalArrayList.add(new CourseModal("Java Course", 3, R.drawable.car));
        courseModalArrayList.add(new CourseModal("C++ Course", 4, R.drawable.car));
        courseModalArrayList.add(new CourseModal("DSA in C++", 4, R.drawable.car));
        courseModalArrayList.add(new CourseModal("Kotlin for Android", 4, R.drawable.car));
        courseModalArrayList.add(new CourseModal("Java for Android", 4, R.drawable.car));
        courseModalArrayList.add(new CourseModal("HTML and CSS", 4, R.drawable.car));

        CourseAdapter courseAdapter = new CourseAdapter(this, getContext(),courseModalArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(courseAdapter);

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(),SaveActivity.class);

        intent.putExtra("Name",courseModalArrayList.get(position).getCourseName());
        intent.putExtra("Rating",courseModalArrayList.get(position).getRating());
        intent.putExtra("Image",courseModalArrayList.get(position).getCourseImage());

        startActivity(intent);
    }
}