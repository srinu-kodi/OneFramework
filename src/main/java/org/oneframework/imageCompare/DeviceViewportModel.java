package org.oneframework.imageCompare;

import java.util.Arrays;

public class DeviceViewportModel {
    private int x;
    private int y;
    private int width;
    private int height;

    private String deviceName;

    private DeviceViewportModel[] deviceViewportModels;

    public DeviceViewportModel() {
    }

    public DeviceViewportModel(DeviceViewportModel[] deviceViewportModels) {
        this.deviceViewportModels = deviceViewportModels;
    }

    public DeviceViewportModel getDeviceViewport(String deviceName) {
        return Arrays.stream(deviceViewportModels).filter(deviceViewportModel -> deviceViewportModel.getDeviceName().equalsIgnoreCase(deviceName)).findFirst().get();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
