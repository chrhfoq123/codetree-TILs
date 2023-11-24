import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int count = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(inRange(nx, ny) && board[nx][ny] == 1){
                        count++;
                    }
                }

                if(count >= 3){
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}