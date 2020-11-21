package vvcl.bootiful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdderService implements Adder{
    private int num;

    public void baseNum(int base){
        this.num= base;
    }

    public int currentBase(){
        return num;
    }


    public int add(int adder){
        return this.num + adder;
    }

    public int accumulate(int adder){
        return this.num+= adder;
    }
}
