import java.util.Scanner;

class Point {
    public int x, y;
}

public class Main {
    static int[][] maze, mark;
    static int sizeX, sizeY;
    static Point start, exit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void dfs(int x, int y) {
        if (x == exit.x && y == exit.y) {
            mark[x][y] = 1;
            printMaze();
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= sizeX || ny >= sizeY)
                continue;
            if (maze[nx][ny] == 1 || mark[nx][ny] == 1)
                continue;

            mark[nx][ny] = 1;
            dfs(nx, ny);
            mark[nx][ny] = 0;
        }
    }

    public static void printMaze() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (maze[i][j] == 1)
                    System.out.print("1 ");
                else if (mark[i][j] == 1) {
                    if (i == start.x && j == start.y)
                        System.out.print("S ");
                    else if (i == exit.x && j == exit.y)
                        System.out.print("F ");
                    else
                        System.out.print("* ");
                } else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sizeX = scan.nextInt();
        sizeY = scan.nextInt();

        start = new Point();
        start.x = scan.nextInt();
        start.y = scan.nextInt();

        exit = new Point();
        exit.y = scan.nextInt();
        exit.x = scan.nextInt();

        maze = new int[sizeX][sizeY];
        mark = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                maze[i][j] = scan.nextInt();
            }
        }

        mark[start.x][start.y] = 1;
        dfs(start.x, start.y);
    }
}
