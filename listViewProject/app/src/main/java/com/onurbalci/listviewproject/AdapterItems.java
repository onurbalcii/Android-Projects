package com.onurbalci.listviewproject;

public class AdapterItems {

    public int ID;
    public String Name;
    public String Description;

    //for news details
    AdapterItems(int ID, String Name, String Description){
        this.ID = ID;
        this.Description = Description;
        this.Name = Name;
    }
}
