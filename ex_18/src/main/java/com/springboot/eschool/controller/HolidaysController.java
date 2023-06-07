package com.springboot.eschool.controller;

import com.springboot.eschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(display != null && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }
        if(display != null && display.equals("festival")) {
            model.addAttribute("festival", true);
        }
        if(display != null && display.equals("federal")) {
            model.addAttribute("federal", true);
        }

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
