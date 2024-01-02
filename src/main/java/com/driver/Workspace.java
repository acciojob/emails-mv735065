package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.*;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
       // super(super.getMail());
        // The inboxCapacity is equal to the maximum value an integer can store.
  super(emailId,0);

 this.calendar=new ArrayList<>();

    }

    public int getInboxCapacity(){
        return super.getInboxCapacity();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar

        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
//        Collections.sort(calendar);
//                (Meeting a,Meeting b){
//            return a.startTime.comapreTo(b.startTime);
//        });

        Collections.sort(calendar, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                 if(o1.getStartTime().compareTo(o2.getStartTime())==0){
                     return o1.getEndTime().compareTo(o2.getEndTime());
                 }

return o1.getStartTime().compareTo(o2.getStartTime());

            }
        });
//     for(int i=0;i<calendar.size();i++)
//        System.out.println(calendar.get(i).toString());

      LocalTime start=calendar.get(0).getStartTime();
      LocalTime end=calendar.get(0).getEndTime();

       int i=1;int c=1;
       while(i<calendar.size()){
           if(end.compareTo(calendar.get(i).getStartTime())<0){
               c++;
               end=calendar.get(i).getEndTime();
           }
          else if(end.compareTo(calendar.get(i).getEndTime())>0){
              end=calendar.get(i).getEndTime();
           }
          i++;
       }





 return c;

    }
}
