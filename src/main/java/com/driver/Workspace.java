package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail {
    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // sort the meetings by start time
        calendar.sort((m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));

        int maxMeetings = 0;
        LocalTime lastEndTime = null;
        for (Meeting meeting : calendar) {
            if (lastEndTime == null || meeting.getStartTime().isAfter(lastEndTime)) {
                maxMeetings++;
                lastEndTime = meeting.getEndTime();
            }
        }
        return maxMeetings;
    }
}
