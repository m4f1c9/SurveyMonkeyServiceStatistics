package org.jugru.monkeyStatistics.tempData;

import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.view.Conference;
import org.jugru.monkeyService.model.view.ConferenceGroup;
import org.jugru.monkeyService.model.view.ViewAnswer;
import org.jugru.monkeyService.model.view.ViewQuestion;

public class Conferences {

    public static ConferenceGroup holyJS() {
        ConferenceGroup gejzenbag = new ConferenceGroup();
        gejzenbag.setName("HolyJS");

        List<Conference> confList = new LinkedList<>();
        confList.add(new Conference("2016 Piter", 80191211));
        confList.add(new Conference("2016 Moscow", 87269535));
        confList.add(new Conference("2017 Piter", 117652322));
        gejzenbag.setConferenceList(confList);

        {
            ViewQuestion position = new ViewQuestion();
            position.setName("Ваша позиция в компании?");

            ViewAnswer answer1 = new ViewAnswer();
            answer1.setText("Junior Developer");
            answer1.setIDList(new LinkedList<Long>() {
                {
                    add(10239887091L);
                    add(10789207613L);
                    add(874803001L);
                }
            });

            ViewAnswer answer2 = new ViewAnswer();
            answer2.setText("Middle Developer");
            answer2.setIDList(new LinkedList<Long>() {
                {
                    add(10239887092L);
                    add(10789207614L);
                    add(874803002L);
                }
            });

            ViewAnswer answer3 = new ViewAnswer();
            answer3.setText("Senior Developer");
            answer3.setIDList(new LinkedList<Long>() {
                {
                    add(10239887093L);
                    add(10789207615L);
                    add(874803003L);
                }
            });

            ViewAnswer answer4 = new ViewAnswer();
            answer4.setText("Team Lead");
            answer4.setIDList(new LinkedList<Long>() {
                {
                    add(10239887094L);
                    add(10789207616L);
                    add(874803004L);
                }
            });

            ViewAnswer answer5 = new ViewAnswer();
            answer5.setText("Технический директор");
            answer5.setIDList(new LinkedList<Long>() {
                {
                    add(10239887100L);
                    add(10789207622L);
                    add(874803006L);
                }
            });

            ViewAnswer answer6 = new ViewAnswer();
            answer6.setText("Менеджер");
            answer6.setIDList(new LinkedList<Long>() {
                {
                    add(10239887101L);
                    add(10789207623L);
                    add(null);
                }
            });

            ViewAnswer answer7 = new ViewAnswer();
            answer7.setText("Директор");
            answer7.setIDList(new LinkedList<Long>() {
                {
                    add(10239887102L);
                    add(10789207624L);
                    add(874803007L);
                }
            });

            ViewAnswer answer8 = new ViewAnswer();
            answer8.setText("Architect");
            answer8.setIDList(new LinkedList<Long>() {
                {
                    add(10239887103L);
                    add(10789207625L);
                    add(874803005L);
                }
            });

            position.AddAnswer(answer1);
            position.AddAnswer(answer2);
            position.AddAnswer(answer3);
            position.AddAnswer(answer4);
            position.AddAnswer(answer5);
            position.AddAnswer(answer6);
            position.AddAnswer(answer7);
            position.AddAnswer(answer8);

            gejzenbag.addQuestion(position);

        }

        {
            ViewQuestion position = new ViewQuestion();
            position.setName("Cтатус на конференции?");

            ViewAnswer answer1 = new ViewAnswer();
            answer1.setText("Участник");
            answer1.setIDList(new LinkedList<Long>() {
                {
                    add(10239887124L);
                    add(10789207648L);
                    add(874803022L);
                }
            });

            ViewAnswer answer2 = new ViewAnswer();
            answer2.setText("Спикер");
            answer2.setIDList(new LinkedList<Long>() {
                {
                    add(10239887125L);
                    add(10789207649L);
                    add(874803023L);
                }
            });

            ViewAnswer answer3 = new ViewAnswer();
            answer3.setText("Спонсор");
            answer3.setIDList(new LinkedList<Long>() {
                {
                    add(10239887126L);
                    add(10789207650L);
                    add(874803024L);
                }
            });

            ViewAnswer answer4 = new ViewAnswer();
            answer4.setText("Организатор / Волонтер");
            answer4.setIDList(new LinkedList<Long>() {
                {
                    add(10239887132L);
                    add(10789207656L);
                    add(874803025L);
                }
            });

           

            position.AddAnswer(answer1);
            position.AddAnswer(answer2);
            position.AddAnswer(answer3);
            position.AddAnswer(answer4);


            gejzenbag.addQuestion(position);
        }
        return gejzenbag;
    }

    public static void main(String[] args) {
        ConferenceGroup cg = holyJS();
        System.out.println("");
        System.out.println("");
    }
}
