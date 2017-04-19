package com.itransition.lyubin.service;


import com.itransition.lyubin.model.notdbmodel.Top;

import java.util.ArrayList;

public interface TopService {
    public ArrayList<Top> findTop(Integer col);
}
