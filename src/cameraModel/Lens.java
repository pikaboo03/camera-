package cameraModel;
import java.lang.String;

public class Lens {
    private String make;
    private double aperture;
    private int focalLength;

    public Lens(String make, double aperture, int focalLength) {
        this.make = make;
        this.aperture = aperture;
        this.focalLength = focalLength;
    }

    public String getMake() {
        return make;
    }

    public double getAperture() {
        return aperture;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setAperture(double aperture) {
        this.aperture = aperture;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    @Override
    public String toString() {
        return ". " + make  + "  " + focalLength + "mm   F" + aperture ;
    }


}

