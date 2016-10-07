/*\
:*: To change this license header, choose License Headers in Project Properties.
:*: To change this template file, choose Tools | Templates
:*: and open the template in the editor.
\*/
package quarter1;

/*\ 
:*:
:*: @author Bennett DenBleyker
:*: @author Skyler Cameron
:*:
\*/ 

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Quarter1 {
    public static List<Double> circleAreas = new ArrayList(); // Create ArrayList for circleAreas
    public static List<Double> numList = new ArrayList();
    public static Object circleColor;
    public static int radiusEntry;
    public static double lastEntry;
    private static final JFrame frame = new JFrame();
    private static boolean statsGiven = false;
    private static final Scanner stdIn = new Scanner(System.in);
    
    public static void main(String[] args) { // Main method
        nonApStuff();
        apStuff();
    }
    public static void nonApStuff() {
        boolean greaterThanOneK = true;
        System.out.print("Please enter a number: ");
        int input = stdIn.nextInt();
        for (int i = 1; i<=input; i++) {
            System.out.println(i);
        }
        
        System.out.print("Please enter another number: ");
        input = stdIn.nextInt();
        if (input >= 0) {
            MathFunctions.SquareRootAndAddThree(input);
        }
        if (lastEntry > 1000) {
            
        } else {
            numList.add(lastEntry);
        }
        
    }
    public static void apStuff() {
        radiusCheck();
        colorInput();
        circleStats();
        circleDraw();
    }
    public static void radiusCheck() {
        Object radius = JOptionPane.showInputDialog(frame, "Please input a radius\nPress 0 or Cancel to exit", null, JOptionPane.QUESTION_MESSAGE); // Asks to input radius in a pop-up
        radiusEntry = Integer.parseInt(radius.toString()); // Turn the input into a string
        if (radiusEntry >= 0) { // If radius is not negative
            circleAreas.add(MathFunctions.areaOfCircle(radiusEntry)); // calculate areaOfCircle via MathFunctions then print...
        } else { // If radiusEntry is less than 0 ...
            JOptionPane.showMessageDialog(null, "Radius is negative", "Error", JOptionPane.ERROR_MESSAGE); // Tell the user why the input was invalid
            radiusCheck(); // Ask again
        }
        if (circleAreas.get(0).equals(0.0)) { // If user hits cancel ...
            JOptionPane.showMessageDialog(null, "User entered 0 or pressed Cancel to exit", "Error", JOptionPane.ERROR_MESSAGE); // State why the program ended
            System.exit(0); // Exit the program
        }
    }
    public static void colorInput() {
        Object[] colors = {"Red", "Green", "Blue"}; // Set the text of the buttons
        circleColor = JOptionPane.showOptionDialog(frame, "What color should the circle be?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, colors, colors[1]); // Ask for colors with prespecified inputs
        if (circleColor.equals(0)) {circleColor = "Red";} // If the left button is pressed, it is red
        if (circleColor.equals(1)) {circleColor = "Green";} // If the middle button is pressed, it is green
        if (circleColor.equals(2)) {circleColor = "Blue";} // If the right button is pressed, it is blue
        if (circleColor.equals(-1)) {colorInput();} // If the dialog is closed, reopen it
    }
    public static void circleStats() {
        if(!statsGiven) { // If this pop-up hasn't appeared before ...
            JOptionPane.showMessageDialog(null, "CIRCLE:\n  Color: "+circleColor+"\n  Area : "+circleAreas.get(0), null, JOptionPane.INFORMATION_MESSAGE); // Give circle statistics in a pop-up
            statsGiven = true; // Make it so that this pop-up won't appear again
        }
    }
    public static void circleDraw() {
        frame.getContentPane().add(new CircleMaker(), BorderLayout.CENTER); // Creates the drawing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets how you can close the drawing
        frame.setSize(1500, 1500); // Sets the drawing's canvas size
        frame.setVisible(true); // Makes the drawing visible
    }
}