package com.amary.app.data.jetmovietvcat.utils;

import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.MovieResponse;
import com.amary.app.data.jetmovietvcat.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieEntity> generateDummyMovies(){
        ArrayList<MovieEntity> entities = new ArrayList<>();

        entities.add(new MovieEntity("m01",
                "A Star Is Born",
                "October 3, 2018",
                "7.5",
                "https://image.tmdb.org/t/p/w342/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "https://image.tmdb.org/t/p/w342/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg",
                "Seasoned musician Jackson Maine discovers - and falls in love with - struggling artist Ally. She has just about given up on her dream to make it big as a singer - until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons"));
        entities.add(new MovieEntity("m02",
                "Alita: Battle Angel",
                "January 31, 2019",
                "6.8",
                "https://image.tmdb.org/t/p/w342/hLuWJCEdI4bKxhugxnuGKyWwI7I.jpg",
                "https://image.tmdb.org/t/p/w342/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."));
        entities.add(new MovieEntity("m03",
                "Aquaman",
                "December 7, 2018",
                "6.8",
                "https://image.tmdb.org/t/p/w342/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "https://image.tmdb.org/t/p/w342/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."));
        entities.add(new MovieEntity("m04",
                "Bohemian Rhapsody",
                "October 24, 2018",
                "8.1",
                "https://image.tmdb.org/t/p/w342/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "https://image.tmdb.org/t/p/w342/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."));
        entities.add(new MovieEntity("m05",
                "Cold Pursuit",
                "February 7, 2019",
                "5.4",
                "https://image.tmdb.org/t/p/w342/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "https://image.tmdb.org/t/p/w342/1OjgfTVfXushKmdcQ2Xxn9RbNte.jpg",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."));
        entities.add(new MovieEntity("m06",
                "Creed II",
                "November 21, 2018",
                "6.7",
                "https://image.tmdb.org/t/p/w342/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "https://image.tmdb.org/t/p/w342/hZqx2JcZVjHSY2lMEMDC0XlObiw.jpg",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."));
        entities.add(new MovieEntity("m07",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "November 14, 2018",
                "6.9",
                "https://image.tmdb.org/t/p/w342/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "https://image.tmdb.org/t/p/w342/qrtRKRzoNkf5vemO9tJ2Y4DrHxQ.jpg",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world."));
        entities.add(new MovieEntity("m08",
                "Glass",
                "January 16, 2019",
                "6.5",
                "https://image.tmdb.org/t/p/w342/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "https://image.tmdb.org/t/p/w342/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."));
        entities.add(new MovieEntity("m09",
                "How to Train Your Dragon: The Hidden World",
                "January 3, 2019",
                "7.6",
                "https://image.tmdb.org/t/p/w342/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "https://image.tmdb.org/t/p/w342/nkWMDZgiBcvcWyAtmJrgY0oYZvR.jpg",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."));
        entities.add(new MovieEntity("m10",
                "Avengers: Infinity War",
                "April 25, 2018",
                "8.3",
                "https://image.tmdb.org/t/p/w342/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "https://image.tmdb.org/t/p/w342/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));

        return entities;
    }

    public static ArrayList<TvShowEntity> generateDummyTvShows(){
        ArrayList<TvShowEntity> entities = new ArrayList<>();
        entities.add(new TvShowEntity("t01",
                "Arrow",
                "October 10, 2012",
                "5.8",
                "https://image.tmdb.org/t/p/w342/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "https://image.tmdb.org/t/p/w342/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        entities.add(new TvShowEntity("t02",
                "Doom Patrol",
                "February 15, 2019",
                "6.2",
                "https://image.tmdb.org/t/p/w342/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                "https://image.tmdb.org/t/p/w342/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find."));
        entities.add(new TvShowEntity("t03",
                "Dragon Ball",
                "February 26, 1986",
                "7.1",
                "https://image.tmdb.org/t/p/w342/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                "https://image.tmdb.org/t/p/w342/iflq7ZJfso6WC7gk9l1tD3unWK.jpg",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure."));
        entities.add(new TvShowEntity("t04",
                "Fairy Tail",
                "October 12, 2009",
                "6.4",
                "https://image.tmdb.org/t/p/w342/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
                "https://image.tmdb.org/t/p/w342/m2lugAG39sO0yCcuxEAu4fY5u1o.jpg",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail."));
        entities.add(new TvShowEntity("t05",
                "Hanna",
                "April 7, 2011",
                "6.6",
                "https://image.tmdb.org/t/p/w342/2Jr4Rl4Hjiahgh09bjeH8tFhgKp.jpg",
                "https://image.tmdb.org/t/p/w342/1jcwDtYfcjR5QdbY6iUxYBpXn8I.jpg",
                "A 16-year-old girl raised by her father to be the perfect assassin is dispatched on a mission across Europe. Tracked by a ruthless operatives, she faces startling revelations about her existence and questions about her humanity."));
        entities.add(new TvShowEntity("t06",
                "Family Guy",
                "January 31, 1999",
                "6.5",
                "https://image.tmdb.org/t/p/w342/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "https://image.tmdb.org/t/p/w342/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."));
        entities.add(new TvShowEntity("t07",
                "The Flash",
                "October 7, 2014",
                "6.7",
                "https://image.tmdb.org/t/p/w342/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                "https://image.tmdb.org/t/p/w342/lhBBQ5SL956mYp4oyv3b5yHMc4o.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        entities.add(new TvShowEntity("t08",
                "Game of Thrones",
                "April 17, 2011",
                "8.1",
                "https://image.tmdb.org/t/p/w342/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "https://image.tmdb.org/t/p/w342/qsD5OHqW7DSnaQ2afwz8Ptht1Xb.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."));
        entities.add(new TvShowEntity("t09",
                "Gotham",
                "September 22, 2014",
                "6.8",
                "https://image.tmdb.org/t/p/w342/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "https://image.tmdb.org/t/p/w342/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"));
        entities.add(new TvShowEntity("t10",
                "Grey's Anatomy",
                "March 27, 2005",
                "6.3",
                "https://image.tmdb.org/t/p/w342/eqgIOObafPJitt8JNh1LuO2fvqu.jpg",
                "https://image.tmdb.org/t/p/w342/y6JABtgWMVYPx84Rvy7tROU5aNH.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."));

        return entities;
    }

    public static ArrayList<MovieResponse> generateRemoteDummyMovies(){
        ArrayList<MovieResponse> responses = new ArrayList<>();

        responses.add(new MovieResponse("m01",
                "A Star Is Born",
                "October 3, 2018",
                "7.5",
                "https://image.tmdb.org/t/p/w342/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "https://image.tmdb.org/t/p/w342/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg",
                "Seasoned musician Jackson Maine discovers - and falls in love with - struggling artist Ally. She has just about given up on her dream to make it big as a singer - until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons"));
        responses.add(new MovieResponse("m02",
                "Alita: Battle Angel",
                "January 31, 2019",
                "6.8",
                "https://image.tmdb.org/t/p/w342/hLuWJCEdI4bKxhugxnuGKyWwI7I.jpg",
                "https://image.tmdb.org/t/p/w342/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."));
        responses.add(new MovieResponse("m03",
                "Aquaman",
                "December 7, 2018",
                "6.8",
                "https://image.tmdb.org/t/p/w342/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "https://image.tmdb.org/t/p/w342/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."));
        responses.add(new MovieResponse("m04",
                "Bohemian Rhapsody",
                "October 24, 2018",
                "8.1",
                "https://image.tmdb.org/t/p/w342/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "https://image.tmdb.org/t/p/w342/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."));
        responses.add(new MovieResponse("m05",
                "Cold Pursuit",
                "February 7, 2019",
                "5.4",
                "https://image.tmdb.org/t/p/w342/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "https://image.tmdb.org/t/p/w342/1OjgfTVfXushKmdcQ2Xxn9RbNte.jpg",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."));
        responses.add(new MovieResponse("m06",
                "Creed II",
                "November 21, 2018",
                "6.7",
                "https://image.tmdb.org/t/p/w342/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "https://image.tmdb.org/t/p/w342/hZqx2JcZVjHSY2lMEMDC0XlObiw.jpg",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."));
        responses.add(new MovieResponse("m07",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "November 14, 2018",
                "6.9",
                "https://image.tmdb.org/t/p/w342/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "https://image.tmdb.org/t/p/w342/qrtRKRzoNkf5vemO9tJ2Y4DrHxQ.jpg",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world."));
        responses.add(new MovieResponse("m08",
                "Glass",
                "January 16, 2019",
                "6.5",
                "https://image.tmdb.org/t/p/w342/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "https://image.tmdb.org/t/p/w342/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."));
        responses.add(new MovieResponse("m09",
                "How to Train Your Dragon: The Hidden World",
                "January 3, 2019",
                "7.6",
                "https://image.tmdb.org/t/p/w342/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "https://image.tmdb.org/t/p/w342/nkWMDZgiBcvcWyAtmJrgY0oYZvR.jpg",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."));
        responses.add(new MovieResponse("m10",
                "Avengers: Infinity War",
                "April 25, 2018",
                "8.3",
                "https://image.tmdb.org/t/p/w342/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "https://image.tmdb.org/t/p/w342/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));

        return responses;
    }

    public static ArrayList<TvShowResponse> generateRemoteDummyTvShows(){
        ArrayList<TvShowResponse> responses = new ArrayList<>();
        responses.add(new TvShowResponse("t01",
                "Arrow",
                "October 10, 2012",
                "5.8",
                "https://image.tmdb.org/t/p/w342/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "https://image.tmdb.org/t/p/w342/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        responses.add(new TvShowResponse("t02",
                "Doom Patrol",
                "February 15, 2019",
                "6.2",
                "https://image.tmdb.org/t/p/w342/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                "https://image.tmdb.org/t/p/w342/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find."));
        responses.add(new TvShowResponse("t03",
                "Dragon Ball",
                "February 26, 1986",
                "7.1",
                "https://image.tmdb.org/t/p/w342/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                "https://image.tmdb.org/t/p/w342/iflq7ZJfso6WC7gk9l1tD3unWK.jpg",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure."));
        responses.add(new TvShowResponse("t04",
                "Fairy Tail",
                "October 12, 2009",
                "6.4",
                "https://image.tmdb.org/t/p/w342/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
                "https://image.tmdb.org/t/p/w342/m2lugAG39sO0yCcuxEAu4fY5u1o.jpg",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail."));
        responses.add(new TvShowResponse("t05",
                "Hanna",
                "April 7, 2011",
                "6.6",
                "https://image.tmdb.org/t/p/w342/2Jr4Rl4Hjiahgh09bjeH8tFhgKp.jpg",
                "https://image.tmdb.org/t/p/w342/1jcwDtYfcjR5QdbY6iUxYBpXn8I.jpg",
                "A 16-year-old girl raised by her father to be the perfect assassin is dispatched on a mission across Europe. Tracked by a ruthless operatives, she faces startling revelations about her existence and questions about her humanity."));
        responses.add(new TvShowResponse("t06",
                "Family Guy",
                "January 31, 1999",
                "6.5",
                "https://image.tmdb.org/t/p/w342/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "https://image.tmdb.org/t/p/w342/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."));
        responses.add(new TvShowResponse("t07",
                "The Flash",
                "October 7, 2014",
                "6.7",
                "https://image.tmdb.org/t/p/w342/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                "https://image.tmdb.org/t/p/w342/lhBBQ5SL956mYp4oyv3b5yHMc4o.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        responses.add(new TvShowResponse("t08",
                "Game of Thrones",
                "April 17, 2011",
                "8.1",
                "https://image.tmdb.org/t/p/w342/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "https://image.tmdb.org/t/p/w342/qsD5OHqW7DSnaQ2afwz8Ptht1Xb.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."));
        responses.add(new TvShowResponse("t09",
                "Gotham",
                "September 22, 2014",
                "6.8",
                "https://image.tmdb.org/t/p/w342/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "https://image.tmdb.org/t/p/w342/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"));
        responses.add(new TvShowResponse("t10",
                "Grey's Anatomy",
                "March 27, 2005",
                "6.3",
                "https://image.tmdb.org/t/p/w342/eqgIOObafPJitt8JNh1LuO2fvqu.jpg",
                "https://image.tmdb.org/t/p/w342/y6JABtgWMVYPx84Rvy7tROU5aNH.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."));

        return responses;
    }
}
