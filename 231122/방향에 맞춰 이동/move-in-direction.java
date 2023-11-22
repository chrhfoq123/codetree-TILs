import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int nx = 0;
        int ny = 0;

        int move = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());

            if(dir.equals("N")){
                move = 0;
            }else if(dir.equals("E")){
                move = 1;
            }else if(dir.equals("S")){
                move = 2;
            }else{
                move = 3;
            }

            nx = nx + dx[move] * dist;
            ny = ny + dy[move] * dist;
        }

        System.out.print(nx + " " + ny);
    }
}