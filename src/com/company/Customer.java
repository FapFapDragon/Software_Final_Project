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
        this.setMembershipActive(false);
        this.membership = null;
        this.setCheckedIn(false);
        this.setRoom(null);
    }

    //Add membership
    public void addMembership(Membership membership)
    {
    	this.membership = membership;
    }

    //Check person into room
    public void checkIn(Room room, Date checkoutDate)
    {
    	checkedIn = room.checkIn(this, checkoutDate);
    	if (!checkedIn) {
    		System.out.println("Could not reserve room, Is it taken?");
    		return;
    	}
    	this.room = room;
    }
    
    public void checkOut()
    {
    	checkedIn = !room.checkOut();
    	if (checkedIn) {
    		System.out.println("Could not check out of room");
    		return;
    	}
    	this.room = null;
    }

    //Edit details of a check in
    public void modifyCheckIn()
    {
    	//May delete or implement as Needed by James
    }

    //add a note to the room
    public void addNote(boolean important, String note)
    {
    	if (important == true) {
    		importantNotes += ", " + note;
    	}
    	else {
    		notes += ", " + note;
    	}
    }

    //
    public void requestRoomService()
    {
    	
    }

    public void generateComplaint()
    {

    }

    public void removeComplaint()
    {

    }

	public boolean isMembershipActive() {
		return membershipActive;
	}

	public void setMembershipActive(boolean membershipActive) {
		this.membershipActive = membershipActive;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
}
