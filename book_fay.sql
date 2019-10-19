-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2019 at 11:26 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_fay`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(10) NOT NULL,
  `ISBN` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` varchar(1000) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `ISBN`, `name`, `author`, `publisher`, `quantity`, `added_date`) VALUES
(1, 'A@4', 'C In Depth', 'Shrivastav', 'BPB', '1', '2019-10-17 11:39:21'),
(2, 'B@1', 'DBMS', 'Korth', 'Pearson', '3', '2016-07-18 18:39:52'),
(3, 'G@12', 'Let\'s see', 'Yashwant Kanetkar', 'BPB', '10', '2016-07-18 23:02:14'),
(4, 'sfhsf', 'hfshfsh', 'sfh', 'sfsff', 'fhfh', '2019-09-15 19:13:28'),
(5, 'cccc', '', '', '', '', '2019-09-15 19:21:57'),
(6, 'gwg', 'grg', '', '', '', '2019-09-16 19:48:41'),
(7, 'dddddd', '', '', '', '', '2019-09-16 19:59:03'),
(8, 'rryytyt', '', '', '', '', '2019-09-16 20:03:44'),
(9, 'tywehty', '', '', '', '', '2019-09-16 20:03:57'),
(10, 'aduuaGFY', 'HDJGGAhus', 'JSJJFJ', 'AXJAV', 'SAFUIAS', '2019-09-26 12:37:14'),
(11, '12', 'hwhgwghhil', 'sgjgsjg', 'iufhfuhquh', 'jwugh', '2019-10-02 20:25:26'),
(12, '555', 'rider', 'rider', 'frider', '79', '2019-10-13 20:03:07'),
(13, '3322', 'jack', 'jackson', 'may', '50', '2019-10-15 13:51:17'),
(14, '245', 'hafh', 'jdjg', 'jnk', '53', '2019-10-17 14:04:12'),
(15, '1239-55676-887788', 'THE PROGRAMMING LANGUAGE FOR BEGGINERS', 'PROF.H.G. KENNETH', 'FENNN CHINA', '8', '2019-10-18 09:04:13'),
(16, '5667-887776-998770', 'ORGANIC CHEMISTRY', 'DR CLEMENT & MR BENNY', 'AFRICANNA PUBLISHERS', '20', '2019-10-17 10:44:11'),
(17, '0098-98887-977655', 'ALGORITHM OF NUMBERS', 'PROF.H.M LEO', 'W.N CANNADA', '9', '2019-10-17 10:45:20'),
(18, '8897-9087-554320', 'DATA STRUCTURES ', 'W.L. LEONARD', 'POER PUBLSHERS INDIA', '15', '2019-10-17 10:47:02'),
(19, '2331-9887-789766', 'DISCRETE STRUCTURES & MODELING', 'DR OKAFOR', 'FIRST CIT PUBLISHERS LAGOS', '41', '2019-10-17 10:48:45'),
(20, '1008-90999-977656', 'MATHEMATICAL COMPUTATION', 'PROF. HAGGIN LUTH', 'BROWN PUBLISHERS L.A', '42', '2019-10-17 10:52:56'),
(21, '1092-6674-2366-2223', 'MATHEMATICAL PHYSICS ', 'PRO.MOHAMMED LIMAN', 'AFRICANNA FIRST PUBLISHERS', '90', '2019-10-17 10:54:18'),
(22, '12001-4436-00987-0900', 'FUNCTIONAL SEQUENTIAL PROGRAMMING(FSP)', 'DR. BAKO & DR. DAUDA', 'PEAKLAND PUBLISHERS Plc', '70', '2019-10-17 10:57:17'),
(23, '87009-00978-99867-0090', 'ORGANIC BIO-CHEMISTRY', 'DR. F.J SANUSI', 'J PEE PUBLISHERS UNILID', '119', '2019-10-18 05:31:41'),
(24, '393930-99989-9393-39000', 'MICROBIOLOGY', 'DR. GREEN M.L', 'GREEN PBLISHERS LOS ANGELES', '31', '2019-10-17 11:00:53'),
(25, '09908-44563-944410-0999', 'INTRODUCTRY BIOCHEMISTRY ', 'A.A HAGGIN ', 'FIRST CITY PRINTERS', '130', '2019-10-17 11:02:24'),
(26, '0955-494949-0004889-090887', 'INTRODUCTION TO SEQUENTIAL PROGRAMMING III', 'MR BAKO J.K ', 'FIRST CITY PUBLISHERS', '290', '2019-10-17 11:04:24'),
(27, '2101-00393-03389-999003', 'INTRODUCTION TO JAVA PROGRAMMING III', 'MR HABILA MUSA', 'PEAKLAND PRINTERS LTD', '397', '2019-10-17 11:06:38'),
(28, '0998-09983-383890-3321001', 'PHYSICAL CHEMISTRY FOR LEANNERS', 'MR ERASMUS O. H', 'AFRICANNA FIRST PUBLISHERS', '172', '2019-10-17 11:08:14'),
(29, '00909-3039393-3399-0990998', 'ATOMS & MOLECULES EXPANTIATED ', 'PROF.MAMMUDA & DR. BETTY', 'LANDSCAPE PUBLISHERS &. CO', '81', '2019-10-17 11:10:36'),
(30, '54400-00980-06645-09890', 'COMPUTATIONAL PHYSICS IV', 'PROF. LIMAN .M', 'FIRST AFRICAN PUBLISHERS', '321', '2019-10-17 11:14:20'),
(31, '34456-98009-06645-09980', 'CLOUD PRGRAMMING II', 'DR. BENNY CISSCO', 'CISSCO PUBLISHERS INT\'L', '100', '2019-10-17 11:16:34'),
(32, '128009-0098-76009', 'PHYSICAL CHYEMISTRY', 'DR. KATE BRYAN', 'AFRICANNA FIRST PUBLISHERS', '43', '2019-10-17 11:22:11'),
(33, '9089-87678-9090-099098', 'CISSCO COMPUTATIONAL NETWORKING ', 'ENGR.DANIEL.N J.  ', 'FIRST CITY PUBLISHERS', '43', '2019-10-17 11:24:13'),
(34, '0989-8888-00897-00096', ' BOOKKEEPING & ACCONTING', 'DR. SIXTUS IKECHUKU', 'AFRICANNA FIRST PUBLISHERS LTD', '42', '2019-10-17 22:06:42'),
(35, '3421-89970-87890-9090', 'COMPUTATIONAL COMMERCE', 'DR. CHRISTAIN IKENNA', 'FIRST CITY PUBLISHERS PLC', '87', '2019-10-17 11:30:27'),
(36, '9870-0909-9751-090887', 'DRAMA & POETRY ', 'PROF. S.V DUGGA', 'AFRICANNA FIRST PUBLISHERS', '26', '2019-10-17 11:31:57'),
(37, '0980-97878-0098-0909880-8009', 'PHILOSOPHY & LOGIC ', 'DR. NNEMEKA IKE', 'GRAND CENIMENT PUBLISHERS PLC', '89', '2019-10-17 11:33:31'),
(38, '4556-98009-0990-09098', 'DRAMMER AND POET', 'DR. SINNERS DINNATU', 'L.A PUBLISHERS LTD', '61', '2019-10-17 11:37:46'),
(39, '8776-90098-0988-8767', 'ORGANIC CHEMISTRY III', 'DR. HAGGIN M. N', 'LOS ANGELES PRINTERS', '87', '2019-10-17 11:56:06'),
(40, '123-11010-101098-0998', 'DRAMMER & AFRICAN POET ', 'DR. BEKKY POKER', 'AFRICANNER PUBLISHERS', '43', '2019-10-17 11:59:06'),
(41, '01098-09908-09098-010123', 'BOOK-KEEPING REVISED.', 'MR. SUNNY OBIDDA', 'AFRICANNA FIRST PUBLISHERS', '80', '2019-10-17 12:02:14'),
(42, '0808-0796-080897-07978', 'ACCOUNTACY FOR M.sc', 'PROF. DANIELS PETERS', 'AFRICANNA PUBLISHERS', '90', '2019-10-17 13:59:22'),
(43, '09088-96656-00975-009765', 'NUMBER SYSTEMS & ANALYSIS', 'DR. LEO BENJAMINE', 'FIRST CITY PRINTERS LTD', '', '2019-10-17 12:05:57');

-- --------------------------------------------------------

--
-- Table structure for table `issuebooks`
--

CREATE TABLE `issuebooks` (
  `id` int(11) NOT NULL,
  `Book_Id` int(50) NOT NULL,
  `studentid` int(11) NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(100) NOT NULL,
  `ReturnDate` varchar(11) NOT NULL,
  `issueddate` timestamp(6) NOT NULL DEFAULT current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebooks`
--

INSERT INTO `issuebooks` (`id`, `Book_Id`, `studentid`, `studentname`, `studentcontact`, `ReturnDate`, `issueddate`) VALUES
(4, 0, 23, 'kk', '932992932', '0000-00-00', '2016-07-19 18:43:16.000000'),
(6, 0, 335, 'Sumedh', '95676565756', '0000-00-00', '2016-07-19 18:44:34.000000'),
(7, 0, 87, 'abhishek', '9329882382', '0000-00-00', '2016-07-19 18:46:12.000000'),
(13, 14, 12, 'ab', '8248768', '31-10-2019', '2019-10-16 09:58:03.632553'),
(14, 14, 12, 'hahlh', 'jbahbhb', '29-10-2019', '2019-10-17 10:36:44.529484'),
(15, 1, 8877, 'YTTT', 'BHIB88888', '06-10-2019', '2019-10-17 11:39:22.063726'),
(16, 14, 12, 'christian', 'odeychristian@yahoo.com', '31-10-2019', '2019-10-17 14:04:12.935677'),
(17, 34, 12, 'christian', 'egaxtian@gmail.com', '30-10-2019', '2019-10-17 22:06:43.026713'),
(18, 23, 24, 'crash', 'egaxtian@gmail.com', '28-10-2019', '2019-10-18 05:31:41.539192'),
(19, 15, 12, 'joseph daniel', 'princedanieljoseph956@gmail.com', '20-10-2019', '2019-10-18 08:59:48.964843'),
(20, 15, 2031700050, 'Haruna Habibu Nuhu', 'haruna.habibu114@gmail.com', '30-10-2019', '2019-10-18 09:04:13.861694');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `user_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `password`, `email`, `address`, `city`, `contact`, `user_type`) VALUES
(1, 'Prabhakar', 'ppp', 'prabhakar@gmail.com', 'javatpoint', 'noida', '9998328238', ''),
(4, 'sumedh', 'sumesh', 'sumesh@gmail.com', 'Kuch Bhi', 'noida', '93823932823', ''),
(6, 'abhi', 'abhi', 'abhi@gmail.com', 'javatpoint', 'noida', '92393282323', ''),
(7, 'wr', '', '', '', '', '', ''),
(8, 'adgdgd', 'wfwfw', 'fgvadv', '', '', '', ''),
(9, 'chris', 'chris', 'odeyxtian@gmail.com', 'Lafia Buan kwato', 'Lafia', '08090990653', ''),
(10, 'lib', 'lib', 'jaff', 'vvdv', 'jhfghh', 'jbsb', 'librarian'),
(11, 'afF', 'EEAF', 'aDF', 'aGG', 'aDG', 'aDD', 'librarian'),
(13, 'ha', 'FBHBA', '', 'b', 'b', 'jvdjvgJB', 'librarian'),
(14, 'chris', 'chris', 'chris@gmail.com', 'bukakwato', 'lafia', '0809099653', 'librarian'),
(15, 'richard', 'richard', 'richard@hotmale.com', 'Marley', 'Lafia', '8030849796', 'librarian'),
(16, 'john', 'innocent', 'johninnocent@gmail.com', 'mararaba', 'lafia', '09036063076', 'librarian'),
(17, 'ajogwu_sixtus', 'six', 'ajogwusixtus@gmail.com', 'Akunza-Lafia', 'Abuja', '08175228616', 'librarian'),
(18, 'aladdin', 'aladdin', 'nuzyflex14@gmail.com', 'phase3 federal housing ua', 'abuja', '706020706', 'librarian'),
(19, 'jhhu', 'kjhgf', 'jej', '', '', '', 'librarian'),
(20, 'Engr dan', '12345', 'dan@gmail.com', 'lafia', 'lafia', '12345', 'librarian');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `matric` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `name`, `password`, `matric`, `user_type`) VALUES
(1, 'admin', 'admin', '', 'admin'),
(2, 'subusr', 'subusr', '', 'student'),
(8, 'user', 'user', '', 'librarian'),
(10, 'cap', 'cap', 'hdh', 'student'),
(11, 'agad', 'DGG', '', 'librarian'),
(12, 'ah', 'jjgjgjn', 'jsjj', 'student'),
(13, 'ha', 'FBHBA', '', 'librarian'),
(14, 'ayga', 'jajjjadn', '48886827', 'student'),
(15, 'chris', 'chris', '', 'librarian'),
(16, 'richard', 'richard', '', 'librarian'),
(17, 'john', 'innocent', '', 'librarian'),
(18, 'ajogwu_sixtus', 'six', '', 'librarian'),
(19, 'Idris Kwarra Yakubu', 'idris', '080', 'student'),
(20, 'aladdin', 'aladdin', '', 'librarian'),
(21, 'Eeg', 'qeg', '', 'student'),
(22, 'EUEA', 'IEJG', '', 'student'),
(23, 'JDGGwN', 'IAJCJD', 'JNJNVNJS', 'student'),
(24, 'IJWFH', 'nsd', 'jddjdj', 'student'),
(25, 'james', 'james', '998468468', 'student'),
(26, 'isaac', 'isaac', '9091385580', 'student'),
(27, 'faith', 'faith', '9395899', 'student'),
(28, 'nelly', 'nelly', '88135588788', 'student'),
(29, 'jane', 'jane', '8927884441899', 'student'),
(30, 'mike', 'mika', '918783788', 'student'),
(31, 'vicky', 'bffjnefjnj', '115717573', 'student'),
(32, 'arome', 'arome', '82855835', 'student'),
(33, 'jayay', 'jay', '18755819', 'student'),
(34, 'joy', 'joy', '8913782369', 'student'),
(35, 'famouse', 'ihfjjnfj/', '877589899', 'student'),
(36, 'jhhu', 'kjhgf', '', 'librarian'),
(37, 'Engr dan', '12345', '12345', 'student'),
(38, 'Engr dan', '12345', '', 'librarian');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `std_id` int(5) NOT NULL,
  `stdname` varchar(20) NOT NULL,
  `stdpass` varchar(11) NOT NULL,
  `stdphone` varchar(40) NOT NULL,
  `stdemail` varchar(20) NOT NULL,
  `stdmatric` varchar(10) NOT NULL,
  `user_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`std_id`, `stdname`, `stdpass`, `stdphone`, `stdemail`, `stdmatric`, `user_type`) VALUES
(11, 'Fayrix', 'fayrix', '', '', '2031700096', ''),
(12, 'rrw', 'tyr', '', '', 'sRYY', 'student'),
(13, 'crash', 'crash', '', '', '1234567', 'student'),
(14, 'cry', 'cry', 'hh', 'AGg', 'jethETt', 'student'),
(15, 'cryy', 'cryy', '', '', 'aaa', 'student'),
(16, 'ege', 'ege', 'egE', 'eg', 'EG', 'student'),
(17, 'cap', 'cap', 'hdh', 'gfggv', 'hdhhd', 'student'),
(18, 'ah', 'jjgjgjn', 'jsjj', 'jvdjvj', '20', 'student'),
(19, 'ayga', 'jajjjadn', '48886827', 'jajjgjj', '987488448', 'student'),
(20, 'Idris Kwarra Yakubu', 'idris', '080', 'idriskwara@gmail.com', '2031700003', 'student'),
(21, 'Eeg', 'qeg', '', 'eg', 'EG', 'student'),
(22, 'EUEA', 'IEJG', '', 'JJVNEN', 'NNAVNIVN', 'student'),
(23, 'JDGGwN', 'IAJCJD', 'JNJNVNJS', 'ncjnwCN', 'NNJCJ', 'student'),
(24, 'IJWFH', 'nsd', 'jddjdj', 'n', 'djndd', 'student'),
(25, 'james', 'james', '998468468', 'jjjddjj@gmail.com', '203170000', 'student'),
(26, 'isaac', 'isaac', '9091385580', 'isaac@gm.com', '8377689386', 'student'),
(27, 'faith', 'faith', '9395899', 'faithfaith@g.v', '2031700005', 'student'),
(28, 'nelly', 'nelly', '88135588788', 'nelly@gg.vom', '8185137585', 'student'),
(29, 'jane', 'jane', '8927884441899', 'jannd@jwdhh.jf', '9892887578', 'student'),
(30, 'mike', 'mika', '918783788', 'mika@gml.com', '252563556', 'student'),
(31, 'vicky', 'bffjnefjnj', '115717573', 'vic@jh.com', '752755566', 'student'),
(32, 'arome', 'arome', '82855835', 'aroe@ekhf.co', '893684688', 'student'),
(33, 'jayay', 'jay', '18755819', 'jay@df.gb', '987357876', 'student'),
(34, 'joy', 'joy', '8913782369', 'joy@jjgn.vk', '2867866864', 'student'),
(35, 'famouse', 'ihfjjnfj/', '877589899', 'fnm@jf.v', '8935755878', 'student'),
(36, 'Engr dan', '12345', '12345', 'dan@gmail.com', '12345', 'student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `callno` (`ISBN`),
  ADD UNIQUE KEY `callno_2` (`ISBN`);

--
-- Indexes for table `issuebooks`
--
ALTER TABLE `issuebooks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`std_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `issuebooks`
--
ALTER TABLE `issuebooks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `std_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
