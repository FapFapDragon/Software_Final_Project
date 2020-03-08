package com.company;

import java.util.Date;

public class WakeUpTimer {
    private int ID;
    private Date date;

    public WakeUpTimer(int ID, Date date)
    {
        this.setID(ID);
        this.setDate(date);
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
    
    
}
