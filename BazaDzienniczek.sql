-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 20 Maj 2019, 19:57
-- Wersja serwera: 10.1.38-MariaDB-0ubuntu0.18.04.2
-- Wersja PHP: 7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `DzienniczekDB`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Classes`
--

CREATE TABLE `Classes` (
  `class_id` int(8) NOT NULL,
  `subject_id` int(8) NOT NULL,
  `teacher_id` int(8) NOT NULL,
  `class_name` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Classes`
--

INSERT INTO `Classes` (`class_id`, `subject_id`, `teacher_id`, `class_name`) VALUES
(1, 1, 2, 'KlasaA'),
(2, 2, 3, 'KlasaB');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Students`
--

CREATE TABLE `Students` (
  `student_id` int(8) NOT NULL,
  `UserID` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `surname` varchar(80) NOT NULL,
  `address` varchar(80) NOT NULL,
  `phone` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Students`
--

INSERT INTO `Students` (`student_id`, `UserID`, `name`, `surname`, `address`, `phone`) VALUES
(3, 18, 'John', 'Kowalski', 'NewYork', '543321765'),
(4, 19, 'Marta', 'Jackowska', 'Warszawa', '678421645');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Student_Classes`
--

CREATE TABLE `Student_Classes` (
  `class_id` int(8) NOT NULL,
  `student_id` int(8) NOT NULL,
  `grade` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Student_Classes`
--

INSERT INTO `Student_Classes` (`class_id`, `student_id`, `grade`) VALUES
(1, 3, 5),
(2, 3, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Subjects`
--

CREATE TABLE `Subjects` (
  `subject_id` int(8) NOT NULL,
  `subject_name` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Subjects`
--

INSERT INTO `Subjects` (`subject_id`, `subject_name`) VALUES
(1, 'Matematyka'),
(2, 'Biologia');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Teachers`
--

CREATE TABLE `Teachers` (
  `teacher_id` int(8) NOT NULL,
  `user_id` int(11) NOT NULL,
  `teacher_name` varchar(50) NOT NULL,
  `teacher_surname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Teachers`
--

INSERT INTO `Teachers` (`teacher_id`, `user_id`, `teacher_name`, `teacher_surname`) VALUES
(2, 15, 'Anna', 'Nowak'),
(3, 17, 'Karol', 'Sosna');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Users`
--

CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Rola` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `Users`
--

INSERT INTO `Users` (`UserID`, `Username`, `Password`, `Rola`) VALUES
(1, 'admin', '11359253167136112191157273831868213424894151238977825495151751245223120279101186202', 'admin'),
(15, 'teacher1', '10204203186581301012311581129391941631881561738214284391352481616021941231992482417', 'teacher'),
(16, 'parent1', '631011552543311411217356180150218112131134149228899310041140226142121342421951566030', 'parent'),
(17, 'teacher2', '10204203186581301012311581129391941631881561738214284391352481616021941231992482417', 'teacher'),
(18, 'student1', '121121082172331952299973448255141116133121622392202253222220119205214107244207209146206', 'student'),
(19, 'student2', '121121082172331952299973448255141116133121622392202253222220119205214107244207209146206', 'student');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `Classes`
--
ALTER TABLE `Classes`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `Students`
--
ALTER TABLE `Students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `Student_Classes`
--
ALTER TABLE `Student_Classes`
  ADD KEY `class_id` (`class_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `Teachers`
--
ALTER TABLE `Teachers`
  ADD PRIMARY KEY (`teacher_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `Classes`
--
ALTER TABLE `Classes`
  MODIFY `class_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `Students`
--
ALTER TABLE `Students`
  MODIFY `student_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `Subjects`
--
ALTER TABLE `Subjects`
  MODIFY `subject_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `Teachers`
--
ALTER TABLE `Teachers`
  MODIFY `teacher_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `Users`
--
ALTER TABLE `Users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `Classes`
--
ALTER TABLE `Classes`
  ADD CONSTRAINT `Classes_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teachers` (`teacher_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Classes_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `Subjects` (`subject_id`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `Students`
--
ALTER TABLE `Students`
  ADD CONSTRAINT `Students_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `Users` (`UserID`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `Student_Classes`
--
ALTER TABLE `Student_Classes`
  ADD CONSTRAINT `Student_Classes_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `Classes` (`class_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Student_Classes_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `Students` (`student_id`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `Teachers`
--
ALTER TABLE `Teachers`
  ADD CONSTRAINT `Teachers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`UserID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
