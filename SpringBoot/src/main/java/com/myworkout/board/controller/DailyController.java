package com.myworkout.board.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myworkout.board.model.dto.Diary;
import com.myworkout.board.model.dto.Friend;
import com.myworkout.board.model.service.DiaryService;

@RestController
@RequestMapping("/dailyView")
public class DailyController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private DiaryService diaryservice;
	
	@GetMapping("/")
	public ResponseEntity<List<Diary>> diarylist(@RequestParam String userId) {
		return new ResponseEntity<List<Diary>>(diaryservice.getDiaryList(userId), HttpStatus.OK);
	}
	
	@GetMapping("/old")
	public ResponseEntity<Map<String, Object>> getolddiary(@RequestParam String userId, @RequestParam String date) {
		Diary diary = diaryservice.getoldDiary(userId, date);
		HashMap<String, Object> result = new HashMap<>();
		
		result.put("diary", diary);
		
		HttpStatus status = HttpStatus.ACCEPTED;
		return new ResponseEntity<Map<String, Object>>(result, status);
	}
	
	@GetMapping("/regist")
	public ResponseEntity<Map<String, Object>> get(@RequestParam String userId){
		Diary daily = diaryservice.getDiary(userId, LocalDate.now()+"");
		HashMap<String, Object> result = new HashMap<>();
		if (daily != null) {
			result.put("daily", daily);
		}
		else {
			result.put("daily", null);
		}
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> write(@RequestParam String category, @RequestParam String diary,
			@RequestParam int changedWeight, @RequestParam int changedHeight, @RequestParam String userId){
		Diary daily = diaryservice.getDiary(userId, LocalDate.now()+"");
		if (daily == null) {
			Diary dailyWorkout = new Diary(0, category, diary, "", changedWeight, changedWeight, userId);
			diaryservice.writeDiary(dailyWorkout);			
		}
		else {
			daily.setChangedHeight(changedHeight);
			daily.setChangedWeight(changedWeight);
			daily.setDiary(diary);
			daily.setCategory(category);
			diaryservice.modifyDiary(daily);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}

}