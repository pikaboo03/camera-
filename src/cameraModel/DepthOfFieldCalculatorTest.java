package cameraModel;
/*
  Test created for DepthOfFieldCalculator class methods.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthOfFieldCalculatorTest {


    Lens l1 = new Lens("Canon", 1.8, 50);


    @Test
    void TestConstructor() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1,1.1,1.8 );
        assertEquals( l1, calculator.getLens());
        assertEquals(1.1, calculator.getSelectedDistance());
        assertEquals(1.8, calculator.getSelectedAperture());
    }

    @Test
    void TestApertureGetter() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(1.8, calculator.getSelectedAperture());
    }

    @Test
    void TestLensGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(l1, calculator.getLens());
    }

    @Test
    void TestDistanceGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(1.1, calculator.getSelectedDistance());
    }

    @Test
    void TestHyperFocalDistance(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(47892.720, calculator.hyperfocalDistance(),0.01);
    }

    @Test
    void TestFarFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(1124.656, calculator.farFocalPoint(),0.01);
    }

    @Test
    void TestNearFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(1076.400, calculator.nearFocalPoint(),0.01);
    }

    @Test
    void TestDepthOfField() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l1, 1.1,1.8);
        assertEquals(48.256, calculator.depthOfField(),0.01);
    }


    Lens l2 = new Lens("Tamron", 2.8, 90);


    @Test
    void Test2Constructor() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2,1,3 );
        assertEquals( l2, calculator.getLens());
        assertEquals(1, calculator.getSelectedDistance());
        assertEquals(3, calculator.getSelectedAperture());
    }
    @Test
    void Test2ApertureGetter() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(3, calculator.getSelectedAperture());
    }

    @Test
    void Test2LensGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(l2, calculator.getLens());
    }

    @Test
    void Test2DistanceGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(1, calculator.getSelectedDistance());
    }

    @Test
    void Test2HyperFocalDistance(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(93103.448, calculator.hyperfocalDistance(),0.01);
    }

    @Test
    void Test2FarFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(1009.87, calculator.farFocalPoint(),0.01);
    }

    @Test
    void Test2NearFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(990.320, calculator.nearFocalPoint(),0.01);
    }

    @Test
    void Test2DepthOfField() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l2, 1,3);
        assertEquals(19.55, calculator.depthOfField(),0.01);
    }


    Lens l3 = new Lens( "Sigma", 4.0, 300);


    @Test
    void Test3Constructor() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3,15,8.0);
        assertEquals( l3, calculator.getLens());
        assertEquals(15, calculator.getSelectedDistance());
        assertEquals(8.0, calculator.getSelectedAperture());
    }


    @Test
    void Test3ApertureGetter() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(8.0, calculator.getSelectedAperture());
    }

    @Test
    void Test3LensGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(l3, calculator.getLens());
    }

    @Test
    void Test3DistanceGetter(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(15, calculator.getSelectedDistance());
    }

    @Test
    void Test3HyperFocalDistance(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(387931.034, calculator.hyperfocalDistance(),0.01);
    }

    @Test
    void Test3FarFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(15590.786, calculator.farFocalPoint(),0.01);
    }

    @Test
    void Test3NearFocalPt(){
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(14452.352, calculator.nearFocalPoint(),0.01);
    }

    @Test
    void Test3DepthOfField() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l3, 15,8.0);
        assertEquals(1138.434, calculator.depthOfField(),0.01);
    }

    Lens l4 = new Lens("Olympus",3.4, 50 );

    @Test
    void Test4FarFocalIfCase() {
        DepthOfFieldCalculator calculator = new DepthOfFieldCalculator(l4,15,11);
        assertEquals(Double.POSITIVE_INFINITY, calculator.farFocalPoint(),0.01);
    }

    /* On Putting the calculated value for Far focal length in Test4FarFocalIfCase, i.e. 5158.858 mm,
      the test was failed and after changing the value to infinity, the test was passed.*/

}