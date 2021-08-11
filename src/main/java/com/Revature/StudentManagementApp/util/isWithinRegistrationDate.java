package com.Revature.StudentManagementApp.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class isWithinRegistrationDate {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDateTime now = LocalDateTime.now();


    private final String start;
    private final String end;
    private final String today =dtf.format(now);

    public isWithinRegistrationDate(String start, String end){
        this.start = start;
        this.end = end;
    }

    public boolean check(){


        String[] date = start.split("/");
        String[] dateEnd = end.split("/");
        String[] twoDay = today.split("/");

        Date Start = new Date(Integer.parseInt(date[2]), Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));

        Date End = new Date(Integer.parseInt(dateEnd[2]), Integer.parseInt(dateEnd[0])-1, Integer.parseInt(dateEnd[1]));

        Date Today = new Date(Integer.parseInt(twoDay[2]),Integer.parseInt(twoDay[0])-1,Integer.parseInt(twoDay[1]));



        return Today.after(Start) && Today.before(End);


    }

}
