import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int[][] board;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int x = n-1;
        int y = n-1;

        board[x][y] = n*n;

        int dir = 0;
        for(int i=n*n-1; i>=1; i--){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx, ny) || board[nx][ny] != 0){
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
            board[x][y] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}