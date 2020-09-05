package com.kgw.moelist;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster;
    private String name;
    private String genre;
    private String synopsis;

    Movie(){

    }

    private Movie(Parcel in) {
        poster = in.readInt();
        name = in.readString();
        genre = in.readString();
        synopsis = in.readString();
        releaseYear = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    int getPoster() {
        return poster;
    }

    void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    String getSynopsis() {
        return synopsis;
    }

    void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    String getReleaseYear() {
        return releaseYear;
    }

    void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    private String releaseYear;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(name);
        dest.writeString(genre);
        dest.writeString(synopsis);
        dest.writeString(releaseYear);
    }
}
