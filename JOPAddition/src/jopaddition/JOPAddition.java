package jopaddition;

import javax.swing.*;



public class JOPAddition{
    
    public static void main(String[] args){
        
        String firstNumber = JOptionPane.showInputDialog("Enter first integer");
        String secondNumber = JOptionPane.showInputDialog("Enter second integer");
        
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        
        int sum = num1 + num2;
        
        JOptionPane.showMessageDialog(null, "The sum is: " + sum, "Sum of two numbers", JOptionPane.PLAIN_MESSAGE);
        
        
    }
}