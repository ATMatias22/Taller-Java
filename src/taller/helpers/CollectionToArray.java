/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.helpers;

import java.util.Collection;

/**
 *
 * @author Matias
 */
public class CollectionToArray {
    
      public static final String[] conversionCollectionString(Collection<String> dni){
        String[]datos = new String[dni.size()];
        return dni.toArray(datos);
    }

}
