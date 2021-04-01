package hr.ferit.drazetic.sudokuapp;

public class Globalstwo {
    private static Globalstwo instance;

    private int data;

    public Globalstwo(){}

    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized Globalstwo getInstance(){
        if(instance==null){
            instance=new Globalstwo();
        }
        return instance;
    }
}
