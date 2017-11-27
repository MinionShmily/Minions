package com.example.shmily.minionsdelta;

/**
 * Created by Shmily on 2017/11/25.
 */

public class Date {
    private String dTitle;
    private String dDate;
    private String dEvent;
   public  Date(){

    }
    public Date(String dTitle,String dDate,String dEvent){
        this.dDate=dDate;
        this.dEvent=dEvent;
        this.dTitle=dTitle;
    }
    public String getdTitle(){
        return dTitle;
    }
    public String getdDate(){
        return dDate;
    }
    public String getdEvent(){
        return dEvent;
    }
    public void setdTitle(String s){
        this.dTitle=s;
    }
    public void setdDate(String s){
        this.dDate=s;
    }
    public void setdEvent(String s){
        this.dEvent=s;
    }

}
