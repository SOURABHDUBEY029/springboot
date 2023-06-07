package com.springboot.eschool.controller;

import com.springboot.eschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                  @RequestParam(required = false) boolean federal, Model model){
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<Holiday> holidays = Arrays.asList(
                new Holiday("January 1", "New Year", Holiday.Type.FESTIVAL),
                new Holiday("January 26", "Republic Day", Holiday.Type.FEDERAL),
                new Holiday("March 8", "Holi", Holiday.Type.FESTIVAL),
                new Holiday("August 15", "Independence Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }

        return "holidays.html";
    }
}
