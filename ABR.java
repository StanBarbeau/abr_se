package abr_se;

/**
 * Created by Iperi on 09/11/2016.
 */
public class ABR {

    private int nbrElement;
    private Node root_;

    private class Node
    {
        private Node child_right;
        private Node child_left;

        public Node()
        {
            this.child_left = null;
            this.child_right = null;
        }
    }


    public ABR()
    {
        nbrElement = 0;
    }

    public void insert(Node n)
    {
        nbrElement += 1;

        if(this.root_ == null)
        {
            this.root_ = n;
        }
        else
        {

        }
    }

    public boolean isEmpty()
    {
        return nbrElement == 0;
    }

    public int getNbrElement()
    {
        return nbrElement;
    }
}
