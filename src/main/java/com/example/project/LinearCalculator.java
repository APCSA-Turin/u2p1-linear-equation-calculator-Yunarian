package com.example.project;

public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2)
    private int x1; 
    private int x2; 
    private int y1; 
    private int y2; 


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    //for x-values: the substring between the "(" and the "," is taken & converted to an int
    //for y-values: the substring between the "," and the ")" is taken & converted to an int
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        x1 = Integer.valueOf(point1.substring(1, point1.indexOf(",")));
        y1 = Integer.valueOf(point1.substring(point1.indexOf(",") + 1, point1.length() - 1));
        x2 = Integer.valueOf(point2.substring(1, point2.indexOf(",")));
        y2 = Integer.valueOf(point2.substring(point2.indexOf(",") + 1, point2.length() - 1));
    }


    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){x1 = newX1;}
    public void setY1(int newY1){y1 = newY1;}
    public void setX2(int newX2){x2 = newX2;}
    public void setY2(int newY2){y2 = newY2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    //takes the difference in x and y values, squares then, adds them together, then takes the square root of that result
    public double distance(){
        double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        return roundedToHundredth(distance);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        //to see if the slope is undefined
        if (x1 == x2) {
            return -999.99;
        }
        return roundedToHundredth( (double) (y2 - y1)/(x2 - x1));
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        //to see if the y-intercept is undefined
        if (x1 == x2) {
            return -999.99;
        }
        return roundedToHundredth(y1 - (slope * x1));
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double slope = slope();
        double yInt = yInt();
        //checks to see if the equation is undefined
        if (x1 == x2) {
            return "undefined";
        }

        if (yInt != 0.0 && slope != 0.0) {
            if (yInt >= 0) {return "y=" + slope + "x+" + yInt;}

            return "y=" + slope + "x" + yInt;
                
        } else if (yInt == 0.0) {
            return "y=" + slope + "x";

        }
        return "y=" + yInt;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100) / 100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 +  "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}