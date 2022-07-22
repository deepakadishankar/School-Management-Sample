CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(300) NOT NULL,
    display_name VARCHAR(30) NOT NULL,
    email VARCHAR(50),
    date_of_birth DATE,
    role VARCHAR(10) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE (username),
    UNIQUE (email)
);
CREATE TABLE admin(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    PRIMARY KEY(id),
    CONSTRAINT FK_UserAdmin FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (user_id)
);
CREATE TABLE teachers(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    specialization VARCHAR (15) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_UserTeacher FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (user_id)
);
CREATE TABLE classes(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (10) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE students(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    class_id INT,
    PRIMARY KEY(ID),
    CONSTRAINT FK_UserStudent FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT FK_ClassStudent FOREIGN KEY (class_id) REFERENCES classes(id),
    UNIQUE (user_id)
);
CREATE TABLE class_teachers(
    class_id INT,
    teacher_id INT,
    CONSTRAINT FK_ClassClassTeacher FOREIGN KEY (class_id) REFERENCES classes(id),
    CONSTRAINT FK_ FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    UNIQUE (class_id),
    UNIQUE (teacher_id)
);
CREATE TABLE subjects(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (15),
    class_id INT,
    PRIMARY KEY (id),
    CONSTRAINT FK_ClassSubjects FOREIGN KEY (class_id) REFERENCES classes(id)
);
CREATE TABLE subject_teachers(
    subject_id INT,
    academic_year YEAR,
    teacher_id INT,
    CONSTRAINT FK_SubjectSubjectTeacher FOREIGN KEY (subject_id) REFERENCES subjects(id),
    CONSTRAINT FK_TeacherSubjectTeacher FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    UNIQUE (academic_year),
    UNIQUE (subject_id)
);
CREATE TABLE exams(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25),
    class_id INT,
    PRIMARY KEY (id),
    CONSTRAINT FK_ClassExam FOREIGN KEY (class_id) REFERENCES classes(id),
    CONSTRAINT UC_Exams UNIQUE (name,class_id)
);
CREATE TABLE assignments(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    subject_id INT,
    PRIMARY KEY (id),
    CONSTRAINT FK_SubjectAssignment FOREIGN KEY (subject_id) REFERENCES subjects(id)
);
CREATE TABLE marks(
    student_id INT,
    exam_id INT,
    subject_id INT,
    mark INT,
    CONSTRAINT FK_StudentMark FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT FK_ExamMark FOREIGN KEY (exam_id) REFERENCES exams(id),
    CONSTRAINT FK_SubjectMark FOREIGN KEY (subject_id) REFERENCES subjects(id),
    UNIQUE (student_id,exam_id,subject_id)
);
CREATE TABLE assignment_submissions(
    id INT NOT NULL AUTO_INCREMENT,
    student_id INT,
    assignment_id INT,
    file_id VARCHAR(32),
    PRIMARY KEY (id),
    CONSTRAINT FK_StudentAssignmentSubmission FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT FK_AssignmentAssignmentSubmission FOREIGN KEY (assignment_id) REFERENCES assignments(id)
);