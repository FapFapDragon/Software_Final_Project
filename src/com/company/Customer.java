package com.company;

import java.util.Date;
import java.util.List;

public class Customer {
    private int ID;
    private boolean membershipActive;
    private Membership membership;
    private Booking booking; //room being stayed in
    private boolean checkedIn;
    private Date checkInDate;
    private Date lastVisit;
    private List<Booking> previousBookings;
    private int phoneNumber;
    private String address;
    //Didn't add credit card info as was told by hotels that they don't store any information on payments
    private String notes;
    private String importantNotes;

    private boolean complaint;
    private ComplaintTicket complaintTicket;

    private WakeUpTimer wakeUpTimer;


    public Customer(int ID, int phoneNumber, String address)
    {
        this.ID = ID;
        this.lastVisit = null;
        this.previousBookings = null;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.complaint = false;
        this.setMembershipActive(false);
        this.membership = null;
        this.setCheckedIn(false);
    }

    //Add membership
    public void addMembership(Membership membership)
    {
    	this.membership = membership;
    }

    //Check person into room
    public boolean checkIn(Booking booking)
    {
    	this.setBooking(booking);
    	return true;
    }
    
    public boolean checkOut()
    {
    	this.setBooking(null);
    	return true;
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

    public void generateComplaint(String desciption, int roomID, Date openTime, boolean complete)
    {
    	complaintTicket = new ComplaintTicket(desciption, roomID, openTime, complete);
    	complaint = true;
    }

    public void removeComplaint()
    {
    	complaint = false;
    	complaintTicket.closeTicket();
    }

	public boolean isMembershipActive() {
		return membershipActive;
	}

	public void setMembershipActive(boolean membershipActive) {
		this.membershipActive = membershipActive;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
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
	
	public Room getRoom() {
		if (this.getBooking() == null)
			return null;
		return this.getBooking().getRoom();
	}

	public WakeUpTimer getWakeUpTimer() {
		return wakeUpTimer;
	}

	public void setWakeUpTimer(WakeUpTimer wakeUpTimer) {
		this.wakeUpTimer = wakeUpTimer;
	}
}
