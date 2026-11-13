-- INSERT INTO Students(Name, Email, Age)
-- VALUES ('Chanchal Rani', 'chanchal@gmail.com', 21),
--        ('Harshh Sinha', 'harsh@gmail.com', 21),
--        ('Isha', 'isha@gmail.com', 15),
--        ('Sona Priya', 'sona@gmail.com', 41) ON CONFLICT (Email) DO NOTHING;

INSERT INTO Student(Roll, Name)
VALUES (101, 'Chanchal Rani'),
       (102, 'Iram Fatima'),
       (103, 'Harsh Sinha') ON CONFLICT (Roll) DO NOTHING;