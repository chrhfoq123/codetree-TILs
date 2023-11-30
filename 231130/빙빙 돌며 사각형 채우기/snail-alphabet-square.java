import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static char[][] board;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int dir = 1;

        board[x][y] = 'A';
        for(int i=1; i<n*m; i++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx, ny) || board[nx][ny] != 0){
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
            //System.out.print("x: " + x + " y: " + y + " " + (i%26+'A') + ", ");
            //System.out.println();
            board[x][y] = (char)(i % 26 + 'A');
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}