/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bini
 */
public class RelacionPBSet implements Iterable<RelacionPB> {
    
    private final List<RelacionPB> relationList;
    
    public RelacionPBSet() {
        this.relationList = new ArrayList<>();
    }
    
    public void add(RelacionPB rel) {
        this.relationList.add(rel);
    }
    
    public RelacionPB[] getItems() {
        return relationList.toArray(new RelacionPB[relationList.size()]);
    }

    @Override
    public Iterator<RelacionPB> iterator() {
        return relationList.iterator();
    }
    
}
