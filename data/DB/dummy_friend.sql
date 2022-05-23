USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM friend;

-- 운동 영상에 달린 댓글 
INSERT INTO friend 
VALUES (0, "migon", "soomi"),
	   (0, "soomi", "migon"),
       (0, "soomi", "gyun"),
       (0, "migon", "gyun");

SELECT *
FROM friend;

-- SET sql_safe_updates = 1;