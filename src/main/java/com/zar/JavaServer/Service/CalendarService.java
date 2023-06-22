package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Service;
import com.zar.JavaServer.Entity.TypeServicesPlan;

import java.util.List;

public interface CalendarService {
    List<TypeServicesPlan> getCalendarServicesByUserId(short id);
}
