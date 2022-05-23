package com.myworkout.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myworkout.board.model.dao.VideoDao;
import com.myworkout.board.model.dto.Video;
import com.myworkout.board.model.dto.VideoReview;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoDao videodao;
	
	@Override
	public List<Video> getVideoList() {
		return videodao.selectAllVideos();
	}

	@Override
	public List<VideoReview> getDetail(int videoId) {
		return videodao.detailVideo(videoId);
	}
	
	@Override
	public Video getVideo(int videoId) {
		return videodao.selectOneVideo(videoId);
	}

	@Override
	public VideoReview getReview(int reviewId) {
		return videodao.selectVideoReview(reviewId);
	}

	@Override
	public void writeReview(VideoReview videoreview) {
		videodao.InsertVideoReview(videoreview);		
	}

	@Override
	public boolean modifyReview(VideoReview videoreview) {
		VideoReview originReview = videodao.selectVideoReview(videoreview.getReviewId());
		originReview.setContent(videoreview.getContent());
		originReview.setChanged(1);
		return videodao.UpdateVideoReview(originReview) == 1;
	}

	@Override
	public boolean removeReview(int reviewId) {
		return videodao.DeleteVideoReview(reviewId) == 1;
	}


}