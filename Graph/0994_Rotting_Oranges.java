class Pair{
    int row, col, time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int[] delRow = {-1, 0 ,1, 0};
        int[] delCol = {0, 1, 0, -1};

        int n = grid.length;
        int m = grid[0].length;
        int tm = 0;
        int countFresh = 0;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    vis[i][j] = 0;
                    countFresh++;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int time = q.peek().time;
            tm = Math.max(tm, time);
            Pair p = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                    q.add(new Pair(nr, nc, time + 1));
                    vis[nr][nc] = 1;
                    cnt++;
                }
            }
        }
        if(cnt != countFresh) return -1;
        return tm;
    }
}