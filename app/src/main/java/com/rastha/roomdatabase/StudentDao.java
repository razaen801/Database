package com.rastha.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void addStudent(Student student);

    @Query("select * from student")
    List<Student> getAllStudent();

    @Update
    public void updateStudent(Student student);

    @Delete
    public void deleteStudent(Student student);
}
