package com.onurbalci.javaoopdetails;

public interface Egitim {

    public boolean egitimAl();

    public default boolean egitimAlBody(){
        System.out.println("Eğitim almıyoruz");
        return false;
    }
}
