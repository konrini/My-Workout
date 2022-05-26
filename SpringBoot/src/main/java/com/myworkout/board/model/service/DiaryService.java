package com.myworkout.board.model.service;

import java.util.List;

import com.myworkout.board.model.dto.Diary;

public interface DiaryService {
	// 일기 목록 조회
	List<Diary> getDiaryList(String userId);
	
	// 일기 디테일 조회
	Diary getDiary(String userId, String date);
	
	// 예전 일기 조회
	Diary getoldDiary(String userId, String date);

	// 일기 등록
	void writeDiary(Diary diary);
	
	// 일기 수정
	boolean modifyDiary(Diary diary);
	
	// 일기 삭제
	boolean removeDiary(String date);
	
}