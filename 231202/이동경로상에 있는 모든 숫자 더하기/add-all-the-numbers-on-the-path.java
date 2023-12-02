import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int count = 0;
    public static int[][] board;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n/2;
        int y = n/2;
        int dir = 0;

        count += board[x][y];
        for(int i=0; i<t; i++){
            char c = s.charAt(i);
            if(c == 'R'){
                dir = (dir + 1) % 4;
            }else if(c == 'L'){
                dir = (dir + 3) % 4;
            }else{
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(!inRange(nx, ny)){
                    continue;
                }else{
                    x += dx[dir];
                    y += dy[dir];
                    count += board[x][y];
                }
            }
        }

        System.out.print(count);
    }
}