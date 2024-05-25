package com.example.sanjar_shop.model;



import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CMODEL implements Parcelable, Serializable {
    @SerializedName("id")
    @Expose
    int modelId;

    @SerializedName("name")
    @Expose
    String modelName;

   

    protected CMODEL(Parcel in) {
        modelId = in.readInt();
        modelName = in.readString();
    }

    public static final Creator<CMODEL> CREATOR = new Creator<CMODEL>() {
        @Override
        public CMODEL createFromParcel(Parcel in) {
            return new CMODEL(in);
        }

        @Override
        public CMODEL[] newArray(int size) {
            return new CMODEL[size];
        }
    };

    public CMODEL(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "CMODEL{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelId() {
        return modelId;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(modelId);
        dest.writeString(modelName);
    }
}