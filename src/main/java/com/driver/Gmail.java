package com.driver;

import java.util.*;

class mail
{
    public Date date;
    public String sender;
    public String message;

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}
public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    Deque<mail> inbox;
    ArrayList<mail> trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new LinkedList<>();
        trash = new ArrayList<>();
    }


    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inbox.size()==inboxCapacity){
            trash.add(inbox.removeFirst());
        }
        inbox.add(new mail(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        Iterator<mail> it= inbox.iterator();
        while (it.hasNext()) {
            mail obj = it.next();
            if(obj.getMessage().equals(message))
            {
                trash.add(obj);
                it.remove();
                break;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size() == 0){
            return null;
        }
        return inbox.peekLast().getMessage();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size() == 0){
            return null;
        }
        return inbox.peek().getMessage();

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        Iterator<mail> it = inbox.iterator();
        int count=0;
        while (it.hasNext()) {
            mail obj=it.next();
//           if(obj.date.after(start) && obj.date.before(end))
            if(obj.date.getTime() >=start.getTime() && obj.date.getTime()<=end.getTime())
            {
                count++;
            }

        }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }


    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}