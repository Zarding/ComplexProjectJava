package com.zar.JavaServer.Service;

import com.zar.JavaServer.CalendarRepository;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService{
    private final CalendarRepository calendarRepository;

    public CalendarServiceImpl(CalendarRepository calendarRepository) {
        super();
        this.calendarRepository = calendarRepository;
    }

    @Override
    public List<TypeServicesPlan> getCalendarServicesByUserId(short id) {
        return calendarRepository.findCalendarServicesByUser(id, "Новый");
        //return calendarRepository.findCalendarServicesByUserId(id);
    }
}
