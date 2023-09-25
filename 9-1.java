import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

// 필요한 메소드를 추가하여 아래 클래스를 완성하시오.
class Graph {
	
	// 필요한 field, method는 추가하시오.
	
    private ArrayList[] adjList;
    private int noVertex;


    // 생성자를 작성하시오.
	public Graph(int noVertex) {
        this.noVertex = noVertex;
        this.adjList = new ArrayList[noVertex];

        for (int i = 0; i < noVertex; i++) {
                adjList[i] = new ArrayList<>();
        }
	}

	// 간선 (i, j)를 삽입한다.
	public void addEdge(int i, int j) {
        adjList[i].add(j);
	}

	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
        adjList[i].remove(j);
	}

	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	// vertex에서 시작한다.
	public void bfs(int vertex) {
        boolean[] visited = new boolean[noVertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int w : adjList[v]) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
	}

	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	// vertex에서 시작한다.
	public void dfs(int vertex) {
        boolean[] visited = new boolean[noVertex];
        Stack<Integer> stack = new Stack<>();
        stack.add(vertex);
        visited[vertex] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(v + " ");

            for (int w : adjList[v]) {
                if (!visited[w]) {
                    stack.add(w);
                    visited[w] = true;
                }
            }
        }
	}

	// 그래프를 출력하는 메소드이다.
	public void print() {
        for (int i = 0; i < noVertex; i++) {
            for (int j : adjList[i]) {
                System.out.print(j + " ");
            }
    
            System.out.println();
        }
	}


    class Main {
        
        // main 메소드는 수정하지 마시오.
        public static void main(String[] args) throws Exception {
            Scanner scan = new Scanner(System.in);

            int noVertex = scan.nextInt();
            Graph graph = new Graph(noVertex);

            for(int i = 0; i < noVertex; i++) {
                for(int j = 0; j < noVertex; j++) {
                    int vertex = scan.nextInt();
                    if (vertex == 1)
                        graph.addEdge(i, j);
                }
            }
            
            
            while(scan.hasNext()) {
                String cmd = scan.next();
                if (cmd.equals("P"))
                    graph.print();
                else if (cmd.equals("I")) {
                    int from = scan.nextInt();
                    int to = scan.nextInt();
                    graph.addEdge(from, to);
                } else if (cmd.equals("D")) {
                    int from = scan.nextInt();
                    int to = scan.nextInt();
                    graph.removeEdge(from, to);
                } else if (cmd.equals("DFS")) {
                    int vertex = scan.nextInt();
                    graph.dfs(vertex);
                } else if (cmd.equals("BFS")) {
                    int vertex = scan.nextInt();
                    graph.bfs(vertex);
                } else if (cmd.equals("E")) { // 종료한다.
                    break;
                }
            }
            
            scan.close();		
        }
    }

}