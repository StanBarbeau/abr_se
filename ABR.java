package abr_se;

/**
 * Created by Stanislas Barbillon on 09/11/2016.
 * An 'Arbre binaire de Recherche' of integers that contains no duplicate elements.
 */
public class ABR {

    /** Params
     * private fiels of our ABR structure.
     */
    private int nbrElement;
    private Node root_;

    /** Node
     * a class representing datas in ABR.
     */
    private class Node
    {
        private Node child_right;
        private Node child_left;
        private int value;

        public Node(int val)
        {
            this.child_left = null;
            this.child_right = null;
            this.value = val;
        }

        public int distTo(Node n)
        {
            return (n.getValue() - this.getValue());
        }

        public boolean equals (Node n)
        {
            return this.value == n.value;
        }

        public void setValue(int v)
        {
            this.value = v;
        }

        public int getValue()
        {
            return this.value;
        }
    }

    /**
     * constructor. Generate an empty ABR instance.
     */
    public ABR()
    {
        nbrElement = 0;
        root_ = null;
    }

    /** insert
     * add a new int in the ABR, if it is not already present.
     * @param nbr int to be inserted in ABR
     */
    public void insert(int nbr)
    {

        Node n = new Node(nbr);

        if(this.root_ == null)
        {
            this.root_ = n;
            nbrElement += 1;
        }
        else if(!this.contains(nbr))
        {
            Node pN = getParent(n);
            nbrElement += 1;

            if (pN.distTo(n) < 0)
            {
                pN.child_left = n;
            }
            else
            {
                pN.child_right = n;
            }
        }
    }


    /** isEmpty
     * return true if
     * @return true if ABR is empty, else false.
     */
    public boolean isEmpty()
    {
        return nbrElement == 0;
    }

    /** nbElement
     * return the number of elements present in this ABR.
     * @return the number of elements
     */
    public int nbElement()
    {
        return nbrElement;
    }


    /** toList
     * fill a list with value in the ABR.
     * @param l the list to fill with this ABR integers.
     */
    public void toList(java.util.List<java.lang.Integer> l)
    {
        l.clear();
        if(this.root_ != null)
        {
            this.recRemplissage(l, this.root_);
        }
    }

    /** contains
     * search if a value is in the ABR. Return true if a value
     * is in the ABR
     * @param value to test if is in ABR.
     * @return true if value is in the ABR.
     */
    public boolean contains(int value)
    {
        boolean flag = false;
        Node node = new Node(value);
        if(this.root_ == null)
        {
            flag = false;
        }
        else if (this.getParent(node) == null)
        {
            flag = true;
        }

        return flag;
    }

    private Node getParent(Node p)
    {
        assert(p!=null);

        Node nN = root_, pN = null;

        while(nN != null)
        {
            pN = nN;
            if (pN.distTo(p) == 0)
            {
                return null;
            }
            else if( pN.distTo(p) < 0)
            {
                nN = pN.child_left;
            }
            else
            {
                nN = pN.child_right;
            }
        }
        return pN;
    }

    private void recRemplissage(java.util.List<java.lang.Integer> l, Node node)
    {
        if (node.child_left != null)
        {
            recRemplissage(l, node.child_left);
        }
        if (node != null)
        {
            l.add(node.getValue());
        }
        if (node.child_right != null)
        {
            recRemplissage(l, node.child_right);
        }
    }
}
