USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM daily_workout;

-- 일기 추가
INSERT INTO daily_workout 
VALUES (0, "swm", "발차기 멈추지 말자!", now(), 40, 158, "migon"),
   	   (0, "swm", "손가락 붙이기!", now(), 42, 159, "migon"),
	   (0, "yog", "오늘따라 스트레칭이 잘 되었군!", now(), 38, 175, "soomi");

SELECT *
FROM daily_workout;

-- SET sql_safe_updates = 1;