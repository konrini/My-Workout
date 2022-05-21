USE My_Workout;

-- SET sql_safe_updates = 0;
-- DELETE FROM user;

-- 회원 추가
INSERT INTO user 
VALUES ("soomi", "1234", "뱅순이", 173, 45, 2, 1, "뱅순이"),
	   ("gyun", "1234", "갓명균", 192, 100, 1, 4, "제자"),
       ("migon", "1234", "미코미코니", 158, 40, 2, 5, "잠");

SELECT *
FROM user;

-- SET sql_safe_updates = 1;