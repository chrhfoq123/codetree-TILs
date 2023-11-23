import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        String s = br.readLine();

        int nx = 0, ny = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'L'){
                dir = (dir +3) % 4;
            }else if(s.charAt(i) == 'R'){
                dir = (dir + 1) % 4;
            }else{
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
        }

        System.out.print(nx + " " + ny);
    }
}