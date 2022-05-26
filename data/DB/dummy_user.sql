USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM user;

-- 회원 추가
INSERT INTO user 
VALUES ("soomi", "1234", "뱅순이", 173, 45, 2, 1, "뱅순이"),
	   ("gyun", "1234", "갓명균", 300, 100, 1, 6, "제자"),
	   ("sunho", "1234", "선호", 250, 100, 1, 2, "태쿤"),
	   ("taek", "1234", "태쿤", 200, 60, 1, 5, "선호"),
	   ("isthe", "1234", "갓민균", 240, 120, 1, 4, "웃음"),
       ("migon", "1234", "미코미코니", 158, 40, 2, 3, "잠");

SELECT *
FROM user;

-- SET sql_safe_updates = 1;