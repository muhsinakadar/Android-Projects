package com.example.demoapplication;

public class CourseModal {

    String courseName;
    int rating;
    int courseImage;

    public CourseModal(String cName, int rating,int image){
        courseName = cName;
        this.rating = rating;
        courseImage = image;
    }

    //getters and setters
    public String getCourseName() {
        return courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public int getRating() {
        return rating;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
