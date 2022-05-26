USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM friend;

-- 운동 영상에 달린 댓글 
INSERT INTO friend 
VALUES (0, "migon", "soomi"),
	   (0, "migon", "sunho"),
       (0, "soomi", "migon"),
       (0, "soomi", "gyun"),
       (0, "soomi", "taek"),
       (0, "sunho", "soomi"),
       (0, "taek", "gyun"),
       (0, "taek", "soomi"),
       (0, "taek", "migon"),
       (0, "taek", "sunho"),
       (0, "isthe", "soomi"),
       (0, "soomi", "isthe"),
       (0, "isthe", "gyun");

SELECT *
FROM friend;

-- SELECT follower_id
-- FROM friend
-- WHERE target_id = "gyun";

-- SET sql_safe_updates = 1;

-- SELECT DISTINCT(follower_id), nickname
-- FROM user
-- INNER JOIN friend
-- ON user.user_id = follower_id;

-- SELECT DISTINCT(nickname)
-- FROM user
-- INNER JOIN friend
-- ON user.user_id = "migon";