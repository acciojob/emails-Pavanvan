package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity;//maximum number of mails inbox can store
    ArrayList<Mail> Inbox;
    ArrayList<Mail> Trash;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        Inbox = new ArrayList<>();
        Trash = new ArrayList<>();
    }


    public void receiveMail(Date date, String sender, String message){

        if(Inbox.size()==inboxCapacity){
            Trash.add(Inbox.get(0));
            Inbox.remove(0);
        }

        Mail freshMail = new Mail(date, sender, message);
        Inbox.add(freshMail);

        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){

        for(int i = 0 ; i < Inbox.size() ;i++){
            String x = Inbox.get(i).getMessage();
            if(x.equals(message)){
                Trash.add(Inbox.get(i));
                Inbox.remove(i);
                break;
            }
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){

        int len = getInboxSize();

        if(len==0) return null;

        return Inbox.get(len-1).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        int len = getInboxSize();

        if(len==0) return null;

        return Inbox.get(0).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int count = 0;

        for(Mail mail : Inbox){
            Date d = mail.getDate();

            if(d.equals(start) || d.equals(end) || (d.after(start) && d.before(end))) count++;
        }

        return count;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){

        return Inbox.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){

        return Trash.size();
        // Return number of mails in Trash

    }

    public void emptyTrash(){
        Trash.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}