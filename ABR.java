package abr_se;

/**
 * Created by Iperi on 09/11/2016.
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
    }

    /** ABR
     * constructor.
     */
    public ABR()
    {
        nbrElement = 0;
        root_ = null;
    }

    /** insert
     * add a new int in the ABR.
     * @param nbr , int to put in ABR
     */
    public void insert(int nbr)
    {
        nbrElement += 1;
        Node n = new Node(nbr);

        if(this.root_ == null)
        {
            this.root_ = n;
        }
        else
        {
            ;

        }
    }


    /** isEmpty
     * Is ABR empty ?
     * @return true if ABR is empty, else false.
     */
    public boolean isEmpty()
    {
        return nbrElement == 0;
    }

    /** nbElement
     * return the number of elements present in the ABR.
     * @return the number of elements
     */
    public int nbElement()
    {
        return nbrElement;
    }


    /** toList
     * fill a list with value in the ABR.
     * @param l
     */
    public void toList(java.util.List<java.lang.Integer> l)
    {

    }

    /** containts
     * search if a value is in the ABR.
     * @param value to test if is in ABR.
     * @return true if value is in the ABR.
     */
    public boolean contains(int value)
    {

    }
}
