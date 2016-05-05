/*
 * Copyright (c) 2016 Richik Sinha Choudhury and Nick Dimitrov
 */

package com.bankofjava;

import java.util.ArrayList;

/**
 * Created by Richik SC on 5/5/2016.
 */
public class Statement extends ArrayList<StatementItem> {

  private Account account;
  public Statement(Account a) {
    super();
    this.account = a;
  }

  public boolean addItem(String desc, double charge) {
    return this.add(new StatementItem(desc, charge));
  }

  public String getDescription(int index) {
    return this.get(index).getDescription();
  }

  public double getCharge(int index) {
    return this.get(index).getCharge();
  }

  public static String padRight(String s, int n) {
    return String.format("%1$-" + n + "s", s);
  }

  public static String padLeft(String s, int n) {
    return String.format("%1$" + n + "s", s);
  }

  @Override
  public String toString() {
    int maxLengthD = 0;
    int maxLengthC = 0;
    for (StatementItem i : this) {
      if (i.getDescription().length() > maxLengthD) {
        maxLengthD = i.getDescription().length();
      }
      if (Double.toString(i.getCharge()).length() > maxLengthC) {
        maxLengthC = Double.toString(i.getCharge()).length();
      }
    }
    StringBuilder statement = new StringBuilder();
    for (int i = 0; i < this.size(); i++) {
      statement.append(" " + i + " |");
      statement.append(" " + Statement.padRight(this.getDescription(i), maxLengthD) + " |");
      statement.append(" " + Statement.padLeft(Double.toString(this.getCharge(i)), maxLengthC) +
          " ");
      statement.append(System.lineSeparator());
    }
    statement.append("   |");
    statement.append(" " + Statement.padRight("TOTAL BALANCE", maxLengthD) + " |");
    statement.append(" " + account.getBalance() + " ");
    return statement.toString();
  }
}
