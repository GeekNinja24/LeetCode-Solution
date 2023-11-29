class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() +1 > maxWidth) {
                // format line -- spacing
                int originalSpaces = maxWidth - line.length();
                if (originalSpaces == 0) list.add(line.toString());
                else {
                    String[] currentWords = line.toString().split(" ");
                    int currLen = 0;
                    for (String s: currentWords) {
                        currLen += s.length();
                    }
                    line = new StringBuilder();
                    originalSpaces = maxWidth-currLen;
                    int noOfWords = currentWords.length-1;
                    if (noOfWords == 0) {
                        line.append(currentWords[0]).append(getSpaces(maxWidth-currentWords[0].length()));
                    } else {
                        int i=0;
                        while (originalSpaces > 0) {
                            currentWords[i%noOfWords] = currentWords[i%noOfWords]+" ";
                            i++;
                            originalSpaces--;
                        }
                        for(i=0; i<currentWords.length; i++) {
                            line.append(currentWords[i]);
                        }
                    }
                    list.add(line.toString());
                }
                line = new StringBuilder(word);
            } else {
                if (line.length() == 0) line.append(word);
                else {
                    line.append(" ").append(word);
                }
            }
        }
        line.append(getSpaces(maxWidth-line.length()));
        list.add(line.toString());
        if (list.get(0).trim().isEmpty()) list.remove(0);
        return list;
    }

    private String getSpaces(int spaces) {
        StringBuilder s= new StringBuilder();
        while (spaces > 0) {
            s.append(" ");
            spaces--;
        }
        return s.toString();
    }
}