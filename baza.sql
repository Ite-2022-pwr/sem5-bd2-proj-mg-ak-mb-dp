-- Database: school_db

-- DROP DATABASE IF EXISTS school_db;

-- CREATE DATABASE school_db
--     WITH
--     OWNER = db2
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Polish_Poland.1250'
--     LC_CTYPE = 'Polish_Poland.1250'
--     LOCALE_PROVIDER = 'libc'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

-- adressses

CREATE TABLE public.addresses (
    id uuid NOT NULL PRIMARY KEY,
    apartment_number character varying(6),
    building_number character varying(6),
    street character varying(45),
    id_post_code uuid NOT NULL
);


ALTER TABLE public.addresses OWNER TO db2;

-- classes

CREATE TABLE public.classes (
    id uuid NOT NULL PRIMARY KEY,
    class_name character varying(3) NOT NULL,
    year_of_study integer NOT NULL,
    year_started timestamp(6) without time zone NOT NULL
);


ALTER TABLE public.classes OWNER TO db2;

-- grades

CREATE TABLE public.grades (
    id uuid NOT NULL PRIMARY KEY,
    date_created timestamp(6) without time zone NOT NULL,
    grade_description character varying(45) NOT NULL,
    number_grade integer NOT NULL,
    weight integer NOT NULL,
    id_subject uuid NOT NULL,
    id_student uuid NOT NULL,
    id_teacher uuid NOT NULL
);


ALTER TABLE public.grades OWNER TO db2;

-- lessons

CREATE TABLE public.lessons (
    id uuid NOT NULL PRIMARY KEY,
    date_time_end timestamp(6) without time zone NOT NULL,
    date_time_start timestamp(6) without time zone NOT NULL,
    topic character varying(50) NOT NULL,
    id_class uuid NOT NULL,
    id_teacher uuid NOT NULL,
    id_school_subject uuid NOT NULL
);


ALTER TABLE public.lessons OWNER TO db2;

-- message_user_receiver_pairs

CREATE TABLE public.message_user_receiver_pairs (
    id uuid NOT NULL PRIMARY KEY,
    id_message uuid NOT NULL,
    id_user_receiver uuid NOT NULL
);


ALTER TABLE public.message_user_receiver_pairs OWNER TO db2;

-- messages

CREATE TABLE public.messages (
    id uuid NOT NULL PRIMARY KEY,
    content character varying NOT NULL,
    date_sent timestamp(6) without time zone NOT NULL,
    id_user_sender uuid NOT NULL
);


ALTER TABLE public.messages OWNER TO db2;

-- parents_student_paris

CREATE TABLE public.parent_student_pairs (
    id uuid NOT NULL PRIMARY KEY,
    id_parent uuid NOT NULL,
    id_student uuid NOT NULL
);


ALTER TABLE public.parent_student_pairs OWNER TO db2;

-- parents

CREATE TABLE public.parents (
    id uuid NOT NULL PRIMARY KEY,
    parent_role character varying(20) NOT NULL,
    description character varying(200) NOT NULL,
    id_user uuid NOT NULL,
    id_phone_number uuid NOT NULL,
    CONSTRAINT parents_parent_role_check CHECK (
        ((parent_role)::text = ANY ((ARRAY[
            'Parent'::character varying,
            'Mother'::character varying,
            'Father'::character varying,
            'LegalGuardian'::character varying
        ])::text[]))
    )
);

ALTER TABLE ONLY public.parents
    ADD CONSTRAINT uk_parents_id_user UNIQUE (id_user);

ALTER TABLE public.parents OWNER TO db2;

-- phone_numbers

CREATE TABLE public.phone_numbers (
    id uuid NOT NULL PRIMARY KEY,
    phone_number character varying(20) NOT NULL
);


ALTER TABLE public.phone_numbers OWNER TO db2;

-- phone_numbers_parents_matches

CREATE TABLE public.phone_numbers_parents_matches (
    id uuid NOT NULL PRIMARY KEY,
    description character varying(200) NOT NULL,
    id_parent uuid NOT NULL,
    id_phone_number uuid NOT NULL
);


ALTER TABLE public.phone_numbers_parents_matches OWNER TO db2;

-- post_codes

CREATE TABLE public.post_codes (
    id uuid NOT NULL PRIMARY KEY,
    post_code character varying(8),
    region_name character varying(58)
);


ALTER TABLE public.post_codes OWNER TO db2;

-- presences

CREATE TABLE public.presences (
    id uuid NOT NULL PRIMARY KEY,
    created timestamp(6) without time zone NOT NULL,
    modified timestamp(6) without time zone NOT NULL,
    presence_type character varying(50) NOT NULL,
    id_student uuid NOT NULL,
    id_lesson uuid NOT NULL,
    CONSTRAINT presences_type_check CHECK (
        ((presence_type)::text = ANY ((ARRAY[
            'Present'::character varying,
            'UnexcusedAbsent'::character varying,
            'ExcusedAbsent'::character varying
        ])::text[]))
    )
);


ALTER TABLE public.presences OWNER TO db2;

-- school_subjects

CREATE TABLE public.school_subjects (
    id uuid NOT NULL PRIMARY KEY,
    link_to_subject_program character varying(100) NOT NULL,
    subject_name character varying(45) NOT NULL,
    school_year timestamp(6) without time zone NOT NULL
);


ALTER TABLE public.school_subjects OWNER TO db2;

-- students

CREATE TABLE public.students (
    id uuid NOT NULL PRIMARY KEY,
    age integer NOT NULL,
    date_of_birth timestamp(6) without time zone NOT NULL,
    gender character varying(255) NOT NULL,
    id_user uuid NOT NULL,
    id_class uuid NOT NULL,
    CONSTRAINT students_gender_check CHECK (
        ((gender)::text = ANY ((ARRAY[
            'Male'::character varying,
            'Female'::character varying,
            'Other'::character varying
        ])::text[]))
    )
);

ALTER TABLE ONLY public.students
    ADD CONSTRAINT uk_students_id_user UNIQUE (id_user);

ALTER TABLE public.students OWNER TO db2;

-- teachers

CREATE TABLE public.teachers (
    id uuid NOT NULL PRIMARY KEY,
    lastcocrdate date NOT NULL,
    one_leave boolean NOT NULL,
    id_user uuid NOT NULL
);

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT uk_teachers_id_user UNIQUE (id_user);

ALTER TABLE public.teachers OWNER TO db2;

-- teachers_teaching_subjects

CREATE TABLE public.teachers_teaching_subjects (
    id uuid NOT NULL PRIMARY KEY,
    id_school_subject uuid NOT NULL,
    id_teacher uuid NOT NULL
);


ALTER TABLE public.teachers_teaching_subjects OWNER TO db2;

-- user_role

CREATE TABLE public.user_role (
    id uuid NOT NULL PRIMARY KEY,
    role_id uuid,
    user_id uuid
);


ALTER TABLE public.user_role OWNER TO db2;

-- users

CREATE TABLE public.users (
    id uuid NOT NULL PRIMARY KEY,
    email character varying(60) NOT NULL,
    first_name character varying(45) NOT NULL,
    user_login character varying(45) NOT NULL,
    password_hash character varying(64) NOT NULL,
    second_name character varying(45) NOT NULL,
    surname character varying(45) NOT NULL,
    id_address uuid NOT NULL,
    phone_number character varying(20) NOT NULL
);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_users_email UNIQUE (email);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_users_login UNIQUE (user_login);

ALTER TABLE public.users OWNER TO db2;

-- add foreign keys

-- users

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_users_id_address FOREIGN KEY (id_address) REFERENCES public.addresses(id);

-- students

ALTER TABLE ONLY public.students
    ADD CONSTRAINT fk_parent_student_pairs_id_user FOREIGN KEY (id_user) REFERENCES public.users(id);

ALTER TABLE ONLY public.students
    ADD CONSTRAINT fk_students_id_class FOREIGN KEY (id_class) REFERENCES public.classes(id);

-- parents

ALTER TABLE ONLY public.parents
    ADD CONSTRAINT fk_parents_id_user FOREIGN KEY (id_user) REFERENCES public.users(id);

ALTER TABLE ONLY public.parents
    ADD CONSTRAINT fk_parents_id_phone_number FOREIGN KEY (id_phone_number) REFERENCES public.phone_numbers(id);

-- teachers

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT fk_teachers_id_user FOREIGN KEY (id_user) REFERENCES public.users(id);

-- addresses

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT fk_addresses_id_post_code FOREIGN KEY (id_post_code) REFERENCES public.post_codes(id);

-- grades

ALTER TABLE ONLY public.grades
    ADD CONSTRAINT fk_grades_id_student FOREIGN KEY (id_student) REFERENCES public.students(id);

ALTER TABLE ONLY public.grades
    ADD CONSTRAINT fk_grades_id_teacher FOREIGN KEY (id_teacher) REFERENCES public.teachers(id);

ALTER TABLE ONLY public.grades
    ADD CONSTRAINT fk_grades_id_subject FOREIGN KEY (id_subject) REFERENCES public.school_subjects(id);

-- lessons

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk_lessons_id_class FOREIGN KEY (id_class) REFERENCES public.classes(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk_lessons_id_teacher FOREIGN KEY (id_teacher) REFERENCES public.teachers(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk_lessons_id_school_subject FOREIGN KEY (id_school_subject) REFERENCES public.school_subjects(id);

-- messages

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk_messages_id_user_sender FOREIGN KEY (id_user_sender) REFERENCES public.users(id);

-- user_role

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);

-- teachers_teaching_subjects

ALTER TABLE ONLY public.teachers_teaching_subjects
    ADD CONSTRAINT fk_teachers_teaching_subjects_id_school_subject FOREIGN KEY (id_school_subject) REFERENCES public.school_subjects(id);


-- message_user_receiver_pairs

ALTER TABLE ONLY public.message_user_receiver_pairs
    ADD CONSTRAINT fk_message_user_receiver_pairs_id_user_receiver FOREIGN KEY (id_user_receiver) REFERENCES public.users(id);

ALTER TABLE ONLY public.message_user_receiver_pairs
    ADD CONSTRAINT fk_message_user_receiver_pairs_id_message FOREIGN KEY (id_message) REFERENCES public.messages(id);

-- parent_student_pairs

ALTER TABLE ONLY public.parent_student_pairs
    ADD CONSTRAINT fk_parent_student_pairs_id_student FOREIGN KEY (id_student) REFERENCES public.students(id);


ALTER TABLE ONLY public.parent_student_pairs
    ADD CONSTRAINT fk_parent_student_pairs_id_parent FOREIGN KEY (id_parent) REFERENCES public.parents(id);

-- phone_numbers_parents_matches

ALTER TABLE ONLY public.phone_numbers_parents_matches
    ADD CONSTRAINT fk_phone_numbers_parents_matches_id_phone_number FOREIGN KEY (id_phone_number) REFERENCES public.phone_numbers(id);

ALTER TABLE ONLY public.phone_numbers_parents_matches
    ADD CONSTRAINT fk_phone_numbers_parents_matches_id_parent FOREIGN KEY (id_parent) REFERENCES public.parents(id);

-- presences

ALTER TABLE ONLY public.presences
    ADD CONSTRAINT fk_presences_id_student FOREIGN KEY (id_student) REFERENCES public.students(id);

ALTER TABLE ONLY public.presences
    ADD CONSTRAINT fk_presences_id_lesson FOREIGN KEY (id_lesson) REFERENCES public.lessons(id);

-- VIEWS

CREATE VIEW student_grades_view AS
SELECT
    g.id as grade_id,
    g.id_student,
    ss.subject_name AS subject_name,
    g.number_grade,
    g.weight,
    g.grade_description,
    g.date_created,
    CONCAT(tu.first_name, ' ', tu.surname) AS teacher_name
FROM
    grades AS g
    INNER JOIN students AS s ON g.id_student = s.id
    INNER JOIN teachers AS t ON g.id_teacher = t.id
    INNER JOIN Users AS tu ON t.id_user = tu.id
    INNER JOIN school_subjects AS ss ON g.id_subject = ss.id;


CREATE VIEW user_message_view AS
SELECT
    m.id as message_id,
    murp.id_user_receiver,
    m.content,
    m.date_sent,
    CONCAT(su.first_name, ' ', su.surname) AS sender_name
FROM
    Messages m
    INNER JOIN message_user_receiver_pairs murp ON m.id = murp.id_message
    INNER JOIN users su ON m.id_user_sender = su.id;

CREATE VIEW children_presences_view AS
SELECT
    p.id as presence_id,
    p.id_student,
    p.presence_type,
    l.date_time_start,
    l.topic,
    ss.subject_name AS SubjectName,
    CONCAT(su.first_name, ' ', su.surname) AS student_name
FROM
    presences AS p
    INNER JOIN lessons AS l ON p.id_lesson = l.id
    INNER JOIN school_subjects AS ss ON l.id_school_subject = ss.id
    INNER JOIN students AS s ON p.id_student = s.id
    INNER JOIN users AS su ON s.id_user = su.id
    INNER JOIN parent_student_pairs AS psp ON s.id = psp.id_student
