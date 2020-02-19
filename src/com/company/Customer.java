package com.company;

import java.util.Date;
import java.util.List;

public class Customer {
    private int ID;
    private boolean membershipActive;
    private Membership membership;
    private Room room; //room being stayed in
    private boolean checkedIn;
    private Date checkInDate;
    private Date lastVisit;
    private List<Room> previousRooms;
    private int phoneNumber;
    private String address;
    //Didn't add credit card info as was told by hotels that they don't store any information on payments
    private String notes;
    private String importantNotes;

    private boolean roomService;
    private RoomServiceTicket RS;

    private boolean complaint;
    private ComplaintTicket complaintTicket;

    private WakeUpTimer wakeUpTimer;


    public Customer(int ID, Date lastVisit, List<Room> previousRooms, int phoneNumber, String address)
    {
        this.ID = ID;
        this.lastVisit = lastVisit;
        this.previousRooms = previousRooms;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipActive = false;
        this.membership = null;
        this.checkedIn = false;
        this.room = null;
    }

    //Add membership
    public void addMembership()
    {

    }

    //Check person into room
    public void checkIn(Room room)
    {

    }

    public void modifyCheckIn()
    {


    }

    public void addNote(boolean important, String note)
    {

    }

    public void requestRoomService()
    {

    }

    public void changeRoomServiceStatus()
    {

    }

    public void generateComplaint()
    {

    }

    public void removeComplaint()
    {

    }

}
