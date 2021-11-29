package cameraModel;

public class DepthOfFieldCalculator {
    private Lens lens;
    private double selectedDistance;
    private double selectedAperture;
    private static final double COC = 0.029;

    public DepthOfFieldCalculator(Lens lens, double selectedDistance, double selectedAperture) {
        this.lens = lens;
        this.selectedDistance =  selectedDistance ;
        this.selectedAperture = selectedAperture;
    }


    public Lens getLens() {
        return lens;
    }

    public void setLens(Lens lens) {
        this.lens = lens;
    }

    public double getSelectedAperture() {
        return selectedAperture;
    }

    public double getSelectedDistance() {
        return selectedDistance;
    }

    public void setSelectedDistance(double selectedDistance) {
        this.selectedDistance = selectedDistance;
    }

    public void setSelectedAperture(double selectedAperture) {
        this.selectedAperture = selectedAperture;
    }

    public double hyperfocalDistance(){
        return  ((this.lens.getFocalLength()*this.lens.getFocalLength())/(selectedAperture*COC));

    }

    public double nearFocalPoint (){
        return ((hyperfocalDistance() * selectedDistance*1000)/(hyperfocalDistance()+ ((selectedDistance*1000) - lens.getFocalLength()) ));
    }

    public double farFocalPoint (){
        double value = Double.POSITIVE_INFINITY;
        if(selectedDistance*1000 > hyperfocalDistance())
            return value;
        return ((hyperfocalDistance() * selectedDistance*1000)/(hyperfocalDistance()-((selectedDistance*1000) - lens.getFocalLength()) ));
    }

    public double depthOfField (){
        return farFocalPoint() - nearFocalPoint();
    }
}
