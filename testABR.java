package abr_se;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public void testInsertContains()
    {
        ABR arbre = new ABR();
        int v = 5;
        arbre.insert(v);
        assertEquals("L'abre ne contient pas qu'un seul élément.",arbre.nbElement(),1);
        assertTrue("'v' n'est pas contenu dans l'arbre.", arbre.contains(v));
    }

    @Test
    public void testToList()
    {
        ABR arbre = new ABR();

        ArrayList<Integer> col = new ArrayList<Integer>();
        col.add(2);
        col.add(5);
        col.add(0);
        col.add(1);

        for (int i = 0 ; i < col.size() ; i++)
        {
            arbre.insert(col.get(i));
        }

        ArrayList<Integer> larbre = new ArrayList<Integer>();
        arbre.toList(larbre);

        assertEquals("la liste 'larbre' ne fait pas le bon nombre d'elements", col.size(), larbre.size());
        assertTrue("Les deux listes ne sont pas identiques.",larbre.containsAll(col));
    }
}
