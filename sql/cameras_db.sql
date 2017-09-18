--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.8
-- Dumped by pg_dump version 9.5.8

-- Started on 2017-09-03 16:44:47 EEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE cameras;
--
-- TOC entry 3109 (class 1262 OID 17830)
-- Name: cameras; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE cameras WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'ru_RU.utf8' LC_CTYPE = 'ru_RU.utf8';


ALTER DATABASE cameras OWNER TO postgres;

\connect cameras

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13338)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3112 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 17833)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE address (
    id bigint NOT NULL,
    address character varying(255)
);


ALTER TABLE address OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 17831)
-- Name: address_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE address_id_seq OWNER TO postgres;

--
-- TOC entry 3113 (class 0 OID 0)
-- Dependencies: 181
-- Name: address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE address_id_seq OWNED BY address.id;


--
-- TOC entry 184 (class 1259 OID 17841)
-- Name: camera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE camera (
    id bigint NOT NULL,
    id_device bigint,
    address bigint
);


ALTER TABLE camera OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 17839)
-- Name: camera_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE camera_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE camera_id_seq OWNER TO postgres;

--
-- TOC entry 3114 (class 0 OID 0)
-- Dependencies: 183
-- Name: camera_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE camera_id_seq OWNED BY camera.id;


--
-- TOC entry 186 (class 1259 OID 17849)
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE photo (
    id bigint NOT NULL,
    url character varying(255),
    camera_id bigint
);


ALTER TABLE photo OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17847)
-- Name: photo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE photo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE photo_id_seq OWNER TO postgres;

--
-- TOC entry 3115 (class 0 OID 0)
-- Dependencies: 185
-- Name: photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE photo_id_seq OWNED BY photo.id;


--
-- TOC entry 2974 (class 2604 OID 17836)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY address ALTER COLUMN id SET DEFAULT nextval('address_id_seq'::regclass);


--
-- TOC entry 2975 (class 2604 OID 17844)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY camera ALTER COLUMN id SET DEFAULT nextval('camera_id_seq'::regclass);


--
-- TOC entry 2976 (class 2604 OID 17852)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY photo ALTER COLUMN id SET DEFAULT nextval('photo_id_seq'::regclass);


--
-- TOC entry 3100 (class 0 OID 17833)
-- Dependencies: 182
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO address (id, address) VALUES (1, 'г.Киев,ул.Крещатик,53');
INSERT INTO address (id, address) VALUES (2, 'г.Киев,ул.Крещатик,2');
INSERT INTO address (id, address) VALUES (3, 'г.Киев,ул.Крещатик,3');
INSERT INTO address (id, address) VALUES (4, 'г.Львов,ул.Первая,12');
INSERT INTO address (id, address) VALUES (5, 'г.Львов,ул.Вторая,125');
INSERT INTO address (id, address) VALUES (6, 'г.Одесса,ул.Третья,45');
INSERT INTO address (id, address) VALUES (7, 'г.Одесса,ул.Четвертая,13');


--
-- TOC entry 3116 (class 0 OID 0)
-- Dependencies: 181
-- Name: address_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('address_id_seq', 1, false);


--
-- TOC entry 3102 (class 0 OID 17841)
-- Dependencies: 184
-- Data for Name: camera; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO camera (id, id_device, address) VALUES (1, 11111, 1);
INSERT INTO camera (id, id_device, address) VALUES (2, 22222, 1);
INSERT INTO camera (id, id_device, address) VALUES (3, 33333, 1);
INSERT INTO camera (id, id_device, address) VALUES (4, 44444, 2);
INSERT INTO camera (id, id_device, address) VALUES (5, 55555, 2);
INSERT INTO camera (id, id_device, address) VALUES (6, 6666, 3);
INSERT INTO camera (id, id_device, address) VALUES (7, 77777, 3);
INSERT INTO camera (id, id_device, address) VALUES (8, 88888, 4);
INSERT INTO camera (id, id_device, address) VALUES (9, 99999, 5);
INSERT INTO camera (id, id_device, address) VALUES (10, 121212, 6);
INSERT INTO camera (id, id_device, address) VALUES (11, 4545454, 6);
INSERT INTO camera (id, id_device, address) VALUES (12, 363636, 7);
INSERT INTO camera (id, id_device, address) VALUES (13, 778787, 7);


--
-- TOC entry 3117 (class 0 OID 0)
-- Dependencies: 183
-- Name: camera_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('camera_id_seq', 1, false);


--
-- TOC entry 3104 (class 0 OID 17849)
-- Dependencies: 186
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO photo (id, url, camera_id) VALUES (1, '/home/dimon/Documents/Test_Task/camera/img/22222.png', 2);
INSERT INTO photo (id, url, camera_id) VALUES (2, '/home/dimon/Documents/Test_Task/camera/img/11111.png', 1);
INSERT INTO photo (id, url, camera_id) VALUES (6, '/home/dimon/Documents/Test_Task/camera/img/33333.jpeg', 3);


--
-- TOC entry 3118 (class 0 OID 0)
-- Dependencies: 185
-- Name: photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('photo_id_seq', 6, true);


--
-- TOC entry 2978 (class 2606 OID 17838)
-- Name: address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 2980 (class 2606 OID 17846)
-- Name: camera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY camera
    ADD CONSTRAINT camera_pkey PRIMARY KEY (id);


--
-- TOC entry 2982 (class 2606 OID 17854)
-- Name: photo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY photo
    ADD CONSTRAINT photo_pkey PRIMARY KEY (id);


--
-- TOC entry 2984 (class 2606 OID 17860)
-- Name: fkfbgjfs5f1amq7jhxehj8xc6kv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY photo
    ADD CONSTRAINT fkfbgjfs5f1amq7jhxehj8xc6kv FOREIGN KEY (camera_id) REFERENCES camera(id);


--
-- TOC entry 2983 (class 2606 OID 17855)
-- Name: fkjph35xxqbvgg9pxyo0emdnob8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY camera
    ADD CONSTRAINT fkjph35xxqbvgg9pxyo0emdnob8 FOREIGN KEY (address) REFERENCES address(id);


--
-- TOC entry 3111 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-09-03 16:44:47 EEST

--
-- PostgreSQL database dump complete
--

