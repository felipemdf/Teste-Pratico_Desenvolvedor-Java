package com.felipemdf.client.interfaces;


import com.felipemdf.client.dtos.ResponseDto;
import java.util.ArrayList;
import java.util.HashMap;

public interface IFormService<T> {
    
    public ResponseDto save (T object);
    public ResponseDto update (Long id, T object);
    public ResponseDto remove (Long id);
    public ArrayList<T> getAll();
    public ArrayList<T> get(HashMap<String, String> filter);
    public ArrayList<Object[]> toObjectArray(ArrayList<T> list);
    
}

