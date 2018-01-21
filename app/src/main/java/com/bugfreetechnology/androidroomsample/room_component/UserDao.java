package com.bugfreetechnology.androidroomsample.room_component;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.bugfreetechnology.androidroomsample.pojo.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("delete from user")
    void deleteAll();

    @Query("delete from user where first_name = :fName")
    void deleteByName(String fName);

    @Update
    void updateUser(User user);

    @Query("select * from user where first_name = :firstName OR first_name = :secondName")
    User[] getUserByName(String firstName,String secondName);
}