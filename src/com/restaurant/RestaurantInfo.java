package com.restaurant;

public class RestaurantInfo {
    public int restaurantId;
    public String retaurantName;
    public String retaurantPhoto;
    public String restaurantPhone;
    public String address;
    public String business_hours;
    public Double latitude;
    public Double longitude;
    public String location;

    public RestaurantInfo(int restaurantId, String retaurantName, String retaurantPhoto, String restaurantPhone, String address, String business_hours, Double latitude, Double longitude, String location) {
        this.restaurantId = restaurantId;
        this.retaurantName = retaurantName;
        this.retaurantPhoto = retaurantPhoto;
        this.restaurantPhone = restaurantPhone;
        this.address = address;
        this.business_hours = business_hours;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRetaurantName() {
        return retaurantName;
    }

    public void setRetaurantName(String retaurantName) {
        this.retaurantName = retaurantName;
    }

    public String getRetaurantPhoto() {
        return retaurantPhoto;
    }

    public void setRetaurantPhoto(String retaurantPhoto) {
        this.retaurantPhoto = retaurantPhoto;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "restaurantId=" + restaurantId +
                ", retaurantName='" + retaurantName + '\'' +
                ", retaurantPhoto='" + retaurantPhoto + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", address='" + address + '\'' +
                ", business_hours='" + business_hours + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", location='" + location + '\'' +
                '}';
    }
}
