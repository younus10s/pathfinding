import Ahmad.Grid;
import Ahmad.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMain {
    public static void main(String[] args) {


        System.out.println("Hello World!");
        boolean[][] b  = {{true,true,false}, {true,true,false },{true, true, false}};
        List<List> list = new ArrayList();
        List l = Arrays.asList(true, true, false);
        list.add(l);
        list.add(l);
        list.add(l);
        System.out.println(list.get(2).get(2));

        Node node = new Node(0,0,true);

        Grid grid = new Grid(list);
        List<Node> n = grid.getNeighbors(node);

        for(Node no : n) {
            System.out.println(no.getPosition()[0] + ":" + no.getPosition()[1]);
        }

/*        List<List<Node>> grid = new ArrayList<>();
        grid.add(new ArrayList<>());
        System.out.println(grid.size());*/

    }

}
