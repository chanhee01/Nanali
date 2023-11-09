package Nanali.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    public ResponseEntity<Map<String, Map<String, Object>>> weather(LocalDateTime weatherTime) throws IOException {

        String today = weatherTime.toString().concat("T");
        today = today.substring(0, today.indexOf("T"));
        System.out.println("today = " + today);

        StringBuilder urlBuilder = new StringBuilder("https://api.open-meteo.com/v1/forecast"); // HTTPS 프로토콜 사용
        urlBuilder.append("?" + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode("37.4526", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode("126.6517", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("hourly", "UTF-8") + "=" + URLEncoder.encode("temperature_2m,precipitation,uv_index", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();
        String data = sb.toString();
        System.out.println("API 응답 데이터: " + data);

        try {
            JSONObject jsonResponse = new JSONObject(data);

            JSONObject hourlyTimes = jsonResponse.getJSONObject("hourly");

            JSONArray timeData = hourlyTimes.getJSONArray("time");
            JSONArray temperatureData = hourlyTimes.getJSONArray("temperature_2m");
            JSONArray precipitationData = hourlyTimes.getJSONArray("precipitation");
            JSONArray uvIndexData = hourlyTimes.getJSONArray("uv_index");

            // 날짜별 데이터를 매핑하기 위한 Map
            HashMap<String, Map<String, Object>> weatherDataByDate = new HashMap<>();

            for (int i = 0; i < timeData.length(); i++) {
                // 이전 코드 생략

                String time = timeData.getString(i);
                double temperature = temperatureData.getDouble(i);
                double precipitation = precipitationData.getDouble(i);
                double uvIndex = uvIndexData.getDouble(i);

                // 날짜 정보 추출
                String date = time.replace("T", " ");

                // 해당 날짜에 대한 데이터 매핑
                Map<String, Object> weatherData = new HashMap<>();
                weatherData.put("temperature", temperature);
                weatherData.put("precipitation", precipitation);
                weatherData.put("uv_index", uvIndex);


                if(date.contains(today)) {
                    weatherDataByDate.put(date, weatherData);
                }
            }

            List<Map.Entry<String, Map<String, Object>>> sortedList = new ArrayList<>(weatherDataByDate.entrySet());

            // ResponseEntity로 매핑된 데이터 반환
            return ResponseEntity.ok(weatherDataByDate);
        } catch (JSONException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Map<String, Object> getCurrentWeather(Map<String, Map<String, Object>> weatherData, LocalDateTime time) {
        LocalDateTime currentTime = time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 09:00");
        String currentTimeStr = currentTime.format(formatter);

        System.out.println(currentTime);
        System.out.println(currentTimeStr);

        if (weatherData.containsKey(currentTimeStr)) {
            return weatherData.get(currentTimeStr);
        } else {
            return null;
        }
    }
}