package com.myworkout.board.model.dao;

import java.util.List;

import com.myworkout.board.model.dto.Video;
import com.myworkout.board.model.dto.VideoReview;

public interface VideoDao {
	// 영상 목록 조회하기
	List<Video> selectAllVideos();
	
	// 영상 디테일 조회하기 및 댓글 불러오기
	List<VideoReview> detailVideo(int videoId);
	
	// 영상 특정 댓글 
	VideoReview selectVideoReview(int reviewId);

	// 영상 댓글 등록하기
	void InsertVideoReview(VideoReview review);

	// 영상 댓글 수정하기
	int UpdateVideoReview(VideoReview review);

	// 영상 댓글 삭제하기
	int DeleteVideoReview(int reviewId);
}
