package org.jugru.monkeyStatistics.tempData;

import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.view.Conference;
import org.jugru.monkeyService.model.view.ConferencesGroup;
import org.jugru.monkeyService.model.view.AnswersGroup;
import org.jugru.monkeyService.model.view.QuestionsGroup;

public class Conferences {

    public static ConferencesGroup holyJS() {
        ConferencesGroup HolyJS = new ConferencesGroup();
        HolyJS.setName("HolyJS");

        List<Conference> confList = new LinkedList<>();
        confList.add(new Conference("HolyJS 2016 Piter", 80191211));
        confList.add(new Conference("HolyJS 2016 Moscow", 87269535));
        confList.add(new Conference("HolyJS 2017 Piter", 117652322));
        HolyJS.setConferences(confList);

        {
            QuestionsGroup position = new QuestionsGroup();
            position.setName("Ваша позиция в компании?");

            position.getID().add(966831639L);
            position.getID().add(1045020001L);
            position.getID().add(118678197L);

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(false);

            AnswersGroup answer1 = new AnswersGroup();
            answer1.setText("Junior Developer");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887091L);
                    add(10789207613L);
                    add(874803001L);
                }
            });

            AnswersGroup answer2 = new AnswersGroup();
            answer2.setText("Middle Developer");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887092L);
                    add(10789207614L);
                    add(874803002L);
                }
            });

            AnswersGroup answer3 = new AnswersGroup();
            answer3.setText("Senior Developer");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887093L);
                    add(10789207615L);
                    add(874803003L);
                }
            });

            AnswersGroup answer4 = new AnswersGroup();
            answer4.setText("Team Lead");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887094L);
                    add(10789207616L);
                    add(874803004L);
                }
            });

            AnswersGroup answer5 = new AnswersGroup();
            answer5.setText("Технический директор");
            answer5.setID(new LinkedList<Long>() {
                {
                    add(10239887100L);
                    add(10789207622L);
                    add(874803006L);
                }
            });

            AnswersGroup answer6 = new AnswersGroup();
            answer6.setText("Менеджер");
            answer6.setID(new LinkedList<Long>() {
                {
                    add(10239887101L);
                    add(10789207623L);
                    add(null);
                }
            });

            AnswersGroup answer7 = new AnswersGroup();
            answer7.setText("Директор");
            answer7.setID(new LinkedList<Long>() {
                {
                    add(10239887102L);
                    add(10789207624L);
                    add(874803007L);
                }
            });

            AnswersGroup answer8 = new AnswersGroup();
            answer8.setText("Architect");
            answer8.setID(new LinkedList<Long>() {
                {
                    add(10239887103L);
                    add(10789207625L);
                    add(874803005L);
                }
            });

            position.AddAnswerGroup(answer1);
            position.AddAnswerGroup(answer2);
            position.AddAnswerGroup(answer3);
            position.AddAnswerGroup(answer4);
            position.AddAnswerGroup(answer5);
            position.AddAnswerGroup(answer6);
            position.AddAnswerGroup(answer7);
            position.AddAnswerGroup(answer8);

            HolyJS.addQuestionGroup(position);

        }

        {
            QuestionsGroup position = new QuestionsGroup();
            position.setName("Cтатус на конференции?");

            position.getID().add(966831645L);
            position.getID().add(1045020006L);
            position.getID().add(118678199L);

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(false);

            AnswersGroup answer1 = new AnswersGroup();
            answer1.setText("Участник");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887124L);
                    add(10789207648L);
                    add(874803022L);
                }
            });

            AnswersGroup answer2 = new AnswersGroup();
            answer2.setText("Спикер");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887125L);
                    add(10789207649L);
                    add(874803023L);
                }
            });

            AnswersGroup answer3 = new AnswersGroup();
            answer3.setText("Спонсор");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887126L);
                    add(10789207650L);
                    add(874803024L);
                }
            });

            AnswersGroup answer4 = new AnswersGroup();
            answer4.setText("Организатор / Волонтер");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887132L);
                    add(10789207656L);
                    add(874803025L);
                }
            });

            position.AddAnswerGroup(answer1);
            position.AddAnswerGroup(answer2);
            position.AddAnswerGroup(answer3);
            position.AddAnswerGroup(answer4);

            HolyJS.addQuestionGroup(position);
        }

        {
            QuestionsGroup position = new QuestionsGroup();
            position.setName("Конференции на какие другие темы вы посетили бы?");

            position.getID().add(966831648L);
            position.getID().add(1045020011L);
            position.getID().add(118678250L);

            position.setWithCustomAnswer(true);
            position.setWithNoAnswer(true);

            AnswersGroup answer1 = new AnswersGroup();
            answer1.setText("Web-разработка");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887134L);
                    add(10789207662L);
                    add(874803266L);
                }
            });

            AnswersGroup answer2 = new AnswersGroup();
            answer2.setText("С++");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887135L);
                    add(10789207663L);
                    add(874803267L);
                }
            });

            AnswersGroup answer3 = new AnswersGroup();
            answer3.setText("GNU/Linux");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887136L);
                    add(10789207664L);
                    add(874803268L);
                }
            });

            AnswersGroup answer4 = new AnswersGroup();
            answer4.setText("Методологии разработки");
            answer4.setID(new LinkedList<Long>() {
                {
                    add(10239887147L);
                    add(10789207675L);
                    add(874803269L);
                }
            });

            AnswersGroup answer5 = new AnswersGroup();
            answer5.setText("OpenSource");
            answer5.setID(new LinkedList<Long>() {
                {
                    add(10239887137L);
                    add(10789207665L);
                    add(874803270L);
                }
            });

            position.AddAnswerGroup(answer1);
            position.AddAnswerGroup(answer2);
            position.AddAnswerGroup(answer3);
            position.AddAnswerGroup(answer4);
            position.AddAnswerGroup(answer5);

            HolyJS.addQuestionGroup(position);
        }

        {
            QuestionsGroup position = new QuestionsGroup();
            position.setName("Вы смотрели интервью со спикерами в перерывах между трансляциями докладов?");

            position.getID().add(null);
            position.getID().add(null);
            position.getID().add(118678212L);

            position.setWithCustomAnswer(false);
            position.setWithNoAnswer(true);

            AnswersGroup answer1 = new AnswersGroup();
            answer1.setText("Смотрел полностью");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(null);
                    add(null);
                    add(874803096L);
                }
            });

            AnswersGroup answer2 = new AnswersGroup();
            answer2.setText("Смотрел несколько частей");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(null);
                    add(null);
                    add(874803097L);
                }
            });

            AnswersGroup answer3 = new AnswersGroup();
            answer3.setText("Не смотрел");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(null);
                    add(null);
                    add(874803098L);
                }
            });

            position.AddAnswerGroup(answer1);
            position.AddAnswerGroup(answer2);
            position.AddAnswerGroup(answer3);


            HolyJS.addQuestionGroup(position);
        }

        return HolyJS;
    }

}
