package com.myworkout.board.model.service;

import java.util.List;

import com.myworkout.board.model.dto.Video;
import com.myworkout.board.model.dto.VideoReview;

public interface VideoService {
	// 영상 목록 조회
	List<Video> getVideoList();
	
	// 영상 하나 조회
	Video getVideo(int videoId);
	
	// 특정 영상과 댓글 조회
	List<VideoReview> getDetail(int videoId);

	// 해당 영상의 특정 댓글 조회
	VideoReview getReview(int reviewId);

	// 댓글 등록
	void writeReview(VideoReview videoreview);
	
	// 댓글 수정
	boolean modifyReview(VideoReview videoreview);
	
	// 댓글 삭제
	boolean removeReview(int reviewId);
	
}