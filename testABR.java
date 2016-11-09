package abr_se;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Iperi on 09/11/2016.
 */
public class testABR {

    private class intCompare implements Comparator<Integer>
    {
        public int compare(Integer a, Integer b)
        {
            return (a - b);
        }

    }

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

    /**
     * test de toList. Le liste est forcément triée.
     */
    @Test
    public void testToList()
    {
        System.out.println("testToList() : ");
        ABR arbre = new ABR();

        ArrayList<Integer> col = new ArrayList<Integer>();
        col.add(2);
        col.add(5);
        col.add(0);
        col.add(1);
        System.out.println("'col' before sorting : " + col.toString());
        // On ajoute les éléments 1 à 1. Ils ne sont pas nécessairement
        // triés dans 'col'. Au vu de comment on les ajoutes,
        // '2' est racine, '5' son fils a droite, '0' son fils
        // à gauche et '1' le fils à droite de '0'.
        for (int i = 0 ; i < col.size() ; i++)
        {
            arbre.insert(col.get(i));
        }

        ArrayList<Integer> larbre = new ArrayList<Integer>();
        arbre.toList(larbre);
        System.out.println("'larbre' : " + larbre.toString());

        assertEquals("la liste 'larbre' ne fait pas le bon nombre d'elements", col.size(), larbre.size());
        // Test pour savoir si les éléments sont bien présents dans larbre.
        assertTrue("Les deux listes ne sont pas identiques.",larbre.containsAll(col));

        // maintenant, on sort col et on test si les liste sont les mêmes.
        col.sort(new intCompare());
        System.out.println("'col' after sort : " + col.toString());

        for (int i = 0 ; i < col.size() ; i++)
        {
            assertEquals("L'élément n'est pas le même.",col.get(i), larbre.get(i));
        }
    }

    @Test
    public void testToListWithSameInt()
    {
        ABR arbre = new ABR();
        arbre.insert(5);
        arbre.insert(6);
        arbre.insert(4);
        arbre.insert(5);

        ArrayList<Integer> larbre = new ArrayList<Integer>();
        arbre.toList(larbre);

        assertFalse("La liste 'larbre' fait bien 4 éléments.",larbre.size() == 4);
    }
}
