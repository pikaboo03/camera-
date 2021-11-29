package cameraTextUI;

import cameraModel.Lens;
import cameraModel.LensManager;
import cameraModel.DepthOfFieldCalculator;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CameraTextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager) {
        this.manager = manager;
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {


        int count;
        do {
            System.out.println("Lenses to pick from: ");
            int i =0;
            for (Lens lens : manager) {
                System.out.println(i + lens.toString());
                i++;
            }
            System.out.println("-1 to exit");
            System.out.print(": ");
            count = in.nextInt();

            switch (count) {
                case -1 -> {

                }
                case 0 -> {
                    System.out.print("Aperture [ The F number]: ");
                    double sAperture = in.nextDouble();
                    if (sAperture < manager.getLens(0).getAperture()) {
                        System.out.println("incorrect Aperture value.");
                        continue;
                    }
                    System.out.print("Distance to Subject [m]: ");
                    double sDistance = in.nextDouble();
                    if(sDistance < 0){
                        System.out.println("incorrect Distance value");
                        continue;
                    }
                    DepthOfFieldCalculator dp = new DepthOfFieldCalculator(manager.getLens(0), sDistance, sAperture);

                    System.out.println("In focus " + formatM(dp.nearFocalPoint()) + "m to " + formatM(dp.farFocalPoint()) + "mm [DoF] = " + formatM(dp.depthOfField())+ "m");
                    System.out.println(" hyperfocal Distance = " + formatM(dp.hyperfocalDistance())+"m");


                }
                case 1 -> {
                    System.out.print("Aperture [ The F number]: ");
                    double sAperture = in.nextDouble();
                    if (sAperture < manager.getLens(0).getAperture()) {
                        System.out.println("incorrect Aperture value.");
                        continue;
                    }
                    System.out.print("Distance to Subject [m]: ");
                    double sDistance = in.nextDouble();
                    if(sDistance < 0){
                        System.out.println("incorrect Distance value");
                        continue;
                    }

                    DepthOfFieldCalculator dp = new DepthOfFieldCalculator(manager.getLens(1), sDistance, sAperture);

                    System.out.println("In focus " + formatM(dp.nearFocalPoint()) + "m to " + formatM(dp.farFocalPoint()) + "m [DoF] = " + formatM(dp.depthOfField())+"m");
                    System.out.println(" hyperfocal Distance = " + formatM(dp.hyperfocalDistance())+"m");


                }
                case 2 -> {
                    System.out.print("Aperture [ The F number]: ");
                    double sAperture = in.nextDouble();
                    if (sAperture < manager.getLens(0).getAperture()) {
                        System.out.println("Error: incorrect Aperture value.");
                        continue;
                    }
                    System.out.print("Error : Distance to Subject [m]: ");
                    double sDistance = in.nextDouble();
                    if(sDistance < 0){
                        System.out.println("incorrect Distance value");
                        continue;
                    }
                    DepthOfFieldCalculator dp = new DepthOfFieldCalculator(manager.getLens(2), sDistance, sAperture);

                    System.out.println("In focus " + formatM(dp.nearFocalPoint()) + "m to " + formatM(dp.farFocalPoint()) + "m [DoF] = " + formatM(dp.depthOfField())+ "m");
                    System.out.println(" hyperfocal Distance = " + formatM(dp.hyperfocalDistance()) + "m");

                }
                case 3 -> {
                    System.out.print("Aperture [ The F number]: ");
                    double sAperture = in.nextDouble();
                    if (sAperture < manager.getLens(0).getAperture()) {
                        System.out.println("Error: incorrect Aperture value.");
                        continue;
                    }
                    System.out.print("Distance to Subject [m]: ");
                    double sDistance = in.nextDouble();
                    if(sDistance < 0){
                        System.out.println("incorrect Distance value");
                        continue;
                    }
                    DepthOfFieldCalculator dp = new DepthOfFieldCalculator(manager.getLens(3), sDistance, sAperture);

                    System.out.println("In focus " + formatM(dp.nearFocalPoint()) + "m to " + formatM(dp.farFocalPoint()) + "m [DoF] = " + formatM(dp.depthOfField())+"m");
                    System.out.println(" hyperfocal Distance = " + formatM(dp.hyperfocalDistance())+"m");

                }

                default -> System.out.println("Incorrect Lens index");
            }
        } while (count != -1);

    }
    private String formatM ( double distanceInM){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM/1000);
    }
}


