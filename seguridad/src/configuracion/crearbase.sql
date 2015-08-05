--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2015-02-15 22:13:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 186 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 186
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16405)
-- Name: aplicacion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE aplicacion (
    consultaid integer NOT NULL,
    vacunaid integer NOT NULL
);


--
-- TOC entry 183 (class 1259 OID 16507)
-- Name: aplicacionagendada_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE aplicacionagendada_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 173 (class 1259 OID 16408)
-- Name: aplicacionagendada; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE aplicacionagendada (
    id integer DEFAULT nextval('aplicacionagendada_id_seq'::regclass) NOT NULL,
    fechaaplicacion timestamp without time zone,
    vacunaid integer,
    recordatorioenviado boolean DEFAULT false,
    consultaid integer
);


--
-- TOC entry 174 (class 1259 OID 16411)
-- Name: configenvio; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE configenvio (
    emailorigen character varying(40),
    password character varying(50),
    plantilla text,
    habilitado boolean,
    diasanterioridad integer,
    usuario character varying(50),
    asunto text
);


--
-- TOC entry 184 (class 1259 OID 16509)
-- Name: consulta_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE consulta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 175 (class 1259 OID 16417)
-- Name: consulta; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE consulta (
    id integer DEFAULT nextval('consulta_id_seq'::regclass) NOT NULL,
    mascotaid integer,
    fechaconsulta timestamp without time zone,
    veterinario character varying(50),
    observaciones text
);


--
-- TOC entry 181 (class 1259 OID 16482)
-- Name: duenio_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE duenio_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 176 (class 1259 OID 16423)
-- Name: duenio; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE duenio (
    id integer DEFAULT nextval('duenio_id_seq'::regclass) NOT NULL,
    dni character(9),
    notificaciones boolean,
    nombre character varying(50),
    telefono character varying(50),
    direccion character varying(200),
    email character varying(50)
);


--
-- TOC entry 185 (class 1259 OID 16511)
-- Name: mascota_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE mascota_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 177 (class 1259 OID 16426)
-- Name: mascota; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE mascota (
    id integer DEFAULT nextval('mascota_id_seq'::regclass) NOT NULL,
    nombre character varying(50),
    especie character varying(20),
    especieespecifica character varying(50),
    raza character varying(50),
    fechanacimiento timestamp without time zone,
    duenioid integer,
    vivo boolean,
    sexo character varying(20)
);


--
-- TOC entry 178 (class 1259 OID 16429)
-- Name: recordatorio; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW recordatorio AS
 SELECT d.nombre AS nombreduenio,
    m.nombre AS nombremascota,
    d.email,
    aa.id AS aplicacionid
   FROM (((duenio d
     JOIN mascota m ON ((m.duenioid = d.id)))
     JOIN consulta c ON ((m.id = c.mascotaid)))
     JOIN aplicacionagendada aa ON ((c.id = aa.consultaid)));


--
-- TOC entry 182 (class 1259 OID 16489)
-- Name: roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE roles (
    nivel integer NOT NULL,
    nombre character varying(50) NOT NULL
);


--
-- TOC entry 170 (class 1259 OID 16395)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE usuarios (
    user_name character varying(30) NOT NULL,
    user_pass character varying(15) NOT NULL,
    nombre character varying(100)
);


--
-- TOC entry 171 (class 1259 OID 16400)
-- Name: usuariosroles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE usuariosroles (
    user_name character varying(30) NOT NULL,
    role_name character varying(30) NOT NULL
);


--
-- TOC entry 180 (class 1259 OID 16479)
-- Name: vacuna_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE vacuna_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 179 (class 1259 OID 16434)
-- Name: vacuna; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vacuna (
    id integer DEFAULT nextval('vacuna_id_seq'::regclass) NOT NULL,
    nombre character varying(50),
    droga character varying(200),
    laboratorio character varying(100),
    notas character varying(200),
    activa boolean DEFAULT true NOT NULL
);


INSERT INTO configenvio VALUES ('systepet@gmail.com', 'systepet1', 'Hola, ${nombre_dueño}!\nRecuerde que debe aplicarle la vacuna ${nombre_vacuna} a ${nombre_mascota} el día ${fecha_agendada}.\nVeterinaria PetyPet', false, 7, 'systepet', 'Prueba de envio de mail');


--
-- TOC entry 1981 (class 0 OID 16489)
-- Dependencies: 182
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: systepet
--

INSERT INTO roles VALUES (1, 'veterinario');
INSERT INTO roles VALUES (10, 'jefe_veterinario');
INSERT INTO roles VALUES (20, 'administrador');


--
-- TOC entry 1978 (class 0 OID 16395)
-- Dependencies: 170
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: systepet
--

INSERT INTO usuarios VALUES ('tilly', 'tilly', 'Matilde');


--
-- TOC entry 1979 (class 0 OID 16400)
-- Dependencies: 171
-- Data for Name: usuariosroles; Type: TABLE DATA; Schema: public; Owner: systepet
--

INSERT INTO usuariosroles VALUES ('tilly', 'jefe_veterinario');
INSERT INTO usuariosroles VALUES ('tilly', 'veterinario');
INSERT INTO usuariosroles VALUES ('tilly', 'administrador');


--
-- TOC entry 1889 (class 2606 OID 16438)
-- Name: aplicacionagendadaid; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacionagendada
    ADD CONSTRAINT aplicacionagendadaid PRIMARY KEY (id);


--
-- TOC entry 1887 (class 2606 OID 16440)
-- Name: aplicacionid; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacion
    ADD CONSTRAINT aplicacionid PRIMARY KEY (consultaid, vacunaid);


--
-- TOC entry 1891 (class 2606 OID 16442)
-- Name: consultaid; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY consulta
    ADD CONSTRAINT consultaid PRIMARY KEY (id);


--
-- TOC entry 1893 (class 2606 OID 16444)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY duenio
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1895 (class 2606 OID 16446)
-- Name: mascotaid; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY mascota
    ADD CONSTRAINT mascotaid PRIMARY KEY (id);


--
-- TOC entry 1899 (class 2606 OID 16501)
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (nombre);


--
-- TOC entry 1883 (class 2606 OID 16399)
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (user_name);


--
-- TOC entry 1885 (class 2606 OID 16404)
-- Name: usuariosroles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY usuariosroles
    ADD CONSTRAINT usuariosroles_pkey PRIMARY KEY (user_name, role_name);


--
-- TOC entry 1897 (class 2606 OID 16448)
-- Name: vacunaid; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vacuna
    ADD CONSTRAINT vacunaid PRIMARY KEY (id);


--
-- TOC entry 1900 (class 2606 OID 16449)
-- Name: fk_aplicacion_consulta; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacion
    ADD CONSTRAINT fk_aplicacion_consulta FOREIGN KEY (consultaid) REFERENCES consulta(id);


--
-- TOC entry 1901 (class 2606 OID 16454)
-- Name: fk_aplicacion_vacuna; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacion
    ADD CONSTRAINT fk_aplicacion_vacuna FOREIGN KEY (vacunaid) REFERENCES vacuna(id);


--
-- TOC entry 1902 (class 2606 OID 16459)
-- Name: fk_aplicacionagendada_consulta; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacionagendada
    ADD CONSTRAINT fk_aplicacionagendada_consulta FOREIGN KEY (consultaid) REFERENCES consulta(id);


--
-- TOC entry 1903 (class 2606 OID 16464)
-- Name: fk_aplicacionagendada_vacuna; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY aplicacionagendada
    ADD CONSTRAINT fk_aplicacionagendada_vacuna FOREIGN KEY (vacunaid) REFERENCES vacuna(id);


--
-- TOC entry 1904 (class 2606 OID 16469)
-- Name: fk_consulta_mascota; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY consulta
    ADD CONSTRAINT fk_consulta_mascota FOREIGN KEY (mascotaid) REFERENCES mascota(id);


--
-- TOC entry 1905 (class 2606 OID 16474)
-- Name: fk_mascota_duenio; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY mascota
    ADD CONSTRAINT fk_mascota_duenio FOREIGN KEY (duenioid) REFERENCES duenio(id);


-- Completed on 2015-02-15 22:13:04

--
-- PostgreSQL database dump complete
--

