/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bini
 */
public class RelacionPuertoSet implements Iterable<RelacionPuerto> {
    
    private final List<RelacionPuerto> relationList;
    
    public RelacionPuertoSet() {
        this.relationList = new ArrayList<>();
    }
    
    public void add(RelacionPuerto rel) {
        this.relationList.add(rel);
    }
    
    public RelacionPuerto[] getItems() {
        return relationList.toArray(new RelacionPuerto[relationList.size()]);
    }

    @Override
    public Iterator<RelacionPuerto> iterator() {
        return relationList.iterator();
    }
    
}
