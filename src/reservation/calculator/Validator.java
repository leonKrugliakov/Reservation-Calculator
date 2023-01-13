//*****************************************************************************************************
//
//      File:               Validator.java
//
//      Student:            Leon Krugliakov
//
//      Assignment:         Assignment #7
//
//      Course Name:        Java I
//
//      Course Number:      COSC 2050 - 01
//
//      Due:                March 23rd, 2020
//
//
//      This program takes in user input for an arrival date as well as the 
//      departure date. Then it calculates the total cost of staying at the
//      hotel at a predetermined rate. Then it displays the results to the user.
//
//      Other files required:
//      1.  ReservationDriver.java  -  Contains the Main method
//      2.  Reservation.java  -  Contains the Reservation class
//
//*****************************************************************************************************

//package reservation.calculator;

//*****************************************************************************************************

import java.util.InputMismatchException;
import java.util.Scanner;

//*****************************************************************************************************

public class Validator 
{
    public static int getInt(Scanner sc, String prompt)
    {
        String valid = "n";
        int input = 0;
        
        while(valid.equalsIgnoreCase("n")){
            
            try
            {
                System.out.print(prompt);
                input = sc.nextInt();
                valid = "y";
            }
            catch(InputMismatchException e)
            {
                System.out.println("The input you ahve eneterd is invalid, "
                        + "it must be an integer. Try again!");
                sc.nextLine();
                continue;
            }
            
        }
        
        return input;
    }
    
    //*****************************************************************************************************
    
    public static int getIntWithinRange(Scanner sc, String prompt,
            int min, int max)
    {
        String valid = "n";
        int input = 0;
        
        while(valid == "n")
        {
            
            input = getInt(sc, prompt);
            
            if(input < min)
            {
                System.out.println("The input you have entered cannot be "
                        + "lower than " + min + ", please try again!");
            }
            else if(input > max)
            {
                System.out.println("The input you have entered cannot be "
                        + "higher than " + max + ", please enter a value "
                                + "smaller then the amount on the account!");
            }
            else
            {
                valid = "y";
            }
            
        }
        
        return input;
    }
    
    //*****************************************************************************************************
    
    public static String getRequiredString(Scanner sc, String prompt)
    {
        String input = "",
                valid = "n";
        
        while(valid == "n"){
            
            System.out.print(prompt);
            input = sc.nextLine();
            
            if(input.isEmpty())
            {
                System.out.println("Please enter an input, this"
                        + " line can't be left blank!");
            }
            else if(!input.isEmpty())
            {
                valid = "y";
            }
            
        }
        
        return input;
        
    }
    
    //*****************************************************************************************************
    
    public static String getChoiceString(Scanner sc, 
            String prompt, String s1, String s2)
    {
        String valid = "no",
                input = "";
        
        while(valid == "no")
        {
            input = getRequiredString(sc, prompt);
            if(input.equalsIgnoreCase(s1))
            {
                valid = "yes";
            }
            else if(input.equalsIgnoreCase(s2))
            {
                valid = "yes";
            }
            else
            {
                System.out.println("The input you have entered is invalid."
                        + " Please enter 'y' or 'n' as your answer!");
                valid = "no";
            }
        }
        
        return input;
    }
}
