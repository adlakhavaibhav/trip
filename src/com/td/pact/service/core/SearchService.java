package com.td.pact.service.core;

import com.td.pact.query.SearchQuery;
import com.td.web.action.Page;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/29/14
 * Time: 5:40 PM
 */
public interface SearchService {
  @SuppressWarnings("rawtypes")
  public List executeSearch(SearchQuery searchQuery);

  public Page list(SearchQuery searchQuery);

  public int getCountForSearch(SearchQuery searchQuery);
}