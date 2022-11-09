package com.epam.mjc;


import java.util.Arrays;
import java.util.Iterator;

public class StudentManager {

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

  public Student find(long studentID) {
    boolean isTrue = true;
    Iterator<Long> iterator = Arrays.stream(IDs).iterator();
    while (iterator.hasNext()){
      if(iterator.next() == studentID){
        isTrue = true;
        break;
      }
      else {
        isTrue = false;
      }
    }
    if(!isTrue){
      throw new StudentNotFoundException( "Could not find student with ID " + studentID);
    }else {
      return Student.getValueOf(studentID);
    }
  }

  public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    for (int i = 0; i < IDs.length; i++) {
      Student student = manager.find(IDs[i]);
      System.out.println("Student name " + student.getName());
    }

  }
}