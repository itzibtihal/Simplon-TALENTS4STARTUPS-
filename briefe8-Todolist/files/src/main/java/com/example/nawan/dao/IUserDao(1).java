package com.example.nawan.dao;

import java.sql.SQLException;

public interface IUserDao <T>{
    boolean addUser(T o) throws SQLException;
    boolean signIn(T o);
    boolean signUp(T o);
}
