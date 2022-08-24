package com.example.model;

import java.util.List;

public interface Idao <T> {

        public boolean create(T o);

        public boolean update(T o);

        public boolean delete(T o);

        public T findById(int id);

        public List<T> findAll();

    }

