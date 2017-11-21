package org.jugru.monkeyStatistics.tempData;

import java.util.Arrays;
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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Middle Developer / Developer / Разработчик / Программист");
            choices.setID(new LinkedList<>(Arrays.asList(10094381382L, 10983520029L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Senior Developer / Старший разработчик / Ведущий разработчик / Ведущий программист");
            choices.setID(new LinkedList<>(Arrays.asList(10094381383L, 10983520030L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Team Lead");
            choices.setID(new LinkedList<>(Arrays.asList(10094381384L, 10983520031L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("CTO / CIO / Технический директор");
            choices.setID(new LinkedList<>(Arrays.asList(10118624776L, 10983520032L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Менеджер");
            choices.setID(new LinkedList<>(Arrays.asList(10118624777L, 10983520033L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Директор / CEO");
            choices.setID(new LinkedList<>(Arrays.asList(10118624778L, 10983520034L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Architect / Senior Architect / Архитектор / Системный архитектор");
            choices.setID(new LinkedList<>(Arrays.asList(10118624779L, 10983520035L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1-3 года");
            choices.setID(new LinkedList<>(Arrays.asList(10094381398L, 10983520043L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4-6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10094381399L, 10983520044L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Более 6 лет");
            choices.setID(new LinkedList<>(Arrays.asList(10094381400L, 10983520045L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я не работаю с Java");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520046L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спикер");
            choices.setID(new LinkedList<>(Arrays.asList(10118393713L, 10983520061L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10118393714L, 10983520062L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Организатор / Волонтер");
            choices.setID(new LinkedList<>(Arrays.asList(10118618908L, 10983520063L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Участие в конференциях их вообще не интересует");
            choices.setID(new LinkedList<>(Arrays.asList(10094381423L, 10983520065L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билеты стоят слишком дорого");
            choices.setID(new LinkedList<>(Arrays.asList(10094381424L, 10983520066L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не хотят тратить выходной день на конференцию");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520067L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не могут выделить рабочий день");
            choices.setID(new LinkedList<>(Arrays.asList(null, 11011248742L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Они не знают про JPoint");
            choices.setID(new LinkedList<>(Arrays.asList(10094381431L, 10983520068L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Начальство не дало командировку");
            choices.setID(new LinkedList<>(Arrays.asList(10094381430L, null)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания компенсирует частично");
            choices.setID(new LinkedList<>(Arrays.asList(10094381450L, 10983520076L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Покупал сам, компания полностью компенсирует");
            choices.setID(new LinkedList<>(Arrays.asList(10094381451L, 10983520077L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Билет мне покупала компания");
            choices.setID(new LinkedList<>(Arrays.asList(10094381452L, 10983520078L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал, я организатор / спикер / волонтер / спонсор");
            choices.setID(new LinkedList<>(Arrays.asList(10118629525L, 10983520079L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не покупал — организаторы дали проходку");
            choices.setID(new LinkedList<>(Arrays.asList(10118629524L, 10983520080L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел трансляцию (один или в составе группы коллег)");
            choices.setID(new LinkedList<>(Arrays.asList(8886535090L, 10094494398L, 10983520100L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смог поучаствовать лично, хочу видео");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10118522037L, 10983520101L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Посмотрю больше половины");
            choices.setID(new LinkedList<>(Arrays.asList(10118538103L, 10983520129L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нет, посмотрю 5-10 наиболее важных докладов");
            choices.setID(new LinkedList<>(Arrays.asList(10118538104L, 10983520130L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мне интересна пара докладов, не более");
            choices.setID(new LinkedList<>(Arrays.asList(10118538105L, 10983520131L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(8886559329L, 10094507046L, 10983520136L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520137L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально");
            choices.setID(new LinkedList<>(Arrays.asList(8886559330L, 10094507047L, null)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520138L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(8886559331L, 10094507048L, 10983520139L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(8886559332L, 10094507049L, 10983520140L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520141L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально, но кое-что я упустил");
            choices.setID(new LinkedList<>(Arrays.asList(10118541187L, 10983520145L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Очень быстро");
            choices.setID(new LinkedList<>(Arrays.asList(10118541186L, 10983520146L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не заметил технических проблем");
            choices.setID(new LinkedList<>(Arrays.asList(10118541189L, 10983520147L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Смотрел несколько частей");
            choices.setID(new LinkedList<>(Arrays.asList(10983520158L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел");
            choices.setID(new LinkedList<>(Arrays.asList(10983520159L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520150L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520151L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520152L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520153L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520154L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520155L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не смотрел трансляцию");
            choices.setID(new LinkedList<>(Arrays.asList(10983520156L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520175L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520176L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520177L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520178L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520179L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520180L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520222L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520223L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520224L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520225L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520226L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520227L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо/Скорее не понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703042L, 10094381359L, 10983520212L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе/Средний уровень");
            choices.setID(new LinkedList<>(Arrays.asList(8872703044L, 10094381360L, 10983520213L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520214L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо/Скорее понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703045L, 10094381361L, 10983520215L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично/Понравилась");
            choices.setID(new LinkedList<>(Arrays.asList(8872703046L, 10094381362L, 10983520216L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520217L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Ужасно");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520163L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(8872703049L, 10094381364L, 10983520164L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520165L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520166L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Нормально");
            choices.setID(new LinkedList<>(Arrays.asList(8872703050L, 10094381365L, null)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(8872703051L, 10094381366L, 10983520167L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(8872703052L, 10094381367L, 10983520168L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520169L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Плохо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520234L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Так себе");
            choices.setID(new LinkedList<>(Arrays.asList(10983520235L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(10983520236L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Хорошо");
            choices.setID(new LinkedList<>(Arrays.asList(10983520237L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Отлично");
            choices.setID(new LinkedList<>(Arrays.asList(10983520238L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Идеально");
            choices.setID(new LinkedList<>(Arrays.asList(10983520239L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Я пропустил вечеринку");
            choices.setID(new LinkedList<>(Arrays.asList(10983520240L)));
            questionGroup.AddChoiceGroup(choices);

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
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Из почтовой рассылки JUG.ru");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520281L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (группы/посты)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520280L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (реклама)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520267L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Соцсети (группы/посты/реклама)");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703061L, 10094381487L,  null)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Хабрахабр");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703062L, 10094381488L, 10983520268L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Youtube (какое видео?)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, 10094381495L,  10983520269L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Блоги (чей блог?)");
//            choices.setID(new LinkedList<>(Arrays.asList(null, 10094381496L, 10983520270L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От коллеги (откуда он узнал?)");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703063L, 10094381489L,  10983520271L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От руководителя");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703065L, 10094381490L, 10983520272L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("От друзей");
//            choices.setID(new LinkedList<>(Arrays.asList(8872703066L, 10094381491L,  10983520273L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Нашел в поисковой системе");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520275L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Был на прошлых конференциях");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520276L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Звонок от организаторов");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  11011250271L)));
//            questionGroup.AddChoiceGroup(choices);
//
//            choices = new ChoiceGroup();
//            choices.setText("Не помню");
//            choices.setID(new LinkedList<>(Arrays.asList(null, null,  10983520283L)));
//            questionGroup.AddChoiceGroup(choices);
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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("С++");
            choices.setID(new LinkedList<>(Arrays.asList(10094381408L, 10983520316L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("GNU/Linux");
            choices.setID(new LinkedList<>(Arrays.asList(10094381409L, 10983520318L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Методологии разработки");
            choices.setID(new LinkedList<>(Arrays.asList(10094381421L, 10983520319L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("DevOps");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520320L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("OpenSource");
            choices.setID(new LinkedList<>(Arrays.asList(10094381410L, 10983520321L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Высоконагруженные системы / Highload");
            choices.setID(new LinkedList<>(Arrays.asList(10094381411L, 10983520322L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Performance / Производительность");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520331L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Распределенные системы");
            choices.setID(new LinkedList<>(Arrays.asList(10094381412L, 10983520323L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Enterprise-разработка");
            choices.setID(new LinkedList<>(Arrays.asList(10094381413L, 10983520324L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText(".NET");
            choices.setID(new LinkedList<>(Arrays.asList(null, 10983520325L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("QA/тестирование");
            choices.setID(new LinkedList<>(Arrays.asList(10094381415L, 10983520326L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Мобильная разработка (iOS / Android)");
            choices.setID(new LinkedList<>(Arrays.asList(10094381406L, 10983520327L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("JavаSсript");
            choices.setID(new LinkedList<>(Arrays.asList(10095630274L, 10983520328L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Больше Java!");
            choices.setID(new LinkedList<>(Arrays.asList(10095629459L, 10983520330L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("1");
            choices.setID(new LinkedList<>(Arrays.asList(8872703097L, 8886547243L, 10094381475L, 10983520253L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("2");
            choices.setID(new LinkedList<>(Arrays.asList(8872703098L, 8886547244L, 10094381476L, 10983520254L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("3");
            choices.setID(new LinkedList<>(Arrays.asList(8872703099L, 8886547245L, 10094381477L, 10983520255L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("4");
            choices.setID(new LinkedList<>(Arrays.asList(8872703100L, 8886547246L, 10094381478L, 10983520256L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("5");
            choices.setID(new LinkedList<>(Arrays.asList(8872703101L, 8886547247L, 10094381479L, 10983520257L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("6");
            choices.setID(new LinkedList<>(Arrays.asList(8872703102L, 8886547248L, 10094381480L, 10983520258L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("7");
            choices.setID(new LinkedList<>(Arrays.asList(8872703103L, 8886547249L, 10094381481L, 10983520259L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("8");
            choices.setID(new LinkedList<>(Arrays.asList(8872703104L, 8886547250L, 10094381482L, 10983520260L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("9");
            choices.setID(new LinkedList<>(Arrays.asList(8872703105L, 8886547251L, 10094381483L, 10983520261L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("10");
            choices.setID(new LinkedList<>(Arrays.asList(8872703106L, 8886547252L, 10094381484L, 10983520262L)));
            questionGroup.AddChoiceGroup(choices);

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
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Скорее всего, не приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703089L, 10094381467L, 10983520245L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не знаю, вряд ли");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520246L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Затрудняюсь ответить");
            choices.setID(new LinkedList<>(Arrays.asList(8872703090L, 10094381468L, 10983520247L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Не знаю, возможно");
            choices.setID(new LinkedList<>(Arrays.asList(null, null, 10983520248L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Скорее всего приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703091L, 10094381469L, 10983520249L)));
            questionGroup.AddChoiceGroup(choices);

            choices = new ChoiceGroup();
            choices.setText("Точно приду");
            choices.setID(new LinkedList<>(Arrays.asList(8872703092L, 10094381470L, 10983520250L)));
            questionGroup.AddChoiceGroup(choices);

            JPoint.addQuestionGroup(questionGroup);

        }

        return JPoint;
    }
}
