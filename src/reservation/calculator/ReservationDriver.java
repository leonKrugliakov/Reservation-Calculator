//*****************************************************************************************************
//
//      File:               ReservationDriver.java
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
//      1.  Reservation.java  -  Contains the Reservation class
//      2.  Validator.java  -  Contains the Validator class
//
//*****************************************************************************************************

//package reservation.calculator;

//*****************************************************************************************************

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.time.Month;
import java.util.Scanner;

//*****************************************************************************************************

public class ReservationDriver 
{
    public static void main(String[] args) 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, "
                + "LLLL dd, yyyy");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);
        String contin = "y";
        int arrivalMonth,
                arrivalDay,
                arrivalYear,
                departureMonth,
                departureDay,
                departureYear,
                nights;
        Month arrivalMonthFull = Month.JANUARY,
                    departureMonthFull = Month.JANUARY;
        
        System.out.println("Welcome to the Reservation Calculator.\n");
        
        while(contin.equalsIgnoreCase("y"))
        {

            arrivalMonth = Validator.getIntWithinRange(sc, 
                    "Enter the arrival month (1-12): ", 1, 12);
            arrivalDay = Validator.getIntWithinRange(sc, 
                    "Enter the arrival day (1-31): ", 1, 31);
            arrivalYear = Validator.getIntWithinRange(sc, 
                    "Enter the arrival year: ", 2020, 2030);
            
            System.out.println();
            
            departureMonth = Validator.getIntWithinRange(sc, 
                    "Enter the departure month (1-12): ", 1, 12);
            departureDay = Validator.getIntWithinRange(sc, 
                    "Enter the departure day (1-31): ", 1, 31);
            departureYear = Validator.getIntWithinRange(sc, 
                    "Enter the departure year: ", 2020, 2030);
            
            System.out.println();
            
            switch(arrivalMonth)
            {
                case 1: 
                    arrivalMonthFull = Month.JANUARY;
                    break;
                case 2:
                    arrivalMonthFull = Month.FEBRUARY;
                    break;
                case 3:
                    arrivalMonthFull = Month.MARCH;
                    break;
                case 4:
                    arrivalMonthFull = Month.APRIL;
                    break;
                case 5:
                    arrivalMonthFull = Month.MAY;
                    break;
                case 6:
                    arrivalMonthFull = Month.JUNE;
                    break;
                case 7:
                    arrivalMonthFull = Month.JULY;
                    break;
                case 8:
                    arrivalMonthFull = Month.AUGUST;
                    break;
                case 9:
                    arrivalMonthFull = Month.SEPTEMBER;
                    break;
                case 10:
                    arrivalMonthFull = Month.OCTOBER;
                    break;
                case 11:
                    arrivalMonthFull = Month.NOVEMBER;
                    break;
                case 12:
                    arrivalMonthFull = Month.DECEMBER;
                    break;
            }
            
            switch(departureMonth)
            {
                case 1: 
                    departureMonthFull = Month.JANUARY;
                    break;
                case 2:
                    departureMonthFull = Month.FEBRUARY;
                    break;
                case 3:
                    departureMonthFull = Month.MARCH;
                    break;
                case 4:
                    departureMonthFull = Month.APRIL;
                    break;
                case 5:
                    departureMonthFull = Month.MAY;
                    break;
                case 6:
                    departureMonthFull = Month.JUNE;
                    break;
                case 7:
                    departureMonthFull = Month.JULY;
                    break;
                case 8:
                    departureMonthFull = Month.AUGUST;
                    break;
                case 9:
                    departureMonthFull = Month.SEPTEMBER;
                    break;
                case 10:
                    departureMonthFull = Month.OCTOBER;
                    break;
                case 11:
                    departureMonthFull = Month.NOVEMBER;
                    break;
                case 12:
                    departureMonthFull = Month.DECEMBER;
                    break;
            }
            
            LocalDate arrivalDate = LocalDate.of(arrivalYear, 
                    arrivalMonthFull, arrivalDay);
            LocalDate departureDate = LocalDate.of(departureYear, 
                    departureMonthFull, departureDay);
            
            Reservation r = new Reservation(arrivalDate, departureDate);
            
            nights = r.getNumberOfNights(arrivalDate, departureDate);
            
            System.out.println(r.toString(arrivalDate, departureDate, formatter, 
                    currency, nights));
            
            sc.nextLine();
            contin = Validator.getChoiceString(sc, 
                    "Another reservation? (y/n): ", "y", "n");
        }
        
    }
}

//*****************************************************************************************************

/*
Welcome to the Reservation Calculator.

Enter the arrival month (1-12): 5
Enter the arrival day (1-31): 16
Enter the arrival year: 2020

Enter the departure month (1-12): 5
Enter the departure day (1-31): 18
Enter the departure year: 2020

Arrival Date: Saturday, May 16, 2020
Departure Date: Monday, May 18, 2020
Price: $115.00 per night
Total price: $230.00 for 2 nights

Another reservation? (y/n): n
*/