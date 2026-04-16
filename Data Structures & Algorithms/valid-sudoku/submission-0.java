class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char val = board[i][j];

                if (val != '.') {
                    if (!seen.add(val + "row" + i)
                            || !seen.add(val + "col" + j)
                            || !seen.add(val + "grid" + i / 3 + ':' + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;

  
    }
}
