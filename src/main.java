import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 */

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution.solution(maps);
        solution.solution(maps);
    }
}

class Solution {
    static int[] nArr = {-1, 0, 1, 0};
    static int[] mArr = {0,-1,0,1};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(maps);

        if(answer == Integer.MAX_VALUE)
            return -1;

        return answer;
    }

    class Node{
        int n;
        int m;
        Node(int n,int m){
            this.n = n;
            this.m = m;
        }
    }

    public void bfs(int[][] maps){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        while(!q.isEmpty()){

            Node node = q.poll();

            int n = node.n;
            int m = node.m;

            if(n == maps.length-1 && m == maps[0].length-1){
                answer = Math.min(answer,maps[n][m]);
                continue;
            }

            for(int i=0;i<nArr.length;i++){
                int n1 = n + nArr[i];
                int m1 = m + mArr[i];

                if(n1<0 || n1>= maps.length || m1 <0 || m1 >= maps[0].length)
                    continue;

                if(!visited[n1][m1] && (maps[n1][m1] != 0)){
                    visited[n1][m1] = true;
                    q.offer(new Node(n1,m1));
                    maps[n1][m1] = maps[n][m]+1;
                }
            }
        }
    }
}
