package com.company;

import java.util.Date;

import com.company.Enums.Size;
import com.company.Enums.View;

public class OrderRequest {
    private String requesterID;
    private String item;
    private int quantity;
    private Date generated;
    private boolean complete;
    private boolean denied;
    
    public OrderRequest(String requesterID, String item, int quantity, Date generated, boolean complete, boolean denied) {
    	 this.setRequesterID(requesterID);
    	 this.setItem(item);
    	 this.setQuantity(quantity);
    	 this.generated = generated;
    	 this.setComplete(complete);
    	 this.setDenied(denied);
    }

	public String getRequesterID() {
		return requesterID;
	}

	public void setRequesterID(String requesterID) {
		this.requesterID = requesterID;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isDenied() {
		return denied;
	}

	public void setDenied(boolean denied) {
		this.denied = denied;
	}
}
