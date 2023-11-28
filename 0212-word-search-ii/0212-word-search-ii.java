class Solution {
    // List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int n = board.length;
        int m = board[0].length;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backtrack(board, root, root, i, j, res);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, TrieNode root, TrieNode node, int row, int col, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            String word = node.word;
            res.add(word);
            node.word = null;
            deleteTrie(root, word);
        }

        char temp = board[row][col];
        board[row][col] = '#';
        // explore neighbor cells in clockwise direction: up, right, down, left
        backtrack(board, root, node, row - 1, col, res);
        backtrack(board, root, node, row, col + 1, res);
        backtrack(board, root, node, row + 1, col, res);
        backtrack(board, root, node, row, col - 1, res);
        board[row][col] = temp;
    }

    private void deleteTrie(TrieNode root, String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode root, String word, int i) {
        if (i == word.length() - 1) {
            TrieNode curr = root.children[word.charAt(i) - 'a'];
            if (hasChildren(curr)) {
                return false;
            } else {
                root.children[word.charAt(i) - 'a'] = null;
                return true;
            }
        }
        if (delete(root.children[word.charAt(i) - 'a'], word, i + 1)
        && !hasChildren(root.children[word.charAt(i) - 'a'])
        ) {
            root.children[word.charAt(i) - 'a'] = null;
            return true;
        } 
        return false;
    }

    private boolean hasChildren(TrieNode node) {
        for (TrieNode child: node.children) {
            if (child != null) {
                return true;
            }
        }
        return false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children[c - 'a'] = newNode;
                    node = newNode;
                }
            }
            node.word = word;
        }
        return root;
    }
}

class TrieNode {
    
    TrieNode[] children = new TrieNode[26];
    String word = null;
}