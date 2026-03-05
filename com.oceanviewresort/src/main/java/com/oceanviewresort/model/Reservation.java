package com.oceanviewresort.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private int reservation_id;
    private int guest_id;
    private int room_type_id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private double total_amount;
    private String status;
    private LocalDateTime created_at;
    
    public Reservation() {}
    
    public Reservation(int guest_id, int room_type_id, LocalDate check_in_date, 
                      LocalDate check_out_date, double total_amount, String status) {
        this.guest_id = guest_id;
        this.room_type_id = room_type_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_amount = total_amount;
        this.status = status;
    }
    
    public int getReservation_id() { return reservation_id; }
    public void setReservation_id(int reservation_id) { this.reservation_id = reservation_id; }
    
    public int getGuest_id() { return guest_id; }
    public void setGuest_id(int guest_id) { this.guest_id = guest_id; }
    
    public int getRoom_type_id() { return room_type_id; }
    public void setRoom_type_id(int room_type_id) { this.room_type_id = room_type_id; }
    
    public LocalDate getCheck_in_date() { return check_in_date; }
    public void setCheck_in_date(LocalDate check_in_date) { this.check_in_date = check_in_date; }
    
    public LocalDate getCheck_out_date() { return check_out_date; }
    public void setCheck_out_date(LocalDate check_out_date) { this.check_out_date = check_out_date; }
    
    public double getTotal_amount() { return total_amount; }
    public void setTotal_amount(double total_amount) { this.total_amount = total_amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}