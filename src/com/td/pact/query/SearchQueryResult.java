package com.td.pact.query;

import java.util.List;

/**
 * @author adlakha.vaibhav
 */
public class SearchQueryResult {

  private int count;
  private List results;

  public SearchQueryResult(int count, List results) {
    this.count = count;
    this.results = results;
  }

  public int getCount() {
    return count;
  }

  public List getResults() {
    return results;
  }
}
