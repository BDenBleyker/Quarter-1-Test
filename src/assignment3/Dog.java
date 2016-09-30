/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package assignment3;

/**
 *
 * @author benne_000
 */
public class Dog extends Animal {
    
    public Dog() {
        super(4, "Woof");
    }
    
    public void walkTo(int x, int y) {
        System.out.println("Walking");
        super.walkTo(x, y);
        System.out.println("Wagging Tail");
    }
    
}
