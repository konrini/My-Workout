USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM video_like;

-- 운동 영상에 달린 댓글 
INSERT INTO video_like 
VALUES (0, "migon", 1),
	   (0, "gyun", 1),
       (0, "soomi", 2);

SELECT *
FROM video_like;

-- SET sql_safe_updates = 1;