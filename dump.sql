CREATE TABLE "authors" (
                           "author_id" bigserial not null,
                           "author_full_name" text,
                           "author_biography" text,
                           "author_img_url" text,
                           "author_birth_date" date,
                           "author_death_date" date,
                           CONSTRAINT authors_pkey PRIMARY KEY (author_id)
);

CREATE TABLE "books" (
                         "book_id" bigserial not null,
                         "book_title" text,
                         "book_description" text,
                         "book_img_url" text,
                         "author_id" bigint,
                         CONSTRAINT books_pkey PRIMARY KEY (book_id)
);

CREATE TABLE "articles" (
                            "article_id" bigserial,
                            "article_title" text,
                            "article_description" text,
                            "article_img_url" text,
                            CONSTRAINT articles_pkey PRIMARY KEY (article_id)
);

CREATE TABLE "users" (
                         "user_id" bigserial,
                         "user_first_name" varchar(255),
                         "user_last_name" varchar(255),
                         "user_email" varchar(255),
                         "user_password" varchar(255),
                         "user_role" smallint,
                         CONSTRAINT users_pkey PRIMARY KEY (user_id)
);


INSERT INTO users(user_id, user_first_name, user_last_name, user_email, user_password, user_role) VALUES
(DEFAULT, 'Admin', 'Adminuly', 'admin@astanait.edu.kz', '123', 2),
(DEFAULT, 'Nurym', 'Siyrbayev', 'n.siyrbayev@astanait.edu.kz', '123', 1),
(DEFAULT, 'Miras', 'Satybaldy', 'm.satybaldy@astanait.edu.kz', '123', 1);

insert into authors(author_full_name, author_biography, author_img_url, author_birth_date, author_death_date)
VALUES('Author-2', 'Bio', 'https://bigenc.ru/media/2016/10/27/1235214219/19348.jpg', '12-12-2012', NULL);

select * from authors;

delete from authors where author_id = 7;

INSERT INTO articles(article_title, article_description, article_img_url) VALUES
('Заголовок', 'Что то что то','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW7cKEgr2lHgQ5k8iyHMQ0Rryf3yrWzLyPow&usqp=CAU');

select * from  articles;













?????????????????????????????????????????????????????????????????????????????????
-- don't use !!!!


CREATE TABLE "clubs" (
    "club_id" bigserial,
    "club_name" text,
    "club_description" text,
    "club_img_url" text,
    owner_id bigint,
    CONSTRAINT clubs_pkey PRIMARY KEY (club_id)
);

CREATE TABLE "events" (
    "event_id" bigserial,
    "event_title" text,
    "event_description" text,
    "event_img_url" text,
    "club_id" bigint,
    CONSTRAINT events_pkey PRIMARY KEY (event_id),
    FOREIGN KEY (club_id) REFERENCES clubs(club_id) ON DELETE CASCADE
);

CREATE TABLE "groups" (
    "group_id" bigserial,
    "group_name" text,
    CONSTRAINT groups_pkey PRIMARY KEY (group_id)
);

CREATE TABLE "majors" (
    "major_id" bigserial,
    "major_name" text,
    CONSTRAINT majors_pkey PRIMARY KEY (major_id)
);
CREATE TABLE "news" (
    "news_id" bigserial,
    "news_title" text,
    "news_description" text,
    "news_img_url" text,
    CONSTRAINT news_pkey PRIMARY KEY (news_id)
);

CREATE TABLE "users" (
    "user_id" bigserial,
    "user_first_name" varchar(255),
    "user_last_name" varchar(255),
    "user_email" varchar(255),
    "user_password" varchar(255),
    "user_role" smallint,
    "group_id" bigint,
    "major_id" bigint,
    "graduate_year" int,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    FOREIGN KEY (group_id) REFERENCES groups(group_id) ON DELETE CASCADE,
    FOREIGN KEY (major_id) REFERENCES majors(major_id) ON DELETE CASCADE
);

CREATE TABLE "club_members" (
    "user_id" bigint,
    "club_id" bigint,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (club_id) REFERENCES clubs(club_id) ON DELETE CASCADE
);

create table user_requests_to_join_the_club(
    request_id bigserial primary key,
    user_id bigint,
    club_id bigint,
    request_status boolean default 'true',
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (club_id) REFERENCES clubs(club_id) ON DELETE CASCADE
);

INSERT INTO groups(group_id, group_name) VALUES
(DEFAULT, 'SE-1905'),
(DEFAULT, 'ITM-1901'),
(DEFAULT, 'BDA-1902'),
(DEFAULT, 'IT-1903'),
(DEFAULT, 'IA-1904'),
(DEFAULT, 'TS-1906'),
(DEFAULT, 'SE-2001'),
(DEFAULT, 'SE-2002');

INSERT INTO majors(major_id, major_name) VALUES
(DEFAULT, 'Software Engineering'),
(DEFAULT, 'IT Management'),
(DEFAULT, 'Big Data Analysis'),
(DEFAULT, 'Computer Science'),
(DEFAULT, 'Industrial Automation'),
(DEFAULT, 'Telecommunication Systems');

INSERT INTO users(user_id, user_first_name, user_last_name, user_email, user_password, user_role, group_id, major_id, graduate_year) VALUES
(DEFAULT, 'Admin', 'Adminuly', 'admin@astanait.edu.kz', '123', 2, 1, 1, '2050'),
(DEFAULT, 'Azatkali', 'Nurumgaliyev', 'a.nurumgaliyev@astanait.edu.kz', '123', 1, 5, 5, '2022'),
(DEFAULT, 'Akylbek', 'Konyskairov', 'a.konyskairov@astanait.edu.kz', '123', 1, 4, 4, '2022'),
(DEFAULT, 'Nyrum', 'Siyrbayev', 'n.siyrbayev@astanait.edu.kz', '123', 1, 3, 3, '2022'),
(DEFAULT, 'Chingiz', 'Azimbayev', 'c.azimbayev@astanait.edu.kz', '123', 1, 2, 2, '2022'),
(DEFAULT, 'Miras', 'Satybai', 'm.satybai@astanait.edu.kz', '123', 1, 1, 1, '2022'),
(DEFAULT, 'Adil', 'Rahmetov', 'a.rahmetov@astanait.edu.kz', '123', 1, 5, 5, '2022'),
(DEFAULT, 'Azhar', 'Serikova', 'a.serikova@astanait.edu.kz', '123', 1, 4, 4, '2022'),
(DEFAULT, 'Madiyar', 'Ussabekov', 'm.ussabekov@astanait.edu.kz', '123', 1, 3, 3, '2022'),
(DEFAULT, 'Bekarys', 'Moldahmetov', 'b.moldahmetov@astanait.edu.kz', '123', 1, 2, 2, '2022'),
(DEFAULT, 'Maksat', 'Olzhabayev', 'm.olzhabayev@astanait.edu.kz', '123', 1, 1, 1, '2022'),
(DEFAULT, 'Khassen', 'Amangeldi', 'k.amangeldi@astanait.edu.kz', '123', 1, 5, 5, '2022'),
(DEFAULT, 'Aldiyar', 'Aitkesh', 'a.aitkesh@astanait.edu.kz', '123', 1, 4, 4, '2022'),
(DEFAULT, 'Yernur', 'Bayashev', 'y.bayashev@astanait.edu.kz', '123', 1, 3, 3, '2022'),
(DEFAULT, 'Abylai', 'Serikkazy', 'a.serikkazy@astanait.edu.kz', '123', 1, 2, 2, '2022'),
(DEFAULT, 'Mukhammed', 'Yessbol', 'm.yessbol@astanait.edu.kz', '123', 1, 1, 1, '2022'),
(DEFAULT, 'Georgiy', 'Ivanov', 'g.ivanov@astanait.edu.kz', '123', 1, 7, 1, '2023'),
(DEFAULT, 'Azatkali', 'Siyrbayev', 'a.siyrbayev@astanait.edu.kz', '123', 1, 7, 1, '2023'),
(DEFAULT, 'Siyr', 'Cartier', 's.cartier@astanait.edu.kz', '123', 1, 8, 1, '2023'),
(DEFAULT, 'Nurum', 'Gali', 'n.gali@astanait.edu.kz', '123', 1, 8, 1, '2023'),
(DEFAULT, 'Azat', 'Raven', 'a.raven@astanait.edu.kz', '123', 1, 8, 1, '2023');

alter table clubs add foreign key (owner_id) references users (user_id);

INSERT INTO clubs(club_id, club_name, club_description, club_img_url, owner_id)
VALUES
(DEFAULT, 'Music club', 'Music club is aimed at talented students who want to develop from a creative side,
love to sing and play musical instruments,
contribute in every way to the widespread popularization of music. Music club is a creative music workshop and our main motto is "If you do not know how, we will teach!" It does not matter to us how professional you are,
we value the love of dance and music, the desire and desire to learn and improve.',
'https://astanait.edu.kz/wp-content/uploads/2020/04/music-club.jpg', 1),
(DEFAULT, 'Cybersport club',
'Cybersport club is a club whose activities are aimed at the development and popularization of eSports as part of the international sports movement. Cybersport club was created to empower students with an interest in eSports to participate in various eSports-related events. And now,
students are enthusiastically gaining experience in such disciplines as Counter-Strike,
Global Offensive and Dota 2. Our task is to participate in tournaments in the city of Nur-Sultan on behalf of our university,
thereby attracting more young people, like to our Astana IT University.and in our Cybersport club.',
'https://astanait.edu.kz/wp-content/uploads/2020/04/cybersport-club.png', 2),
(DEFAULT, 'Event club', 'Event club is a club of young, talented, ambitious,
who decided to dilute the boring life of students with leisure and active student life AITU. Activists are eager to organize and conduct incendiary events,
entertainment events, non - standard actions, as well as unique interactive role - playing quests.One of the
large - scale events is the freshman talent competition - "AITU TALENT SHOW", held on October 18,
2019 within the walls of the university. During the preparation of the next event,
the Event club makes hundreds of decisions: what idea to base the concept on,
which host to choose for the event,
whom to invite and much more. The success of the event directly depends on the correctness of the decisions made.',
'https://astanait.edu.kz/wp-content/uploads/2020/04/event-club.jpg', 3),
(DEFAULT, 'Charity club',
'it is a community of students who are ready to selflessly help those in need. The key mission of the Charity club is the formation of a space of charity and care at Astana IT University, involvement in the implementation of good deeds, fostering the habit of helping. The main emphasis in the work is made on the creation of comprehensive programs with orphanages, nursing homes and large charitable events.',
'https://astanait.edu.kz/wp-content/uploads/2020/04/charity-club.jpg', 4),
(DEFAULT, 'AITU JOKERS',
'This is an extra-curricular project of humorous content, the main goal of which is the development of creative, creative thinking of students and the organization of their productive leisure. This club creates humor in all its possible directions - KVN, stand-up, songs, performances, clips, skits. AITU JOKERS is a place where they help students find themselves: test themselves in all kinds of creative and organizational roles and find what is most close to them. We joke a lot, which means we comprehend reality.',
'https://astanait.edu.kz/wp-content/uploads/2020/04/jokers-club.jpg', 5);

INSERT INTO events(event_id, event_title, event_description, event_img_url, club_id) VALUES
(DEFAULT, 'Emin in Nur-Sultan', 'EMIN launches new solo tour. The track list of the program will include the last solo songs presented by the musician in 2017, as well as compositions from the new duet album "Forgive me, my love": the legendary song of Vladimir Kuzmin "Siberian Frosts" and the title and most emotional song of the new disc. The audience will hear well-known Russian and English songs: Still, “I live the best”, “Wake up next to you”, of course, Boomerang, Good Love, Amor and many others. The artist will definitely prepare a few more surprises for the audience of each city.', 'https://ticketon.kz/files/media/emin-v-almaty-2021.jpg', 1),
(DEFAULT, '«Gambit Esports» — победители 8-го сезона CS GO!', 'Команда «Gambit Esports» встретилась с «Virtus.pro» в гранд-финале восьмого сезона CS GO и одержала победу со счетом 2:1. (13:16 на Vertigo, 16:14 на Dust II и 16:11 на Mirage).', 'https://sun9-10.userapi.com/H7uPuU_yFkTXF3Rx8--zOUDjltYOlKVP5NyJ-w/TbRTScL0Pyk.jpg', 2),
(DEFAULT, 'Premiere of the ballet "Triumph" at Astana Ballet', 'The Astana Ballet Theater presents an evening of classical ballet art. Art, in which dance vividly reflects thought in motion, when the artists'' plasticity, their perfected poses become spiritualized, when on stage ballerinas and dancers, thanks to their virtuoso mastery of technique, express all the spirituality inherent in music by composers.', 'https://ticketon.kz/files/images/4254365546756786.jpg', 3),
(DEFAULT, 'Children are not toys, they cannot be abandoned ": How the Mentors project helps children in orphanages', 'According to statistics, almost 5,000 orphans left without the care of their relatives live in Kazakhstani orphanages. 80% of them are so-called social orphans - children whose parents refused to take care of them or lost their parental rights. And the older the child, the less chances he has of finding a new family. Fortunately, it is possible to help children in orphanages thanks to the "Mentors" project. Its members are engaged in the socialization of their wards and prepare them for an independent life after entering the "real" world.', 'https://backend.dara.kz/storage/images/1603185830IMG_2151.jpg', 4),
(DEFAULT, 'Fight the Champions at Alaman Gamer', 'Alaman Gamer is the rarest opportunity to play your favorite game with the top PRO teams of the CIS - Konina Power, Na''Vi, 1218, KDV Esports. We have great news for all PUBG Mobile players and fans! A new Gamer event kicks off as part of the regular Alaman tournaments. Registration will open on October 23 at 17:00 and will be available for 1 hour! The first 12 teams (+ 6 reserve teams) that have successfully registered participate in the tournament. The prize fund is 1,000,000 tenge! 1st place - 500,000 2nd place - 250,000 3rd place - 150,000 4th place - 100,000 And of course, we have prepared cool prizes for our audience from Kazakhtelecom JSC with their revolutionary ULTRA service package!', 'https://images.pinger.kz/fit?file=%2Fstorage%2Ffiles%2Fe2bf6aa0ce808324e8c3945632202636.jpeg&width=920&height=520&type=auto', 5);

INSERT INTO news(news_id, news_title, news_description, news_img_url) VALUES
(DEFAULT, 'Agreement between KU Leuven, Belgium and Astana IT University', 'The Department of International Cooperation is pleased to announce the conclusion of an agreement between KU Leuven, Belgium and Astana IT University on the passage of a scientific internship for the teaching staff of our university on the basis of KU Leuven University in the next 5 years under the Bolashak program.', 'https://astanait.edu.kz/wp-content/uploads/2020/11/image.jpeg'),
(DEFAULT, 'Round table on the topic: "The trinity of languages in the formation of the new essence of the nation"', 'On November 4, 2020, teachers of the program of general education disciplines of Astana IT University (teachers Kamieva G.K., Orazgalieva L.M.) and 2nd year students in order to explain the Message of the President of the Republic of Kazakhstan Kassym-Zhomart Tokayev to the people of Kazakhstan dated 01.09. new conditions: time for action ”, a round table was held on the Tims platform in an online format on the topic:“ The trinity of languages in the formation of the new essence of a nation ”. The purpose of the round table: Orienting towards achieving the goals set by the President, one of the ways to improve the quality of the nation is to widely promote the importance of trilingualism.', 'https://astanait.edu.kz/wp-content/uploads/2020/10/Frame-26.png'),
(DEFAULT, 'Academic mobility in Schmalkalden University', 'Dear Students, The Department of International Cooperation is delighted to announce an open call for applications to nominate 2nd year students from ICT and ITM programs to Academic mobility program with Schmalkalden University of Applied Science, Germany.', 'https://astanait.edu.kz/wp-content/uploads/2020/10/%D0%91%D0%B5%D0%B7-%D0%BD%D0%B0%D0%B7%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F.png'),
(DEFAULT, 'PMI Conference in Astana IT University', 'The teaching staff of the "Business and Management" program took part in the online conference "Project Management in Uncertainty" organized by the Project Management Institute (PMI) Kazakhstan Chapter, which took place on October 9-10, 2020. Practical project managers and certified experts in the field of development of project management in Kazakhstan and abroad. On Friday, October 23, the President of the PMI Kazakhstan Chapter Yulia Zhevno paid a visit and an agreement was reached on an internship for AITU students at the PMI office.', 'https://astanait.edu.kz/wp-content/uploads/2020/10/photo5238030978084090072-1-900x500.jpg'),
(DEFAULT, 'Signing of a Memorandum of Cooperation between the National Olympic Committee of the Republic of Kazakhstan, National Esports Student Association and Qazaq Cybersport Federation for the support and development of student e-sports in the Republic of Kazakhstan', 'General Secretary of the Public Association "National Olympic Committee of the Republic of Kazakhstan" AA Kryukov, President of the ALE "National Association for Student Cybersport" Nurpeisov AE and Vice-President of the RPO "Qazaq Cybersport Federation" Bogatyrev E.A. signed a Memorandum of Cooperation in the field of student eSports in the Republic of Kazakhstan.', 'https://astanait.edu.kz/wp-content/uploads/2020/10/Instagram-Post-216.png');