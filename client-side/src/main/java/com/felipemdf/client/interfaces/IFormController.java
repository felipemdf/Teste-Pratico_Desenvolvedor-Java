package com.felipemdf.client.interfaces;


import java.util.ArrayList;

public interface IFormController<T> {
    
    public boolean save (T object);
    public boolean remove (int id);
    public ArrayList<T> getAll();
    public ArrayList<T> get(T filter);
    public ArrayList<Object[]> toObjectArray(ArrayList<T> list);
}

