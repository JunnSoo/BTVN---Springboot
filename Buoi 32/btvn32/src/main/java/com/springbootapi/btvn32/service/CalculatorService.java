package com.springbootapi.btvn32.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int  cong(int a,int b){
        return a+b;
    }
    public int  tru(int a,int b){
        return a-b;
    }

    public int  nhan(int a,int b){
        return a*b;
    }

    public double chia(int a,int b){
        return (double) a/b;
    }
}
