package com.myworkout.board.model.dao;

import java.util.List;

import com.myworkout.board.model.dto.Diary;

public interface DiaryDao {
	// 일기 목록 조회하기
	List<Diary> selectAllDiaries(String userId);
	
	// 일기 디테일 조회하기
	Diary detailDiary(String userId, String date);

	// 일기 등록하기
	void InsertDiary(Diary diary);

	// 일기 수정하기
	int UpdateDiary(Diary diary);

	// 일기 삭제하기
	int DeleteDiary(String date);
}
