package com.example.nawan.dao;

import com.example.nawan.utils.Categorie;

import java.util.List;

public interface Idao <T>{

    List<T> findAll();
    void add(T o);
    void update(T o);
    void delete(T o );

}
