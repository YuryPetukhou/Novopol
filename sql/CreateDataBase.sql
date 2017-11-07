--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: Novopol; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON DATABASE "Novopol" IS 'Novopol website test base';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: lo; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS lo WITH SCHEMA public;


--
-- Name: EXTENSION lo; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION lo IS 'Large Object maintenance';


--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: articles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE articles (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    post_dt timestamp with time zone NOT NULL,
    content text,
    header text,
    abstract text,
    source text,
    author text
);


--
-- Name: articles_keywords; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE articles_keywords (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    article_id uuid NOT NULL,
    keyword_id uuid NOT NULL
);


--
-- Name: collections; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE collections (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    name character varying(60),
    description text
);


--
-- Name: collections_producers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE collections_producers (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    collection_id uuid NOT NULL,
    producer_id uuid NOT NULL
);


--
-- Name: items; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE items (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    size_one integer,
    size_two integer,
    size_three integer,
    strength_grade integer,
    wear_resistance_class character varying(10),
    code_number character varying(15),
    name character varying(100),
    price_displayed double precision,
    price_real double precision,
    number_in_pack integer,
    meters_in_pack double precision,
    image_thumbnail text,
    image_fullsize text
);


--
-- Name: items_collections; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE items_collections (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    item_id uuid NOT NULL,
    collection_id uuid NOT NULL
);


--
-- Name: items_suppliers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE items_suppliers (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    item_id uuid NOT NULL,
    supplier_id uuid NOT NULL
);


--
-- Name: items_surface_types; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE items_surface_types (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    item_id uuid NOT NULL,
    surface_type_id uuid NOT NULL
);


--
-- Name: keywords; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE keywords (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    keyword text
);


--
-- Name: news; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE news (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    post_dt timestamp with time zone NOT NULL,
    content text,
    header text,
    abstract text,
    source text,
    author text
);


--
-- Name: news_keywords; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE news_keywords (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    news_id uuid NOT NULL,
    keyword_id uuid NOT NULL
);


--
-- Name: producers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE producers (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    name character varying(50),
    country character varying(20),
    city character varying(20),
    state character varying(20),
    zipcode character varying(15),
    phone character varying(20),
    house character varying(10),
    office character varying(10),
    email character varying(50),
    website character varying(100),
    contact_person character varying(50),
    street character varying(50)
);


--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE suppliers (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    name character varying(50),
    country character varying(20),
    city character varying(20),
    state character varying(20),
    zipcode character varying(15),
    phone character varying(20),
    house character varying(10),
    office character varying(10),
    email character varying(50),
    website character varying(100),
    contact_person character varying(50),
    street character varying(50)
);


--
-- Name: surface_types; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE surface_types (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    created_dt timestamp with time zone NOT NULL,
    updated_dt timestamp with time zone NOT NULL,
    created_by character varying(15) NOT NULL,
    updated_by character varying(15) NOT NULL,
    type character varying(50)
);


--
-- Name: articles_keywords articles_keywords_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY articles_keywords
    ADD CONSTRAINT articles_keywords_pkey PRIMARY KEY (id);


--
-- Name: articles articles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY articles
    ADD CONSTRAINT articles_pkey PRIMARY KEY (id);


--
-- Name: collections collections_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY collections
    ADD CONSTRAINT collections_pkey PRIMARY KEY (id);


--
-- Name: collections_producers collections_producers_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY collections_producers
    ADD CONSTRAINT collections_producers_pkey PRIMARY KEY (id);


--
-- Name: items item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- Name: items_collections items_collections_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_collections
    ADD CONSTRAINT items_collections_pkey PRIMARY KEY (id);


--
-- Name: items_suppliers items_suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_suppliers
    ADD CONSTRAINT items_suppliers_pkey PRIMARY KEY (id);


--
-- Name: items_surface_types items_surface_types_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_surface_types
    ADD CONSTRAINT items_surface_types_pkey PRIMARY KEY (id);


--
-- Name: keywords keywords_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY keywords
    ADD CONSTRAINT keywords_pkey PRIMARY KEY (id);


--
-- Name: news_keywords news_keywords_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY news_keywords
    ADD CONSTRAINT news_keywords_pkey PRIMARY KEY (id);


--
-- Name: news news_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY news
    ADD CONSTRAINT news_pkey PRIMARY KEY (id);


--
-- Name: producers producers_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY producers
    ADD CONSTRAINT producers_pkey PRIMARY KEY (id);


--
-- Name: suppliers suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY suppliers
    ADD CONSTRAINT suppliers_pkey PRIMARY KEY (id);


--
-- Name: surface_types surface_types_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY surface_types
    ADD CONSTRAINT surface_types_pkey PRIMARY KEY (id);


--
-- Name: article_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX article_id_covering_index ON articles_keywords USING btree (article_id);


--
-- Name: collection1_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX collection1_id_covering_index ON items_collections USING btree (collection_id);


--
-- Name: collection_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX collection_id_covering_index ON items_collections USING btree (item_id);


--
-- Name: collection_one_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX collection_one_id_covering_index ON collections_producers USING btree (collection_id);


--
-- Name: item_id_covering_index1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX item_id_covering_index1 ON items_surface_types USING btree (item_id);


--
-- Name: keyword_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX keyword_id_covering_index ON articles_keywords USING btree (keyword_id);


--
-- Name: keyword_second_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX keyword_second_id_covering_index ON news_keywords USING btree (keyword_id);


--
-- Name: news_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX news_id_covering_index ON news_keywords USING btree (news_id);


--
-- Name: producer_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX producer_id_covering_index ON collections_producers USING btree (producer_id);


--
-- Name: supplier1_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX supplier1_id_covering_index ON items_suppliers USING btree (item_id);


--
-- Name: supplier_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX supplier_id_covering_index ON items_suppliers USING btree (supplier_id);


--
-- Name: surface_typer_id_covering_index; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX surface_typer_id_covering_index ON items_surface_types USING btree (surface_type_id);


--
-- Name: articles_keywords articles_keywords_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY articles_keywords
    ADD CONSTRAINT articles_keywords_article_id_fkey FOREIGN KEY (article_id) REFERENCES articles(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: articles_keywords articles_keywords_keyword_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY articles_keywords
    ADD CONSTRAINT articles_keywords_keyword_id_fkey FOREIGN KEY (keyword_id) REFERENCES keywords(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: collections_producers collections_producers_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY collections_producers
    ADD CONSTRAINT collections_producers_item_id_fkey FOREIGN KEY (collection_id) REFERENCES collections(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: collections_producers collections_producers_producer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY collections_producers
    ADD CONSTRAINT collections_producers_producer_id_fkey FOREIGN KEY (producer_id) REFERENCES producers(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_collections items_collections_collection_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_collections
    ADD CONSTRAINT items_collections_collection_id_fkey FOREIGN KEY (collection_id) REFERENCES collections(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_collections items_collections_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_collections
    ADD CONSTRAINT items_collections_item_id_fkey FOREIGN KEY (item_id) REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_suppliers items_suppliers_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_suppliers
    ADD CONSTRAINT items_suppliers_item_id_fkey FOREIGN KEY (item_id) REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_suppliers items_suppliers_supplier_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_suppliers
    ADD CONSTRAINT items_suppliers_supplier_id_fkey FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_surface_types items_surface_types_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_surface_types
    ADD CONSTRAINT items_surface_types_item_id_fkey FOREIGN KEY (item_id) REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: items_surface_types items_surface_types_surface_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY items_surface_types
    ADD CONSTRAINT items_surface_types_surface_type_id_fkey FOREIGN KEY (surface_type_id) REFERENCES surface_types(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: news_keywords news_keywords_keyword_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY news_keywords
    ADD CONSTRAINT news_keywords_keyword_id_fkey FOREIGN KEY (keyword_id) REFERENCES keywords(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: news_keywords news_keywords_keyword_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY news_keywords
    ADD CONSTRAINT news_keywords_keyword_id_fkey1 FOREIGN KEY (keyword_id) REFERENCES keywords(id);


--
-- Name: news_keywords news_keywords_news_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY news_keywords
    ADD CONSTRAINT news_keywords_news_id_fkey FOREIGN KEY (news_id) REFERENCES news(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

