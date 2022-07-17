package javaPackage;

//Application that calculates

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class movie {
    public String title; //Movie name
    public int movie_length; //Movie length

    public movie(String name, int length){
        this.title = name; //Sets object variables
        this.movie_length = length;
    }
} //Movie Object Class

class flight {
    public String flightDest; //flight destination
    public int flight_length; //flight length

    public flight(String dest, int length){
        this.flightDest = dest; //Sets object variables
        this.flight_length = length;
    }
} //Flight Object Class

public class Main {

    public static void main(String[] args) throws IOException {

        boolean trueSum;
        int movie1_length = 0;
        int movie2_length = 0;
        int selectedFlight_length = 0;

        ArrayList<movie> movieList = new ArrayList<>();
        ArrayList<flight> flights = new ArrayList<>();

        //PROTOTYPE ONLY THIS MUST BE REPLACED BY A DATABASE

        movieList.add(new movie("The Godfather", 175));
        movieList.add(new movie("Finding Nemo", 100));
        movieList.add(new movie("Terminator", 107));
        movieList.add(new movie("Terminator 2: Judgement Day", 137));
        movieList.add(new movie("Reservoir Dogs", 99));
        movieList.add(new movie("Pulp Fiction", 154));
        movieList.add(new movie("Forrest Gump", 142));
        movieList.add(new movie("Fight Club", 139));
        movieList.add(new movie("The Matrix", 136));
        movieList.add(new movie("Goodfellas", 145));
        movieList.add(new movie("Saving Private Ryan", 169));
        movieList.add(new movie("Intersellar", 169));
        movieList.add(new movie("Star Wars", 121));
        movieList.add(new movie("Truman Show", 103));
        movieList.add(new movie("Toy Story", 81));
        movieList.add(new movie("Phone Booth", 81));
        movieList.add(new movie("Zombieland", 88));
        movieList.add(new movie("Office Space", 89));
        movieList.add(new movie("Ice Age", 81));
        movieList.add(new movie("My Neighbour Totoro", 86));

        //PROTOTYPE ONLY THIS CAN BE REPLACED BY AN API OR DATABASE
        //FLIGHTS ARE BASED ON EDINBURGH TO LISTED DESTINATIONS

        flights.add(new flight("Reykjavík", 150));
        flights.add(new flight("Budapest", 165));
        flights.add(new flight("Naples", 190));
        flights.add(new flight("Marrakesh", 240));
        flights.add(new flight("Athens", 245));
        flights.add(new flight("Bodrum", 275)); //First two movies and this destination will result in returning true
        flights.add(new flight("Cyprus", 295));
        flights.add(new flight("Gran Canaria", 300));
        flights.add(new flight("Egypt", 308));
        flights.add(new flight("Boston", 420));

        Scanner input = new Scanner(System.in); //Used for int inputs
        BufferedReader text = new BufferedReader(new InputStreamReader(System.in)); //Used to get text inputs, using scanner breaks during menu operation
        int choice;

        while (true) {
            System.out.println("1: Select Flight Destination");
            System.out.println("2: Movie Selection");
            System.out.println("3: Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Flight Destination");
                    String selectedFlight = text.readLine();
                    for (flight f : flights) {
                        if (selectedFlight.equals(f.flightDest)) {
                            {
                                selectedFlight_length = f.flight_length;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Select first Movie");
                    String movieOne = text.readLine();

                    for (movie m : movieList) {
                        if (movieOne.equals(m.title)) {
                            movie1_length = m.movie_length;
                        }
                    }

                    System.out.println("Select second Movie");
                    String movieTwo = text.readLine();

                    for (movie m : movieList) {
                        if (movieTwo.equals(m.title) && !movieTwo.equals(movieOne)) {
                            movie2_length = m.movie_length;
                            trueSum = movie1_length + movie2_length == selectedFlight_length;
                            System.out.println(trueSum);
                        }
                        if (movieOne.equals(movieTwo)){
                            System.out.println("Duplicate movie!");
                            break;
                        }
                    }
                    if(movie1_length + movie2_length < selectedFlight_length){
                        System.out.println("Can watch two movies, but flight would still be ongoing");
                        System.out.println(selectedFlight_length - movie1_length - movie2_length + " Minutes left");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 3.");
            }
        }
    }
}
