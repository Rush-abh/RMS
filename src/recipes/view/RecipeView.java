/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipes.view;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import recipes.controller.RecipeController;
import recipes.model.Update;
import recipes.model.RecipeModel;

/**
 *
 * @author Rushabh
 */
public class RecipeView extends JFrame implements Observer {

    RecipeController controller;

    public RecipeView(RecipeController rc) {
        //super();
        controller = rc;

        initComponents();
        PreviousButton.setEnabled(false);
        NextButton.setEnabled(false);
    }

    //implement Observer.update
    @Override
    public void update(Observable obs, Object obj) {
        Update u = (Update) obj;

        if (u.getRecipe() == null) {
            outputTextArea.setText(u.getMessage() + "\n");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
            return;
        }
        PreviousButton.setEnabled(true);
        NextButton.setEnabled(true);
        nameTextField.setText(u.getRecipe().getName());
        catTextField.setText(u.getRecipe().getCategory());
        ptTextField1.setText(Integer.toString(u.getRecipe().getPreparationTime()));
        ctTextField1.setText(Integer.toString(u.getRecipe().getCookingTime()));
        miTextField.setText(u.getRecipe().getMainIngredient());
        outputTextArea.setText(u.getMessage() + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        catButton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        miButton = new javax.swing.JButton();
        catptButton = new javax.swing.JButton();
        catcotButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        miTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cotTextField1 = new javax.swing.JTextField();
        cotTextField2 = new javax.swing.JTextField();
        ctTextField2 = new javax.swing.JTextField();
        ctTextField1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ptTextField1 = new javax.swing.JTextField();
        ptTextField2 = new javax.swing.JTextField();
        catTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        catButton.setText("Category");
        catButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catButtonActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel25.setText("Select recipes for the following attributes: ");

        miButton.setText("Main Ingredient");
        miButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miButtonActionPerformed(evt);
            }
        });

        catptButton.setText("Category and Preparation Time");
        catptButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        catptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catptButtonActionPerformed(evt);
            }
        });

        catcotButton.setText("Category and Combined Time");
        catcotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcotButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                outputTextAreaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(outputTextArea);

        jLabel24.setText("Main Ingredient");

        jLabel23.setText("Combined Time");

        jLabel22.setText("Cooking Time");

        jLabel21.setText("Preparation Time");

        catTextField.setSelectionColor(new java.awt.Color(0, 120, 216));

        jLabel20.setText("Category");

        jLabel19.setText("Name");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setText("Input");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel27.setText("Output");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(catButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(237, 237, 237))
                                .addComponent(jLabel25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(miButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(catcotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(catptButton, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cotTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ctTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ptTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ctTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cotTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(ptTextField2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(miTextField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 219, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel26)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(catTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ClearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddButton, ClearButton, NextButton, PreviousButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(catTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(ptTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ptTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ctTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ctTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cotTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cotTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(miTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton)
                            .addComponent(ClearButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PreviousButton)
                                .addGap(5, 5, 5))
                            .addComponent(NextButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane3))
                .addGap(51, 51, 51)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catButton)
                    .addComponent(catptButton))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miButton)
                    .addComponent(catcotButton)
                    .addComponent(ExitButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void catButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catButtonActionPerformed
        //action for category button
        if (getCatTextField() == "" || getCatTextField().isEmpty()) {
            setOutputTextArea("Error: Category Field Empty");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
        } else {
            controller.recipesForCategory(getCatTextField());
        }
    }//GEN-LAST:event_catButtonActionPerformed

    private void miButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miButtonActionPerformed
        //action for main ingredient button
        if (getMiTextField() == "" || getMiTextField().isEmpty()) {
            setOutputTextArea("Error: Main Ingredient Field Empty");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
        } else {
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
            nameTextField.setText("");
            catTextField.setText("");
            ptTextField1.setText("");
            ctTextField1.setText("");
            cotTextField1.setText("");
            ptTextField2.setText("");
            ctTextField2.setText("");
            cotTextField2.setText("");
            outputTextArea.setText("");
            controller.numberOfRecipesUsingMainIngredient(getMiTextField());
        }
    }//GEN-LAST:event_miButtonActionPerformed

    private void catptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catptButtonActionPerformed
        //action for category and present time button
        //if upper bound is less than lower
        if (getCatTextField() == "" || getCatTextField().isEmpty() || getPtTextField1() == 0 || getPtTextField2() == 0) {
            setOutputTextArea("Error: Category or Prep Time Field Empty");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
        } else if (getPtTextField2() < getPtTextField1()) {
            setOutputTextArea("Error: Lower bound greater then upper bound");
        } else {
            nameTextField.setText("");
            ctTextField1.setText("");
            cotTextField1.setText("");
            miTextField.setText("");
            ctTextField2.setText("");
            cotTextField2.setText("");
            outputTextArea.setText("");
            controller.recipesForCategoryAndPreparationTime(getCatTextField(), getPtTextField1(), getPtTextField2());
        }
    }//GEN-LAST:event_catptButtonActionPerformed

    private void catcotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcotButtonActionPerformed
        //action for category and combined time button
        //if upper bound is less than lower
        if (getCatTextField() == "" || getCatTextField().isEmpty() || getCotTextField1() == 0 || getCotTextField2() == 0) {
            setOutputTextArea("Error: Category or Combined Time Field Empty");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
        } else if (getCotTextField2() < getCotTextField1()) {
            setOutputTextArea("Error: Lower bound greater then upper bound");
        } else {
            nameTextField.setText("");
            ptTextField1.setText("");
            ctTextField1.setText("");
            miTextField.setText("");
            ptTextField2.setText("");
            ctTextField2.setText("");
            outputTextArea.setText("");
            controller.recipesForCategoryAndCombinedTime(getCatTextField(), getCotTextField1(), getCotTextField2());
        }
    }//GEN-LAST:event_catcotButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        //action for exit button
        // close the application
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        //action for add button
        if (getNameTextField().isEmpty() || getCatTextField().isEmpty() || getMiTextField().isEmpty() || getPtTextField1() == 0 || getCtTextField1() == 0) {
            setOutputTextArea("Error: Fields Empty");
            PreviousButton.setEnabled(false);
            NextButton.setEnabled(false);
        } else {
            controller.addRecipe(getNameTextField(), getCatTextField(), getMiTextField(), getPtTextField1(), getCtTextField1());
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        //action for category button
        nameTextField.setText("");
        catTextField.setText("");
        ptTextField1.setText("");
        ctTextField1.setText("");
        cotTextField1.setText("");
        miTextField.setText("");
        ptTextField2.setText("");
        ctTextField2.setText("");
        cotTextField2.setText("");
        outputTextArea.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void outputTextAreaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_outputTextAreaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_outputTextAreaAncestorAdded

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        try {
            controller.next();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        controller.previous();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    public void setOutputTextArea(String s) {
        outputTextArea.setText(s);
    }

    public String getCatTextField() {
        return catTextField.getText();
    }

    public int getCotTextField1() {
        if (cotTextField1.getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cotTextField1.getText());
    }

    public int getCotTextField2() {
        // If upper bound empty,set as lower.
        if (cotTextField2.getText().isEmpty()) {
            return getCotTextField1();
        }
        return Integer.parseInt(cotTextField2.getText());
    }

    public int getCtTextField1() {
        if (ctTextField1.getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(ctTextField1.getText());
    }

    public int getCtTextField2() {
        // If upper bound empty,set as lower.
        if (ctTextField2.getText().isEmpty()) {
            return getCotTextField1();
        }
        return Integer.parseInt(ctTextField2.getText());
    }

    public String getMiTextField() {
        return miTextField.getText();
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public int getPtTextField1() {
        if (ptTextField1.getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(ptTextField1.getText());
    }

    public int getPtTextField2() {
        // If upper bound empty,set as lower.
        if (ptTextField2.getText().isEmpty()) {
            return getPtTextField1();
        }
        return Integer.parseInt(ptTextField2.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton catButton;
    private javax.swing.JTextField catTextField;
    private javax.swing.JButton catcotButton;
    private javax.swing.JButton catptButton;
    private javax.swing.JTextField cotTextField1;
    private javax.swing.JTextField cotTextField2;
    private javax.swing.JTextField ctTextField1;
    private javax.swing.JTextField ctTextField2;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton miButton;
    private javax.swing.JTextField miTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JTextField ptTextField1;
    private javax.swing.JTextField ptTextField2;
    // End of variables declaration//GEN-END:variables
}