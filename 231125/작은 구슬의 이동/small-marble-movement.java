import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};

    public static boolean inRange(int x, int y){
        return (x >= 1 && x <= n && y >= 1 && y <= n);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String d = st.nextToken();
        
        int dir;
        if(d.equals("U")){
            dir = 2;
        }else if(d.equals("D")){
            dir = 1;
        }else if(d.equals("R")){
            dir = 0;
        }else{
            dir = 3;
        }

        int x = r;
        int y = c;
        for(int i=0; i<t; i++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny)){
                dir = 3 - dir;
            }else{
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }

        System.out.print(x + " " + y);
    }
}