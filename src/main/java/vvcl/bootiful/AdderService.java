package vvcl.bootiful;

import org.springframework.stereotype.Service;

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
