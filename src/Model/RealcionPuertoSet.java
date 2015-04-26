/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bini
 */
public class RealcionPuertoSet extends HashSet {
    private RealcionPuertoSet(){}
    private static RelacionPuertoSet instance;

    public static RelacionPuertoSet getInstance() {
        if (instance == null)
            instance = new RelacionPuertoSet();
        return instance;
    }
    public Currency search (String code){
        for (Currency currency: instance)
            if (code.equals(currency.getCode()))
                return currency;
        return null;
    }
    
    public Currency getCurrency(String code) {
        for (Currency currency : this)
            if (code.equals(currency.getCode()))
                return currency;
        return null;
    }
    
    public Currency add (String code, String name, String symbol){
        return new Currency(code, name, symbol);   
    }
}
