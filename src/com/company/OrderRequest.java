package com.company;

import java.util.Date;

public class OrderRequest {
    private String requesterID;
    private String item;
    private int quantity;
    private Date generated;
    private boolean complete;
    private boolean denied;
}
