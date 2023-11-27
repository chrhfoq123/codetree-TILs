import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0, y = 0;
        int time = 0;
        int answer = -1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String s = br.readLine();

        int dir = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'F'){
                x = x + dx[dir];
                y = y + dy[dir];
                time++;
            }else if(c == 'R'){
                dir = (dir + 1) % 4;
                time++;
            }else{
                dir = (dir + 3) % 4;
                time++;
            }

            if(x == 0 && y == 0){
                answer = time;
                break;
            }
        }

        System.out.print(answer);
    }
}