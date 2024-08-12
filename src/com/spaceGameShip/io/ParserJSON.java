package com.spaceGameShip.io;

import com.spaceGameShip.gameObject.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ParserJSON {

    public static ArrayList<DataScore> dataScores() throws FileNotFoundException {
        ArrayList<DataScore> dataScoreArrayList = new ArrayList<DataScore>();

        File file = new File(Constants.SCORE_PATH);
        if (!file.exists() || file.length() == 0) {
            return dataScoreArrayList;
        }

        JSONTokener jsonTokener = new JSONTokener(new FileInputStream(file));
        JSONArray jsonArray = new JSONArray(jsonTokener);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            DataScore score = new DataScore();
            score.setScore(jsonObject.getInt("score"));
            score.setDate(jsonObject.getString("date"));
            dataScoreArrayList.add(score);
        }
        return dataScoreArrayList;
    }

    public static void fileWrite(ArrayList<DataScore> dataList) throws IOException {

        File output = new File(Constants.SCORE_PATH);
        output.getParentFile().mkdirs();
        output.createNewFile();

        JSONArray jsonArray = new JSONArray();

        for (DataScore data: dataList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("score",data.getScore());
            jsonObj.put("date",data.getDate());

            jsonArray.put(jsonObj);
        }

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(output.toURI()));
        jsonArray.write(bufferedWriter);
        bufferedWriter.close();
    }
}
