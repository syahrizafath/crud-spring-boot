--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-12 16:38:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: xxx; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.xxx
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.xxx OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16451)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id integer NOT NULL,
    kode text DEFAULT ('K-'::text || nextval('public.xxx'::regclass)) NOT NULL,
    nama character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    tanggal_masuk date NOT NULL,
    hp character varying(50) NOT NULL,
    limit_reimbursement integer,
    created_date date,
    updated_date date,
    CONSTRAINT employees_kode_check CHECK ((kode ~ '^K-[0-9]+$'::text))
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16449)
-- Name: employees_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_id_seq OWNER TO postgres;

--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 201
-- Name: employees_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;


--
-- TOC entry 2853 (class 2604 OID 16454)
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- TOC entry 2990 (class 0 OID 16451)
-- Dependencies: 202
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees (id, kode, nama, email, tanggal_masuk, hp, limit_reimbursement, created_date, updated_date) FROM stdin;
1	K-112	Jese	jese@gmail.com	2021-04-11	0867473829	8	2021-04-11	2021-04-11
8	K-119	Andy	andy@gmail.com	2021-04-12	0836473	1	2021-04-12	2021-04-12
9	K-120	Karin	karin@gmail.com	2021-04-12	0843773473	1	2021-04-12	2021-04-12
13	K-124	Dandy	dandy@mail.com	2021-04-12	08437637	5	2021-04-12	2021-04-12
10	K-121	Sandy-edit	sandy@gmail.com	2021-04-12	0834363472	2	2021-04-12	2021-04-12
14	K-125	Mulya	mulya@mail.com	2021-04-12	08253267	3	2021-04-12	2021-04-12
15	K-126	Valen	valen@mail.com	2021-04-12	0372736822	3	2021-04-12	2021-04-12
\.


--
-- TOC entry 2997 (class 0 OID 0)
-- Dependencies: 201
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employees_id_seq', 15, true);


--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 200
-- Name: xxx; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.xxx', 126, true);


--
-- TOC entry 2857 (class 2606 OID 16461)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


-- Completed on 2021-04-12 16:38:18

--
-- PostgreSQL database dump complete
--

