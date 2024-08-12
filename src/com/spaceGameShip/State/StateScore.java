package com.spaceGameShip.State;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Text;
import com.spaceGameShip.gameObject.Constants;
import com.spaceGameShip.io.DataScore;
import com.spaceGameShip.io.ParserJSON;
import com.spaceGameShip.math.Vector2D;
import com.spaceGameShip.ui.Action;
import com.spaceGameShip.ui.Button;
import java.awt.Graphics;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StateScore extends States{

    private Button returnButton;
    private PriorityQueue<DataScore> priorityQueue;
    private Comparator<DataScore> comparator;
    private DataScore[] scoreArray;

    public StateScore() {

        returnButton = new Button(Assets.greyButton, Assets.blueButton,
                Assets.greyButton.getHeight(), Constants.HEIGHT - Assets.greyButton.getHeight() * 2,
                Constants.RETURN,
                new Action() {
                    @Override
                    public void doAction() {
                        States.changeState(new MenuState());
                    }
                }
        );

        comparator = new Comparator<DataScore>() {
            @Override
            public int compare(DataScore o1, DataScore o2) {
                return o1.getScore() < o2.getScore() ? -1: o1.getScore() > o2.getScore() ? 1: 0;
            }
        };

        priorityQueue = new PriorityQueue<DataScore>(10, comparator);

        try {

            ArrayList<DataScore> listData = ParserJSON.dataScores();

            for (DataScore dataScore: listData) {
                priorityQueue.add(dataScore);
            }

            while (priorityQueue.size() > 10) {
                priorityQueue.poll();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        returnButton.update();
    }

    @Override
    public void draw(Graphics g) {
        returnButton.draw(g);

        scoreArray = priorityQueue.toArray(new DataScore[priorityQueue.size()]);
        Arrays.sort(scoreArray, comparator);

        Vector2D scorePosition = new Vector2D(Constants.WIDTH / 2 - 200,100);
        Vector2D datePosition = new Vector2D(Constants.WIDTH / 2 + 200,100);

        Text.drawText(g, Constants.SCORE, scorePosition, true, Color.CYAN, Assets.fontBig);
        Text.drawText(g, Constants.DATE, datePosition, true, Color.CYAN, Assets.fontBig);

        scorePosition.setY(scorePosition.getY() + 62);
        datePosition.setY(datePosition.getY() + 62);
        scorePosition.setX(scorePosition.getX() + 150);
        datePosition.setX(datePosition.getX() + 50);

        for (int i = scoreArray.length - 1; i > -1; i--) {

            DataScore dataScore = scoreArray[i];

            Text.drawText(g, Integer.toString(dataScore.getScore()), scorePosition, true, Color.WHITE, Assets.fontMed);
            Text.drawText(g, dataScore.getDate(), datePosition, true, Color.WHITE, Assets.fontMed);

            scorePosition.setY(scorePosition.getY() + 50);
            datePosition.setY(datePosition.getY() + 50);
            scorePosition.setX(scorePosition.getX() + 29);
            datePosition.setX(datePosition.getX() + 85);
        }
    }
}