package ua.kpi.schedule.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AnastasiyaR
 */

public class TimeSlotHandler {
    private Map <Integer, TimeSlot> map = new HashMap<Integer, TimeSlot>();

    TimeSlotHandler(){

        for (int i = 1; i<=30; i++) {
        map.put(new Integer(i), new TimeSlot(i));
        }
    }
}
