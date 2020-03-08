package com.company;

import java.util.Date;

import com.company.Enums.*;
public class Main {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
	// write your code here
    	DeskAttendant desk = new DeskAttendant();
    	Customer client1 = new Customer(1, 1234567, "address");
    	Customer client2 = new Customer(2, 1234567, "address");
    	Room room1 = new Room(1, 1, Size.KING, View.CITY, 1);
    	
    	System.out.println("can only add one client to a room");
    	System.out.println(desk.checkIn(client1, room1, new Date(2000, 12, 12)));
    	System.out.println(desk.checkIn(client1, room1, new Date(2000, 12, 12)));
    	System.out.println(desk.checkIn(client2, room1, new Date(2000, 12, 12)));
    	System.out.println("");
    	
    	System.out.println("checkout only works if your in a room");
    	System.out.println(desk.checkOut(client2));
    	System.out.println(desk.checkOut(client1));
    	System.out.println(desk.checkOut(client1));
    	System.out.println("");
    	
    	System.out.println("checkout only works if your in a room");
    	System.out.println(desk.createReservation(client1, room1, new Date(2020, 12, 12)));
    	System.out.println(desk.createReservation(client2, room1, new Date(2020, 12, 12)));
    	System.out.println(desk.createReservation(client2, room1, new Date(2020, 12, 12)));    	
    	
    	System.out.println(room1.getFutureBookings());
    }
}
