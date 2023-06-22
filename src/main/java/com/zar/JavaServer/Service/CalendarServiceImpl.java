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
        System.out.println(calendarRepository.findCalendarServicesByUserId(id).get(0).getIdServices().getName());
        return calendarRepository.findCalendarServicesByUserId(id);
    }
}
