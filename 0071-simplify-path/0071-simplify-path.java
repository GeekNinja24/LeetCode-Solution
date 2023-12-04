class Solution {
    public String simplifyPath(String path) {

        List<String> dirs = new ArrayList<>();

        int index = 0;

        while(index < path.length()) {
            
            String nextDir = getNextDir(index, path);
            if(isLevelUp(nextDir)) {
                removeLastDir(dirs);
                index+=2;
            } else if(isCurrentDir(nextDir) || nextDir.isEmpty()) {
                index+=1;
            } else {
                dirs.add(nextDir);
                index = nextNonSlashIndex(index+nextDir.length(), path);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(String dir : dirs) {
            sb = sb.append("/").append(dir);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }

    private void removeLastDir(List<String> dirs) {

        if(!dirs.isEmpty()) {
            dirs.remove(dirs.size()-1);
        }
    }

    private String getNextDir(int currentIndex, String path) {

        StringBuilder sb = new StringBuilder();
        while(currentIndex < path.length()) {
            if(path.charAt(currentIndex) != '/') {
                sb.append(path.charAt(currentIndex++));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private boolean isLevelUp(String dir) {
        return dir.length()==2 && dir.charAt(0) == '.' && dir.charAt(1) == '.'; 
    }

    private boolean isCurrentDir(String dir) {
        return dir.length()==1 && dir.charAt(0) == '.';
    }

    private int nextNonSlashIndex(int currentIndex, String path) {

        while(currentIndex < path.length()) {

            if(path.charAt(currentIndex) != '/') {
                break;
            }
            currentIndex++;
        }
        return currentIndex;
    }
}