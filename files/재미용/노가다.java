package PS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.image.DataBufferDouble;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String link = "https://www.acmicpc.net/problem/";

        String temp = "1405/1600/5567/1743/1167/9328/2023/2234/2251/1926/19238/17135/5557/4811/2407/" +
                "10164/1520/1256/14002/7570/9655/1495/12869/5582/5052/9372/3613/9252/1958/" +
                "14675/1747/5525/5639/9935/2671";
        String[] temp2 = temp.split("/");
        ArrayList<Integer> problems = new ArrayList();
        for(int i=0;i<temp2.length;i++){
            problems.add(Integer.parseInt(temp2[i]));
        }
        problems.sort(null);

        for(int i=0;i<problems.size();i++){
            System.out.print(problems.get(i) + " ");
        }
        System.out.println();
        System.out.println(problems.size());

        // TODO : URL로 긁어와서 티어들 정리하기.
        // 긁어와서 하려고 했는데, 찾기 귀찮아서 하드코딩한다.
//        String url = "https://www.acmicpc.net/problem/1000";
//        Document doc = Jsoup.connect(url).get();
//        System.out.println(doc.html().toString());
        for(int i=0;i<problems.size();i++){
            String pNumber = Integer.toString(problems.get(i));
            System.out.println("[" + pNumber + "](" + link + pNumber + ")");
        }

        // 실버 5 11
        // 실버 4
        // 실버 3 1
        // 실버 2 11
        // 실버 1 11111 11
        // 골드 5 11111 11111
        // 골드 4 11111 111
        // 골드 3 111
        // 골드 2
        // 골드 1 1

        //

    }


}

