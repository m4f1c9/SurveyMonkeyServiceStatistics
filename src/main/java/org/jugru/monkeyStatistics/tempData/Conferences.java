package org.jugru.monkeyStatistics.tempData;

import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.view.ConferenceQuestionPair;
import org.jugru.monkeyService.model.view.ConferenceGroup;
import org.jugru.monkeyService.model.view.ChoiceGroup;
import org.jugru.monkeyService.model.view.Keynote;
import org.jugru.monkeyService.model.view.QuestionGroup;
import org.jugru.monkeyService.model.view.SingleConferenceStat;
import org.jugru.monkeyService.model.view.SpeakersRatingPair;

public class Conferences {

    public static ConferenceGroup holyJS() {
        ConferenceGroup HolyJS = new ConferenceGroup();
        HolyJS.setName("HolyJS");

        {
            QuestionGroup position = new QuestionGroup();
            position.setName("Ваша позиция в компании?");

            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Piter", 80191211, 966831639L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Moscow", 87269535, 1045020001L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678197L));

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(false);

            ChoiceGroup answer1 = new ChoiceGroup();
            answer1.setText("Junior Developer");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887091L);
                    add(10789207613L);
                    add(874803001L);
                }
            });

            ChoiceGroup answer2 = new ChoiceGroup();
            answer2.setText("Middle Developer");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887092L);
                    add(10789207614L);
                    add(874803002L);
                }
            });

            ChoiceGroup answer3 = new ChoiceGroup();
            answer3.setText("Senior Developer");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887093L);
                    add(10789207615L);
                    add(874803003L);
                }
            });

            ChoiceGroup answer4 = new ChoiceGroup();
            answer4.setText("Team Lead");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887094L);
                    add(10789207616L);
                    add(874803004L);
                }
            });

            ChoiceGroup answer5 = new ChoiceGroup();
            answer5.setText("Технический директор");
            answer5.setID(new LinkedList<Long>() {
                {
                    add(10239887100L);
                    add(10789207622L);
                    add(874803006L);
                }
            });

            ChoiceGroup answer6 = new ChoiceGroup();
            answer6.setText("Менеджер");
            answer6.setID(new LinkedList<Long>() {
                {
                    add(10239887101L);
                    add(10789207623L);
                    add(null);
                }
            });

            ChoiceGroup answer7 = new ChoiceGroup();
            answer7.setText("Директор");
            answer7.setID(new LinkedList<Long>() {
                {
                    add(10239887102L);
                    add(10789207624L);
                    add(874803007L);
                }
            });

            ChoiceGroup answer8 = new ChoiceGroup();
            answer8.setText("Architect");
            answer8.setID(new LinkedList<Long>() {
                {
                    add(10239887103L);
                    add(10789207625L);
                    add(874803005L);
                }
            });

            position.AddChoiceGroup(answer1);
            position.AddChoiceGroup(answer2);
            position.AddChoiceGroup(answer3);
            position.AddChoiceGroup(answer4);
            position.AddChoiceGroup(answer5);
            position.AddChoiceGroup(answer6);
            position.AddChoiceGroup(answer7);
            position.AddChoiceGroup(answer8);

            HolyJS.addQuestionGroup(position);

        }

        {
            QuestionGroup position = new QuestionGroup();
            position.setName("Cтатус на конференции?");

            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Piter", 80191211, 966831645L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Moscow", 87269535, 1045020006L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678199L));

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(false);

            ChoiceGroup answer1 = new ChoiceGroup();
            answer1.setText("Участник");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887124L);
                    add(10789207648L);
                    add(874803022L);
                }
            });

            ChoiceGroup answer2 = new ChoiceGroup();
            answer2.setText("Спикер");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887125L);
                    add(10789207649L);
                    add(874803023L);
                }
            });

            ChoiceGroup answer3 = new ChoiceGroup();
            answer3.setText("Спонсор");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887126L);
                    add(10789207650L);
                    add(874803024L);
                }
            });

            ChoiceGroup answer4 = new ChoiceGroup();
            answer4.setText("Организатор / Волонтер");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887132L);
                    add(10789207656L);
                    add(874803025L);
                }
            });

            position.AddChoiceGroup(answer1);
            position.AddChoiceGroup(answer2);
            position.AddChoiceGroup(answer3);
            position.AddChoiceGroup(answer4);

            HolyJS.addQuestionGroup(position);
        }

        {
            QuestionGroup position = new QuestionGroup();
            position.setName("Конференции на какие другие темы вы посетили бы?");

            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Piter", 80191211, 966831648L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Moscow", 87269535, 1045020011L));
            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678250L));

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(true);

            ChoiceGroup answer1 = new ChoiceGroup();
            answer1.setText("Web-разработка");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887134L);
                    add(10789207662L);
                    add(874803266L);
                }
            });

            ChoiceGroup answer2 = new ChoiceGroup();
            answer2.setText("С++");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887135L);
                    add(10789207663L);
                    add(874803267L);
                }
            });

            ChoiceGroup answer3 = new ChoiceGroup();
            answer3.setText("GNU/Linux");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887136L);
                    add(10789207664L);
                    add(874803268L);
                }
            });

            ChoiceGroup answer4 = new ChoiceGroup();
            answer4.setText("Методологии разработки");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887147L);
                    add(10789207675L);
                    add(874803269L);
                }
            });

            ChoiceGroup answer5 = new ChoiceGroup();
            answer5.setText("OpenSource");
            answer5.setID(new LinkedList<Long>() {
                {
                    add(10239887137L);
                    add(10789207665L);
                    add(874803270L);
                }
            });

            position.AddChoiceGroup(answer1);
            position.AddChoiceGroup(answer2);
            position.AddChoiceGroup(answer3);
            position.AddChoiceGroup(answer4);
            position.AddChoiceGroup(answer5);

            HolyJS.addQuestionGroup(position);
        }

        {
            QuestionGroup position = new QuestionGroup();
            position.setName("Вы смотрели интервью со спикерами в перерывах между трансляциями докладов?");

            position.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678212L));

            position.setWithCustomAnswer(false);
            position.setWithNoAnswer(true);

            ChoiceGroup answer1 = new ChoiceGroup();
            answer1.setText("Смотрел полностью");
            answer1.setID(new LinkedList<Long>() {
                {

                    add(874803096L);
                }
            });

            ChoiceGroup answer2 = new ChoiceGroup();
            answer2.setText("Смотрел несколько частей");
            answer2.setID(new LinkedList<Long>() {
                {

                    add(874803097L);
                }
            });

            ChoiceGroup answer3 = new ChoiceGroup();
            answer3.setText("Не смотрел");
            answer3.setID(new LinkedList<Long>() {
                {

                    add(874803098L);
                }
            });

            position.AddChoiceGroup(answer1);
            position.AddChoiceGroup(answer2);
            position.AddChoiceGroup(answer3);

            HolyJS.addQuestionGroup(position);
        }

        return HolyJS;
    }

    public static SingleConferenceStat mobius() {
        SingleConferenceStat mobius = new SingleConferenceStat();
        List<SpeakersRatingPair> pairs = new LinkedList<>();
        pairs.add(new SpeakersRatingPair(203789246L, 203789403L, "Слот 10:30 – 11:20."));
        pairs.add(new SpeakersRatingPair(203746738L, 203746745L, "Слот 11:40 – 12:30"));
        pairs.add(new SpeakersRatingPair(203746739L, 203746748L, "Слот 12:50 – 13:40"));
        pairs.add(new SpeakersRatingPair(203746741L, 203746751L, "Слот 14:25 – 15:15"));
        pairs.add(new SpeakersRatingPair(203746740L, 203746754L, "Слот 15:35 – 16:25"));
        pairs.add(new SpeakersRatingPair(203746761L, 203746762L, "Слот 16:45 – 17:35"));
        mobius.setPairs(pairs);
        
        
        
        
        List<Keynote> keynotes = new LinkedList<>();
        keynotes.add(new Keynote(203803150L, "Кейноут 17:50 – 18:40. Йонатан Левин — Как самому запилить новую фичу и при этом не быть убитым своим менеджером"));
        mobius.setKeynotes(keynotes);

        
        return mobius;
    }

}
