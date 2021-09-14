/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Subject;

/**
 *
 * @author vinicius.rodrigues
 */
public interface Observer {
      public void update( Subject o );
}