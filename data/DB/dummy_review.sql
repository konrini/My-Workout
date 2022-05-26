USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM review;

-- 운동 영상에 달린 댓글 
-- INSERT INTO review 
-- VALUES (0, "따라하기 힘드네요", now(), 0, 1, "soomi", "뱅순이", 1),
--        (0, "연습 열심히 하겠습니다.", now(), 0, 5, "migon", "미코미코니", 1),
-- 	   (0, "vㅔ리 EZ", now(), 0, 4, "gyun", "갓명균", 2);

SELECT *
FROM review;

-- SELECT COUNT(*)
-- FROM review
-- WHERE video_id = 1;

-- SET sql_safe_updates = 1;