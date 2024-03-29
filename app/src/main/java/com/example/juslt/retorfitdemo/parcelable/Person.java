package com.example.juslt.retorfitdemo.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juslt on 2019/9/10
 */
public class Person implements Parcelable {
    private String name;
    private int size;

    protected Person(Parcel in) {
        name = in.readString();
        size = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(size);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
