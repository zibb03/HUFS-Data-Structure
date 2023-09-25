import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Graph {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬
	public static final int NONE = 999; // 경로 없음
	
	// 필요한 메소드나 필드를 추가하시오.




	/**
	 * 교재 p.393 참조
	 * startVertex에서 출발하여 모든 정점으로의 최소 비용을 구한다.
	 * @param startVertex 출발하는 정점 (p.384에서 정점 0에 해당)
	 * @return 출발정점에서 다른 모든 정점으로의 최소 비용 (p.394의 최종결과에 해당)
	 */
	public ArrayList<Integer> shortestPath(int startVertex, int finalVertex) {
		ArrayList<Integer> path = new ArrayList<Integer>(); // 최단 경로를 기록하기 위한 변수
		path.add(startVertex);

		// 코드를 작성하시오.

		// 시작 정점에서 모든 정점까지의 거리를 무한대로 초기화한다.
		int[] dist = new int[noVertex];
		for(int i = 0; i < dist.length; i++)
			dist[i] = NONE;

		// 시작 정점을 방문한 것으로 표시한다.
		boolean[] visited = new boolean[noVertex];
		visited[startVertex] = true;

		// 최소 힙을 생성한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
		pq.add(startVertex);
        int v = pq.poll();

		// 최단 경로를 찾는다.
		while(!pq.isEmpty()) {
			v = pq.poll();
			for(int u = 0; u < noVertex; u++) {
				if(!visited[u] && m[v][u] != NONE) {
					dist[u] = Math.min(dist[u], dist[v] + m[v][u]);
					visited[u] = true;
					pq.add(u);
				}
			}
		}

        // 최단 경로를 출력한다.
		while(v != finalVertex) {
			path.add(v);
			v = path.get(path.size() - 2);
		}
		path.add(finalVertex);

		return path;
	}

	/**
	 * 경로 path의 모든 가중치의 합을 구한다.
	 * @param shortestPath 메소드에서 구한 경로로 가중치의 합을 계산하기 위한 것이다.
	 * @return path의 비용 합을 반환한다.
	 */
	public int getCost(ArrayList<Integer> path) {
		int cost = 0;
		for(int i = 1; i < path.size(); i++) {
			cost += m[path.get(i - 1)][path.get(i)];
		}
		return cost;
	}
}