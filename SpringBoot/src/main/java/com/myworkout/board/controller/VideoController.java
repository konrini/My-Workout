package com.myworkout.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworkout.board.model.dto.Video;
import com.myworkout.board.model.dto.VideoReview;
import com.myworkout.board.model.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private VideoService VideoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Video>> videolist() {
		return new ResponseEntity<List<Video>>(VideoService.getVideoList(), HttpStatus.OK);
	}
	
	@GetMapping("/{videoId}")
	public ResponseEntity<List<VideoReview>> videodetail(@PathVariable int videoId) {
		return new ResponseEntity<List<VideoReview>>(VideoService.getDetail(videoId), HttpStatus.OK);
	}

	@GetMapping("/{category}")
	public ResponseEntity<List<Video>> videocategory(@PathVariable String category) {
		return new ResponseEntity<List<Video>>(VideoService.getVideobyCategory(category), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<String> write(VideoReview videoreview){
		System.out.println(videoreview.getContent());
		VideoService.writeReview(videoreview);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(VideoReview videoreview){
		VideoService.modifyReview(videoreview);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> delete(@PathVariable int reviewId){
		if(VideoService.removeReview(reviewId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}