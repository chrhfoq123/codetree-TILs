import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;
        int time = 0;
        int answer = -1;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());

            int dir;
            if(s.equals("W")){
                dir = 3;
            }else if(s.equals("S")){
                dir = 2;
            }else if(s.equals("N")){
                dir = 0;
            }else{
                dir = 1;
            }

            for(int j=0; j<dist; j++){
                x = x + dx[dir];
                y = y + dy[dir];

                time++;

                if(x == 0 && y == 0){
                    answer = time;
                    break;
                }
            }

            if(x ==0 && y == 0){
                break;
            }
        }

        System.out.print(answer);
    }
}