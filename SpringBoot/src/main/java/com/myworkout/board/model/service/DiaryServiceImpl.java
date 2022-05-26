package com.myworkout.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myworkout.board.model.dao.DiaryDao;
import com.myworkout.board.model.dto.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diarydao;
	
	@Override
	public List<Diary> getDiaryList(String userId) {
		return diarydao.selectAllDiaries(userId);
	}

	@Override
	public Diary getDiary(String userId, String date) {
		return diarydao.detailDiary(userId, date);
	}

	@Override
	public Diary getoldDiary(String userId, String date) {
		return diarydao.oldDiary(userId, date);
	}
	
	@Override
	public void writeDiary(Diary diary) {
		diarydao.InsertDiary(diary);
	}

	@Override
	public boolean modifyDiary(Diary diary) {
		Diary originDiary = diarydao.detailDiary(diary.getUserId(), diary.getDate());
		originDiary.setChangedWeight(diary.getChangedWeight());
		originDiary.setChangedHeight(diary.getChangedHeight());
		originDiary.setCategory(diary.getCategory());
		originDiary.setDiary(diary.getDiary());
		return diarydao.UpdateDiary(originDiary) == 1;
	}

	@Override
	public boolean removeDiary(String date) {
		return diarydao.DeleteDiary(date) == 1;
	}

}
