INSERT INTO Students(Name, Email, Age)
VALUES ('Chanchal Rani', 'chanchal@gmail.com', 21),
       ('Harshh Sinha', 'harsh@gmail.com', 21),
       ('Isha', 'isha@gmail.com', 15),
       ('Sona Priya', 'sona@gmail.com', 41) ON CONFLICT (Email) DO NOTHING;