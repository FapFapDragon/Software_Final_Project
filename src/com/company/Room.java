package com.company;

import java.util.Date;
import java.util.List;

public class Room {
    private int ID;
    private int beds;   //number of beds
    private int size; //Size scaled from 0 to something or other
    private boolean reserved;
    private boolean occupied;
    private String state;   //May use this instead of booleans for reserved or occupied
    private Customer client;
    private Date checkoutDate;
    private List<Date> futureBookings;
    private RoomServiceTicket roomService;

    public void createRoom()
    {

    }

    public void addBed()
    {

    }

    public void reserve()
    {

    }

    public List<Date> checkListings()
    {
        return futureBookings;
    }

    public Customer checkClient()
    {
        return client;
    }

    public void checkout()
    {

    }


}
