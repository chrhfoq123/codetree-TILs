import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int startNum;
    public static int x, y, moveDir;
    public static char[][] board = new char[1000][1000];

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void initialize(int num){
        if(num <= n){
            x = 0;
            y = num - 1;
            moveDir = 0; //레이저를 위에서 아래로
        }else if(num <= 2 * n){
            x = num - n - 1;
            y = n - 1;
            moveDir = 1; //레이저를 오른쪽에서 왼쪽으로
        }else if(num <= 3 * n){
            x = n - 1;
            y = n - (num - 2 * n);
            moveDir = 2; //레이저를 아래에서 위로
        }else{
            x = n - (num - 3 * n);
            y = 0;
            moveDir = 3; //레이저를 왼쪽에서 오른쪽으로
        }
    }

    public static void move(int nextDir){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        x += dx[nextDir];
        y += dy[nextDir];
        moveDir = nextDir;
    }

    public static int simulate(){
        int moveNum = 0;
        while(inRange(x, y)){
            if(board[x][y] == '/'){
                move(moveDir ^ 1);
            }else{
                move(3 - moveDir);
            }
            moveNum += 1;
        }
        return moveNum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = s.charAt(j);
            }
        }

        startNum = Integer.parseInt(br.readLine());

        initialize(startNum);
        int moveNum = simulate();

        System.out.print(moveNum);
    }
}