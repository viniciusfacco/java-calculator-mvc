/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.Observer;

/**
 *
 * @author vinicius.rodrigues
 */
public interface Subject {
      public void addObserver( Observer o );
      public void removeObserver( Observer o );
}