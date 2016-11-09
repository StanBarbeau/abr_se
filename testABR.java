package abr_se;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Iperi on 09/11/2016.
 */
public class testABR {

    @Test
    public void testABR()
    {
        ABR arbre = new ABR();
        assertEquals(arbre.isEmpty(), arbre.nbElement() == 0);
        assertTrue("L'arbre n'est pas vide.", arbre.isEmpty());
    }

    @Test
    public void testInsert()
    {
        ABR arbre = new ABR();
        int v = 5;
        arbre.insert(v);

        assertTrue("'v' n'est pas contenu dans l'arbre.", arbre.contains(v));
    }
}
