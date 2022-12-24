package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
        //add the meeting to calendar
    }

    public int findMaxMeetings(){
        Collections.sort(calendar,
                (a,b) -> {
                    return a.getStartTime().compareTo(b.getStartTime());
                });

        int count = 0;

        LocalTime meetEnd = LocalTime.parse("00:00");

        for(Meeting m : calendar){
            LocalTime start = m.getStartTime();
            LocalTime end = m.getEndTime();

            if(meetEnd.compareTo(start)<0){
                meetEnd=end;
                count++;
            }
        }
        return count;
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}