package com.fadh.perkiraancuaca.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TodayWeather implements Serializable , Parcelable {
  @SerializedName("coord")
  @Expose
  private Coord coord;
  @SerializedName("weather")
  @Expose
  private List<Weather> weather = null;
  @SerializedName("base")
  @Expose
  private String base;
  @SerializedName("main")
  @Expose
  private Main main;
  @SerializedName("visibility")
  @Expose
  private Integer visibility;
  @SerializedName("wind")
  @Expose
  private Wind wind;
  @SerializedName("clouds")
  @Expose
  private Clouds clouds;
  @SerializedName("dt")
  @Expose
  private Integer dt;
  @SerializedName("sys")
  @Expose
  private Sys sys;
  @SerializedName("timezone")
  @Expose
  private Integer timezone;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("cod")
  @Expose
  private Integer cod;
//
//  public static Creator<TodayWeather> getCREATOR() {
//    return CREATOR;
//  }

  public Coord getCoord() {
    return coord;
  }

  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public Main getMain() {
    return main;
  }

  public void setMain(Main main) {
    this.main = main;
  }

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public Wind getWind() {
    return wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }

  public Clouds getClouds() {
    return clouds;
  }

  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  public Integer getDt() {
    return dt;
  }

  public void setDt(Integer dt) {
    this.dt = dt;
  }

  public Sys getSys() {
    return sys;
  }

  public void setSys(Sys sys) {
    this.sys = sys;
  }

  public Integer getTimezone() {
    return timezone;
  }

  public void setTimezone(Integer timezone) {
    this.timezone = timezone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCod() {
    return cod;
  }

  public void setCod(Integer cod) {
    this.cod = cod;
  }

  protected TodayWeather(Parcel in) {
    this.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
    in.readList(this.weather, (com.fadh.perkiraancuaca.model.Weather.class.getClassLoader()));
    this.base = ((String) in.readValue((String.class.getClassLoader())));
    this.main = ((Main) in.readValue((Main.class.getClassLoader())));
    this.visibility = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
    this.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
    this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
    this.timezone = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.name = ((String) in.readValue((String.class.getClassLoader())));
    this.cod = ((Integer) in.readValue((Integer.class.getClassLoader())));
  }

  public static final Creator<TodayWeather> CREATOR = new Creator<TodayWeather>() {
    @Override
    public TodayWeather createFromParcel(Parcel in) {
      return new TodayWeather(in);
    }

    @Override
    public TodayWeather[] newArray(int size) {
      return new TodayWeather[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeValue(coord);
    parcel.writeList(weather);
    parcel.writeValue(base);
    parcel.writeValue(main);
    parcel.writeValue(visibility);
    parcel.writeValue(wind);
    parcel.writeValue(clouds);
    parcel.writeValue(dt);
    parcel.writeValue(sys);
    parcel.writeValue(timezone);
    parcel.writeValue(id);
    parcel.writeValue(name);
    parcel.writeValue(cod);
  }
  public TodayWeather(Coord coord, List<Weather> weather, String base, Main main, Integer visibility, Wind wind, Clouds clouds, Integer dt, Sys sys, Integer timezone, Integer id, String name, Integer cod) {
    super();
    this.coord = coord;
    this.weather = weather;
    this.base = base;
    this.main = main;
    this.visibility = visibility;
    this.wind = wind;
    this.clouds = clouds;
    this.dt = dt;
    this.sys = sys;
    this.timezone = timezone;
    this.id = id;
    this.name = name;
    this.cod = cod;
  }
}
