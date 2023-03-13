CREATE TABLE IF NOT EXISTS java_lessons.user_course
(

    user_id   INT,
    course_id INT,

    FOREIGN KEY (user_id)
        REFERENCES java_lessons.users (id),

    FOREIGN KEY (course_id)
        REFERENCES java_lessons.course (id)
);
