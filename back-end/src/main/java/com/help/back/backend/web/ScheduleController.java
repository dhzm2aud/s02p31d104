package com.help.back.backend.web;

import com.help.back.backend.domain.Schedule;
import com.help.back.backend.domain.User;
import com.help.back.backend.dto.ScheduleDate;
import com.help.back.backend.service.ScheduleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. Schedule"})
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("v1/user/personal-schedule")
    public ResponseEntity<Schedule> postPersonalSchedule(@RequestBody Schedule schedule) throws Exception{
        try {
            System.out.println("개인 스케쥴 추가");
            System.out.println(schedule.toString());
            int ans = scheduleService.postPersonalSchedule(schedule);
            if(ans == 1){
                System.out.println("추가 : " + schedule.toString());
                return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("v1/user/personal-schedule")
    public ResponseEntity updatePersonalSchedule(@RequestBody Schedule schedule) throws Exception{
        try {
            System.out.println("개인 스케쥴 수정");
            System.out.println(schedule.toString());
            int ans = scheduleService.updatePersonalSchedule(schedule);
            if(ans == 1){
                System.out.println("수정 성공  : " + ans);
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/v1/user/{id}/personal-schedule")
    public ResponseEntity deletePersonalSchedule(@PathVariable("id") int id) throws Exception{
        try {
            System.out.println("개인 스케쥴 삭제");
            System.out.println(id);
            int ans = scheduleService.deleteSchedule(id);
            if(ans == 1){
                System.out.println("삭제 성공  : " + ans);
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/v1/user/{user_id}/personal-schedule")
    public ResponseEntity<List<Schedule>> getPersonalSchedule(@PathVariable("user_id") int user_id) throws Exception{
        List<Schedule> list = null;
        try {
            System.out.println("개인 스케쥴 검색");
            list = scheduleService.getPersonalSchedule(user_id);
            System.out.println(list);
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/v1/user/personal-schedule/date")
    public ResponseEntity<List<Schedule>> getPersonalScheduleByDate(@RequestBody ScheduleDate scheduleDate) throws Exception{
        List<Schedule> list = null;
        try {
            System.out.println("개인 스케쥴 날짜에 따라 검색");
            System.out.println(scheduleDate);
            list = scheduleService.getPersonalScheduleByDate(scheduleDate);
            System.out.println(list);
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("v1/group/group-schedule")
    public ResponseEntity<Schedule> postGroupSchedule(@RequestBody Schedule schedule) throws Exception{
        try {
            System.out.println("그룹 스케쥴 추가");
            System.out.println(schedule.toString());
            int ans = scheduleService.postGroupSchedule(schedule);
            if(ans == 1){
                System.out.println("추가 : " + schedule.toString());
                return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("v1/group/group-schedule")
    public ResponseEntity updateGroupSchedule(@RequestBody Schedule schedule) throws Exception{
        try {
            System.out.println("그룹 스케쥴 수정");
            System.out.println(schedule.toString());
            int ans = scheduleService.updateGroupSchedule(schedule);
            if(ans == 1){
                System.out.println("수정 성공  : " + ans);
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/v1/group/{groupId}/personal-schedule")
    public ResponseEntity<List<Schedule>> getGroupSchedule(@PathVariable("groupId") int groupId) throws Exception{
        List<Schedule> list = null;
        try {
            System.out.println("개인 스케쥴 검색");
            list = scheduleService.getGroupSchedule(groupId);
            System.out.println(list);
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/v1/group/group-schedule/date")
    public ResponseEntity<List<Schedule>> getGroupScheduleByDate(@RequestBody ScheduleDate scheduleDate) throws Exception{
        List<Schedule> list = null;
        try {
            System.out.println("그룹 스케쥴 날짜에 따라 검색");
            System.out.println(scheduleDate);
            list = scheduleService.getGroupScheduleByDate(scheduleDate);
            System.out.println(list);
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<List<Schedule>>(list,HttpStatus.NO_CONTENT);
        }

    }
}
