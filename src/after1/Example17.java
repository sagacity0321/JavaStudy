package after1;

import java.net.*;
import java.io.*;

public class Example17 {
    public static void main(String[] args) throws Exception {
        URL _URL = new URL("https://www.naver.com/");
        URLConnection _URLConnection = _URL.openConnection();

        System.out.println(" ===== 뮤직 급상승 차트 ===== ");
        BufferedReader _BufferedReader = new BufferedReader(new InputStreamReader(_URLConnection.getInputStream()));

        int nRank = 0;
        String strTemp = "";

        while((strTemp = _BufferedReader.readLine()) != null){
            if(strTemp.contains("tcc_tvc.mranksong") && nRank < 10){
                System.out.println(++nRank + "위: " + strTemp.split(">")[1].split("<")[0]);
            }
            _BufferedReader.close();
        }
    }
}
