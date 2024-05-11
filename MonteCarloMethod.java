package ohjelmointiDemot;
import java.util.Random;

/**
 * Approximating pi using Monte Carlo Method
 * Center of a circle is at (0.5, 0.5), radius 0.5 and dots gets assigned random coordinates between 0-1
 * @author rajuruoho
 * @version 11.5.2024
 */
public class MonteCarloMethod {
    
    /**
     * Measuring the distance of a dot and the center of a circle to determine
     * if the dot is inside of the circle or not
     * @param dots the amount of dots to be used
     */
    public static void MeasureDistance(int dots) {
        Random rand = new Random();
        double x, y; //x and y coordinate of the dot
        double cX = 0.5, cY = 0.5; //circle center coordinates
        int insideOfCircle = 0;
        
        for (int i = 0; i < dots; i++) {
            x = rand.nextDouble(); //random number between 0-1, but cannot ever be exactly 1
            y = rand.nextDouble();
            if (Math.sqrt(Math.pow(((cX-x)), 2) + Math.pow(((cY-y)),2)) < 0.5)
                insideOfCircle++;
        }
        double precision = 4 * insideOfCircle / (double)dots;
        System.out.println("Precision was: " + precision);
        System.out.println("Error: " + (precision - Math.PI) + "\n");
    }

    
    /**
     * @param args Not in use
     */
    public static void main(String[] args) {
        //Last number is 10 million. 100 million does not give that much more accuracy
        int [] dots = {10,100,1000,10000,100000,1000000,10000000};
        for (int i = 0; i < dots.length; i++) {
            MeasureDistance(dots[i]);
        }        
    }
}