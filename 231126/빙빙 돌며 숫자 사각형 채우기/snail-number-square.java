import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[][] board;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        int x = 0, y = 0;
        int dir = 0;
        board[x][y] = 1;
        for(int i=2; i<=n*m; i++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx, ny) || board[nx][ny] != 0){
                dir = (dir + 1) % 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];
            board[x][y] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}