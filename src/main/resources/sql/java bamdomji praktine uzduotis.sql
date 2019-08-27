CREATE DATABASE `dienynas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `studentai` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vardas` varchar(32) NOT NULL,
  `pavarde` varchar(32) NOT NULL,
  `el_pastas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pazymiai` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `studentas_id` int(10) unsigned NOT NULL,
  `data` date NOT NULL,
  `pazymys` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `studentas_id_idx` (`studentas_id`),
  CONSTRAINT `studentas_id` FOREIGN KEY (`studentas_id`) REFERENCES `studentai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO studentai (`vardas`, `pavarde`, `el_pastas`) VALUES ('Gediminas', 'Jonaitis', 'g.jonaitis@gmail.com');
INSERT INTO studentai (`vardas`, `pavarde`, `el_pastas`) VALUES ('Jonas', 'Petraitis', 'j.petraitis@gmail.com');
INSERT INTO studentai (`vardas`, `pavarde`, `el_pastas`) VALUES ('Kazimieras', 'Lukšys', 'k.luksys@gmail.com');
INSERT INTO studentai (`vardas`, `pavarde`, `el_pastas`) VALUES ('Rimas', 'Motuza', 'r.motuza@gmail.com');
INSERT INTO studentai (`vardas`, `pavarde`, `el_pastas`) VALUES ('Vardenis', 'Pavardenis', 'v.pav@yahoo.com');

select * from studentai;

INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (1, STR_TO_DATE('2018-08-12', '%Y-%m-%d'), 10);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (2, STR_TO_DATE('2018-08-12', '%Y-%m-%d'), 8);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (3, STR_TO_DATE('2018-08-12', '%Y-%m-%d'), 8);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (4, STR_TO_DATE('2018-08-12', '%Y-%m-%d'), 9);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (1, STR_TO_DATE('2018-08-16', '%Y-%m-%d'), 9);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (2, STR_TO_DATE('2018-08-16', '%Y-%m-%d'), 8);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (3, STR_TO_DATE('2018-08-16', '%Y-%m-%d'), 9);
INSERT INTO pazymiai (`studentas_id`, `data`, `pazymys`) VALUES (1, STR_TO_DATE('2018-08-17', '%Y-%m-%d'), 10);

select * from pazymiai;

-- STR_TO_DATE('1-01-2012', '%d-%m-%Y')

-- 1. 
SELECT COUNT(*) FROM studentai;

-- 2.
SELECT vardas, pavarde, pazymys
FROM studentai
JOIN pazymiai ON studentai.id = pazymiai.studentas_id
WHERE `data` = '2018-08-12';

-- 3
SELECT vardas, pavarde, AVG(pazymys) AS vidurkis
FROM studentai
JOIN pazymiai ON studentai.id = pazymiai.studentas_id
GROUP BY studentai.id;

-- 4
SELECT vardas, pavarde, AVG(pazymys) AS vidurkis
FROM studentai
JOIN pazymiai ON studentai.id = pazymiai.studentas_id
GROUP BY studentai.id
HAVING AVG(pazymys) > 9;

-- 5
SELECT el_pastas
FROM studentai
JOIN (
	SELECT studentas_id, COUNT(*) cnt
	FROM pazymiai
	GROUP BY studentas_id
	HAVING count(CASE WHEN pazymys IS NULL THEN 1 END)
	-- COUNT(IFNULL(0, pazymys)) <= 1	-- COUNT(pazymys) <= 1 and
	) paz ON studentai.id = paz.studentas_id;

-- 5 teisingesnis variantas, kad selectintu ir neturinti pazymiu

SELECT el_pastas
FROM (
SELECT studentai.id, el_pastas, COUNT(pazymys)
FROM studentai
LEFT JOIN pazymiai paz ON studentai.id = paz.studentas_id
GROUP BY studentai.id, el_pastas
HAVING COUNT(pazymys) <= 1
) stud_paz;



