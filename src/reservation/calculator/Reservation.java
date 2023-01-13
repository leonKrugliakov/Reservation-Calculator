//*****************************************************************************************************
//
//      File:               Reservation.java
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
//      2.  Validator.java  -  Contains the Validator class
//
//*****************************************************************************************************

//package reservation.calculator;

//*****************************************************************************************************

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.time.temporal.ChronoUnit;

//*****************************************************************************************************

public class Reservation 
{
    private LocalDate arrivalDate,
                departureDate;
    private final double PRICE_PER_NIGHT = 115.00;
    
    //*****************************************************************************************************
    
    public Reservation()
    {
        arrivalDate = LocalDate.now();
        departureDate = LocalDate.now();
    }
    
    //*****************************************************************************************************
    
    public Reservation(LocalDate arrivalDate, LocalDate departureDate)
    {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    
    //*****************************************************************************************************
    
    public LocalDate getArrivalDate()
    {
        return arrivalDate;
    }
    
    //*****************************************************************************************************
    
    public LocalDate getDepartureDate()
    {
        return departureDate;
    }
    
    //*****************************************************************************************************
    
    public void setArrivalDate(LocalDate arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
    
    //*****************************************************************************************************
    
    public void setDepartureDate(LocalDate departureDate)
    {
        this.departureDate = departureDate;
    }
    
    //*****************************************************************************************************
    
    public String getArrivalDateFormatted(LocalDate arrivalDate,
            DateTimeFormatter formatter)
    {
        String formatDate = arrivalDate.format(formatter);
        return formatDate;
    }
    
    //*****************************************************************************************************
    
    public String getDepartureDateFormatted(LocalDate departureDate, 
            DateTimeFormatter formatter)
    {
        String formatDate = departureDate.format(formatter);
        return formatDate;
    }
    
    //*****************************************************************************************************
    
    public int getNumberOfNights(LocalDate arrivalDate,
            LocalDate departureDate)
    {
        int nights = (int)ChronoUnit.DAYS.between(arrivalDate, departureDate);
        return nights;
    }
    
    //*****************************************************************************************************
    
    public double getTotalPrice(long nights)
    {
        double finalPrice = (double)nights * PRICE_PER_NIGHT;
        return finalPrice;
    }
    
    //*****************************************************************************************************
    
    public String getTotalPriceFormatted(int nights, 
            NumberFormat currency)
    {
        double totalPrice = getTotalPrice(nights);
        String formattedTotalPrice = currency.format(totalPrice);
        return formattedTotalPrice;
    }
    
    //*****************************************************************************************************
    
    public String toString(LocalDate arrivalDate, LocalDate departureDate, 
            DateTimeFormatter formatter, NumberFormat currency, int nights)
    {
        String output = "Arrival Date: " + getArrivalDateFormatted(arrivalDate, 
                formatter) + "\n";
        output += "Departure Date: " + getDepartureDateFormatted(departureDate, 
                formatter) + "\n";
        output += "Price: " + currency.format(PRICE_PER_NIGHT) + " per night\n";
        output += "Total price: " + 
                getTotalPriceFormatted(nights, currency) + 
                " for " + nights + " nights\n";
        
        return output;
    }
}