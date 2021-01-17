package Ahmad;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<List<Node>> grid = new ArrayList<>();

    public Grid(List input_2d){
        getGrid(input_2d);
    };

    private void getGrid(List<List<Boolean>> input_2d){
        for(int row = 0; row < input_2d.size(); row++) {
            grid.add(new ArrayList<>());
            for(int column = 0; column < input_2d.get(row).size(); column++) {
                boolean isWall = input_2d.get(row).get(column);
                Node node = new Node(row, column, isWall);
                grid.get(row).add(node);
            }
        }
    }

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[] position = node.getPosition();

        int row = position[0];
        int column = position[1];

        for(int i=-1; i<2; i++) {
            for(int j=-1; j<2; j++) {
                Node n = getNode(row+i, column+j);
                if(i==0 && j==0) continue;

                if(n != null) {
                    neighbors.add(n);
                }
            }
        }
        return neighbors;
    }

    private Node getNode(int row, int column) {
        Node node;
        if(row >= 0 && column >= 0) {
            node = grid.get(row).get(column);
        } else {
            node = null;
        }
        return node;
    }





}
