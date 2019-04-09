package com.example.qedquestioneveryday;

public class ImageSelector{


    public void SetCurrentImageNumber(int CurrentImageNumber)
    {
        mCurrentImageNumber=CurrentImageNumber;
    }
    public int GetCurrentImageNumber()
    {
        return mCurrentImageNumber;
    }

    int mCurrentImageNumber;

}