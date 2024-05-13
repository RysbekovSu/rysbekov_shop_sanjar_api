
package com.example.rysbekov_shop_api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelM implements Parcelable, Serializable {

    @SerializedName("id")
    @Expose
    long modelId;

    @SerializedName("title")
    @Expose
    String modelTitle;

    @SerializedName("price")
    @Expose
    Double modelPrice;

    @SerializedName("description")
    @Expose
    String modelDescription;

    @SerializedName("image")
    @Expose
    String modelImage;

    public ModelM(long modelId, String modelTitle, Double modelPrice, String modelDescription, String modelImage) {
        this.modelId = modelId;
        this.modelTitle = modelTitle;
        this.modelPrice = modelPrice;
        this.modelDescription = modelDescription;
        this.modelImage = modelImage;
    }

    @Override
    public String toString() {
        return "ModelM{" +
                "modelId=" + modelId +
                ", modelTitle='" + modelTitle + '\'' +
                ", modelPrice=" + modelPrice +
                ", modelDescription='" + modelDescription + '\'' +
                ", modelImage='" + modelImage + '\'' +
                '}';
    }

    protected ModelM(Parcel in) {
        modelId = in.readLong();
        modelTitle = in.readString();
        if (in.readByte() == 0) {
            modelPrice = null;
        } else {
            modelPrice = in.readDouble();
        }
        modelDescription = in.readString();
        modelImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(modelId);
        dest.writeString(modelTitle);
        if (modelPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(modelPrice);
        }
        dest.writeString(modelDescription);
        dest.writeString(modelImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelM> CREATOR = new Creator<ModelM>() {
        @Override
        public ModelM createFromParcel(Parcel in) {
            return new ModelM(in);
        }

        @Override
        public ModelM[] newArray(int size) {
            return new ModelM[size];
        }
    };

    public long getModelId() {
        return modelId;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    public Double getModelPrice() {
        return modelPrice;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public String getModelImage() {
        return modelImage;
    }
}
