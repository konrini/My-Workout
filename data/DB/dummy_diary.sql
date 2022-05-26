USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM daily_workout;

-- 일기 추가
INSERT INTO daily_workout 
VALUES (0, "swm", "발차기 멈추지 말자!", "2022-05-23", 40, 158, "migon"),
   	   (0, "swm", "손가락 붙이기!", curdate(), 42, 159, "migon"),
	   (0, "swm", "나는 여자 박태환", "2022-05-20", 40, 160, "soomi"),
	   (0, "glf", "나이스샷", "2022-05-11", 30, 170, "soomi"),
	   (0, "ftn", "헛둘헛둘", "2022-05-04", 45, 177, "soomi"),
	   (0, "bmt", "강 스매싱!", "2022-05-01", 34, 176, "soomi"),
	   (0, "yog", "오늘따라 스트레칭이 잘 되었군!", curdate(), 38, 185, "soomi");

SELECT *
FROM daily_workout;

-- SET sql_safe_updates = 1;