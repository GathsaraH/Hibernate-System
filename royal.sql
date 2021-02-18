USE royal;
SHOW TABLES;
SELECT * FROM course;
SELECT * FROM student;
SELECT * FROM registration;

SELECT * FROM registration;

SELECT r.regNumber,r.regFee,r.courseID,r.studentID,s.studentName FROM registration r ,student s WHERE r.studentID=s.studentID;

SELECT r.courseID,r.studentID,s.studentName FROM registration r,student s WHERE r.studentID="S002";

SELECT r.courseID,r.studentID, FROM registration r WHERE r.studentID="S002";

SELECT r.courseID,r.studentID,s.studentName FROM registration r,student s WHERE r.studentID=s.studentID and r.studentID= 'S002';

