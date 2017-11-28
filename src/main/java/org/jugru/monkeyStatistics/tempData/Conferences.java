package org.jugru.monkeyStatistics.tempData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.chart.Chart;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
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

            position.addChoiceGroup(answer1);
            position.addChoiceGroup(answer2);
            position.addChoiceGroup(answer3);
            position.addChoiceGroup(answer4);
            position.addChoiceGroup(answer5);
            position.addChoiceGroup(answer6);
            position.addChoiceGroup(answer7);
            position.addChoiceGroup(answer8);

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

            position.addChoiceGroup(answer1);
            position.addChoiceGroup(answer2);
            position.addChoiceGroup(answer3);
            position.addChoiceGroup(answer4);

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

            position.addChoiceGroup(answer1);
            position.addChoiceGroup(answer2);
            position.addChoiceGroup(answer3);
            position.addChoiceGroup(answer4);
            position.addChoiceGroup(answer5);

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

            position.addChoiceGroup(answer1);
            position.addChoiceGroup(answer2);
            position.addChoiceGroup(answer3);

            HolyJS.addQuestionGroup(position);
        }

        return HolyJS;
    }

    public static SingleConferenceStat mobius() {
        SingleConferenceStat mobius = new SingleConferenceStat();
        List<SpeakersRatingPair> pairs = new LinkedList<>();
        pairs.add(new SpeakersRatingPair(203789246L, 203789403L, "Слот 10:30 – 11:20.", 125742994L));
        pairs.add(new SpeakersRatingPair(203746738L, 203746745L, "Слот 11:40 – 12:30", 125742994L));
        pairs.add(new SpeakersRatingPair(203746739L, 203746748L, "Слот 12:50 – 13:40", 125742994L));
        pairs.add(new SpeakersRatingPair(203746741L, 203746751L, "Слот 14:25 – 15:15", 125742994L));
        pairs.add(new SpeakersRatingPair(203746740L, 203746754L, "Слот 15:35 – 16:25", 125742994L));
        pairs.add(new SpeakersRatingPair(203746761L, 203746762L, "Слот 16:45 – 17:35", 125742994L));
        mobius.setPairs(pairs);

        List<Keynote> keynotes = new LinkedList<>();
        keynotes.add(new Keynote(203803150L, "Кейноут 17:50 – 18:40. Йонатан Левин — Как самому запилить новую фичу и при этом не быть убитым своим менеджером", 125742994L));

        mobius.setKeynotes(keynotes);

        return mobius;
    }

    public static ConferenceGroup JPoint() {
        ConferenceGroup JPoint = new ConferenceGroup();
        JPoint.setName("JPoint");

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Ваша позиция в компании?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394060L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183341L));

            questionGroup.setWithCustomAnswer(true);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Junior Developer / Младший разработчик / Младший программист");
            choices.setID(new LinkedList<>(Arrays.asList(10094381381L, 10983520028L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Middle Developer / Developer / Разработчик / Программист");
            choices.setID(new LinkedList<>(Arrays.asList(10094381382L, 10983520029L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Senior Developer / Старший разработчик / Ведущий разработчик / Ведущий программист");
            choices.setID(new LinkedList<>(Arrays.asList(10094381383L, 10983520030L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Team Lead");
            choices.setID(new LinkedList<>(Arrays.asList(10094381384L, 10983520031L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CTO / CIO / Технический директор");
            choices.setID(new LinkedList<>(Arrays.asList(10118624776L, 10983520032L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Менеджер");
            choices.setID(new LinkedList<>(Arrays.asList(10118624777L, 10983520033L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Директор / CEO");
            choices.setID(new LinkedList<>(Arrays.asList(10118624778L, 10983520034L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Architect / Senior Architect / Архитектор / Системный архитектор");
            choices.setID(new LinkedList<>(Arrays.asList(10118624779L, 10983520035L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Ваш стаж работы Java-разработчиком");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394063L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183342L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Менее 1 года");
            choices.setID(new LinkedList<>(Arrays.asList(10094381397L, 10983520042L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1-3 года");
            choices.setID(new LinkedList<>(Arrays.asList(10094381398L, 10983520043L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4-6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10094381399L, 10983520044L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Более 6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10094381400L, 10983520045L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я не работаю с Java");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520046L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Укажите ваш статус на конференции:");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 948925836L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183344L));

            questionGroup.setWithCustomAnswer(true);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Участник");
            choices.setID(new LinkedList<>(Arrays.asList(10118393712L, 10983520060L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спикер");
            choices.setID(new LinkedList<>(Arrays.asList(10118393713L, 10983520061L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10118393714L, 10983520062L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Организатор / Волонтер");
            choices.setID(new LinkedList<>(Arrays.asList(10118618908L, 10983520063L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Как вы думаете, по каким причинам некоторые ваши коллеги/друзья не участвуют в JPoint?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394068L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183346L));

            questionGroup.setWithCustomAnswer(true);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Им неинтересно участие в JPoint ");
            choices.setID(new LinkedList<>(Arrays.asList(10094381429L, 10983520064L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Участие в конференциях их вообще не интересует");
            choices.setID(new LinkedList<>(Arrays.asList(10094381423L, 10983520065L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билеты стоят слишком дорого");
            choices.setID(new LinkedList<>(Arrays.asList(10094381424L, 10983520066L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не хотят тратить выходной день на конференцию");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520067L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не могут выделить рабочий день");
            choices.setID(new LinkedList<>(Arrays.asList(null, 11011248742L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Они не знают про JPoint");
            choices.setID(new LinkedList<>(Arrays.asList(10094381431L, 10983520068L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Начальство не дало командировку");
            choices.setID(new LinkedList<>(Arrays.asList(10094381430L, null)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Как вы покупали билет?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394070L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183347L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания не компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(10094381449L, 10983520075L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания компенсирует частично");
            choices.setID(new LinkedList<>(Arrays.asList(10094381450L, 10983520076L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания полностью компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(10094381451L, 10983520077L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билет мне покупала компания");
            choices.setID(new LinkedList<>(Arrays.asList(10094381452L, 10983520078L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал, я организатор / спикер / волонтер / спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10118629525L, 10983520079L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал — организаторы дали проходку");
            choices.setID(new LinkedList<>(Arrays.asList(10118629524L, 10983520080L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Укажите форму участия в конференции");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 790940867L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945410909L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183349L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Присутствовал лично");
            choices.setID(new LinkedList<>(Arrays.asList(8886535089L, 10094494397L, 10983520099L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел трансляцию (один или в составе группы коллег)");
            choices.setID(new LinkedList<>(Arrays.asList(8886535090L, 10094494398L, 10983520100L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смог поучаствовать лично, хочу видео");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10118522037L, 10983520101L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Вы планируете смотреть все видео?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 948952901L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183352L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Да, думаю, что посмотрю 80-100% видеозаписей");
            choices.setID(new LinkedList<>(Arrays.asList(10118538102L, 10983520128L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Посмотрю больше половины");
            choices.setID(new LinkedList<>(Arrays.asList(10118538103L, 10983520129L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нет, посмотрю 5-10 наиболее важных докладов");
            choices.setID(new LinkedList<>(Arrays.asList(10118538104L, 10983520130L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мне интересна пара докладов, не более");
            choices.setID(new LinkedList<>(Arrays.asList(10118538105L, 10983520131L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените организацию онлайн-трансляции");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 790944403L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945412851L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183354L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520135L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(8886559329L, 10094507046L, 10983520136L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520137L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально");
            choices.setID(new LinkedList<>(Arrays.asList(8886559330L, 10094507047L, null)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520138L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(8886559331L, 10094507048L, 10983520139L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(8886559332L, 10094507049L, 10983520140L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520141L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Насколько быстро решались технические проблемы");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 948953646L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183355L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Очень медленно");
            choices.setID(new LinkedList<>(Arrays.asList(10118541188L, 10983520144L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально, но кое-что я упустил");
            choices.setID(new LinkedList<>(Arrays.asList(10118541187L, 10983520145L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Очень быстро");
            choices.setID(new LinkedList<>(Arrays.asList(10118541186L, 10983520146L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не заметил технических проблем");
            choices.setID(new LinkedList<>(Arrays.asList(10118541189L, 10983520147L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Вы смотрели интервью со спикерами в перерывах между трансляциями докладов?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183359L));

            questionGroup.setWithCustomAnswer(true);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Смотрел полностью");
            choices.setID(new LinkedList<>(Arrays.asList(10983520157L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел несколько частей");
            choices.setID(new LinkedList<>(Arrays.asList(10983520158L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел");
            choices.setID(new LinkedList<>(Arrays.asList(10983520159L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените онлайн-трансляцию интервью со спикерами");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183358L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(10983520149L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520150L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520151L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520152L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520153L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520154L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520155L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел трансляцию");
            choices.setID(new LinkedList<>(Arrays.asList(10983520156L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените удобство места проведения? регистрация, залы, температурный режим");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183362L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(10983520174L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520175L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520176L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520177L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520178L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520179L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520180L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените удобство навигации места проведения Указатели, карта, программа, расположение залов, удобно ли добираться.");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183372L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(10983520221L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520222L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520223L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520224L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520225L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520226L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520227L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените техническую организацию конференции качество звука, качество картинки, качество связи, сайты");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 789372999L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394051L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183368L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно/Не понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(789372999L, 10094381358L, 10983520211L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо/Скорее не понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703042L, 10094381359L, 10983520212L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе/Средний уровень");
            choices.setID(new LinkedList<>(Arrays.asList(8872703044L, 10094381360L, 10983520213L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520214L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо/Скорее понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703045L, 10094381361L, 10983520215L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично/Понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703046L, 10094381362L, 10983520216L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520217L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените обеды");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 789372996L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394053L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183360L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Я не обедал на конференции");
            choices.setID(new LinkedList<>(Arrays.asList(8872703056L, 10094381370L, 10983520170L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520163L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(8872703049L, 10094381364L, 10983520164L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520165L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520166L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально");
            choices.setID(new LinkedList<>(Arrays.asList(8872703050L, 10094381365L, null)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(8872703051L, 10094381366L, 10983520167L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(8872703052L, 10094381367L, 10983520168L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520169L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Оцените вечеринку");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183374L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(10983520233L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520234L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520235L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520236L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520237L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520238L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520239L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я пропустил вечеринку");
            choices.setID(new LinkedList<>(Arrays.asList(10983520240L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

//        {
//            QuestionGroup questionGroup = new QuestionGroup();
//            questionGroup.setName("Откуда вы узнали о конференции?");
//
//            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 789373007L));
//            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394075L));
//   
//            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183377L));
//
//            questionGroup.setWithCustomAnswer(true);
//            questionGroup.setWithNoAnswer(true);
//
//            ChoiceGroup choices;
//
//            choices = new ChoiceGroup();
//            choices.setText("На одной из встреч JUG.ru");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520266L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Из почтовой рассылки JUG.ru");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520281L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (группы/посты)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520280L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (реклама)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520267L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (группы/посты/реклама)");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703061L, 10094381487L,  null)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Хабрахабр");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703062L, 10094381488L, 10983520268L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Youtube (какое видео?)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, 10094381495L,  10983520269L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Блоги (чей блог?)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, 10094381496L, 10983520270L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От коллеги (откуда он узнал?)");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703063L, 10094381489L,  10983520271L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От руководителя");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703065L, 10094381490L, 10983520272L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От друзей");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703066L, 10094381491L,  10983520273L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Нашел в поисковой системе");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520275L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Был на прошлых конференциях");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520276L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Звонок от организаторов");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  11011250271L)));
//            questionGroup.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Не помню");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520283L)));
//            questionGroup.addChoiceGroup(choices);
//
//            JPoint.addQuestionGroup(questionGroup);
//
//        }
        {

            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Конференции на какие другие темы вы посетили бы?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394067L));

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183385L));

            questionGroup.setWithCustomAnswer(true);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Web-раработка");
            choices.setID(new LinkedList<>(Arrays.asList(10094381407L, 10983520315L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("С++");
            choices.setID(new LinkedList<>(Arrays.asList(10094381408L, 10983520316L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GNU/Linux");
            choices.setID(new LinkedList<>(Arrays.asList(10094381409L, 10983520318L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Методологии разработки");
            choices.setID(new LinkedList<>(Arrays.asList(10094381421L, 10983520319L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520320L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("OpenSource");
            choices.setID(new LinkedList<>(Arrays.asList(10094381410L, 10983520321L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Высоконагруженные системы / Highload");
            choices.setID(new LinkedList<>(Arrays.asList(10094381411L, 10983520322L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Performance / Производительность");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520331L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Распределенные системы");
            choices.setID(new LinkedList<>(Arrays.asList(10094381412L, 10983520323L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Enterprise-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10094381413L, 10983520324L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText(".NET");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520325L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("QA/тестирование");
            choices.setID(new LinkedList<>(Arrays.asList(10094381415L, 10983520326L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мобильная разработка (iOS / Android)");
            choices.setID(new LinkedList<>(Arrays.asList(10094381406L, 10983520327L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("JavаSсript");
            choices.setID(new LinkedList<>(Arrays.asList(10095630274L, 10983520328L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Больше Java!");
            choices.setID(new LinkedList<>(Arrays.asList(10095629459L, 10983520330L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);
        }

        {

            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Какова вероятность, что Вы порекомендуете JPoint другу или коллеге?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015/1", 63616183, 789373011L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015/2", 63616183, 790942582L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394074L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183376L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("0");
            choices.setID(new LinkedList<>(Arrays.asList(8872703096L, 8886547242L, 10094381474L, 10983520252L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1");
            choices.setID(new LinkedList<>(Arrays.asList(8872703097L, 8886547243L, 10094381475L, 10983520253L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("2");
            choices.setID(new LinkedList<>(Arrays.asList(8872703098L, 8886547244L, 10094381476L, 10983520254L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("3");
            choices.setID(new LinkedList<>(Arrays.asList(8872703099L, 8886547245L, 10094381477L, 10983520255L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4");
            choices.setID(new LinkedList<>(Arrays.asList(8872703100L, 8886547246L, 10094381478L, 10983520256L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("5");
            choices.setID(new LinkedList<>(Arrays.asList(8872703101L, 8886547247L, 10094381479L, 10983520257L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("6");
            choices.setID(new LinkedList<>(Arrays.asList(8872703102L, 8886547248L, 10094381480L, 10983520258L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("7");
            choices.setID(new LinkedList<>(Arrays.asList(8872703103L, 8886547249L, 10094381481L, 10983520259L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("8");
            choices.setID(new LinkedList<>(Arrays.asList(8872703104L, 8886547250L, 10094381482L, 10983520260L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("9");
            choices.setID(new LinkedList<>(Arrays.asList(8872703105L, 8886547251L, 10094381483L, 10983520261L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("10");
            choices.setID(new LinkedList<>(Arrays.asList(8872703106L, 8886547252L, 10094381484L, 10983520262L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);
        }

        {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setName("Насколько вероятно, что вы станете (онлайн или оффлайн) участником следующей конференции JPoint?");

            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2015", 63616183, 789373010L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2016", 78199292, 945394073L));
            questionGroup.AddConferenceQuestionPair(new ConferenceQuestionPair("JPoint 2017", 88971560, 1072183375L));

            questionGroup.setWithCustomAnswer(false);
            questionGroup.setWithNoAnswer(false);

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Точно не приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703088L, 10094381466L, 10983520244L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Скорее всего, не приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703089L, 10094381467L, 10983520245L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не знаю, вряд ли");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520246L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(8872703090L, 10094381468L, 10983520247L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не знаю, возможно");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520248L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Скорее всего приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703091L, 10094381469L, 10983520249L)));
            questionGroup.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Точно приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703092L, 10094381470L, 10983520250L)));
            questionGroup.addChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        return JPoint;
    }

    public static ChartsPreset test() {

        ChartsPreset preset = new ChartsPreset("1111!!!!!");
        //        {
        //            UngroupedCharts ungroupedCharts = new UngroupedCharts();
        //            ungroupedCharts.setChartName("Оцените организацию онлайн-трансляции");
        //            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.FULL, false, false);
        //            chartOptions.setShowTitle(true);
        //            ungroupedCharts.setChartOptions(chartOptions);
        //
        //            List<SingleQuestionChart> charts = new ArrayList<>();
        //            SingleQuestionChart cqc;
        //            cqc = new SingleQuestionChart("JPoint 2015", 63616183L, 790944403L, true);
        //            cqc.setUseRow_idInstedOfChoice_id(false);
        //            charts.add(cqc);
        //            
        //            cqc = new SingleQuestionChart("JPoint 2016", 78199292L, 945412851L, true);
        //            cqc.setUseRow_idInstedOfChoice_id(false);
        //            charts.add(cqc);
        //            
        //            cqc = new SingleQuestionChart("JPoint 2017", 88971560L, 1072183354L, true);
        //            cqc.setUseRow_idInstedOfChoice_id(false);
        //            charts.add(cqc);
        //            
        //            System.out.println(charts);
        //            System.out.println(charts);
        //            System.out.println(charts);
        //
        //            ungroupedCharts.setCharts(charts);
        //            preset.AddChart(ungroupedCharts);
        //
        //        }
        //        {
        //            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
        //            CrossGroupingChart cgc = new CrossGroupingChart("Слот 10:30 – 11:20.", 125742994L, 203789246L, 203789403L, chartOptions);
        //             cgc.setHideLastChoiceInFirst(true);
        //            cgc.setHideLastChoiceInSecond(true);
        //            preset.AddChart(cgc);
        //
        //        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Как вы покупали билет?", 125742994L, 203746709L, 203746713L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько конференция в целом соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746770L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените программу конференции в целом", 125742994L, 203746709L, 203746764L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените техническую глубину программы", 125742994L, 203746709L, 203746765L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько техническая глубина соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746768L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените практическую применимость услышанного вами в докладах", 125742994L, 203746709L, 203746766L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько практическая применимость услышанного вами на конференции соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746769L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Конференции на какие другие темы вы бы посетили ?", 125742994L, 203746709L, 203746759L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

//        {
//
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);
//
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Piter", 80191211, 966831639L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Moscow", 87269535, 1045020001L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678197L));
//
//            ChoiceGroup answer1 = new ChoiceGroup();
//            answer1.setText("Junior Developer");
//            answer1.setID(new LinkedList<Long>() {
//                {
//                    add(10239887091L);
//                    add(10789207613L);
//                    add(874803001L);
//                }
//            });
//
//            ChoiceGroup answer2 = new ChoiceGroup();
//            answer2.setText("Middle Developer");
//            answer2.setID(new LinkedList<Long>() {
//                {
//                    add(10239887092L);
//                    add(10789207614L);
//                    add(874803002L);
//                }
//            });
//
//            ChoiceGroup answer3 = new ChoiceGroup();
//            answer3.setText("Senior Developer");
//            answer3.setID(new LinkedList<Long>() {
//                {
//                    add(10239887093L);
//                    add(10789207615L);
//                    add(874803003L);
//                }
//            });
//
//            chart.addChoiceGroup(answer1);
//            chart.addChoiceGroup(answer2);
//            chart.addChoiceGroup(answer3);
//
//            preset.AddChart(chart);
//        }
        return preset;

    }

    public static ChartsPreset mobius2() {
        ChartsPreset preset = new ChartsPreset("Mobius");

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220518L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553275L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746709L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Junior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(10235807486L, 11013988130L, 1436523628L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Middle Developer");
            choices.setID(new LinkedList<>(Arrays.asList(10235807487L, 11013988131L, 1436523629L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Senior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(10235807488L, 11013988132L, 1436523630L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Team Lead");
            choices.setID(new LinkedList<>(Arrays.asList(10235807489L, 11013988133L, 1436523631L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("QA");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523669L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Architect");
            choices.setID(new LinkedList<>(Arrays.asList(10235807498L, 11013988137L, 1436523632L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523670L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CTO / CIO");
            choices.setID(new LinkedList<>(Arrays.asList(10235807495L, 11013988134L, 1436523633L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CEO");
            choices.setID(new LinkedList<>(Arrays.asList(10235807497L, 11013988136L, 1436523634L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Менеджер");
            choices.setID(new LinkedList<>(Arrays.asList(10235807496L, 11013988135L, null)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваш стаж работы мобильным разработчиком ", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220521L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553276L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746710L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Менее 1 года");
            choices.setID(new LinkedList<>(Arrays.asList(10235807506L, 11013988144L, 1436523338L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1-3 года");
            choices.setID(new LinkedList<>(Arrays.asList(10235807507L, 11013988145L, 1436523339L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4-6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10235807508L, 11013988146L, 1436523340L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Более 6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10235807509L, 11013988147L, 1436523341L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я не занимаюсь мобильной разработкой");
            choices.setID(new LinkedList<>(Arrays.asList(10244813488L, 11013988148L, 1436523342L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Укажите ваш статус на конференции:", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220524L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553277L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746711L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Участник");
            choices.setID(new LinkedList<>(Arrays.asList(10235807517L, 11013988151L, 1436523345L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спикер");
            choices.setID(new LinkedList<>(Arrays.asList(10235807518L, 11013988152L, 1436523346L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10235807519L, 11013988153L, 1436523347L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Организатор / Волонтер");
            choices.setID(new LinkedList<>(Arrays.asList(10235807525L, 11013988154L, 1436523348L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Как вы покупали билет?", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220529L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553280L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746713L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания не компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(10235807556L, 11013988167L, 1436523351L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания компенсирует частично");
            choices.setID(new LinkedList<>(Arrays.asList(10235807557L, 11013988168L, 1436523352L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания полностью компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(10235807558L, 11013988169L, 1436523353L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билет мне покупала компания");
            choices.setID(new LinkedList<>(Arrays.asList(10235807559L, 11013988170L, 1436523354L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал, я организатор / спикер / волонтер / спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10235807565L, 11013988171L, 1436523355L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал — организаторы дали проходку");
            choices.setID(new LinkedList<>(Arrays.asList(10235807564L, 11013988172L, 1436523356L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких конференциях JUG.ru Group вы участвовали ранее? (или смотрели онлайн)");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553281L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746714L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких других конференциях вы участвовали за прошедший год? (или смотрели онлайн)");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220531L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553283L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746778L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Укажите форму участия в конференции", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220530L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553282L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746715L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Присутствовал лично");
            choices.setID(new LinkedList<>(Arrays.asList(10235807568L, 11013988193L, 1436523364L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел трансляцию (один или в составе группы коллег)");
            choices.setID(new LinkedList<>(Arrays.asList(10235807569L, 11013988194L, 1436523365L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смог поучаствовать лично, хочу видео");
            choices.setID(new LinkedList<>(Arrays.asList(10235807571L, 11013988195L, 1436523366L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените организацию онлайн-трансляции");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220540L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553287L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746718L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько быстро решались технические проблемы?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220543L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553288L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746719L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Вы смотрели интервью со спикерами в перерывах между трансляциями докладов?", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553292L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746723L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Смотрел полностью");
            choices.setID(new LinkedList<>(Arrays.asList(11013988251L, 1436523408L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел несколько частей");
            choices.setID(new LinkedList<>(Arrays.asList(11013988252L, 1436523409L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел");
            choices.setID(new LinkedList<>(Arrays.asList(11013988253L, 1436523410L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените онлайн-трансляцию интервью со спикерами в перерывах между докладами");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553291L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746722L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство места проведения");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784474294L, true));
            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220507L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553296L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746727L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство навигации в месте проведения");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553305L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746732L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените техническую организацию конференции");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784474922L, true));
            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220509L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553301L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746773L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }
        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените сайт конференции");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746730L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените обед");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784864552L, true));
            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220511L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553294L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746725L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените вечеринку для участников конференции");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553307L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746776L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько в целом понравилась конференция?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1077511279L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746767L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько конференция в целом соответствовала вашим ожиданиям?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1077517932L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746770L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько вероятно, что вы станете (онлайн или оффлайн) участником следующей конференции Mobius?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784845315L, true));
            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220532L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553308L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746734L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Какова вероятность, что Вы порекомендуете Mobius другу или коллеге?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784845360L, true));
            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, 966220533L, true));
            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076553309L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746735L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Откуда вы узнали о конференции?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, 784457778L, true));

            SingleQuestionChart sqc;
            sqc = new SingleQuestionChart("Mobius 2016", 80136513L, 966220535L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);

            sqc = new SingleQuestionChart("Mobius 2017", 89235000L, 1076553310L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);

            sqc = new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746736L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените программу конференции в целом");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076587665L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746764L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените техническую глубину программы");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076587682L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746765L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько техническая глубина соответствовала вашим ожиданиям?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1077515714L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746768L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }
        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените практическую применимость услышанного вами в докладах");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1076587999L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746766L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько практическая применимость услышанного вами на конференции соответствовала вашим ожиданиям?");
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, 1077515926L, true));
            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, 203746769L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Конференции на какие другие темы вы бы посетили ?", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, 966220527L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, 1076553335L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, 203746759L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Web-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10235807528L, 11013988473L, 1436523552L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText(".NET");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523649L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Тестирование");
            choices.setID(new LinkedList<>(Arrays.asList(10235807536L, 11013988483L, 1436523650L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523651L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("С++");
            choices.setID(new LinkedList<>(Arrays.asList(10235807529L, 11013988474L, 1436523553L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GNU/Linux");
            choices.setID(new LinkedList<>(Arrays.asList(10235807530L, 11013988475L, 1436523554L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Методологии разработки");
            choices.setID(new LinkedList<>(Arrays.asList(10235807542L, 11013988476L, 1436523555L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("OpenSource");
            choices.setID(new LinkedList<>(Arrays.asList(10235807531L, 11013988478L, 1436523556L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Высоконагруженные системы / Highload");
            choices.setID(new LinkedList<>(Arrays.asList(10235807532L, 11013988479L, 1436523557L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Performance / Производительность");
            choices.setID(new LinkedList<>(Arrays.asList(null, 11013988488L, 1436523562L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Распределённые системы");
            choices.setID(new LinkedList<>(Arrays.asList(10235807533L, 11013988480L, 1436523558L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Enterprise-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10235807534L, 11013988481L, 1436523559L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("JavаSсript");
            choices.setID(new LinkedList<>(Arrays.asList(10235807544L, 11013988485L, 1436523560L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Java");
            choices.setID(new LinkedList<>(Arrays.asList(null, 11014233903L, 1436523580L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GO (Golang)");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523625L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Функциональное программирование");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1436523814L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

//        
//        {
//
//            UngroupedCharts ungroupedCharts = new UngroupedCharts();
//            ungroupedCharts.setChartName("");
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            chartOptions.setShowTitle(true);
//            chartOptions.setUseGradient(true);
//            ungroupedCharts.setChartOptions(chartOptions);
//
//            List<SingleQuestionChart> charts = new ArrayList<>();
//
//            charts.add(new SingleQuestionChart("Mobius 2015", 63175554L, L, true));
//            charts.add(new SingleQuestionChart("Mobius 2016", 80136513L, L, true));
//            charts.add(new SingleQuestionChart("Mobius 2017", 89235000L, L, true));
//            charts.add(new SingleQuestionChart("Mobius 2017 Moscow", 125742994L, L, true));
//
//            ungroupedCharts.setCharts(charts);
//            preset.AddChart(ungroupedCharts);
//
//        }
//
//        {
//
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            chartOptions.setShowTitle(true);
//            GroupedByChoiceChart chart = new GroupedByChoiceChart("", chartOptions);
//
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2015", 63175554L, L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2016", 80136513L, L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017", 89235000L, L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Mobius 2017 Moscow", 125742994L, L));
//
//            ChoiceGroup choices;
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L, L, L)));
//            chart.addChoiceGroup(choices);
//
//            preset.AddChart(chart);
//
//        }
        return preset;
    }

    public static ChartsPreset joker() {
        ChartsPreset preset = new ChartsPreset("joker");

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2015", 70153290L, 861919609L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023191960L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148960L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Junior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9487397398L, 10633811347L, 1394626358L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Middle Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9487397399L, 10633811348L, 1394626359L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Senior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9487397400L, 10633811349L, 1394626360L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Team Lead");
            choices.setID(new LinkedList<>(Arrays.asList(9487397401L, 10633811350L, 1394626361L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("QA /QA Head");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1394863705L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Architect ");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811354L, 1394626362L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 1394863706L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CTO / CIO");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811351L, 1394626363L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CEO ");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811353L, 1394626364L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Менеджер");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811352L, null)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }
        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваш стаж работы Java-разработчиком", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023191961L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148961L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Менее 1 года");
            choices.setID(new LinkedList<>(Arrays.asList(10633811361L, 1394626013L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1-3 года");
            choices.setID(new LinkedList<>(Arrays.asList(10633811362L, 1394626014L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4-6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10633811363L, 1394626015L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Более 6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10633811364L, 1394626016L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я не работаю с Java");
            choices.setID(new LinkedList<>(Arrays.asList(10633811365L, 1394626017L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Укажите ваш статус на конференции:", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023191963L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148962L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Участник");
            choices.setID(new LinkedList<>(Arrays.asList(10633811374L, 1394626020L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спикер");
            choices.setID(new LinkedList<>(Arrays.asList(10633811375L, 1394626021L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10633811376L, 1394626022L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Организатор / Волонтер");
            choices.setID(new LinkedList<>(Arrays.asList(10633811377L, 1394626023L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Как вы покупали билет?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2015", 70153290L, 862022968L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023191967L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148964L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания не компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(9488252965L, 10633811392L, 1394626026L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания компенсирует частично");
            choices.setID(new LinkedList<>(Arrays.asList(9488252966L, 10633811393L, 1394626027L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания полностью компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(9488252967L, 10633811394L, 1394626028L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билет мне покупала компания");
            choices.setID(new LinkedList<>(Arrays.asList(9488252968L, 10633811395L, 1394626029L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал, я организатор / спикер / волонтер / спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811396L, 1394626030L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал — организаторы дали проходку");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10633811397L, 1394626031L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких конференциях JUG.ru Group вы участвовали ранее? (или смотрели онлайн)");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191968L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148965L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких других конференциях вы участвовали за прошедший год? (или смотрели онлайн)");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1026044958L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197204980L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }
        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Укажите форму участия в конференции", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023191969L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148966L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Присутствовал лично");
            choices.setID(new LinkedList<>(Arrays.asList(10633811412L, 1394626039L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел трансляцию (один или в составе группы коллег)");
            choices.setID(new LinkedList<>(Arrays.asList(10633811413L, 1394626040L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смог поучаствовать лично, хочу видео");
            choices.setID(new LinkedList<>(Arrays.asList(10633811414L, 1394626041L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените организацию онлайн-трансляции");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897522L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191975L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148969L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }

        {

            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько быстро решались технические проблемы");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191977L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148970L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);

        }
        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Вы смотрели интервью со спикерами в перерывах между трансляциями докладов?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197148974L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Смотрел полностью");
            choices.setID(new LinkedList<>(Arrays.asList(1394626083L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел несколько частей");
            choices.setID(new LinkedList<>(Arrays.asList(1394626084L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел");
            choices.setID(new LinkedList<>(Arrays.asList(1394626085L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените онлайн-трансляцию интервью со спикерами в перерывах между докладами");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148973L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство места проведения");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897512L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191982L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148978L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство навигации в месте проведения");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023211765L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148983L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените техническую организацию конференции");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897514L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191989L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149027L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените сайт конференции");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148981L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените обед");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897517L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191980L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148976L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените вечеринку первого дня конференции");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1030045773L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149030L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько в целом понравилась конференция?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149018L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько конференция в целом соответствовала вашим ожиданиям?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149021L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько вероятно, что вы станете (онлайн или оффлайн) участником следующей конференции Joker?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897527L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191994L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148985L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Какова вероятность, что Вы порекомендуете Joker другу или коллеге?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2015", 70153290L, 861897528L, true));
            charts.add(new SingleQuestionChart("Joker 2016", 85694193L, 1023191995L, true));
            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197148986L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Откуда вы узнали о конференции?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();
            SingleQuestionChart sqc;

            sqc = new SingleQuestionChart("Joker 2015", 70153290L, 861897530L, true);
            sqc.setUseRow_idInstedOfChoice_id(false);
            charts.add(sqc);

            sqc = new SingleQuestionChart("Joker 2016", 85694193L, 1023191996L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);

            sqc = new SingleQuestionChart("Joker 2017", 125137353L, 197148987L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените программу конференции в целом");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149015L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените техническую глубину программы");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149016L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько техническая глубина соответствовала вашим ожиданиям?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149019L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените практическую применимость услышанного вами в докладах");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149017L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько практическая применимость услышанного вами на конференции соответствовала вашим ожиданиям?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("Joker 2017", 125137353L, 197149020L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Конференции на какие другие темы вы бы посетили ?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2016", 85694193L, 1023192011L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("Joker 2017", 125137353L, 197149010L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Web-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10633811670L, 1394626227L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText(".NET");
            choices.setID(new LinkedList<>(Arrays.asList(10633811679L, 1394626399L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Тестирование");
            choices.setID(new LinkedList<>(Arrays.asList(10633811680L, 1394626400L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(10633811674L, 1394626401L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("С++");
            choices.setID(new LinkedList<>(Arrays.asList(10633811671L, 1394626228L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GNU/Linux");
            choices.setID(new LinkedList<>(Arrays.asList(10633811672L, 1394626229L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Методологии разработки");
            choices.setID(new LinkedList<>(Arrays.asList(10633811673L, 1394626230L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("OpenSource");
            choices.setID(new LinkedList<>(Arrays.asList(10633811675L, 1394626231L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Высоконагруженные системы / Highload");
            choices.setID(new LinkedList<>(Arrays.asList(10633811676L, 1394626232L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Performance / Производительность");
            choices.setID(new LinkedList<>(Arrays.asList(10653362143L, 1394626237L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Распределённые системы");
            choices.setID(new LinkedList<>(Arrays.asList(10633811677L, 1394626233L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Enterprise-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10633811678L, 1394626234L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("JavаSсript");
            choices.setID(new LinkedList<>(Arrays.asList(10633811683L, 1394626235L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Больше Java!");
            choices.setID(new LinkedList<>(Arrays.asList(10634204008L, 1394626255L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GO (Golang)");
            choices.setID(new LinkedList<>(Arrays.asList(null, 1394626316L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Функциональное программирование");
            choices.setID(new LinkedList<>(Arrays.asList(null, 1428372438L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мобильная разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10633811681L, null)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        return preset;

    }

    public static ChartsPreset jbreak() {
        ChartsPreset preset = new ChartsPreset("jbreak");
        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2016", 76600618L, 928398045L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, 1072543727L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Junior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9975891551L, 10985992218L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Middle Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9975891552L, 10985992219L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Senior Developer");
            choices.setID(new LinkedList<>(Arrays.asList(9975891553L, 10985992220L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Team Lead");
            choices.setID(new LinkedList<>(Arrays.asList(9975891554L, 10985992221L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CTO / CIO");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992222L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Менеджер");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992223L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Директор / CEO");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992224L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Architect");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992225L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, false);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваш стаж работы Java-разработчиком", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2016", 76600618L, 928399753L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, 1072543728L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Менее 1 года");
            choices.setID(new LinkedList<>(Arrays.asList(9975902672L, 10985992232L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1-3 года");
            choices.setID(new LinkedList<>(Arrays.asList(9975902673L, 10985992233L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4-6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(9975902674L, 10985992234L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Более 6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(9975902675L, 10985992235L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я не работаю с Java");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992236L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Укажите ваш статус на конференции:", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, 266282679L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Участник");
            choices.setID(new LinkedList<>(Arrays.asList(10985992246L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спикер");
            choices.setID(new LinkedList<>(Arrays.asList(10985992247L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10985992248L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Организатор / Волонтер");
            choices.setID(new LinkedList<>(Arrays.asList(10985992249L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Как вы покупали билет?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2016", 76600618L, 928398054L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, 1072543734L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания не компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(9975891598L, 10985992263L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания компенсирует частично");
            choices.setID(new LinkedList<>(Arrays.asList(9975891599L, 10985992264L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания полностью компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(9975891600L, 10985992265L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билет мне покупала компания");
            choices.setID(new LinkedList<>(Arrays.asList(9975891601L, 10985992266L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал, я организатор / спикер / волонтер / спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992267L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал — организаторы дали проходку");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992268L)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких конференциях JUG.ru Group вы участвовали ранее?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543735L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("В каких других конференциях вы участвовали за прошедший год?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543737L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство места проведения?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, 928398029L, true));
            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543749L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените удобство навигации места проведения?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1074763723L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените техническую организацию конференции");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, 928398031L, true));
            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543755L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }
        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Оцените обед");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, 928398033L, true));
            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543747L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Насколько вероятно, что вы станете (онлайн или оффлайн) участником следующей конференции JBreak?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, 928398055L, true));
            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543762L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Какова вероятность, что Вы порекомендуете JBreak другу или коллеге?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(true);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, 928398056L, true));
            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, 1072543763L, true));

            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            UngroupedCharts ungroupedCharts = new UngroupedCharts();
            ungroupedCharts.setChartName("Откуда вы узнали о конференции?");  //!!!
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, false, true);
            chartOptions.setShowTitle(true);
            chartOptions.setUseGradient(false);
            ungroupedCharts.setChartOptions(chartOptions);

            List<SingleQuestionChart> charts = new ArrayList<>();

            SingleQuestionChart sqc = new SingleQuestionChart("JBreak 2016", 76600618L, 928398057L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);
            
             sqc = new SingleQuestionChart("JBreak 2017", 88993967L, 1072543764L, true);
            sqc.setUseRow_idInstedOfChoice_id(true);
            charts.add(sqc);
            
            
            ungroupedCharts.setCharts(charts);
            preset.AddChart(ungroupedCharts);
        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            chartOptions.setShowTitle(true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Конференции на какие другие темы вы посетили бы?", chartOptions);  //!!!

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2016", 76600618L, 928398050L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, 1072543769L));

            ChoiceGroup choices;

            choices = new ChoiceGroup();
            choices.setText("Web-раработка");
            choices.setID(new LinkedList<>(Arrays.asList(9975891565L, 10985992471L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("С++");
            choices.setID(new LinkedList<>(Arrays.asList(9975891566L, 10985992472L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GNU/Linux");
            choices.setID(new LinkedList<>(Arrays.asList(9975891567L, 10985992473L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Методологии разработки");
            choices.setID(new LinkedList<>(Arrays.asList(9976660431L, 10985992474L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992475L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("OpenSource");
            choices.setID(new LinkedList<>(Arrays.asList(9975891568L, 10985992476L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Высоконагруженные системы / Highload");
            choices.setID(new LinkedList<>(Arrays.asList(9975891569L, 10985992477L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Performance / Производительность");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992486L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Распределенные системы");
            choices.setID(new LinkedList<>(Arrays.asList(9975891570L, 10985992478L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Enterprise-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(9975891571L, 10985992479L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText(".NET");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992480L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("QA/тестирование");
            choices.setID(new LinkedList<>(Arrays.asList(9975891573L, 10985992481L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мобильная разработка");
            choices.setID(new LinkedList<>(Arrays.asList(9975891564L, 10985992482L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("JavаSсript");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992483L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Больше Java!");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10985992485L)));
            chart.addChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("методологии разработки 2");
            choices.setID(new LinkedList<>(Arrays.asList(9975891572L, null)));
            chart.addChoiceGroup(choices);

            preset.AddChart(chart);
        }

//        
//        
//        
//        
//        
//        {
//            UngroupedCharts ungroupedCharts = new UngroupedCharts();
//            ungroupedCharts.setChartName("");  //!!!
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            chartOptions.setShowTitle(true);
//            chartOptions.setUseGradient(true);
//            ungroupedCharts.setChartOptions(chartOptions);
//
//            List<SingleQuestionChart> charts = new ArrayList<>();
//
//            charts.add(new SingleQuestionChart("JBreak 2016", 76600618L, L, true));
//            charts.add(new SingleQuestionChart("JBreak 2017", 88993967L, L, true));
//
//            ungroupedCharts.setCharts(charts);
//            preset.AddChart(ungroupedCharts);
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            chartOptions.setShowTitle(true);
//            GroupedByChoiceChart chart = new GroupedByChoiceChart("", chartOptions);  //!!!
//
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2016", 76600618L, L));
//            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("JBreak 2017", 88993967L, L));
//
//            ChoiceGroup choices;
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("");
//            choices.setID(new LinkedList<>(Arrays.asList(L, L)));
//            chart.addChoiceGroup(choices);
//
//            preset.AddChart(chart);
//        }
        return preset;
    }
}
