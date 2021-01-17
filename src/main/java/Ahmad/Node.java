package Ahmad;

public class Node {
    private int [] position;
    private Boolean isWall = false;
    public Node(int row, int column , boolean isWall ){
        this.position = new int[]{row, column};
        this.isWall = isWall;
    };
    public int[] getPosition(){
        return position;
    }
}
