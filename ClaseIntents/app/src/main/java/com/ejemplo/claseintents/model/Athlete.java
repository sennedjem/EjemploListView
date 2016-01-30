package com.ejemplo.claseintents.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sebastian on 08/01/16.
 */
public class Athlete implements Parcelable{
    private String name;
    private Integer age;
    private String sport;
    private Integer id;

    public static final Parcelable.Creator<Athlete> CREATOR = new Creator<Athlete>() {

        public Athlete createFromParcel(Parcel source) {
            Athlete mAthlete = new Athlete(source.readString(),source.readInt(),source.readString());
            return mAthlete;
        }
        public Athlete[] newArray(int size) {
            return new Athlete[size];
        }

    };

    public Athlete(String name, Integer age, String sport) {
        this.name = name;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(sport);
    }
}
