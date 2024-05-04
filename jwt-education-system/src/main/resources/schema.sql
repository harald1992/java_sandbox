DROP SCHEMA IF EXISTS education_system CASCADE;
CREATE SCHEMA education_system;
SET
search_path TO education_system;

CREATE TABLE instructor_detail
(
    id              SERIAL NOT NULL PRIMARY KEY, -- serial means auto increment primary keys
    youtube_channel VARCHAR(128) DEFAULT NULL,
    hobby           VARCHAR(45)  DEFAULT NULL
);

CREATE TABLE instructor
(
    id                   SERIAL NOT NULL PRIMARY KEY,
    first_name           VARCHAR(45) DEFAULT NULL,
    last_name            VARCHAR(45) DEFAULT NULL,
    email                VARCHAR(45) DEFAULT NULL,
    instructor_detail_id BIGINT      DEFAULT NULL,

    CONSTRAINT fk_detail                            -- name of the constraint (foreign key _detail), can be referenced somewhere else
        FOREIGN KEY (instructor_detail_id)          -- instructor_detail_id is the foreign key
            REFERENCES instructor_detail (id)       -- foreign key references the id field in instructor_detail table
            ON DELETE NO ACTION ON UPDATE NO ACTION -- when instructor_detail row is deleted, do nothing and keep the instructor row. Basically means don't do cascade
);


CREATE TABLE course
(
    id            SERIAL NOT NULL PRIMARY KEY,
    title         VARCHAR(128) UNIQUE DEFAULT NULL,
    instructor_id BIGINT              DEFAULT NULL,

    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES instructor (id)
);

CREATE TABLE review
(
    id        SERIAL   NOT NULL PRIMARY KEY,
    stars     SMALLINT NOT NULL,
    comment   VARCHAR(128) DEFAULT NULL,
    course_id BIGINT       DEFAULT NULL,

    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course (id)

);
