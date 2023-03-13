ALTER TABLE java_lessons.account
    ADD COLUMN user_id INT;

ALTER TABLE java_lessons.account
    ADD
        FOREIGN KEY (user_id)
            REFERENCES java_lessons.users (id);