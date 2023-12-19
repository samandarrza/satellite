package com.company.model;

public class Satellite {
    private int satelliteId;
    private double latitude;
    private double longitude;
    private String timestamp;
    private String status;

    // Constructors
    public Satellite() {
    }

    public Satellite(int satelliteId, double latitude, double longitude, String timestamp, String status) {
        this.satelliteId = satelliteId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters
    public int getSatelliteId() {
        return satelliteId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setSatelliteId(int satelliteId) {
        this.satelliteId = satelliteId;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

