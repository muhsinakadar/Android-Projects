package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SaveFragment extends Fragment {

    private int counter = 0;

    public SaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save, container, false);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        TextView refreshText = (TextView) view.findViewById(R.id.save_text_view);
        TextView courseText = (TextView) view.findViewById(R.id.save_course_name);
        TextView ratingText = (TextView) view.findViewById(R.id.save_course_rating);
        ImageView courseImageView = (ImageView) view.findViewById(R.id.save_card_image);


        Bundle args = getArguments();

        String courseName="Java";

        courseName = args.getString("Name");
        String courseRating = String.valueOf(args.getInt("Rating",0));
        int courseImage = args.getInt("Image",0);

        courseText.setText(courseName);
        ratingText.setText(courseRating);
        courseImageView.setImageResource(courseImage);


//        Toast.makeText(getActivity(), "course name"+courseName, Toast.LENGTH_SHORT).show();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                counter++;
//                refreshText.setText("View is Refreshed " + counter + " times");
//
//                swipeRefreshLayout.setRefreshing(false);

                Intent intent = new Intent(getContext(),CheckActivity.class);
                startActivity(intent);

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }


}