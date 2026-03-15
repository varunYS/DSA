class Solution {
    public void dfs(int[][] isConnected, int r, int c, int[] delRow, int[] delCol){
        int nr, nc;
        isConnected[r][c] = 0;
        for(int i = 0; i < 4; i++){
            nr = r + delRow[i];
            nc = c + delCol[i];

            if(nr > -1 && nr < isConnected.length && nc > - 1 && nc < isConnected[0].length){
                if(isConnected[nr][nc] == 1)
                    dfs(isConnected, nr, nc, delRow, delCol);
            }
        }
        
        
    }
    public int findCircleNum(int[][] isConnected) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int provinces = 0;

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; i++){
                if(isConnected[i][j] == 1){
                    dfs(isConnected, i, j, delRow, delCol);
                    provinces++;
                }
            }
        }
        return provinces;

    }
}